/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.DblObj;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Swiss Ephemeris, as one object that many threads may share.
 *
 * <p>Create one per ephemeris directory and keep it —— as a singleton bean, a static field,
 * whatever suits. It is safe to call from any number of threads at once.
 *
 * <pre>{@code
 * SwissEphemeris ephemeris = SwissEphemeris.at("/ephemeris/ephe");
 *
 * CalcResult sun = ephemeris.calculate(
 *     JulianDayUT.of(2451545.0), Body.Point.SUN, Ephemeris.SWISS, EnumSet.of(CalcOption.SPEED));
 *
 * double longitude = sun.ecliptic().longitudeDeg();
 * }</pre>
 *
 * <h2>Why this class exists</h2>
 *
 * <p>The class it wraps, {@link SwissEph}, cannot be shared. Its state is one big mutable
 * structure that every calculation reads and writes, and the protocol for a topocentric or
 * sidereal position is "mutate the object, then call" —— so two threads on one instance corrupt
 * each other. Measured on eight threads sharing one {@code SwissEph}: of 150 distinct requests,
 * 94 came back with more than one answer, some of them zero or NaN with a success return code.
 *
 * <p>Callers therefore kept a {@code ThreadLocal<SwissEph>} each, which works but pushes the
 * problem outward: every consumer has to know about it, remember to clean it up, and give up
 * having one shared object.
 *
 * <p>This class keeps that arrangement, but on the inside. Each thread that calls gets its own
 * calculation context, lazily; the mutate-then-call protocol happens within one such context and
 * is never visible from outside. What made per-thread contexts expensive —— a full copy of the
 * ephemeris state each —— is no longer true: the star catalogue and the {@code .se1} contents are
 * held once for the whole process, so a context costs about 43 KiB.
 *
 * <h2>What this class does not fix</h2>
 *
 * <p>An answer can still depend on what that same thread computed before it, if the two calls
 * used different ephemerides —— an inheritance from the C original, where a single global state
 * made the question meaningless. The effect is small for ordinary use and large in one corner
 * ({@code nodes and apsides}, up to half a degree). It is a separate defect with a separate fix,
 * and it is not made worse by anything here.
 */
public final class SwissEphemeris implements AutoCloseable {

  private final String ephemerisPath;

  /**
   * One calculation context per thread, created on first use.
   *
   * <p>Not initialised eagerly: a context is only worth its 43 KiB on a thread that actually
   * calculates, and a servlet container's idle threads never will.
   */
  private final ThreadLocal<Context> perThread = ThreadLocal.withInitial(this::newContext);

