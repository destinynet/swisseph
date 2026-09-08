/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * How to derive a body's nodes and apsides.
 *
 * <p>The two differ in what they describe. Mean elements come from a smoothed, long-term orbit ——
 * steady, and what most traditional work means by "the lunar node". Osculating elements come from
 * the orbit the body is on at that exact instant, as if every other perturbation stopped; they
 * wobble, sometimes sharply.
 */
public enum ApsisMethod {

  /** Averaged orbital elements: smooth, slow-moving. */
  MEAN(SweConst.SE_NODBIT_MEAN),

  /** The instantaneous orbit at that moment. */
  OSCULATING(SweConst.SE_NODBIT_OSCU),

  /** Osculating, but about the solar system's barycentre rather than the Sun. */
  OSCULATING_BARYCENTRIC(SweConst.SE_NODBIT_OSCU_BAR);

  private final int bit;

  ApsisMethod(int bit) {
    this.bit = bit;
  }

  int bit() {
    return bit;
  }
}
