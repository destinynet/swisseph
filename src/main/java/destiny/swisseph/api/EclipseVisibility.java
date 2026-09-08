/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import destiny.swisseph.SweConst;

/**
 * Which phases of a lunar eclipse are actually above the horizon for an observer.
 *
 * <p>A lunar eclipse happens at the same moments for everyone, but the Moon sets. So a place can
 * see the beginning and miss the end, and the phase times alone do not tell you what was seen.
 * The legacy API returns these as bits packed into the same {@code int} as the eclipse kind.
 *
 * @param eclipseVisible        any part of it is visible from here
 * @param maximumVisible        the deepest moment is above the horizon
 * @param partialBeginVisible   the Moon touching the umbra is above the horizon
 * @param partialEndVisible     the Moon leaving the umbra is
 * @param totalityBeginVisible  the start of totality is
 * @param totalityEndVisible    the end of totality is
 * @param penumbraBeginVisible  the Moon touching the penumbra is
 * @param penumbraEndVisible    the Moon leaving the penumbra is
 */
public record EclipseVisibility(boolean eclipseVisible,
                                boolean maximumVisible,
                                boolean partialBeginVisible,
                                boolean partialEndVisible,
                                boolean totalityBeginVisible,
                                boolean totalityEndVisible,
                                boolean penumbraBeginVisible,
                                boolean penumbraEndVisible) {

  static EclipseVisibility from(int returnedFlags) {
    return new EclipseVisibility(
        (returnedFlags & SweConst.SE_ECL_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_MAX_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_PARTBEG_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_PARTEND_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_TOTBEG_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_TOTEND_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_PENUMBBEG_VISIBLE) != 0,
        (returnedFlags & SweConst.SE_ECL_PENUMBEND_VISIBLE) != 0);
  }
}
