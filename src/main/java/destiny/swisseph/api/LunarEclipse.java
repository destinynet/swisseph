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
 * A lunar eclipse.
 *
 * <p>Unlike a solar eclipse, this one happens at the same moments for everybody who can see the
 * Moon —— the Earth's shadow falls on the Moon, not on the observer. So the phase times here are
 * the same whether the eclipse was searched for globally or for a place; what a place adds is
 * whether the Moon is above the horizon at the time, and when it rises or sets during the event.
 *
 * @param kind             total, partial, or merely penumbral
 * @param maximum          when the Moon is deepest in the shadow
 * @param partialBegin     when the Moon first touches the umbra
 * @param partialEnd       when it last leaves it
 * @param totalityBegin    when the Moon is first entirely inside the umbra
 * @param totalityEnd      when it is last entirely inside
 * @param penumbraBegin    when the Moon first touches the penumbra
 * @param penumbraEnd      when it last leaves it
 * @param moonrise         if the Moon rises while the eclipse is in progress —— only ever present
 *                         when the eclipse was searched for at a place
 * @param moonset          if it sets while the eclipse is in progress
 * @param appearance       how deep in the shadow it is, and where it is in the sky; present only
 *                         for an eclipse searched for at a place
 * @param visibility       which phases are above the horizon there; present only for an eclipse
 *                         searched for at a place. A lunar eclipse happens at the same moments
 *                         for everyone, but the Moon sets —— so a place can see the beginning and
 *                         miss the end, and the phase times alone do not say what was seen
 */
public record LunarEclipse(LunarEclipseKind kind,
                           JulianDayUT maximum,
                           Optional<JulianDayUT> partialBegin,
                           Optional<JulianDayUT> partialEnd,
                           Optional<JulianDayUT> totalityBegin,
                           Optional<JulianDayUT> totalityEnd,
                           Optional<JulianDayUT> penumbraBegin,
                           Optional<JulianDayUT> penumbraEnd,
                           Optional<JulianDayUT> moonrise,
                           Optional<JulianDayUT> moonset,
                           Optional<LunarEclipseAppearance> appearance,
                           Optional<EclipseVisibility> visibility) {

  public LunarEclipse {
    Objects.requireNonNull(kind, "kind");
    Objects.requireNonNull(maximum, "maximum");
  }
}
