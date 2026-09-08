/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;

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

  private static CalcResult assemble(int returnedFlags,
                                     double[] xx,
                                     StringBuffer serr,
                                     Set<CalcOption> requested,
                                     String resolvedName) {
    Position position;
    if (requested.contains(CalcOption.CARTESIAN)) {
      position = new Position.Cartesian(xx[0], xx[1], xx[2]);
    } else if (requested.contains(CalcOption.EQUATORIAL)) {
      position = new Position.Equatorial(xx[0], xx[1], xx[2]);
    } else {
      position = new Position.Ecliptic(xx[0], xx[1], xx[2]);
    }

    // Speeds are only meaningful if they were asked for; otherwise the slots hold zeroes, which
    // would read as "not moving" rather than "not computed".
    Optional<Motion> motion = requested.contains(CalcOption.SPEED)
        ? Optional.of(new Motion(xx[3], xx[4], xx[5]))
        : Optional.empty();

    List<Warning> warnings = new ArrayList<>(1);
    if (!serr.isEmpty()) {
      warnings.add(Warning.classify(serr.toString()));
    }

    return new CalcResult(position, motion, ephemerisOf(returnedFlags),
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
