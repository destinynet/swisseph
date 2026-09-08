package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Equivalence and behaviour for {@code swe_nod_aps_ut}. */
class NodesAndApsidesEquivalenceTest {

  private static String render(Position p) {
    if (p instanceof Position.Ecliptic e) {
      return Double.toHexString(e.longitudeDeg()) + ',' + Double.toHexString(e.latitudeDeg())
             + ',' + Double.toHexString(e.distanceAu())
             + e.speed().map(v -> ',' + Double.toHexString(v.longitudeDegPerDay())
                                  + ',' + Double.toHexString(v.latitudeDegPerDay())
                                  + ',' + Double.toHexString(v.distanceAuPerDay())).orElse("");
    }
    Position.Equatorial q = (Position.Equatorial) p;
    return Double.toHexString(q.rightAscensionDeg()) + ',' + Double.toHexString(q.declinationDeg())
           + ',' + Double.toHexString(q.distanceAu())
           + q.speed().map(v -> ',' + Double.toHexString(v.rightAscensionDegPerDay())
                                + ',' + Double.toHexString(v.declinationDegPerDay())
                                + ',' + Double.toHexString(v.distanceAuPerDay())).orElse("");
  }

  @Test
  void nodesAndApsidesMatchTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    double[] dates = {2299160.5, 2451545.0, 2460841.5};
    List<Body.Point> bodies = List.of(Body.Point.MOON, Body.Point.MERCURY, Body.Point.MARS,
                                      Body.Point.SATURN, Body.Point.CHIRON);
    List<Set<CalcOption>> optionSets = List.of(
        EnumSet.noneOf(CalcOption.class),
        EnumSet.of(CalcOption.SPEED),
        EnumSet.of(CalcOption.SPEED, CalcOption.EQUATORIAL));
    List<Set<ApsisOption>> apsisSets = List.of(
        EnumSet.noneOf(ApsisOption.class),
        EnumSet.of(ApsisOption.FOCAL_POINT));

