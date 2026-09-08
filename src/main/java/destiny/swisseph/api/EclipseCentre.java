/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * Where on Earth a solar eclipse is central at a given instant, and what it looks like there.
 *
 * @param centralLine where the axis of the Moon's shadow meets the Earth's surface
 * @param kind        what sort of eclipse it is at that point
 * @param central     false when the shadow's axis misses the Earth entirely, in which case
 *                    {@code centralLine} describes where the eclipse is greatest instead
 * @param appearance  how much of the Sun is covered there
 */
public record EclipseCentre(GeoLocation centralLine,
                            SolarEclipseKind kind,
                            boolean central,
                            SolarEclipseAppearance appearance) { }
