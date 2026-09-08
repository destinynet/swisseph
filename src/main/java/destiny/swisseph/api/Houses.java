/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.List;
import java.util.Objects;

/**
 * A house division: where the twelve cusps fall, and where the chart's angles are.
 *
 * <p>The legacy API fills two arrays the caller allocates —— {@code double[13]} whose slot 0 is
 * unused, and {@code double[10]} whose meaning is documented only in a comment ("ascmc[4] =
 * equatorial ascendant, ascmc[5] = co-ascendant (Walter Koch)…"). Both are replaced here: the
 * cusps by a list that is addressed by house number, the angles by named components.
 *
 * @param cusps  cusp longitudes in degrees, {@code cusps.get(0)} being the first house.
 *               Twelve entries, except for {@link HouseSystem#GAUQUELIN_SECTORS}, which has 36
 * @param angles the chart's angles
 * @param zodiac what these longitudes are measured from —— the same value that was requested,
 *               carried along so a result cannot be read in the wrong zodiac by mistake
 */
public record Houses(List<Double> cusps, HouseAngles angles, Zodiac zodiac) {

  public Houses {
    Objects.requireNonNull(angles, "angles");
    Objects.requireNonNull(zodiac, "zodiac");
    cusps = List.copyOf(cusps);
  }

  /**
   * The cusp of a house, by its number.
   *
   * @param house 1 to 12 (1 to 36 for Gauquelin sectors) —— house numbers, not array indices.
   *              The legacy array's unused slot 0 is the reason this accessor exists
   * @return the cusp longitude in degrees
   * @throws IndexOutOfBoundsException if there is no such house in this division
   */
  public double cusp(int house) {
    if (house < 1 || house > cusps.size()) {
      throw new IndexOutOfBoundsException(
          "house " + house + " does not exist; this division has " + cusps.size());
    }
    return cusps.get(house - 1);
  }
}
