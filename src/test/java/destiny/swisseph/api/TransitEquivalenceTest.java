package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import destiny.swisseph.TCPlanet;
import destiny.swisseph.TCPlanetPlanet;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Equivalence and behaviour for transit searches —— {@code getTransitUT} with a
 * {@code TransitCalculator}.
 *
 * <p>This is the corner of the API that made a search inseparable from one mutable instance: the
 * legacy calculator is constructed <em>around</em> a {@code SwissEph}, so the thing describing
 * what you want and the thing able to answer it were the same object. {@link TransitSearch} is a
 * plain value instead, and the instance is passed separately —— which is what lets one shared
 * {@link SwissEphemeris} serve every thread's searches.
 */
class TransitEquivalenceTest {

  private static final double FROM = 2451545.0;

  @Test
  void singleBodyTransitsMatchTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    int checked = 0;

    for (Body.Point body : List.of(Body.Point.SUN, Body.Point.MARS, Body.Point.JUPITER)) {
      for (double target : new double[]{0, 90, 180, 270}) {
        for (SearchDirection direction : SearchDirection.values()) {
          boolean backwards = direction == SearchDirection.BACKWARD;
          int flags = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_TRANSIT_LONGITUDE;

          double expected;
          SwissEph se = new SwissEph(ephePath);
          try {
            expected = se.getTransitUT(new TCPlanet(se, body.number(), flags, target),
                                       FROM, backwards);
          } finally {
            se.swe_close();
          }

          try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
            Optional<JulianDayUT> actual = ephemeris.nextTransit(
                TransitSearch.OfBody.of(body, TransitQuantity.LONGITUDE, target, Ephemeris.SWISS),
                JulianDayUT.of(FROM), direction);
            assertTrue(actual.isPresent(), body + " at " + target + " " + direction);
            assertEquals(Double.toHexString(expected), Double.toHexString(actual.get().value()),
                         "differs for " + body + " longitude=" + target + " " + direction);
          }
          checked++;
        }
      }
    }
    assertTrue(checked >= 24, "only " + checked + " searches checked");
  }

  @Test
  void bodyPairTransitsMatchTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    int flags = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_TRANSIT_LONGITUDE;

    for (double separation : new double[]{0, 60, 90, 120, 180}) {
      double expected;
      SwissEph se = new SwissEph(ephePath);
      try {
        expected = se.getTransitUT(
            new TCPlanetPlanet(se, Body.Point.SUN.number(), Body.Point.MARS.number(), flags, separation),
            FROM, false);
      } finally {
        se.swe_close();
      }

      try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
        Optional<JulianDayUT> actual = ephemeris.nextTransit(
            TransitSearch.BetweenBodies.of(Body.Point.SUN, Body.Point.MARS, separation, Ephemeris.SWISS),
            JulianDayUT.of(FROM), SearchDirection.FORWARD);
        assertTrue(actual.isPresent(), "no aspect found at " + separation);
        assertEquals(Double.toHexString(expected), Double.toHexString(actual.get().value()),
                     "differs for Sun-Mars separation " + separation);
      }
    }
  }

  @Test
  void aStationIsASpeedOfZero() {
    // The idiom the upper layer uses to bound a retrogradation, given a name here.
    String ephePath = SmokeTestSupport.ephePath();
    int flags = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_TRANSIT_LONGITUDE | SweConst.SEFLG_TRANSIT_SPEED;

    double expected;
    SwissEph se = new SwissEph(ephePath);
    try {
      expected = se.getTransitUT(new TCPlanet(se, Body.Point.MERCURY.number(), flags, 0.0), FROM, false);
    } finally {
      se.swe_close();
    }

    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      Optional<JulianDayUT> station = ephemeris.nextTransit(
          TransitSearch.OfBody.station(Body.Point.MERCURY, Ephemeris.SWISS),
          JulianDayUT.of(FROM), SearchDirection.FORWARD);
      assertTrue(station.isPresent());
      assertEquals(Double.toHexString(expected), Double.toHexString(station.get().value()));

      // Mercury stations roughly three times a year, so the next one is not far off.
      assertTrue(station.get().value() - FROM < 130,
                 "水星的留應該在幾個月內，實得 " + (station.get().value() - FROM) + " 日後");

      // And at that moment its longitude speed really is about zero.
      CalcResult at = ephemeris.calculate(
          station.get(), Body.Point.MERCURY, Ephemeris.SWISS,
          java.util.EnumSet.of(CalcOption.SPEED));
      double speed = ((Position.Ecliptic) at.position()).speed().orElseThrow().longitudeDegPerDay();
      assertTrue(Math.abs(speed) < 1e-3, "留的時刻黃經速度應該接近 0，實得 " + speed);
    }
  }

  @Test
  void anImpossibleSpeedIsAnAbsentAnswer() {
    // Jupiter cannot move at ten degrees a day. The library knows the bounds of a body's speed,
    // so it can say so at once —— and "never happens" is an answer, not a malfunction.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      Optional<JulianDayUT> never = ephemeris.nextTransit(
          TransitSearch.OfBody.of(Body.Point.JUPITER, TransitQuantity.LONGITUDE_SPEED, 10,
                                  Ephemeris.SWISS),
          JulianDayUT.of(FROM), SearchDirection.FORWARD);
      assertTrue(never.isEmpty(), "木星不可能一天走 10 度，應該回傳 empty，實得 " + never);
    }
  }

  @Test
  void anUnreachablePositionSearchesUntilItRunsOutOfData() {
    // Worth pinning because it is a sharp edge, not a nicety. For a *position* the library does
    // not know what a body can reach —— it only bounds the target to 0..360 —— so asking Mars for
    // an ecliptic latitude of 80 degrees is accepted and searched for, forever, until the data
    // runs out. That is a genuine failure and is reported as one.
    //
    // The remedy is the window, which is why nextTransit has a form that takes one.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      SwissEphemerisException e = org.junit.jupiter.api.Assertions.assertThrows(
          SwissEphemerisException.class,
          () -> ephemeris.nextTransit(
              TransitSearch.OfBody.of(Body.Point.MARS, TransitQuantity.LATITUDE, 80, Ephemeris.SWISS),
              JulianDayUT.of(FROM), SearchDirection.FORWARD));
      assertTrue(e.getMessage().contains("MARS"), "例外訊息應該說出在找什麼，實得 " + e.getMessage());

      // With a window, the same impossible request is simply an absent answer.
      Optional<JulianDayUT> bounded = ephemeris.nextTransit(
          TransitSearch.OfBody.of(Body.Point.MARS, TransitQuantity.LATITUDE, 80, Ephemeris.SWISS),
          JulianDayUT.of(FROM), SearchDirection.FORWARD, Optional.of(JulianDayUT.of(FROM + 3650)));
      assertTrue(bounded.isEmpty(), "有視窗時應該是 empty，實得 " + bounded);
    }
  }

  @Test
  void runningOutOfWindowIsAnAbsentAnswerRatherThanAFailure() {
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      // Jupiter takes about twelve years to go round; one day is not enough to find any given
      // degree, but that is not an error.
      Optional<JulianDayUT> tooSoon = ephemeris.nextTransit(
          TransitSearch.OfBody.of(Body.Point.JUPITER, TransitQuantity.LONGITUDE, 200, Ephemeris.SWISS),
          JulianDayUT.of(FROM), SearchDirection.FORWARD, Optional.of(JulianDayUT.of(FROM + 1)));
      assertTrue(tooSoon.isEmpty(), "一天的視窗內找不到，應該是 empty，實得 " + tooSoon);

      // Given long enough, the same search succeeds —— so the empty above was the window, not a
      // broken search.
      Optional<JulianDayUT> eventually = ephemeris.nextTransit(
          TransitSearch.OfBody.of(Body.Point.JUPITER, TransitQuantity.LONGITUDE, 200, Ephemeris.SWISS),
          JulianDayUT.of(FROM), SearchDirection.FORWARD,
          Optional.of(JulianDayUT.of(FROM + 12 * 366)));
      assertTrue(eventually.isPresent(), "十二年的視窗內木星必定經過黃經 200 度");
    }
  }

  @Test
  void searchesRunOnAThreadOfTheirOwnState() throws Exception {
    // The legacy calculator is built around a SwissEph instance, so a search and the object that
    // answers it were one thing. Here the search is a value; several threads must be able to run
    // different ones against a single shared instance.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris shared = SwissEphemeris.at(ephePath)) {
      List<Body.Point> bodies = List.of(Body.Point.SUN, Body.Point.MOON, Body.Point.MARS,
                                        Body.Point.JUPITER, Body.Point.SATURN, Body.Point.VENUS);

      double[] alone = new double[bodies.size()];
      for (int i = 0; i < bodies.size(); i++) {
        try (SwissEphemeris privateInstance = SwissEphemeris.at(ephePath)) {
          alone[i] = privateInstance.nextTransit(
              TransitSearch.OfBody.of(bodies.get(i), TransitQuantity.LONGITUDE, 100, Ephemeris.SWISS),
              JulianDayUT.of(FROM), SearchDirection.FORWARD).orElseThrow().value();
        }
      }

      List<java.util.concurrent.Callable<Double>> jobs = new java.util.ArrayList<>();
      for (Body.Point body : bodies) {
        jobs.add(() -> shared.nextTransit(
            TransitSearch.OfBody.of(body, TransitQuantity.LONGITUDE, 100, Ephemeris.SWISS),
            JulianDayUT.of(FROM), SearchDirection.FORWARD).orElseThrow().value());
      }

      var pool = java.util.concurrent.Executors.newFixedThreadPool(bodies.size());
      try {
        var results = pool.invokeAll(jobs);
        for (int i = 0; i < bodies.size(); i++) {
          assertEquals(Double.toHexString(alone[i]), Double.toHexString(results.get(i).get()),
                       bodies.get(i) + " 的搜尋結果在共用實例上改變了");
        }
      } finally {
        pool.shutdownNow();
      }
    }
  }
}
