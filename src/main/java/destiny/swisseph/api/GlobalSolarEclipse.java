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
 * A solar eclipse as an event on the Earth as a whole —— not as seen from any one place.
 *
 * <p>The legacy call returns this as {@code double[10] tret} whose ten slots mean one thing here
 * and <em>something else entirely</em> in the local variant of the same call: slot 2 is the start
 * of the eclipse over the Earth here, and the second contact at an observer there. Nothing in
 * either signature says so. That is why these are two different types.
 *
 * <p>The later phases are {@link Optional} because they do not all exist for every eclipse: a
 * partial eclipse has no totality and no central line.
 *
 * @param kind                what sort of eclipse
 * @param central             true when the axis of the Moon's shadow touches the Earth
 * @param maximum             when the eclipse is greatest, seen from the Earth as a whole
 * @param atLocalApparentNoon when the eclipse is central at local apparent noon
 * @param begin               when the eclipse first touches the Earth anywhere
 * @param end                 when it last leaves it
 * @param totalityBegin       when totality (or annularity) first occurs anywhere
 * @param totalityEnd         when it last occurs
 * @param centralLineBegin    when the shadow's axis first touches the Earth
 * @param centralLineEnd      when it last does
 * @param becomesTotal        for a hybrid eclipse, when it turns from annular to total
 * @param becomesAnnular      for a hybrid eclipse, when it turns back
 */
public record GlobalSolarEclipse(SolarEclipseKind kind,
                                 boolean central,
                                 JulianDayUT maximum,
                                 JulianDayUT atLocalApparentNoon,
                                 JulianDayUT begin,
                                 JulianDayUT end,
                                 Optional<JulianDayUT> totalityBegin,
                                 Optional<JulianDayUT> totalityEnd,
                                 Optional<JulianDayUT> centralLineBegin,
                                 Optional<JulianDayUT> centralLineEnd,
                                 Optional<JulianDayUT> becomesTotal,
                                 Optional<JulianDayUT> becomesAnnular) {

  public GlobalSolarEclipse {
    Objects.requireNonNull(kind, "kind");
    Objects.requireNonNull(maximum, "maximum");
  }
}
