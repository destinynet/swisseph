/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * Where a body is.
 *
 * <p>Sealed, with one variant per coordinate system, because the legacy API returns all three in
 * the same {@code double[6]} and leaves the caller to remember which flags they passed. Reading
 * {@code xx[0]} as an ecliptic longitude when {@code SEFLG_EQUATORIAL} was set gives a right
 * ascension —— a plausible number, in the same units, that is simply not what the caller thinks it
 * is. Naming the components per variant makes that confusion impossible to write down.
 */
public sealed interface Position {

  /** Distance from the centre of reference, in astronomical units. */
  double distanceAu();

  /**
   * Ecliptic coordinates: the default, and what astrology means by a position.
   *
   * @param longitudeDeg along the ecliptic, 0 to 360
   * @param latitudeDeg  north (+) or south (-) of the ecliptic
   * @param distanceAu   from the centre of reference
   */
  record Ecliptic(double longitudeDeg, double latitudeDeg, double distanceAu) implements Position { }

  /**
   * Equatorial coordinates —— what {@link CalcOption#EQUATORIAL} returns.
   *
   * @param rightAscensionDeg along the celestial equator, 0 to 360 (degrees, not hours)
   * @param declinationDeg    north (+) or south (-) of the celestial equator
   * @param distanceAu        from the centre of reference
   */
  record Equatorial(double rightAscensionDeg, double declinationDeg, double distanceAu) implements Position { }

  /**
   * Rectangular coordinates —— what {@link CalcOption#CARTESIAN} returns.
   *
   * @param x astronomical units
   * @param y astronomical units
   * @param z astronomical units
   */
  record Cartesian(double x, double y, double z) implements Position {
    @Override
    public double distanceAu() {
      return Math.sqrt(x * x + y * y + z * z);
    }
  }
}
