/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * Where a body appears in the observer's sky.
 *
 * <p>Note the azimuth convention, which is the trap here: Swiss Ephemeris measures it
 * <b>from south, towards west</b>, not from north as a compass does. The two differ by 180°, and
 * neither reading is obviously wrong when you look at the number —— so this type names the one it
 * holds and offers the other by conversion rather than leaving a bare "azimuth" to be guessed at.
 *
 * @param azimuthFromSouthDeg   0 at due south, increasing westward —— the library's own convention
 * @param trueAltitudeDeg       geometric altitude above the horizon, before refraction
 * @param apparentAltitudeDeg   altitude as actually seen, refraction included
 */
public record Horizontal(double azimuthFromSouthDeg,
                         double trueAltitudeDeg,
                         double apparentAltitudeDeg) {

  /**
   * The same direction in the compass convention: 0 at due north, increasing eastward.
   *
   * <p>A half turn, not a mirroring —— both conventions run the same way round the horizon, they
   * just start from opposite points. (Follow the Sun: it is due east in the morning, due south at
   * noon, due west in the afternoon, and the number grows all day in either convention.) Getting
   * this wrong is invisible due north and due south, where a mirroring happens to agree, and
   * swaps east for west everywhere else.
   */
  public double azimuthFromNorthDeg() {
    double fromNorth = (azimuthFromSouthDeg + 180) % 360;
    return fromNorth < 0 ? fromNorth + 360 : fromNorth;
  }

  /** True when the body is above the horizon as seen, refraction included. */
  public boolean isVisible() {
    return apparentAltitudeDeg > 0;
  }
}
