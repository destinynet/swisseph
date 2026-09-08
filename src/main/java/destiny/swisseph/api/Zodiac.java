/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * Which zodiac longitudes are measured in.
 *
 * <p>Sealed rather than an enum for the same reason as {@link Centre}: a sidereal calculation
 * needs an ayanamsa, and in the legacy API supplying it is a separate {@code swe_set_sid_mode()}
 * call that has to be paired by hand with the {@code SEFLG_SIDEREAL} flag. Here the choice
 * carries what it needs.
 */
public sealed interface Zodiac {

  /** The legacy {@code SEFLG_*} bit for this choice; zero for tropical, which is the default. */
  int bit();

  /** Measured from the vernal equinox of the date. This is the default. */
  static Zodiac tropical() {
    return Tropical.INSTANCE;
  }

  /**
   * Measured from a fixed point, using one of the ayanamsas Swiss Ephemeris defines.
   *
   * @param ayanamsaMode one of the {@code SweConst.SE_SIDM_*} constants
   */
  static Zodiac sidereal(int ayanamsaMode) {
    return new Sidereal(ayanamsaMode);
  }

  /**
   * Measured from a fixed point the caller defines: the ayanamsa value at a reference instant.
   *
   * @param referenceJulianDay the instant the value below is measured at
   * @param ayanamsaDeg        the ayanamsa at that instant, in degrees
   */
  static Zodiac siderealUserDefined(JulianDayUT referenceJulianDay, double ayanamsaDeg) {
    return new SiderealUserDefined(referenceJulianDay, ayanamsaDeg);
  }

  /** @see Zodiac#tropical() */
  enum Tropical implements Zodiac {
    INSTANCE;

    @Override
    public int bit() {
      return 0;
    }
  }

  /** @see Zodiac#sidereal(int) */
  record Sidereal(int ayanamsaMode) implements Zodiac {
    @Override
    public int bit() {
      return SweConst.SEFLG_SIDEREAL;
    }
  }

  /** @see Zodiac#siderealUserDefined(JulianDayUT, double) */
  record SiderealUserDefined(JulianDayUT referenceJulianDay, double ayanamsaDeg) implements Zodiac {
    public SiderealUserDefined {
      if (referenceJulianDay == null) {
        throw new IllegalArgumentException("referenceJulianDay is required for a user-defined ayanamsa");
      }
    }

    @Override
    public int bit() {
      return SweConst.SEFLG_SIDEREAL;
    }
  }
}