  /**
   * Every live context, so that {@link #close()} can release them all —— a thread cannot clear
   * another thread's {@code ThreadLocal}.
   *
   * <p>Weakly held, so a context becomes collectable as soon as its thread is gone. A strong
   * registry would turn "many short-lived threads" into a leak.
   */
  private final Set<Context> live =
      Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));

  private SwissEphemeris(String ephemerisPath) {
    this.ephemerisPath = ephemerisPath;
  }

  /**
   * An instance reading data files from the given directory.
   *
   * @param ephemerisPath one or more directories, separated by {@code ;} or {@code :}. A path with
   *                      no usable files is not an error —— calculations fall back to Moshier and
   *                      report {@link Warning.Kind#EPHEMERIS_FILE_MISSING}.
   */
  public static SwissEphemeris at(String ephemerisPath) {
    return new SwissEphemeris(Objects.requireNonNull(ephemerisPath, "ephemerisPath"));
  }

  /**
   * An instance with no data files, computing everything analytically.
   *
   * <p>Fixed stars still need {@code sefstars.txt}; without it they cannot be computed at all.
   */
  public static SwissEphemeris moshierOnly() {
    return new SwissEphemeris("");
  }

  // -----------------------------------------------------------------------------------------
  // Calculation
  // -----------------------------------------------------------------------------------------

  /** Geocentric, tropical, no modifiers —— the shortest form. */
  public CalcResult calculate(JulianDayUT time, Body body, Ephemeris ephemeris) {
    return calculate(time, body, ephemeris, EnumSet.noneOf(CalcOption.class));
  }

  /** Geocentric and tropical, with modifiers. */
  public CalcResult calculate(JulianDayUT time, Body body, Ephemeris ephemeris, Set<CalcOption> options) {
    return calculate(time, body, ephemeris, options, Centre.geocentric(), Zodiac.tropical());
  }

  /**
   * Where a body is at a given moment.
   *
   * @param time      the instant, in Universal Time
   * @param body      what to compute —— a numbered point, a minor planet, or a named fixed star
   * @param ephemeris which ephemeris to compute from; see {@link CalcResult#usedEphemeris()} for
   *                  what was actually used, which can differ
   * @param options   modifiers; an empty set gives apparent geocentric ecliptic coordinates of
   *                  the date, without speeds
   * @param centre    where the observer is; {@link Centre#topocentric} carries the position
   * @param zodiac    what longitudes are measured from; sidereal variants carry the ayanamsa
   * @return the position, plus what the calculation has to say about it
   * @throws SwissEphemerisException if no result could be produced at all
   */
  public CalcResult calculate(JulianDayUT time,
                              Body body,
                              Ephemeris ephemeris,
                              Set<CalcOption> options,
                              Centre centre,
                              Zodiac zodiac) {
    Objects.requireNonNull(time, "time");
    Objects.requireNonNull(body, "body");
    Objects.requireNonNull(ephemeris, "ephemeris");
    Objects.requireNonNull(options, "options");
    Objects.requireNonNull(centre, "centre");
    Objects.requireNonNull(zodiac, "zodiac");

    Context context = perThread.get();
    context.apply(centre, zodiac);

    int iflag = ephemeris.bit() | CalcOption.bitmask(options) | centre.bit() | zodiac.bit();
    double[] xx = new double[6];
    StringBuffer serr = new StringBuffer();

    int returned;
    String resolvedName = null;
    if (body instanceof Body.FixedStar star) {
      // The legacy call takes the name in a buffer and writes the catalogue's own name back into
      // it, so the buffer is both argument and result.
      StringBuffer name = new StringBuffer(star.name());
      returned = context.se.swe_fixstar_ut(name, time.value(), iflag, xx, serr);
      resolvedName = name.toString();
    } else {
      returned = context.se.swe_calc_ut(time.value(), numberOf(body), iflag, xx, serr);
    }

    if (returned == SweConst.ERR) {
      throw new SwissEphemerisException(
          "cannot compute " + body.displayName() + " at " + time + ": "
          + (serr.isEmpty() ? "no reason given" : serr.toString()));
    }

    return assemble(returned, xx, serr, options, resolvedName);
  }

  private static int numberOf(Body body) {
    if (body instanceof Body.Point point) {
      return point.number();
    }
    if (body instanceof Body.MinorPlanet minor) {
      return minor.number();
    }
    throw new IllegalArgumentException("not a numbered body: " + body);
  }

  /**
   * Reads one legacy {@code double[6]} into the position type the requested options imply.
   *
   * <p>Shared by every call that returns a position, so that the mapping from slot to meaning is
   * written down exactly once.
   */
  private static Position positionFrom(double[] xx, Set<CalcOption> requested) {
    // Speeds are only meaningful if they were asked for; otherwise the slots hold zeroes, which
    // would read as "not moving" rather than "not computed".
    boolean withSpeed = requested.contains(CalcOption.SPEED);

    if (requested.contains(CalcOption.CARTESIAN)) {
      return new Position.Cartesian(xx[0], xx[1], xx[2], withSpeed
          ? Optional.of(new Position.CartesianSpeed(xx[3], xx[4], xx[5]))
          : Optional.empty());
    }
    if (requested.contains(CalcOption.EQUATORIAL)) {
      return new Position.Equatorial(xx[0], xx[1], xx[2], withSpeed
          ? Optional.of(new Position.EquatorialSpeed(xx[3], xx[4], xx[5]))
          : Optional.empty());
    }
    return new Position.Ecliptic(xx[0], xx[1], xx[2], withSpeed
        ? Optional.of(new Position.EclipticSpeed(xx[3], xx[4], xx[5]))
        : Optional.empty());
  }

  /** Classifies whatever the legacy {@code serr} out-parameter came back with. */
  private static List<Warning> warningsFrom(StringBuffer serr) {
    List<Warning> warnings = new ArrayList<>(1);
    if (!serr.isEmpty()) {
      warnings.add(Warning.classify(serr.toString()));
    }
    return warnings;
  }

  private static CalcResult assemble(int returnedFlags,
                                     double[] xx,
                                     StringBuffer serr,
                                     Set<CalcOption> requested,
                                     String resolvedName) {
    Position position = positionFrom(xx, requested);

    List<Warning> warnings = new ArrayList<>(1);
    if (!serr.isEmpty()) {
      warnings.add(Warning.classify(serr.toString()));
    }

    return new CalcResult(position, ephemerisOf(returnedFlags),
                          Optional.ofNullable(resolvedName), warnings);
  }

  private static Ephemeris ephemerisOf(int returnedFlags) {
    if ((returnedFlags & SweConst.SEFLG_JPLEPH) != 0) {
      return Ephemeris.JPL;
    }
    if ((returnedFlags & SweConst.SEFLG_SWIEPH) != 0) {
      return Ephemeris.SWISS;
    }
    return Ephemeris.MOSHIER;
  }

  // -----------------------------------------------------------------------------------------
  // Houses
  // -----------------------------------------------------------------------------------------

  /** Houses in the tropical zodiac. */
  public Houses houses(JulianDayUT time, GeoLocation place, HouseSystem system) {
    return houses(time, place, system, Zodiac.tropical());
  }

  /**
   * Divides the sky into houses for a place and a moment.
   *
   * <p>Note what this does <em>not</em> take: an {@link Ephemeris}. House division is geometry —— it
   * needs the obliquity and sidereal time, not a planetary ephemeris —— so the choice would have
   * had no effect. The legacy signature accepts the ephemeris bits anyway and ignores them, which
   * has misled callers into thinking they were selecting something.
   *
   * @param time   the instant, in Universal Time
   * @param place  where on Earth
   * @param system how to divide
   * @param zodiac what the returned longitudes are measured from
   * @throws SwissEphemerisException if the division could not be computed —— which happens for
   *                                 real: several systems are undefined inside the polar circles
   */
  public Houses houses(JulianDayUT time, GeoLocation place, HouseSystem system, Zodiac zodiac) {
    Objects.requireNonNull(time, "time");
    Objects.requireNonNull(place, "place");
    Objects.requireNonNull(system, "system");
    Objects.requireNonNull(zodiac, "zodiac");

    Context context = perThread.get();
    context.apply(Centre.geocentric(), zodiac);

    // 13 and 10 are the legacy sizes: cusp[0] is unused, and ascmc has two reserved slots.
    double[] cusp = new double[37];
    double[] ascmc = new double[10];
    int returned = context.se.swe_houses(
        time.value(), zodiac.bit(), place.latitudeDeg(), place.longitudeDeg(), system.code(),
        cusp, ascmc);

    if (returned == SweConst.ERR) {
      throw new SwissEphemerisException(
          "cannot divide houses (" + system.displayName() + ") at " + time
          + " for " + place + "; several systems are undefined near the poles");
    }

    int count = system == HouseSystem.GAUQUELIN_SECTORS ? 36 : 12;
    List<Double> cusps = new ArrayList<>(count);
    for (int house = 1; house <= count; house++) {
      cusps.add(cusp[house]);
    }

    HouseAngles angles = new HouseAngles(
        ascmc[SweConst.SE_ASC], ascmc[SweConst.SE_MC], ascmc[SweConst.SE_ARMC],
        ascmc[SweConst.SE_VERTEX], ascmc[SweConst.SE_EQUASC], ascmc[SweConst.SE_COASC1],
        ascmc[SweConst.SE_COASC2], ascmc[SweConst.SE_POLASC]);

    return new Houses(cusps, angles, zodiac);
  }

  // -----------------------------------------------------------------------------------------
  // Solar time
  // -----------------------------------------------------------------------------------------

  /**
   * The equation of time: apparent solar time minus mean solar time at this instant.
   *
   * <p>Returned as a {@link Duration} rather than the legacy's bare {@code double}, which is in
   * days —— a unit nothing in the signature mentions, and which every caller immediately multiplies
   * away. It swings roughly between -14 and +16 minutes over a year.
   *
   * @throws SwissEphemerisException if it could not be computed
   */
  public Duration equationOfTime(JulianDayUT time) {
    Objects.requireNonNull(time, "time");
    Context context = perThread.get();

    double[] e = new double[1];
    StringBuffer serr = new StringBuffer();
    int returned = context.se.swe_time_equ(time.value(), e, serr);
    if (returned == SweConst.ERR) {
      throw new SwissEphemerisException(
          "cannot compute the equation of time at " + time + ": "
          + (serr.isEmpty() ? "no reason given" : serr.toString()));
    }
    // e[0] is a fraction of a day.
    return Duration.ofNanos(Math.round(e[0] * 24 * 60 * 60 * 1_000_000_000L));
  }

  // -----------------------------------------------------------------------------------------
  // Nodes and apsides
  // -----------------------------------------------------------------------------------------

  /** Geocentric, tropical, no modifiers. */
  public NodesAndApsides nodesAndApsides(JulianDayUT time,
                                         Body body,
                                         Ephemeris ephemeris,
                                         ApsisMethod method) {
    return nodesAndApsides(time, body, ephemeris, method, EnumSet.noneOf(CalcOption.class),
                           EnumSet.noneOf(ApsisOption.class), Centre.geocentric(), Zodiac.tropical());
  }

  /**
   * Where a body's orbit crosses the reference plane, and where it is nearest and furthest.
   *
   * @param time      the instant, in Universal Time
   * @param body      whose orbit —— a numbered body; fixed stars have no orbit to speak of here
   * @param ephemeris which ephemeris to compute from
   * @param method    mean or osculating elements; they answer different questions
   * @param options   modifiers on the returned positions, as for {@link #calculate}
   * @param apsis     modifiers on what is returned in place of the aphelion
   * @param centre    where the observer is
   * @param zodiac    what longitudes are measured from
   * @throws SwissEphemerisException if nothing could be computed
   */
  public NodesAndApsides nodesAndApsides(JulianDayUT time,
                                         Body body,
                                         Ephemeris ephemeris,
                                         ApsisMethod method,
                                         Set<CalcOption> options,
                                         Set<ApsisOption> apsis,
                                         Centre centre,
                                         Zodiac zodiac) {
    Objects.requireNonNull(time, "time");
    Objects.requireNonNull(body, "body");
    Objects.requireNonNull(ephemeris, "ephemeris");
    Objects.requireNonNull(method, "method");
    Objects.requireNonNull(options, "options");
    Objects.requireNonNull(apsis, "apsis");
    Objects.requireNonNull(centre, "centre");
    Objects.requireNonNull(zodiac, "zodiac");

    Context context = perThread.get();
    context.apply(centre, zodiac);

    int iflag = ephemeris.bit() | CalcOption.bitmask(options) | centre.bit() | zodiac.bit();
    double[] ascending = new double[6];
    double[] descending = new double[6];
    double[] perihelion = new double[6];
    double[] aphelion = new double[6];
    StringBuffer serr = new StringBuffer();

    int returned = context.se.swe_nod_aps_ut(
        time.value(), numberOf(body), iflag, method.bit() | ApsisOption.bitmask(apsis),
        ascending, descending, perihelion, aphelion, serr);

    if (returned == SweConst.ERR) {
      throw new SwissEphemerisException(
          "cannot compute the nodes and apsides of " + body.displayName() + " at " + time + ": "
          + (serr.isEmpty() ? "no reason given" : serr.toString()));
    }

    return new NodesAndApsides(
        positionFrom(ascending, options), positionFrom(descending, options),
        positionFrom(perihelion, options), positionFrom(aphelion, options),
        warningsFrom(serr));
  }

  // -----------------------------------------------------------------------------------------
  // The observer's sky
  // -----------------------------------------------------------------------------------------

  /** Under the standard atmosphere. */
  public Horizontal toHorizontal(JulianDayUT time, GeoLocation place, Position position) {
    return toHorizontal(time, place, position, Atmosphere.STANDARD);
  }

  /**
   * Where a position appears in an observer's sky: its azimuth and altitude.
   *
   * <p>Which conversion to run is decided by the type of {@code position} —— ecliptic and
   * equatorial coordinates need different maths, and the legacy API selects between them with a
   * magic {@code int} ({@code SE_ECL2HOR} or {@code SE_EQU2HOR}) that the caller has to keep in
   * step with what is actually in the array by hand.
   *
   * @param position a position from {@link #calculate}, in ecliptic or equatorial coordinates
   * @throws IllegalArgumentException for a cartesian position, which this conversion does not take
   */
  public Horizontal toHorizontal(JulianDayUT time,
                                 GeoLocation place,
                                 Position position,
                                 Atmosphere atmosphere) {
    Objects.requireNonNull(time, "time");
    Objects.requireNonNull(place, "place");
    Objects.requireNonNull(position, "position");
    Objects.requireNonNull(atmosphere, "atmosphere");

    int direction;
    double[] xin = new double[3];
    switch (position) {
      case Position.Ecliptic e -> {
        direction = SweConst.SE_ECL2HOR;
        xin[0] = e.longitudeDeg();
        xin[1] = e.latitudeDeg();
        xin[2] = e.distanceAu();
      }
      case Position.Equatorial q -> {
        direction = SweConst.SE_EQU2HOR;
        xin[0] = q.rightAscensionDeg();
        xin[1] = q.declinationDeg();
        xin[2] = q.distanceAu();
      }
      case Position.Cartesian ignored -> throw new IllegalArgumentException(
          "a cartesian position cannot be converted to the horizon; ask for the position in "
          + "ecliptic or equatorial coordinates instead");
    }

    double[] geopos = {place.longitudeDeg(), place.latitudeDeg(), place.altitudeMetres()};
    double[] xaz = new double[3];
    perThread.get().se.swe_azalt(time.value(), direction, geopos,
                                 atmosphere.pressureMillibars(), atmosphere.temperatureCelsius(),
                                 xin, xaz);
    return new Horizontal(xaz[0], xaz[1], xaz[2]);
  }

  // -----------------------------------------------------------------------------------------
  // Rising, setting, culminating
  // -----------------------------------------------------------------------------------------

  /** The next rise or set, under the standard atmosphere and default disc handling. */
  public Optional<JulianDayUT> nextRiseSet(JulianDayUT after,
                                           Body body,
                                           RiseSetEvent event,
                                           GeoLocation place,
                                           Ephemeris ephemeris) {
    return nextRiseSet(after, body, event, place, ephemeris,
                       EnumSet.noneOf(RiseSetOption.class), Atmosphere.STANDARD);
  }

  /**
   * When a body next rises, sets, or crosses the meridian.
   *
   * <p>The result is an {@link Optional} because "it does not happen" is a real, ordinary answer,
   * not a failure: inside the polar circles a body can stay up or stay down for months. The
   * legacy API distinguishes that ({@code -2}) from a genuine error ({@code -1}), but callers
   * routinely collapse both into null and lose the difference —— a polar summer then looks like a
   * malfunction. Here a real failure still throws.
   *
   * @param after      search forward from this instant
   * @param body       what to watch for
   * @param event      which moment in its daily circuit
   * @param place      where the observer is
   * @param ephemeris  which ephemeris to compute the body's motion from
   * @param options    how to treat the disc and the atmosphere; ignored for the transits
   * @param atmosphere the air the body is seen through
   * @return when it happens, or empty if it does not happen at all
   * @throws SwissEphemerisException if the search failed
   */
  public Optional<JulianDayUT> nextRiseSet(JulianDayUT after,
                                           Body body,
                                           RiseSetEvent event,
                                           GeoLocation place,
                                           Ephemeris ephemeris,
                                           Set<RiseSetOption> options,
                                           Atmosphere atmosphere) {
    Objects.requireNonNull(after, "after");
    Objects.requireNonNull(body, "body");
    Objects.requireNonNull(event, "event");
    Objects.requireNonNull(place, "place");
    Objects.requireNonNull(ephemeris, "ephemeris");
    Objects.requireNonNull(options, "options");
    Objects.requireNonNull(atmosphere, "atmosphere");

    Context context = perThread.get();
    double[] geopos = {place.longitudeDeg(), place.latitudeDeg(), place.altitudeMetres()};
    DblObj found = new DblObj(0.0);
    StringBuffer serr = new StringBuffer();

    int ipl;
    StringBuffer starName;
    if (body instanceof Body.FixedStar star) {
      ipl = 0;
      starName = new StringBuffer(star.name());
    } else {
      ipl = numberOf(body);
      starName = null;
    }

    int returned = context.se.swe_rise_trans(
        after.value(), ipl, starName, ephemeris.bit(),
        event.bit() | RiseSetOption.bitmask(options), geopos,
        atmosphere.pressureMillibars(), atmosphere.temperatureCelsius(), found, serr);

    if (returned == DOES_NOT_HAPPEN) {
      return Optional.empty();
    }
    if (returned == SweConst.ERR) {
      throw new SwissEphemerisException(
          "cannot find the " + event + " of " + body.displayName() + " after " + after
          + " at " + place + ": " + (serr.isEmpty() ? "no reason given" : serr.toString()));
    }
    return Optional.of(JulianDayUT.of(found.val));
  }

  /**
   * The legacy return code for "this body never rises or sets here", as opposed to
   * {@link SweConst#ERR} for a failure. It has no name in {@code SweConst}.
   */
  private static final int DOES_NOT_HAPPEN = -2;

  // -----------------------------------------------------------------------------------------
  // Lifecycle
  // -----------------------------------------------------------------------------------------

  /**
   * Releases every calculation context this instance has handed out.
   *
   * <p>Rarely needed. Contexts hold no file handles —— data files are read once into memory that
   * the whole process shares —— so letting them go out of scope with their threads is fine. This
   * exists for the case of deliberately discarding an instance while the process continues, such
   * as a test that swaps the ephemeris directory underneath.
   */
  @Override
  public void close() {
    List<Context> snapshot;
    synchronized (live) {
      snapshot = new ArrayList<>(live);
      live.clear();
    }
    for (Context context : snapshot) {
      context.se.swe_close();
    }
    perThread.remove();
  }

  @Override
  public String toString() {
    return "SwissEphemeris[" + (ephemerisPath.isEmpty() ? "no data files" : ephemerisPath) + "]";
  }

  private Context newContext() {
    Context context = new Context(new SwissEph(ephemerisPath));
    live.add(context);
    return context;
  }

  /**
   * One thread's calculation state: a legacy instance, plus what has already been set on it.
   *
   * <p>Remembering the last centre and zodiac is not just a saving. {@code swe_set_topo} discards
   * cached apparent positions on every call, so re-applying an unchanged observer position would
   * throw away work the underlying instance had done —— on every single call.
   */
  private static final class Context {
    private final SwissEph se;
    private Centre centre = Centre.geocentric();
    private Zodiac zodiac = Zodiac.tropical();

    Context(SwissEph se) {
      this.se = se;
    }

    void apply(Centre wanted, Zodiac wantedZodiac) {
      if (wanted instanceof Centre.Topocentric topo && !wanted.equals(centre)) {
        se.swe_set_topo(topo.longitudeDeg(), topo.latitudeDeg(), topo.altitudeMetres());
      }
      centre = wanted;

      if (!wantedZodiac.equals(zodiac)) {
        if (wantedZodiac instanceof Zodiac.Sidereal sidereal) {
          se.swe_set_sid_mode(sidereal.ayanamsaMode(), 0, 0);
        } else if (wantedZodiac instanceof Zodiac.SiderealUserDefined user) {
          se.swe_set_sid_mode(SweConst.SE_SIDM_USER,
                              user.referenceJulianDay().value(),
                              user.ayanamsaDeg());
        }
        zodiac = wantedZodiac;
      }
    }
  }
}
