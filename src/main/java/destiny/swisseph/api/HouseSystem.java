/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A way of dividing the sky into twelve houses.
 *
 * <p>The legacy API takes this as an {@code int} that is really a character code —— {@code 'P'}
 * for Placidus, and so on —— with an unusual failure mode: an unrecognised code does not fail, it
 * silently computes Placidus. A typo therefore produces a complete, plausible, wrong chart. An
 * enum removes the possibility.
 */
public enum HouseSystem {

  /** Placidus. The most widely used system, and what the legacy API falls back to. */
  PLACIDUS('P', "Placidus"),

  KOCH('K', "Koch"),
  PORPHYRY('O', "Porphyry"),
  REGIOMONTANUS('R', "Regiomontanus"),
  CAMPANUS('C', "Campanus"),

  /** Equal houses from the ascendant. */
  EQUAL('E', "equal"),

  /** Equal houses, with the ascendant in the middle of the first house. */
  VEHLOW_EQUAL('V', "equal/Vehlow"),

  /** Whole sign houses: each house is one whole zodiac sign. */
  WHOLE_SIGN('W', "whole sign"),

  ALCABITIUS('B', "Alcabitius"),
  MORINUS('M', "Morinus"),
  POLICH_PAGE('T', "Polich/Page"),
  KRUSINSKI('U', "Krusinski-Pisa-Goelzer"),
  APC('Y', "APC"),

  /** Axial rotation, also known as the Meridian system. */
  AXIAL_ROTATION('X', "axial rotation/Meridian"),

  /** Horizon (azimuthal) houses. */
  HORIZON('H', "horizon/azimuth"),

  /** Gauquelin sectors —— 36 of them, not 12; see {@link Houses#cusps()}. */
  GAUQUELIN_SECTORS('G', "Gauquelin sectors");

  private final char code;
  private final String displayName;

  HouseSystem(char code, String displayName) {
    this.code = code;
    this.displayName = displayName;
  }

  /** The legacy character code. */
  public char code() {
    return code;
  }

  /** The name Swiss Ephemeris itself uses for this system. */
  public String displayName() {
    return displayName;
  }
}
