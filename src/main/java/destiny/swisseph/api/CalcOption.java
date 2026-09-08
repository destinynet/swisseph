/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Modifiers on a position calculation, as a set rather than a hand-assembled bitmask.
 *
 * <p>Deliberately absent from this enum are the flags that are not modifiers at all but choices
 * with their own type:
 *
 * <ul>
 *   <li>the ephemeris bits — see {@link Ephemeris}
 *   <li>{@code SEFLG_TOPOCTR} / {@code SEFLG_HELCTR} / {@code SEFLG_BARYCTR} — see {@link Centre},
 *       which also carries the observer position that topocentric positions require
 *   <li>{@code SEFLG_SIDEREAL} — see {@link Zodiac}, which carries the ayanamsa
 * </ul>
 *
 * <p>Keeping those out is the point: in the legacy API a topocentric position needs both the flag
 * and a separate {@code swe_set_topo()} call, and setting one without the other fails quietly.
 */
public enum CalcOption {

  /** Also return speeds, computed to high precision. */
  SPEED(SweConst.SEFLG_SPEED),

  /** Return equatorial coordinates (right ascension, declination) instead of ecliptic. */
  EQUATORIAL(SweConst.SEFLG_EQUATORIAL),

  /** Return cartesian coordinates instead of polar. */
  CARTESIAN(SweConst.SEFLG_XYZ),

  /** Return angles in radians instead of degrees. */
  RADIANS(SweConst.SEFLG_RADIANS),

  /** Return true positions rather than apparent ones. */
  TRUE_POSITION(SweConst.SEFLG_TRUEPOS),

  /** Refer positions to J2000 rather than to the equinox of the date. */
  J2000(SweConst.SEFLG_J2000),

  /** Refer positions to the mean equinox of the date: no nutation. */
  NO_NUTATION(SweConst.SEFLG_NONUT),

  /** Turn off gravitational deflection by the Sun. */
  NO_GRAVITATIONAL_DEFLECTION(SweConst.SEFLG_NOGDEFL),

  /** Turn off annual aberration of light. */
  NO_ABERRATION(SweConst.SEFLG_NOABERR),

  /** Use the ICRS reference frame. */
  ICRS(SweConst.SEFLG_ICRS);

  private final int bit;

  CalcOption(int bit) {
    this.bit = bit;
  }

  /** The legacy {@code SEFLG_*} bit for this option. */
  public int bit() {
    return bit;
  }

  /** Folds a set of options into the legacy bitmask. */
  static int bitmask(Set<CalcOption> options) {
    int mask = 0;
    for (CalcOption option : options) {
      mask |= option.bit;
    }
    return mask;
  }

  /**
   * Reads back the options the underlying calculation reported it honoured.
   *
   * <p>Bits that are not modifiers —— the ephemeris, centre and zodiac choices —— are ignored here;
   * they come back through their own types.
   */
  static Set<CalcOption> decode(int flags) {
    EnumSet<CalcOption> found = EnumSet.noneOf(CalcOption.class);
    for (CalcOption option : values()) {
      if ((flags & option.bit) == option.bit) {
        found.add(option);
      }
    }
    return Collections.unmodifiableSet(found);
  }
}
