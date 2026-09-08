package destiny.swisseph.api;

import destiny.swisseph.DblObj;
import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Equivalence and behaviour for the horizon calls: {@code swe_azalt} and {@code swe_rise_trans}. */
class HorizonEquivalenceTest {

  private static final List<GeoLocation> PLACES = List.of(
      GeoLocation.of(121.5, 25.0),      // Taipei
      GeoLocation.of(-0.13, 51.5),      // London
      GeoLocation.of(-58.4, -34.6),     // Buenos Aires
      GeoLocation.of(18.9, 69.6));      // Tromsø, inside the arctic circle

  private static final double[] DATES = {2451545.0, 2451630.5, 2458849.5, 2460841.5};

  @Test
  void horizontalCoordinatesMatchTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    int checked = 0;

    for (double tjd : DATES) {
      for (GeoLocation place : PLACES) {
        for (Body.Point body : List.of(Body.Point.SUN, Body.Point.MOON, Body.Point.MARS)) {
          for (boolean equatorial : List.of(false, true)) {
            for (Atmosphere air : List.of(Atmosphere.STANDARD, Atmosphere.VACUUM,
                                          new Atmosphere(950, -20))) {
              String expected;
              SwissEph se = new SwissEph(ephePath);
              try {
                int iflag = SweConst.SEFLG_SWIEPH | (equatorial ? SweConst.SEFLG_EQUATORIAL : 0);
                double[] xx = new double[6];
                se.swe_calc_ut(tjd, body.number(), iflag, xx, new StringBuffer());
                double[] geopos = {place.longitudeDeg(), place.latitudeDeg(), place.altitudeMetres()};
                double[] xin = {xx[0], xx[1], xx[2]};
                double[] xaz = new double[3];
                se.swe_azalt(tjd, equatorial ? SweConst.SE_EQU2HOR : SweConst.SE_ECL2HOR, geopos,
                             air.pressureMillibars(), air.temperatureCelsius(), xin, xaz);
                expected = Double.toHexString(xaz[0]) + ',' + Double.toHexString(xaz[1])
                           + ',' + Double.toHexString(xaz[2]);
              } finally {
                se.swe_close();
              }

              String actual;
              try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
                CalcResult r = ephemeris.calculate(
                    JulianDayUT.of(tjd), body, Ephemeris.SWISS,
                    equatorial ? EnumSet.of(CalcOption.EQUATORIAL) : EnumSet.noneOf(CalcOption.class));
                Horizontal h = ephemeris.toHorizontal(JulianDayUT.of(tjd), place, r.position(), air);
                actual = Double.toHexString(h.azimuthFromSouthDeg())
                         + ',' + Double.toHexString(h.trueAltitudeDeg())
                         + ',' + Double.toHexString(h.apparentAltitudeDeg());
              }

              assertEquals(expected, actual,
                           "differs at tjd=" + tjd + " " + place + " " + body
                           + " equatorial=" + equatorial + " air=" + air);
              checked++;
            }
          }
        }
      }
    }
    assertTrue(checked > 200, "only " + checked + " combinations checked");
  }

  @Test
  void azimuthConversionIsNotOffByHalfATurn() {
    // The whole reason azimuthFromSouthDeg is named rather than called "azimuth": the two
    // conventions differ by 180 degrees and neither looks wrong on its own.
    Horizontal dueSouth = new Horizontal(0, 30, 30);
    assertEquals(180.0, dueSouth.azimuthFromNorthDeg(), 1e-9, "正南在羅盤上是 180 度");

    Horizontal dueWest = new Horizontal(90, 10, 10);
    assertEquals(270.0, dueWest.azimuthFromNorthDeg(), 1e-9, "從南往西 90 度 = 正西 = 羅盤 270 度");

    Horizontal dueNorth = new Horizontal(180, -20, -20);
    assertEquals(0.0, dueNorth.azimuthFromNorthDeg(), 1e-9, "正北在羅盤上是 0 度");
    assertFalse(dueNorth.isVisible(), "地平線下不算可見");

    Horizontal dueEast = new Horizontal(270, 10, 10);
    assertEquals(90.0, dueEast.azimuthFromNorthDeg(), 1e-9, "從南往西 270 度 = 正東 = 羅盤 90 度");
  }

  @Test
  void theSunGoesEastToWestThroughTheDay() {
    // The conversion above is asserted against a convention; this asserts it against the sky,
    // which is the thing the convention is supposed to describe. In Taipei the Sun rises in the
    // east, is due south around noon, and sets in the west —— so the compass azimuth must climb
    // through roughly 90, 180, 270 over the course of a day.
    String ephePath = SmokeTestSupport.ephePath();
    GeoLocation taipei = GeoLocation.of(121.5, 25.0);
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      // JD 2451544.5 is 2000-01-01 00:00 UT. Taipei runs eight hours ahead, so 06:00, 12:00 and
      // 16:00 local are 22:00 the previous day, 04:00, and 08:00 UT.
      double[] utMoments = {2451544.5 - 2.0 / 24,      // Taipei 06:00
                            2451544.5 + 4.0 / 24,      // Taipei 12:00
                            2451544.5 + 8.0 / 24};     // Taipei 16:00
      double[] compass = new double[utMoments.length];
      for (int i = 0; i < utMoments.length; i++) {
        JulianDayUT t = JulianDayUT.of(utMoments[i]);
        CalcResult sun = ephemeris.calculate(t, Body.Point.SUN, Ephemeris.SWISS);
        compass[i] = ephemeris.toHorizontal(t, taipei, sun.position()).azimuthFromNorthDeg();
      }
      assertTrue(compass[0] > 90 && compass[0] < 150,
                 "早上太陽應該在東方偏南（羅盤 90~150 度），實得 " + compass[0]);
      assertTrue(compass[1] > 160 && compass[1] < 200,
                 "接近正午太陽應該在南方（羅盤 160~200 度），實得 " + compass[1]);
      assertTrue(compass[2] > 210 && compass[2] < 270,
                 "下午太陽應該在西方偏南（羅盤 210~270 度），實得 " + compass[2]);
      assertTrue(compass[0] < compass[1] && compass[1] < compass[2],
                 "方位角整天單調遞增，實得 " + java.util.Arrays.toString(compass));
    }
  }

  @Test
  void riseAndSetMatchTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    int checked = 0;

    for (double tjd : DATES) {
      for (GeoLocation place : PLACES) {
        for (RiseSetEvent event : RiseSetEvent.values()) {
          Double expected;
          SwissEph se = new SwissEph(ephePath);
          try {
            DblObj tret = new DblObj(0.0);
            double[] geopos = {place.longitudeDeg(), place.latitudeDeg(), place.altitudeMetres()};
            int rc = se.swe_rise_trans(tjd, Body.Point.SUN.number(), null, SweConst.SEFLG_SWIEPH,
                                       event.bit(), geopos, Atmosphere.STANDARD.pressureMillibars(),
                                       Atmosphere.STANDARD.temperatureCelsius(), tret,
                                       new StringBuffer());
            expected = rc == SweConst.OK ? tret.val : null;
          } finally {
            se.swe_close();
          }

          try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
            Optional<JulianDayUT> actual = ephemeris.nextRiseSet(
                JulianDayUT.of(tjd), Body.Point.SUN, event, place, Ephemeris.SWISS);
            if (expected == null) {
              assertTrue(actual.isEmpty(),
                         "legacy said it does not happen, new API returned " + actual
                         + " at tjd=" + tjd + " " + place + " " + event);
            } else {
              assertTrue(actual.isPresent(), "no " + event + " at tjd=" + tjd + " " + place);
              assertEquals(Double.toHexString(expected),
                           Double.toHexString(actual.get().value()),
                           "differs at tjd=" + tjd + " " + place + " " + event);
            }
          }
          checked++;
        }
      }
    }
    assertTrue(checked >= DATES.length * PLACES.size() * RiseSetEvent.values().length);
  }

  @Test
  void aPolarSummerIsAnAbsentAnswerRatherThanAFailure() {
    // Tromsø in late June: the Sun does not set. That is the sky behaving normally, and it must
    // not be reported the same way as a broken calculation.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      GeoLocation tromso = GeoLocation.of(18.9, 69.6);
      JulianDayUT midsummer = JulianDayUT.of(2459391.5);   // 2021-06-21

      Optional<JulianDayUT> sunset = ephemeris.nextRiseSet(
          midsummer, Body.Point.SUN, RiseSetEvent.SET, tromso, Ephemeris.SWISS);
      assertTrue(sunset.isEmpty(), "極晝的日落應該是 empty，實得 " + sunset);

      // The same body at the same instant still culminates —— an absent sunset is not an absent sky.
      Optional<JulianDayUT> noon = ephemeris.nextRiseSet(
          midsummer, Body.Point.SUN, RiseSetEvent.UPPER_TRANSIT, tromso, Ephemeris.SWISS);
      assertTrue(noon.isPresent(), "極晝仍然有中天");
      assertNotEquals(midsummer, noon.get());
    }
  }

  @Test
  void discAndRefractionOptionsActuallyChangeTheAnswer() {
    // If the option bits were dropped on the way through, every one of these would be identical.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      GeoLocation taipei = GeoLocation.of(121.5, 25.0);
      JulianDayUT from = JulianDayUT.of(2451545.0);

      double upperEdge = ephemeris.nextRiseSet(
          from, Body.Point.SUN, RiseSetEvent.RISE, taipei, Ephemeris.SWISS).orElseThrow().value();
      double discCentre = ephemeris.nextRiseSet(
          from, Body.Point.SUN, RiseSetEvent.RISE, taipei, Ephemeris.SWISS,
          EnumSet.of(RiseSetOption.DISC_CENTRE), Atmosphere.STANDARD).orElseThrow().value();
      double noRefraction = ephemeris.nextRiseSet(
          from, Body.Point.SUN, RiseSetEvent.RISE, taipei, Ephemeris.SWISS,
          EnumSet.of(RiseSetOption.NO_REFRACTION), Atmosphere.STANDARD).orElseThrow().value();
      double astronomicalDawn = ephemeris.nextRiseSet(
          from, Body.Point.SUN, RiseSetEvent.RISE, taipei, Ephemeris.SWISS,
          EnumSet.of(RiseSetOption.ASTRONOMICAL_TWILIGHT), Atmosphere.STANDARD).orElseThrow().value();

      assertNotEquals(upperEdge, discCentre, "圓面中心與上緣不該是同一個時刻");
      assertNotEquals(upperEdge, noRefraction, "有無大氣折射不該是同一個時刻");
      assertTrue(discCentre > upperEdge, "上緣先出現，圓面中心才出現");
      assertTrue(astronomicalDawn < upperEdge, "天文曙光早於日出");
      // Both differences are minutes, not hours —— a sanity check on the magnitude.
      assertTrue((discCentre - upperEdge) * 24 * 60 < 10, "圓面差異應該是分鐘等級");
    }
  }
}
