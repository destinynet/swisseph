/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.Objects;
import java.util.Optional;

/**
 * A solar eclipse as seen from one place: when each contact happens there, and how much of the
 * Sun is covered.
 *
 * <p>Note how differently the four contacts are laid out from {@link GlobalSolarEclipse}, though
 * the legacy API returns both in an identically-shaped {@code double[10]}.
 *
 * @param kind          what sort of eclipse it is at this place —— which need not be what it is
 *                      elsewhere: a total eclipse is partial for most of the Earth that sees it
 * @param visible       whether the eclipse can be seen here at all, the Sun being above the horizon
 * @param maximum       when the greatest coverage occurs here
 * @param firstContact  when the Moon's edge first touches the Sun's
 * @param secondContact when totality or annularity begins
 * @param thirdContact  when it ends
 * @param fourthContact when the discs separate
 * @param sunrise       if the Sun rises while the eclipse is in progress
 * @param sunset        if it sets while the eclipse is in progress
 * @param appearance    how much is covered, and where the Sun is in the sky
 */
public record LocalSolarEclipse(SolarEclipseKind kind,
                                boolean visible,
                                JulianDayUT maximum,
                                JulianDayUT firstContact,
                                Optional<JulianDayUT> secondContact,
                                Optional<JulianDayUT> thirdContact,
                                JulianDayUT fourthContact,
                                Optional<JulianDayUT> sunrise,
                                Optional<JulianDayUT> sunset,
                                SolarEclipseAppearance appearance) {

  public LocalSolarEclipse {
    Objects.requireNonNull(kind, "kind");
    Objects.requireNonNull(maximum, "maximum");
    Objects.requireNonNull(appearance, "appearance");
  }
}
