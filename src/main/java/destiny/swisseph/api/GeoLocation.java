/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A place on the Earth.
 *
 * <p>Exists mainly to stop longitude and latitude being swapped. They are two bare doubles in the
 * legacy API, and the order is not consistent across it: {@code swe_houses} takes latitude first,
 * {@code swe_set_topo} takes longitude first, and {@code swe_azalt} takes an array that is
 * longitude, latitude, altitude. Swapping them is an easy mistake that yields a chart for
 * somewhere else rather than an error.
 *
 * @param longitudeDeg   east of Greenwich (+) or west (-), in degrees
 * @param latitudeDeg    north of the equator (+) or south (-), in degrees
 * @param altitudeMetres above sea level
 */
public record GeoLocation(double longitudeDeg, double latitudeDeg, double altitudeMetres) {

  public GeoLocation {
    if (latitudeDeg < -90 || latitudeDeg > 90) {
      throw new IllegalArgumentException("latitude out of range: " + latitudeDeg);
    }
    if (longitudeDeg < -180 || longitudeDeg > 360) {
      throw new IllegalArgumentException("longitude out of range: " + longitudeDeg);
    }
  }

  /** At sea level. */
  public static GeoLocation of(double longitudeDeg, double latitudeDeg) {
    return new GeoLocation(longitudeDeg, latitudeDeg, 0);
  }

  /** This place, as an observation point for a topocentric calculation. */
  public Centre asObserver() {
    return Centre.topocentric(longitudeDeg, latitudeDeg, altitudeMetres);
  }
}
