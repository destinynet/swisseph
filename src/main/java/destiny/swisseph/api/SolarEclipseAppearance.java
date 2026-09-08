/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * How a solar eclipse looks from somewhere at some instant —— the legacy {@code double[20] attr},
 * with the eight slots it actually fills given names.
 *
 * <p>The two "fraction covered" numbers are different quantities and are routinely confused:
 * the eclipse magnitude is a ratio of <em>diameters</em>, while obscuration is a fraction of the
 * visible <em>area</em>. A magnitude of 0.5 hides only about 39% of the disc.
 *
 * @param magnitude              fraction of the Sun's diameter covered by the Moon
 * @param lunarToSolarDiameterRatio  apparent size of the Moon over that of the Sun; above 1 an
 *                               eclipse can be total, below 1 only annular
 * @param obscuration            fraction of the Sun's visible disc area covered
 * @param coreShadowDiameterKm   width of the umbra where it touches the Earth; negative when the
 *                               cone falls short, which is what makes an eclipse annular
 * @param sun                    where the Sun is in the observer's sky
 * @param moonSunDistanceDeg     angular separation of the two bodies
 */
public record SolarEclipseAppearance(double magnitude,
                                     double lunarToSolarDiameterRatio,
                                     double obscuration,
                                     double coreShadowDiameterKm,
                                     Horizontal sun,
                                     double moonSunDistanceDeg) {

  /** Reads the legacy {@code attr} array. */
  static SolarEclipseAppearance from(double[] attr) {
    return new SolarEclipseAppearance(attr[0], attr[1], attr[2], attr[3],
                                      new Horizontal(attr[4], attr[5], attr[6]), attr[7]);
  }
}
