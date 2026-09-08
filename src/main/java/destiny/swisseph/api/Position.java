/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.Optional;

/**
 * Where a body is, and how fast it is moving.
 *
 * <p>Sealed, with one variant per coordinate system, because the legacy API returns all three in
 * the same {@code double[6]} and leaves the caller to remember which flags they passed. Reading
 * {@code xx[0]} as an ecliptic longitude when {@code SEFLG_EQUATORIAL} was set gives a right
 * ascension —— a plausible number, in the same units, that is simply not what the caller thinks it
 * is. Naming the components per variant makes that confusion impossible to write down.
 *
 * <p>Speeds live inside the variant for exactly the same reason, with the same per-variant names:
 * {@code xx[3]} is degrees of longitude per day, or degrees of right ascension per day, or AU
 * along x per day, depending on flags the speed value itself does not carry.
 *
 * <p>They are {@link Optional} because the legacy API fills those slots with zeroes when
 * {@link CalcOption#SPEED} was not requested, and zero is not "not moving" —— it is "not computed".
 * An absent speed cannot be misread as a stationary body.
 */
public sealed interface Position {

  /** Distance from the centre of reference, in astronomical units. */
  double distanceAu();

  /** How fast the body is moving, if {@link CalcOption#SPEED} was requested. */
  Optional<? extends Speed> speed();

  /**
   * Common ground for the per-coordinate-system speeds, so that {@link #speed()} has a type.
   *
   * <p>Deliberately empty. The three variants share no component that means the same thing in
   * all of them —— even "how fast the distance changes" is a returned value for the polar ones
   * and not determined by the cartesian speed alone. Anything hoisted up here would have to be
   * wrong for one of them.
   */
  sealed interface Speed permits EclipticSpeed, EquatorialSpeed, CartesianSpeed { }

  // -----------------------------------------------------------------------------------------

  /**
   * Ecliptic coordinates: the default, and what astrology means by a position.
   *
   * @param longitudeDeg along the ecliptic, 0 to 360
   * @param latitudeDeg  north (+) or south (-) of the ecliptic
   * @param distanceAu   from the centre of reference
   * @param speed        present only if {@link CalcOption#SPEED} was requested
   */
  record Ecliptic(double longitudeDeg,
                  double latitudeDeg,
                  double distanceAu,
                  Optional<EclipticSpeed> speed) implements Position { }

  /**
   * @param longitudeDegPerDay along the ecliptic; negative means retrograde
   * @param latitudeDegPerDay  towards ecliptic north (+) or south (-)
   * @param distanceAuPerDay   receding (+) or approaching (-)
   */
  record EclipticSpeed(double longitudeDegPerDay,
                       double latitudeDegPerDay,
                       double distanceAuPerDay) implements Speed {

    /** True when the body appears to move backwards through the zodiac. */
    public boolean isRetrograde() {
      return longitudeDegPerDay < 0;
    }
  }

  // -----------------------------------------------------------------------------------------

  /**
   * Equatorial coordinates —— what {@link CalcOption#EQUATORIAL} returns.
   *
   * @param rightAscensionDeg along the celestial equator, 0 to 360 (degrees, not hours)
   * @param declinationDeg    north (+) or south (-) of the celestial equator
   * @param distanceAu        from the centre of reference
   * @param speed             present only if {@link CalcOption#SPEED} was requested
   */
  record Equatorial(double rightAscensionDeg,
                    double declinationDeg,
                    double distanceAu,
                    Optional<EquatorialSpeed> speed) implements Position { }

  /**
   * @param rightAscensionDegPerDay along the celestial equator
   * @param declinationDegPerDay    towards celestial north (+) or south (-)
   * @param distanceAuPerDay        receding (+) or approaching (-)
   */
  record EquatorialSpeed(double rightAscensionDegPerDay,
                         double declinationDegPerDay,
                         double distanceAuPerDay) implements Speed { }

  // -----------------------------------------------------------------------------------------

  /**
   * Rectangular coordinates —— what {@link CalcOption#CARTESIAN} returns.
   *
   * @param x     astronomical units
   * @param y     astronomical units
   * @param z     astronomical units
   * @param speed present only if {@link CalcOption#SPEED} was requested
   */
  record Cartesian(double x, double y, double z, Optional<CartesianSpeed> speed) implements Position {
    @Override
    public double distanceAu() {
      return Math.sqrt(x * x + y * y + z * z);
    }
  }

  /**
   * @param xAuPerDay astronomical units per day
   * @param yAuPerDay astronomical units per day
   * @param zAuPerDay astronomical units per day
   */
  record CartesianSpeed(double xAuPerDay, double yAuPerDay, double zAuPerDay) implements Speed { }
}
