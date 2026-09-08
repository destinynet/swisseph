/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * A moment in a body's daily circuit of the sky.
 *
 * <p>An enum rather than the legacy's {@code int rsmi}, which mixes the event with a handful of
 * modifier bits in one integer —— see {@link RiseSetOption} for the modifiers, kept separate.
 */
public enum RiseSetEvent {

  /** Crossing the horizon upward. */
  RISE(SweConst.SE_CALC_RISE),

  /** Crossing the horizon downward. */
  SET(SweConst.SE_CALC_SET),

  /** Crossing the meridian above the horizon: the body's highest point, its culmination. */
  UPPER_TRANSIT(SweConst.SE_CALC_MTRANSIT),

  /** Crossing the meridian below the horizon: the body's lowest point. */
  LOWER_TRANSIT(SweConst.SE_CALC_ITRANSIT);

  private final int bit;

  RiseSetEvent(int bit) {
    this.bit = bit;
  }

  int bit() {
    return bit;
  }
}
