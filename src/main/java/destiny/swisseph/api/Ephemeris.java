/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * Which ephemeris to compute from.
 *
 * <p>An enum rather than a flag, because the three are mutually exclusive: the legacy API takes
 * {@code SEFLG_JPLEPH | SEFLG_SWIEPH | SEFLG_MOSEPH} as bits in the same mask, so nothing stops
 * a caller from asking for two at once and silently getting whichever the implementation checks
 * first.
 *
 * <p>Choosing one that has no data files available is not an error: the calculation falls back
 * to Moshier and says so through {@link Warning#EPHEMERIS_FILE_MISSING}.
 */
public enum Ephemeris {

  /** Swiss Ephemeris compressed files ({@code .se1}). Highest precision when the files are present. */
  SWISS(SweConst.SEFLG_SWIEPH),

  /** Moshier's analytical theory. Needs no data files; roughly one arcsecond for the planets. */
  MOSHIER(SweConst.SEFLG_MOSEPH),

  /** JPL DE ephemeris files. Highest precision of all, but the files are large. */
  JPL(SweConst.SEFLG_JPLEPH);

  private final int bit;

  Ephemeris(int bit) {
    this.bit = bit;
  }

  /** The legacy {@code SEFLG_*} bit for this choice. */
  public int bit() {
    return bit;
  }
}
