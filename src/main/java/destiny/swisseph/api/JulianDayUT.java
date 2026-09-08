/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A Julian day number in Universal Time.
 *
 * <p>Swiss Ephemeris has two time scales that differ by delta-T (about 70 seconds today), and in
 * the legacy API both are a bare {@code double}: {@code tjd_ut} and {@code tjd_et} are passed to
 * different functions, and handing one to the other compiles cleanly and returns a plausible
 * wrong answer. That is this API's real trap, and it is the reason these two types exist.
 *
 * <p>Deliberately not the same type as destiny-core's {@code GmtJulDay}. Copying a type is cheap;
 * copying its dependency tree is not, and this library has none. Converting at the boundary costs
 * nothing: {@code JulianDayUT.of(gmtJulDay.getValue())}.
 *
 * @param value the Julian day number, days since -4712-01-01 12:00 UT
 * @see JulianDayET
 */
public record JulianDayUT(double value) implements Comparable<JulianDayUT> {

  public static JulianDayUT of(double value) {
    return new JulianDayUT(value);
  }

  @Override
  public int compareTo(JulianDayUT other) {
    return Double.compare(value, other.value);
  }

  @Override
  public String toString() {
    return "JD " + value + " UT";
  }
}
