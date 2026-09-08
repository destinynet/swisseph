/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * How fast a body is moving, in the coordinate system of the {@link Position} it accompanies.
 *
 * <p>Present only when {@link CalcOption#SPEED} was asked for. That is why it arrives as an
 * {@code Optional} rather than as three more fields on {@code Position}: without the option the
 * legacy API fills the speed slots with zeroes, which is not "no speed" but a wrong speed, and
 * every caller has to remember that. An absent {@code Motion} cannot be misread.
 *
 * @param first  degrees per day along the first coordinate (ecliptic longitude, right ascension),
 *               or AU per day along x for a cartesian position
 * @param second degrees per day along the second coordinate (latitude, declination), or AU per
 *               day along y
 * @param third  AU per day along the third coordinate (distance, or z)
 */
public record Motion(double first, double second, double third) {

  /** Alias for {@link #first()}, reading naturally for an ecliptic position. */
  public double longitudeDegPerDay() {
    return first;
  }

  /** True when the body is moving backwards through the zodiac. Meaningful for an ecliptic position. */
  public boolean isRetrograde() {
    return first < 0;
  }
}
