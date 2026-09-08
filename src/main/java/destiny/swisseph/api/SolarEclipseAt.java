/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A solar eclipse in progress, as seen from one place at one instant.
 *
 * @param kind       what sort of eclipse it is at this place
 * @param appearance how much of the Sun is covered, and where it is in the sky
 */
public record SolarEclipseAt(SolarEclipseKind kind, SolarEclipseAppearance appearance) { }