    int checked = 0;
    for (double tjd : dates) {
      for (Body.Point body : bodies) {
        for (ApsisMethod method : ApsisMethod.values()) {
          for (Set<CalcOption> options : optionSets) {
            for (Set<ApsisOption> apsis : apsisSets) {
              int iflag = Ephemeris.SWISS.bit();
              for (CalcOption o : options) {
                iflag |= o.bit();
              }
              int nodeMethod = method.bit() | (apsis.isEmpty() ? 0 : SweConst.SE_NODBIT_FOPOINT);

              String expected;
              SwissEph se = new SwissEph(ephePath);
              try {
                double[] a = new double[6], d = new double[6], p = new double[6], f = new double[6];
                int rc = se.swe_nod_aps_ut(tjd, body.number(), iflag, nodeMethod, a, d, p, f,
                                           new StringBuffer());
                expected = rc == SweConst.ERR ? "ERR" : hex(a) + '|' + hex(d) + '|' + hex(p) + '|' + hex(f);
              } finally {
                se.swe_close();
              }

              String actual;
              try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
                NodesAndApsides n = ephemeris.nodesAndApsides(
                    JulianDayUT.of(tjd), body, Ephemeris.SWISS, method, options, apsis,
                    Centre.geocentric(), Zodiac.tropical());
                actual = render(n.ascendingNode()) + '|' + render(n.descendingNode())
                         + '|' + render(n.perihelion()) + '|' + render(n.aphelion());
              } catch (SwissEphemerisException e) {
                actual = "ERR";
              }

              // The legacy renderer always prints six slots; the typed one omits absent speeds.
              // Compare only what both sides agree is meaningful.
              if (!"ERR".equals(expected)) {
                expected = trimToSpeedPresence(expected, options.contains(CalcOption.SPEED));
              }
              assertEquals(expected, actual,
                           "differs at tjd=" + tjd + " " + body + " " + method
                           + " options=" + options + " apsis=" + apsis);
              checked++;
            }
          }
        }
      }
    }
    assertTrue(checked > 150, "only " + checked + " combinations checked");
  }

  private static String hex(double[] xx) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      if (i > 0) sb.append(',');
      sb.append(Double.toHexString(xx[i]));
    }
    return sb.toString();
  }

  /** Drops the three speed slots from each of the four groups when speeds were not requested. */
  private static String trimToSpeedPresence(String rendered, boolean withSpeed) {
    if (withSpeed) {
      return rendered;
    }
    String[] groups = rendered.split("\\|");
    StringBuilder sb = new StringBuilder();
    for (int g = 0; g < groups.length; g++) {
      if (g > 0) sb.append('|');
      String[] slots = groups[g].split(",");
      sb.append(slots[0]).append(',').append(slots[1]).append(',').append(slots[2]);
    }
    return sb.toString();
  }

  @Test
  void theFourPointsAreNotShuffled() {
    // An equivalence test cannot catch the four arrays being read into the wrong roles, because
    // both sides would shuffle identically. These are geometric facts about any orbit —— but only
    // as seen from the body the orbit is around. Geocentrically the two nodes lie at different
    // distances from the observer and are not opposite at all, and the far apsis can even be the
    // nearer of the two. So this has to be asked heliocentrically.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      NodesAndApsides mars = ephemeris.nodesAndApsides(
          JulianDayUT.of(2451545.0), Body.Point.MARS, Ephemeris.SWISS, ApsisMethod.OSCULATING,
          java.util.EnumSet.noneOf(CalcOption.class), java.util.EnumSet.noneOf(ApsisOption.class),
          Centre.heliocentric(), Zodiac.tropical());

      double ascending = ((Position.Ecliptic) mars.ascendingNode()).longitudeDeg();
      double descending = ((Position.Ecliptic) mars.descendingNode()).longitudeDeg();
      double separation = Math.abs(ascending - descending);
      // 容差留到 1e-4 度（0.36 弧秒）：即使日心，光行時修正仍會讓兩點差一點點。
      assertEquals(180.0, Math.min(separation, 360 - separation), 1e-4,
                   "升交點與降交點必定相隔 180 度");

      double perihelion = mars.perihelion().distanceAu();
      double aphelion = mars.aphelion().distanceAu();
      assertTrue(aphelion > perihelion,
                 "遠日點必定比近日點遠，實得 near=" + perihelion + " far=" + aphelion);
      // 火星的近日點約 1.38 AU、遠日點約 1.67 AU —— 順帶確認拿到的是日心距離而非地心。
      assertTrue(perihelion > 1.3 && aphelion < 1.7,
                 "火星日心距離應在 1.38~1.67 AU，實得 " + perihelion + " / " + aphelion);
    }
  }

  @Test
  void meanAndOsculatingAreDifferentAnswers() {
    // If the method bits were dropped, these would coincide.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      JulianDayUT t = JulianDayUT.of(2451545.0);
      double mean = ((Position.Ecliptic) ephemeris.nodesAndApsides(
          t, Body.Point.MOON, Ephemeris.SWISS, ApsisMethod.MEAN).ascendingNode()).longitudeDeg();
      double osculating = ((Position.Ecliptic) ephemeris.nodesAndApsides(
          t, Body.Point.MOON, Ephemeris.SWISS, ApsisMethod.OSCULATING).ascendingNode()).longitudeDeg();
      assertNotEquals(mean, osculating, "平均交點與真交點不該是同一個值");
      assertTrue(Math.abs(mean - osculating) < 5, "兩者相差應該是度的等級，不是象限");
    }
  }

  @Test
  void theFocalPointIsNotTheAphelion() {
    // Black Moon Lilith versus the lunar apogee —— the option must actually reach the library.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      JulianDayUT t = JulianDayUT.of(2451545.0);
      NodesAndApsides plain = ephemeris.nodesAndApsides(
          t, Body.Point.MOON, Ephemeris.SWISS, ApsisMethod.OSCULATING);
      NodesAndApsides focal = ephemeris.nodesAndApsides(
          t, Body.Point.MOON, Ephemeris.SWISS, ApsisMethod.OSCULATING,
          EnumSet.noneOf(CalcOption.class), EnumSet.of(ApsisOption.FOCAL_POINT),
          Centre.geocentric(), Zodiac.tropical());

      assertNotEquals(plain.aphelion().distanceAu(), focal.aphelion().distanceAu(),
                      "軌道第二焦點與遠地點是不同的點");
      assertEquals(((Position.Ecliptic) plain.ascendingNode()).longitudeDeg(),
                   ((Position.Ecliptic) focal.ascendingNode()).longitudeDeg(), 1e-9,
                   "這個選項不該動到交點");
    }
  }
}
