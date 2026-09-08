/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * What to search for: a moment when some quantity of a body, or of a pair of bodies, reaches a
 * given value.
 *
 * <p>The legacy equivalent is a {@code TransitCalculator} object built by handing a
 * {@code SwissEph} instance, an {@code int} body number, an {@code int} flag mask and a bare
 * {@code double} target to a constructor —— including the instance, which is what tied a search to
 * one particular mutable object. Here the search is a plain value that says what is wanted, and
 * the instance that runs it is passed separately.
 */
public sealed interface TransitSearch {

  /** Which quantity is being watched. */
  TransitQuantity quantity();

  /** The value being watched for, in degrees or AU as the quantity implies. */
  double target();

  /**
   * One body reaching a value.
   *
   * @param body      whose position or speed
   * @param quantity  what about it
   * @param target    the value to reach —— degrees for longitude and latitude, AU for distance,
   *                  and per day for the speeds. Zero speed in longitude means a station
   * @param ephemeris which ephemeris to compute from
   * @param centre    where the observer is
   * @param zodiac    what longitudes are measured from
   */
  record OfBody(Body body,
                TransitQuantity quantity,
                double target,
                Ephemeris ephemeris,
                Centre centre,
                Zodiac zodiac) implements TransitSearch {

    public OfBody {
      Objects.requireNonNull(body, "body");
      Objects.requireNonNull(quantity, "quantity");
      Objects.requireNonNull(ephemeris, "ephemeris");
      Objects.requireNonNull(centre, "centre");
      Objects.requireNonNull(zodiac, "zodiac");
    }

    /** Geocentric and tropical. */
    public static OfBody of(Body body, TransitQuantity quantity, double target, Ephemeris ephemeris) {
      return new OfBody(body, quantity, target, ephemeris, Centre.geocentric(), Zodiac.tropical());
    }

    /** The moment a body turns direct or retrograde: its longitude speed passing through zero. */
    public static OfBody station(Body body, Ephemeris ephemeris) {
      return of(body, TransitQuantity.LONGITUDE_SPEED, 0, ephemeris);
    }
  }

  /**
   * Two bodies separated by a given amount —— which is what an aspect is.
   *
   * @param first    the moving body of the pair
   * @param second   the other
   * @param quantity what about the pair; longitude gives the familiar aspects
   * @param target   the separation to reach, in degrees: 0 for a conjunction, 180 for an
   *                 opposition, 120 for a trine, and so on
   */
  record BetweenBodies(Body first,
                       Body second,
                       TransitQuantity quantity,
                       double target,
                       Ephemeris ephemeris,
                       Centre centre,
                       Zodiac zodiac) implements TransitSearch {

    public BetweenBodies {
      Objects.requireNonNull(first, "first");
      Objects.requireNonNull(second, "second");
      Objects.requireNonNull(quantity, "quantity");
      Objects.requireNonNull(ephemeris, "ephemeris");
      Objects.requireNonNull(centre, "centre");
      Objects.requireNonNull(zodiac, "zodiac");
    }

    /** Geocentric and tropical. */
    public static BetweenBodies of(Body first, Body second, double separationDeg, Ephemeris ephemeris) {
      return new BetweenBodies(first, second, TransitQuantity.LONGITUDE, separationDeg, ephemeris,
                               Centre.geocentric(), Zodiac.tropical());
    }
  }

  /** The legacy flag mask this search implies. */
  default int flags() {
    Set<CalcOption> none = EnumSet.noneOf(CalcOption.class);
    return switch (this) {
      case OfBody b -> b.ephemeris().bit() | b.centre().bit() | b.zodiac().bit()
                       | b.quantity().bits() | CalcOption.bitmask(none);
      case BetweenBodies p -> p.ephemeris().bit() | p.centre().bit() | p.zodiac().bit()
                              | p.quantity().bits() | CalcOption.bitmask(none);
    };
  }
}
