/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

import java.util.Set;

/** Modifiers on a nodes-and-apsides calculation. */
public enum ApsisOption {

  /**
   * Return the orbit's second focus in place of the aphelion.
   *
   * <p>For the Moon this is the "Black Moon Lilith" of astrological usage, which is a different
   * point from the lunar apogee even though the two are often conflated.
   *
   * <p>When this is set, {@link NodesAndApsides#aphelion()} holds the focal point.
   */
  FOCAL_POINT(SweConst.SE_NODBIT_FOPOINT);

  private final int bit;

  ApsisOption(int bit) {
    this.bit = bit;
  }

  static int bitmask(Set<ApsisOption> options) {
    int mask = 0;
    for (ApsisOption option : options) {
      mask |= option.bit;
    }
    return mask;
  }
}
