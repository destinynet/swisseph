/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A Julian day number in Ephemeris Time (Terrestrial Time).
 *
 * <p>The counterpart to {@link JulianDayUT}; see there for why these are separate types.
 *
 * @param value the Julian day number, days since -4712-01-01 12:00 TT
 */
public record JulianDayET(double value) implements Comparable<JulianDayET> {

  public static JulianDayET of(double value) {
    return new JulianDayET(value);
  }

  @Override
  public int compareTo(JulianDayET other) {
    return Double.compare(value, other.value);
  }

  @Override
  public String toString() {
    return "JD " + value + " ET";
  }
}
