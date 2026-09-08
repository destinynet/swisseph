/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * What quantity a transit search watches for a given value.
 *
 * <p>The legacy API expresses this as more bits in the same {@code iflag} mask that also carries
 * the ephemeris, the coordinate system and everything else —— so "which quantity" and "how to
 * compute it" are indistinguishable at the call site, and leaving the quantity out entirely
 * still compiles.
 */
public enum TransitQuantity {

  /** The body's ecliptic longitude reaches a value. */
  LONGITUDE(SweConst.SEFLG_TRANSIT_LONGITUDE),

  /** Its ecliptic latitude reaches a value. */
  LATITUDE(SweConst.SEFLG_TRANSIT_LATITUDE),

  /** Its distance reaches a value, in AU. */
  DISTANCE(SweConst.SEFLG_TRANSIT_DISTANCE),

  /**
   * Its speed in longitude reaches a value.
   *
   * <p>With a target of zero this finds a station —— the moment a planet stops and turns, which is
   * how retrogradation is bounded.
   */
  LONGITUDE_SPEED(SweConst.SEFLG_TRANSIT_LONGITUDE | SweConst.SEFLG_TRANSIT_SPEED),

  /** Its speed in latitude reaches a value. */
  LATITUDE_SPEED(SweConst.SEFLG_TRANSIT_LATITUDE | SweConst.SEFLG_TRANSIT_SPEED),

  /** Its speed in distance —— how fast it is receding or approaching —— reaches a value. */
  DISTANCE_SPEED(SweConst.SEFLG_TRANSIT_DISTANCE | SweConst.SEFLG_TRANSIT_SPEED);

  private final int bits;

  TransitQuantity(int bits) {
    this.bits = bits;
  }

  int bits() {
    return bits;
  }
}
