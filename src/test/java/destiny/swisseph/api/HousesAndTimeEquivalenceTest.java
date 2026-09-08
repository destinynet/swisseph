package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Same contract as {@link SwissEphemerisEquivalenceTest}, for house division and the equation of
 * time: whatever the legacy call returns, the typed one must return the same, bit for bit.
 *
 * <p>The house case has a particular trap worth pinning. The legacy {@code cusp} array's slot 0
 * is unused, so every index is off by one from the house number, and {@code ascmc}'s eight
 * meaningful slots are documented only in a comment. Both are re-shaped here, and a re-shaping is
 * exactly the kind of change that can be wrong by one without anything looking wrong.
 */
class HousesAndTimeEquivalenceTest {

  private record Case(double tjd, GeoLocation place, HouseSystem system, Zodiac zodiac) { }

  private static List<Case> cases() {
    List<Case> out = new ArrayList<>();
    double[] dates = {2299160.5, 2451545.0, 2460841.5};
    List<GeoLocation> places = List.of(
        GeoLocation.of(121.5, 25.0),      // Taipei
        GeoLocation.of(-0.13, 51.5),      // London
        GeoLocation.of(-58.4, -34.6),     // Buenos Aires, southern hemisphere
        GeoLocation.of(18.9, 69.6));      // Tromsø, inside the arctic circle
    List<Zodiac> zodiacs = List.of(
        Zodiac.tropical(),
        Zodiac.sidereal(SweConst.SE_SIDM_LAHIRI));
    for (double tjd : dates) {
      for (GeoLocation place : places) {
        for (HouseSystem system : HouseSystem.values()) {
          for (Zodiac zodiac : zodiacs) {
            out.add(new Case(tjd, place, system, zodiac));
          }
        }
      }
    }
    return out;
  }

  private static String legacyHouses(String ephePath, Case c) {
    SwissEph se = new SwissEph(ephePath);
    try {
      if (c.zodiac() instanceof Zodiac.Sidereal sidereal) {
        se.swe_set_sid_mode(sidereal.ayanamsaMode(), 0, 0);
      }
      double[] cusp = new double[37];
      double[] ascmc = new double[10];
      int rc = se.swe_houses(c.tjd(), c.zodiac().bit(),
                             c.place().latitudeDeg(), c.place().longitudeDeg(),
                             c.system().code(), cusp, ascmc);
      if (rc == SweConst.ERR) {
        return "ERR";
      }
      int count = c.system() == HouseSystem.GAUQUELIN_SECTORS ? 36 : 12;
      StringBuilder sb = new StringBuilder();
      for (int house = 1; house <= count; house++) {
        sb.append(Double.toHexString(cusp[house])).append(',');
      }
      for (int i = 0; i < 8; i++) {
        sb.append(Double.toHexString(ascmc[i])).append(',');
      }
      return sb.toString();
    } finally {
      se.swe_close();
    }
  }

  private static String modernHouses(String ephePath, Case c) {
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      Houses h = ephemeris.houses(JulianDayUT.of(c.tjd()), c.place(), c.system(), c.zodiac());
      StringBuilder sb = new StringBuilder();
      for (double cusp : h.cusps()) {
        sb.append(Double.toHexString(cusp)).append(',');
      }
      HouseAngles a = h.angles();
      for (double v : new double[]{a.ascendantDeg(), a.midheavenDeg(), a.armcDeg(), a.vertexDeg(),
                                   a.equatorialAscendantDeg(), a.coAscendantKochDeg(),
                                   a.coAscendantMunkaseyDeg(), a.polarAscendantDeg()}) {
        sb.append(Double.toHexString(v)).append(',');
      }
      return sb.toString();
    } catch (SwissEphemerisException e) {
      return "ERR";
    }
  }

  @Test
  void houseDivisionMatchesTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    List<Case> cases = cases();
    assertTrue(cases.size() > 300, "the matrix collapsed to " + cases.size() + " cases");

    int produced = 0;
    for (Case c : cases) {
      String expected = legacyHouses(ephePath, c);
      String actual = modernHouses(ephePath, c);
      assertEquals(expected, actual,
                   "differs for tjd=" + c.tjd() + " place=" + c.place()
                   + " system=" + c.system() + " zodiac=" + c.zodiac());
      if (!"ERR".equals(expected)) {
        produced++;
      }
    }
    assertTrue(produced > cases.size() * 9 / 10,
               "only " + produced + " of " + cases.size() + " divisions succeeded");
  }

  @Test
  void houseNumbersAreNotOffByOne() {
    // The one thing an equivalence test cannot catch on its own: both sides could be shifted the
    // same way. cusp(1) must be the ascendant, and cusp(10) the midheaven, for a quadrant system.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      Houses h = ephemeris.houses(
          JulianDayUT.of(2451545.0), GeoLocation.of(121.5, 25.0), HouseSystem.PLACIDUS);

      assertEquals(12, h.cusps().size());
      assertEquals(h.angles().ascendantDeg(), h.cusp(1), 1e-9, "第一宮的宮首就是上升點");
      assertEquals(h.angles().midheavenDeg(), h.cusp(10), 1e-9, "第十宮的宮首就是天頂");
      assertEquals(h.cusps().get(0), h.cusp(1), 0.0, "cusp(1) 對應 list 的第 0 個");
    }
  }

  @Test
  void theEquationOfTimeMatchesTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    double[] dates = {2299160.5, 2415020.5, 2451545.0, 2451630.5, 2458849.5, 2460841.5};

    for (double tjd : dates) {
      SwissEph se = new SwissEph(ephePath);
      double expectedDays;
      try {
        double[] e = new double[1];
        se.swe_time_equ(tjd, e, new StringBuffer());
        expectedDays = e[0];
      } finally {
        se.swe_close();
      }

      try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
        Duration actual = ephemeris.equationOfTime(JulianDayUT.of(tjd));
        long expectedNanos = Math.round(expectedDays * 24 * 60 * 60 * 1_000_000_000L);
        assertEquals(expectedNanos, actual.toNanos(), "differs at tjd=" + tjd);
        // Sanity: the equation of time never leaves roughly +/-17 minutes.
        assertTrue(Math.abs(actual.toMinutes()) <= 17,
                   "equation of time out of its physical range at tjd=" + tjd + ": " + actual);
      }
    }
  }
}
