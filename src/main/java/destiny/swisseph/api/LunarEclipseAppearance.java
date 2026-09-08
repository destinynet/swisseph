/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * How a lunar eclipse looks from somewhere at some instant.
 *
 * <p>Both magnitudes are fractions of the Moon's diameter, in the two shadows: the umbra, where
 * the Earth blocks the Sun completely, and the penumbra around it, where it blocks only part.
 * A penumbral magnitude above 1 with an umbral magnitude at or below 0 is a purely penumbral
 * eclipse —— technically an eclipse, barely visible in practice.
 *
 * @param umbralMagnitude        fraction of the Moon's diameter inside the umbra
 * @param penumbralMagnitude     fraction inside the penumbra
 * @param moon                   where the Moon is in the observer's sky
 * @param distanceFromOppositionDeg how far the Moon is from exact opposition to the Sun
 */
public record LunarEclipseAppearance(double umbralMagnitude,
                                     double penumbralMagnitude,
                                     Horizontal moon,
                                     double distanceFromOppositionDeg) {

  static LunarEclipseAppearance from(double[] attr) {
    return new LunarEclipseAppearance(attr[0], attr[1],
                                      new Horizontal(attr[4], attr[5], attr[6]), attr[7]);
  }
}
