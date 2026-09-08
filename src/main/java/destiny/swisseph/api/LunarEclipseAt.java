/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A lunar eclipse in progress, as seen from one place at one instant.
 *
 * @param kind       total, partial, or merely penumbral
 * @param appearance how deep in the shadow the Moon is, and where it is in the sky
 * @param visibility which phases are above the horizon here
 */
public record LunarEclipseAt(LunarEclipseKind kind,
                             LunarEclipseAppearance appearance,
                             EclipseVisibility visibility) { }
