/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

import java.util.Set;

/**
 * How to decide that a rise or a set has happened.
 *
 * <p>These change the answer by minutes, and they are not academic: whether "sunrise" means the
 * upper edge of the disc or its centre is a difference of a couple of minutes, and refraction is
 * worth about another two.
 *
 * <p>Meaningful only for {@link RiseSetEvent#RISE} and {@link RiseSetEvent#SET}; the transits do
 * not involve the horizon at all.
 */
public enum RiseSetOption {

  /** Time the centre of the disc across the horizon, rather than its upper edge. */
  DISC_CENTRE(SweConst.SE_BIT_DISC_CENTER),

  /** Time the lower edge of the disc across the horizon. */
  DISC_BOTTOM(SweConst.SE_BIT_DISC_BOTTOM),

  /** Treat the disc as a fixed size rather than scaling it with distance. */
  FIXED_DISC_SIZE(SweConst.SE_BIT_FIXED_DISC_SIZE),

  /** Ignore atmospheric refraction: give the geometric crossing. */
  NO_REFRACTION(SweConst.SE_BIT_NO_REFRACTION),

  /** Civil twilight: the Sun 6° below the horizon. */
  CIVIL_TWILIGHT(SweConst.SE_BIT_CIVIL_TWILIGHT),

  /** Nautical twilight: the Sun 12° below the horizon. */
  NAUTICAL_TWILIGHT(SweConst.SE_BIT_NAUTIC_TWILIGHT),

  /** Astronomical twilight: the Sun 18° below the horizon. */
  ASTRONOMICAL_TWILIGHT(SweConst.SE_BIT_ASTRO_TWILIGHT);

  private final int bit;

  RiseSetOption(int bit) {
    this.bit = bit;
  }

  int bit() {
    return bit;
  }

  static int bitmask(Set<RiseSetOption> options) {
    int mask = 0;
    for (RiseSetOption option : options) {
      mask |= option.bit;
    }
    return mask;
  }
}
