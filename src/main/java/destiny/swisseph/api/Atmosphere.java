/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * The air a body is seen through —— what bends its light, and so what separates where a body
 * really is from where it appears to be.
 *
 * <p>Matters most near the horizon, where refraction lifts an object by about half a degree ——
 * enough that the Sun is wholly above the horizon at the moment it geometrically touches it.
 *
 * @param pressureMillibars    at the observer; 0 asks the library to estimate it from the altitude
 * @param temperatureCelsius   at the observer
 */
public record Atmosphere(double pressureMillibars, double temperatureCelsius) {

  /** Sea-level pressure and 15 °C —— the ICAO standard atmosphere. */
  public static final Atmosphere STANDARD = new Atmosphere(1013.25, 15);

  /**
   * No atmosphere: geometric positions, unrefracted.
   *
   * <p>Note this is not the same as passing zero pressure to the legacy API, which means
   * "estimate the pressure" rather than "no air".
   */
  public static final Atmosphere VACUUM = new Atmosphere(0, 0);
}
