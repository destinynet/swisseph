/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/** What kind of solar eclipse. */
public enum SolarEclipseKind {

  /** The Moon covers the Sun entirely. */
  TOTAL(SweConst.SE_ECL_TOTAL),

  /** The Moon is too far away to cover the Sun, leaving a ring of light. */
  ANNULAR(SweConst.SE_ECL_ANNULAR),

  /** The Moon covers only part of the Sun. */
  PARTIAL(SweConst.SE_ECL_PARTIAL),

  /**
   * Total along part of the track and annular along the rest, because the Earth's curvature
   * brings some places close enough to the Moon and not others. Also called a hybrid eclipse.
   */
  ANNULAR_TOTAL(SweConst.SE_ECL_ANNULAR_TOTAL);

  private final int bit;

  SolarEclipseKind(int bit) {
    this.bit = bit;
  }

  int bit() {
    return bit;
  }

  /** Reads the kind out of the legacy return code, which packs it into a bitmask. */
  static SolarEclipseKind from(int returnedFlags) {
    for (SolarEclipseKind kind : values()) {
      if ((returnedFlags & kind.bit) != 0) {
        return kind;
      }
    }
    throw new SwissEphemerisException(
        "no solar eclipse kind in the returned flags 0x" + Integer.toHexString(returnedFlags));
  }
}
