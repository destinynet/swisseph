/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * The angles of a chart —— the legacy {@code double[10] ascmc}, with its slots named.
 *
 * <p>All in degrees, in the zodiac the {@link Houses} were requested in.
 *
 * @param ascendantDeg           where the ecliptic meets the eastern horizon
 * @param midheavenDeg           where the ecliptic meets the meridian above
 * @param armcDeg                right ascension of the midheaven
 * @param vertexDeg              where the ecliptic meets the prime vertical in the west
 * @param equatorialAscendantDeg the east point: the equator's eastern horizon crossing, projected
 *                               onto the ecliptic
 * @param coAscendantKochDeg     co-ascendant after Walter Koch
 * @param coAscendantMunkaseyDeg co-ascendant after Michael Munkasey
 * @param polarAscendantDeg      polar ascendant after Michael Munkasey
 */
public record HouseAngles(double ascendantDeg,
                          double midheavenDeg,
                          double armcDeg,
                          double vertexDeg,
                          double equatorialAscendantDeg,
                          double coAscendantKochDeg,
                          double coAscendantMunkaseyDeg,
                          double polarAscendantDeg) { }
