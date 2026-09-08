/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

import java.util.Objects;

/**
 * What to compute the position of.
 *
 * <p>Sealed rather than an enum because the space is not closed: minor planets are any integer
 * above {@link SweConst#SE_AST_OFFSET}, and fixed stars are named, not numbered. The legacy API
 * expresses all of that as one {@code int ipl}, so nothing distinguishes a valid body number from
 * a typo, and fixed stars go through an entirely different function that the type system does not
 * connect to the others.
 */
public sealed interface Body {

  /** A short, stable name for this body, for messages. */
  String displayName();

  /**
   * The body a legacy {@code ipl} number refers to.
   *
   * <p>A bridge for code being migrated, where the number is already being produced by some
   * existing mapping that is worth keeping —— one that encodes choices the number alone does not
   * show, such as whether "the lunar node" means the mean node or the true one. New code should
   * name the body directly instead; that is the whole point of this type.
   *
   * @throws IllegalArgumentException if no body has that number
   */
  static Body ofLegacyNumber(int ipl) {
    if (ipl >= SweConst.SE_AST_OFFSET) {
      return new MinorPlanet(ipl - SweConst.SE_AST_OFFSET);
    }
    for (Point point : Point.values()) {
      if (point.number() == ipl) {
        return point;
      }
    }
    throw new IllegalArgumentException("no body has the number " + ipl);
  }

  /** The bodies Swiss Ephemeris addresses by a small fixed number. */
  enum Point implements Body {
    SUN(SweConst.SE_SUN),
    MOON(SweConst.SE_MOON),
    MERCURY(SweConst.SE_MERCURY),
    VENUS(SweConst.SE_VENUS),
    MARS(SweConst.SE_MARS),
    JUPITER(SweConst.SE_JUPITER),
    SATURN(SweConst.SE_SATURN),
    URANUS(SweConst.SE_URANUS),
    NEPTUNE(SweConst.SE_NEPTUNE),
    PLUTO(SweConst.SE_PLUTO),

    /** Earth, meaningful only in a heliocentric or barycentric frame. */
    EARTH(SweConst.SE_EARTH),

    MEAN_LUNAR_NODE(SweConst.SE_MEAN_NODE),
    TRUE_LUNAR_NODE(SweConst.SE_TRUE_NODE),
    MEAN_LUNAR_APOGEE(SweConst.SE_MEAN_APOG),
    OSCULATING_LUNAR_APOGEE(SweConst.SE_OSCU_APOG),
    INTERPOLATED_LUNAR_APOGEE(SweConst.SE_INTP_APOG),
    INTERPOLATED_LUNAR_PERIGEE(SweConst.SE_INTP_PERG),

    CHIRON(SweConst.SE_CHIRON),
    PHOLUS(SweConst.SE_PHOLUS),
    CERES(SweConst.SE_CERES),
    PALLAS(SweConst.SE_PALLAS),
    JUNO(SweConst.SE_JUNO),
    VESTA(SweConst.SE_VESTA),

    /** Uranian ("Hamburg School") hypothetical bodies. */
    CUPIDO(SweConst.SE_CUPIDO),
    HADES(SweConst.SE_HADES),
    ZEUS(SweConst.SE_ZEUS),
    KRONOS(SweConst.SE_KRONOS),
    APOLLON(SweConst.SE_APOLLON),
    ADMETOS(SweConst.SE_ADMETOS),
    VULKANUS(SweConst.SE_VULKANUS),
    POSEIDON(SweConst.SE_POSEIDON);

    private final int number;

    Point(int number) {
      this.number = number;
    }

    /** The legacy {@code ipl} number. */
    public int number() {
      return number;
    }

    @Override
    public String displayName() {
      return name();
    }
  }

  /**
   * A minor planet, by its catalogue number —— 1 for Ceres, 433 for Eros, and so on.
   *
   * <p>Needs the corresponding {@code seas*.se1} or {@code se00001s.se1} file to be available;
   * without it the call comes back with {@link Warning.Kind#EPHEMERIS_FILE_MISSING}.
   *
   * @param catalogueNumber the minor planet number, as in the IAU catalogue
   */
  record MinorPlanet(int catalogueNumber) implements Body {
    public MinorPlanet {
      if (catalogueNumber <= 0) {
        throw new IllegalArgumentException("minor planet number must be positive, got " + catalogueNumber);
      }
    }

    /** The legacy {@code ipl} number, which for minor planets is offset. */
    public int number() {
      return SweConst.SE_AST_OFFSET + catalogueNumber;
    }

    @Override
    public String displayName() {
      return "minor planet " + catalogueNumber;
    }
  }

  /**
   * A fixed star, by a name the star catalogue recognises —— a traditional name ("Aldebaran"), a
   * Bayer designation ("alTau"), or a catalogue line number.
   *
   * <p>Reaching one of these goes through a different underlying function than the numbered
   * bodies. That is an implementation detail here: {@code calculate} takes any {@code Body}.
   *
   * @param name as it appears in {@code sefstars.txt}
   */
  record FixedStar(String name) implements Body {
    public FixedStar {
      Objects.requireNonNull(name, "name");
      if (name.isBlank()) {
        throw new IllegalArgumentException("fixed star name must not be blank");
      }
    }

    @Override
    public String displayName() {
      return name;
    }
  }
}
