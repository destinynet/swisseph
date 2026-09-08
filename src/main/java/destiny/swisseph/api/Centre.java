/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * Where the observer is —— the origin the returned position is referred to.
 *
 * <p>Sealed rather than an enum so that {@link Topocentric} can carry the observer position it
 * needs. In the legacy API those are two separate steps: set {@code SEFLG_TOPOCTR} in the flag
 * mask, and call {@code swe_set_topo()} beforehand. Doing one without the other compiles and runs;
 * it just gives the wrong answer. Here the position and the choice are the same value, so the
 * mistake cannot be expressed.
 */
public sealed interface Centre {

  /** The legacy {@code SEFLG_*} bit for this choice; zero for geocentric, which is the default. */
  int bit();

  /** Seen from the centre of the Earth. This is the default. */
  static Centre geocentric() {
    return Geocentric.INSTANCE;
  }

  /** Seen from a place on the Earth's surface. */
  static Centre topocentric(double longitudeDeg, double latitudeDeg, double altitudeMetres) {
    return new Topocentric(longitudeDeg, latitudeDeg, altitudeMetres);
  }

  /** Seen from the centre of the Sun. */
  static Centre heliocentric() {
    return Heliocentric.INSTANCE;
  }

  /** Seen from the barycentre of the solar system. */
  static Centre barycentric() {
    return Barycentric.INSTANCE;
  }

  /** @see Centre#geocentric() */
  enum Geocentric implements Centre {
    INSTANCE;

    @Override
    public int bit() {
      return 0;
    }
  }

  /**
   * @param longitudeDeg    east of Greenwich, in degrees
   * @param latitudeDeg     north of the equator, in degrees
   * @param altitudeMetres  above sea level
   * @see Centre#topocentric(double, double, double)
   */
  record Topocentric(double longitudeDeg, double latitudeDeg, double altitudeMetres) implements Centre {
    @Override
    public int bit() {
      return SweConst.SEFLG_TOPOCTR;
    }
  }

  /** @see Centre#heliocentric() */
  enum Heliocentric implements Centre {
    INSTANCE;

    @Override
    public int bit() {
      return SweConst.SEFLG_HELCTR;
    }
  }

  /** @see Centre#barycentric() */
  enum Barycentric implements Centre {
    INSTANCE;

    @Override
    public int bit() {
      return SweConst.SEFLG_BARYCTR;
    }
  }
}
