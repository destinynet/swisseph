/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/** What kind of lunar eclipse. */
public enum LunarEclipseKind {

  /** The Moon passes entirely into the Earth's umbra. */
  TOTAL(SweConst.SE_ECL_TOTAL),

  /** Part of the Moon enters the umbra. */
  PARTIAL(SweConst.SE_ECL_PARTIAL),

  /**
   * The Moon passes only through the penumbra —— a slight, easily missed dimming rather than
   * anything a casual observer would call an eclipse.
   */
  PENUMBRAL(SweConst.SE_ECL_PENUMBRAL);

  private final int bit;

  LunarEclipseKind(int bit) {
    this.bit = bit;
  }

  int bit() {
    return bit;
  }

  static LunarEclipseKind from(int returnedFlags) {
    for (LunarEclipseKind kind : values()) {
      if ((returnedFlags & kind.bit) != 0) {
        return kind;
      }
    }
    throw new SwissEphemerisException(
        "no lunar eclipse kind in the returned flags 0x" + Integer.toHexString(returnedFlags));
  }
}
