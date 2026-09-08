/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * The tilt of the Earth's axis at a moment, and the small periodic wobble on top of it.
 *
 * <p>The legacy API returns these through {@code swe_calc_ut} with a body number of -1 —— a
 * pseudo-planet whose "position" is not a position at all: the four slots hold two obliquities
 * and two nutation components. Every other body number returns coordinates. Nothing distinguishes
 * the two cases but the caller remembering.
 *
 * @param trueObliquityDeg    obliquity of the date including nutation —— what you want for
 *                            converting between ecliptic and equatorial coordinates
 * @param meanObliquityDeg    obliquity without nutation
 * @param nutationInLongitudeDeg the wobble along the ecliptic
 * @param nutationInObliquityDeg the wobble in the tilt itself; the difference between the two
 *                            obliquities above
 */
public record ObliquityAndNutation(double trueObliquityDeg,
                                   double meanObliquityDeg,
                                   double nutationInLongitudeDeg,
                                   double nutationInObliquityDeg) { }
