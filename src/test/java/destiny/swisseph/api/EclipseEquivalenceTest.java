package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Equivalence and behaviour for the eclipse family.
 *
 * <p>These are the calls where the legacy shape misleads hardest: {@code swe_sol_eclipse_when_glob}
 * and {@code swe_sol_eclipse_when_loc} both fill a {@code double[10]}, and the slots mean
 * different things. Slot 2 is "the eclipse begins somewhere on Earth" in the first and "second
 * contact at the observer" in the second. Nothing in either signature says so, and both are
 * plausible Julian days. So the re-shaping here is checked slot by slot against each call.
 */
class EclipseEquivalenceTest {

  private static final GeoLocation TAIPEI = GeoLocation.of(121.5, 25.0);
  private static final double[] STARTS = {2451545.0, 2455000.0, 2458849.5};

  private static String hex(double d) {
    return Double.toHexString(d);
  }

  private static String hexOf(Optional<JulianDayUT> t) {
    return t.map(v -> Double.toHexString(v.value())).orElse("-");
  }

  /** The legacy convention for an absent phase, so both sides render it the same way. */
  private static String hexSlot(double tret) {
    return tret == 0 ? "-" : Double.toHexString(tret);
  }

  @Test
  void globalSolarEclipseMatchesTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    for (double start : STARTS) {
      for (SearchDirection direction : SearchDirection.values()) {
        String expected;
        int expectedFlags;
        SwissEph se = new SwissEph(ephePath);
        try {
          double[] tret = new double[10];
          int rc = se.swe_sol_eclipse_when_glob(start, SweConst.SEFLG_SWIEPH, 0, tret,
                                                direction.flag(), new StringBuffer());
          expectedFlags = rc;
          expected = hex(tret[0]) + ',' + hex(tret[1]) + ',' + hex(tret[2]) + ',' + hex(tret[3])
                     + ',' + hexSlot(tret[4]) + ',' + hexSlot(tret[5])
                     + ',' + hexSlot(tret[6]) + ',' + hexSlot(tret[7])
                     + ',' + hexSlot(tret[8]) + ',' + hexSlot(tret[9]);
        } finally {
          se.swe_close();
        }

        try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
          GlobalSolarEclipse e = ephemeris.nextGlobalSolarEclipse(
              JulianDayUT.of(start), direction, Ephemeris.SWISS, EnumSet.noneOf(SolarEclipseKind.class));
          String actual = hex(e.maximum().value()) + ',' + hex(e.atLocalApparentNoon().value())
                          + ',' + hex(e.begin().value()) + ',' + hex(e.end().value())
                          + ',' + hexOf(e.totalityBegin()) + ',' + hexOf(e.totalityEnd())
                          + ',' + hexOf(e.centralLineBegin()) + ',' + hexOf(e.centralLineEnd())
                          + ',' + hexOf(e.becomesTotal()) + ',' + hexOf(e.becomesAnnular());
          assertEquals(expected, actual, "differs from " + start + " " + direction);
          assertEquals(SolarEclipseKind.from(expectedFlags), e.kind());
          assertEquals((expectedFlags & SweConst.SE_ECL_CENTRAL) != 0, e.central());
        }
      }
    }
  }

  @Test
  void localSolarEclipseMatchesTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    for (double start : STARTS) {
      String expected;
      int expectedFlags;
      SwissEph se = new SwissEph(ephePath);
      try {
        double[] geopos = {TAIPEI.longitudeDeg(), TAIPEI.latitudeDeg(), TAIPEI.altitudeMetres()};
        double[] tret = new double[10];
        double[] attr = new double[20];
        int rc = se.swe_sol_eclipse_when_loc(start, SweConst.SEFLG_SWIEPH, geopos, tret, attr,
                                             0, new StringBuffer());
        expectedFlags = rc;
        expected = hex(tret[0]) + ',' + hex(tret[1]) + ',' + hexSlot(tret[2]) + ',' + hexSlot(tret[3])
                   + ',' + hex(tret[4]) + ',' + hexSlot(tret[5]) + ',' + hexSlot(tret[6])
                   + "|" + hex(attr[0]) + ',' + hex(attr[1]) + ',' + hex(attr[2]) + ',' + hex(attr[3])
                   + ',' + hex(attr[4]) + ',' + hex(attr[5]) + ',' + hex(attr[6]) + ',' + hex(attr[7]);
      } finally {
        se.swe_close();
      }

      try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
        LocalSolarEclipse e = ephemeris.nextLocalSolarEclipse(
            JulianDayUT.of(start), TAIPEI, SearchDirection.FORWARD, Ephemeris.SWISS);
        SolarEclipseAppearance a = e.appearance();
        String actual = hex(e.maximum().value()) + ',' + hex(e.firstContact().value())
                        + ',' + hexOf(e.secondContact()) + ',' + hexOf(e.thirdContact())
                        + ',' + hex(e.fourthContact().value())
                        + ',' + hexOf(e.sunrise()) + ',' + hexOf(e.sunset())
                        + "|" + hex(a.magnitude()) + ',' + hex(a.lunarToSolarDiameterRatio())
                        + ',' + hex(a.obscuration()) + ',' + hex(a.coreShadowDiameterKm())
                        + ',' + hex(a.sun().azimuthFromSouthDeg())
                        + ',' + hex(a.sun().trueAltitudeDeg())
                        + ',' + hex(a.sun().apparentAltitudeDeg())
                        + ',' + hex(a.moonSunDistanceDeg());
        assertEquals(expected, actual, "differs from " + start);
        assertEquals((expectedFlags & SweConst.SE_ECL_VISIBLE) != 0, e.visible());
      }
    }
  }

  @Test
  void lunarEclipseMatchesTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    for (double start : STARTS) {
      for (SearchDirection direction : SearchDirection.values()) {
        String expected;
        SwissEph se = new SwissEph(ephePath);
        try {
          double[] tret = new double[10];
          se.swe_lun_eclipse_when(start, SweConst.SEFLG_SWIEPH, 0, tret, direction.flag(),
                                  new StringBuffer());
          expected = hex(tret[0]) + ',' + hexSlot(tret[2]) + ',' + hexSlot(tret[3])
                     + ',' + hexSlot(tret[4]) + ',' + hexSlot(tret[5])
                     + ',' + hexSlot(tret[6]) + ',' + hexSlot(tret[7]);
        } finally {
          se.swe_close();
        }

        try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
          LunarEclipse e = ephemeris.nextLunarEclipse(
              JulianDayUT.of(start), direction, Ephemeris.SWISS,
              EnumSet.noneOf(LunarEclipseKind.class));
          String actual = hex(e.maximum().value()) + ',' + hexOf(e.partialBegin())
                          + ',' + hexOf(e.partialEnd()) + ',' + hexOf(e.totalityBegin())
                          + ',' + hexOf(e.totalityEnd()) + ',' + hexOf(e.penumbraBegin())
                          + ',' + hexOf(e.penumbraEnd());
          assertEquals(expected, actual, "differs from " + start + " " + direction);
          assertTrue(e.appearance().isEmpty(), "全球性的搜尋不該帶著某地的觀測資料");
        }
      }
    }
  }

  @Test
  void eclipseCentreAndAppearanceMatchTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    // A known total solar eclipse: 2009-07-22, the longest of the 21st century.
    double maximum;
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      maximum = ephemeris.nextGlobalSolarEclipse(
          JulianDayUT.of(2455000.0), SearchDirection.FORWARD, Ephemeris.SWISS,
          EnumSet.of(SolarEclipseKind.TOTAL)).maximum().value();
    }

    String expected;
    SwissEph se = new SwissEph(ephePath);
    try {
      double[] geopos = new double[20];
      double[] attr = new double[20];
      se.swe_sol_eclipse_where(maximum, SweConst.SEFLG_SWIEPH, geopos, attr, new StringBuffer());
      expected = hex(geopos[0]) + ',' + hex(geopos[1]) + ',' + hex(attr[0]) + ',' + hex(attr[2]);
    } finally {
      se.swe_close();
    }

    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      // While we are here: at a moment with no eclipse, "how does it look" has no answer, and
      // that must be an absence rather than a fabricated one. The legacy call returns 0 for this
      // and the arrays keep whatever was in them.
      assertTrue(ephemeris.solarEclipseAt(JulianDayUT.of(2451545.0), TAIPEI, Ephemeris.SWISS).isEmpty(),
                 "沒有日食的時刻不該回傳觀測資料");
      assertTrue(ephemeris.lunarEclipseAt(JulianDayUT.of(2451545.0), TAIPEI, Ephemeris.SWISS).isEmpty(),
                 "沒有月食的時刻不該回傳觀測資料");

      // And at a moment when there is one, it does answer.
      assertTrue(ephemeris.solarEclipseAt(JulianDayUT.of(maximum),
                                          GeoLocation.of(0.0, 0.0), Ephemeris.SWISS).isPresent()
                 || ephemeris.solarEclipseAt(JulianDayUT.of(maximum), TAIPEI, Ephemeris.SWISS).isPresent(),
                 "食甚時刻至少某處看得到");

      assertTrue(ephemeris.solarEclipseCentre(JulianDayUT.of(2451545.0), Ephemeris.SWISS).isEmpty(),
                 "沒有日食的時刻不該回傳中心線");
      EclipseCentre centre = ephemeris.solarEclipseCentre(JulianDayUT.of(maximum), Ephemeris.SWISS).orElseThrow();
      String actual = hex(centre.centralLine().longitudeDeg()) + ',' + hex(centre.centralLine().latitudeDeg())
                      + ',' + hex(centre.appearance().magnitude())
                      + ',' + hex(centre.appearance().obscuration());
      assertEquals(expected, actual);

      // Physical sanity at the point of greatest eclipse of a total eclipse.
      assertEquals(SolarEclipseKind.TOTAL, centre.kind());
      assertTrue(centre.central(), "全食的最大食甚點應該在中心線上");
      assertTrue(centre.appearance().magnitude() >= 1.0,
                 "全食的食分應該 >= 1，實得 " + centre.appearance().magnitude());
      assertTrue(centre.appearance().obscuration() >= 0.999,
                 "全食應該幾乎遮蔽整個日面，實得 " + centre.appearance().obscuration());
      assertTrue(centre.appearance().lunarToSolarDiameterRatio() > 1.0,
                 "能全食代表月面視直徑大於日面");
    }
  }

  @Test
  void magnitudeAndObscurationAreDifferentQuantities() {
    // The two are routinely confused: magnitude is a ratio of diameters, obscuration a fraction
    // of area. If the slots were swapped, a partial eclipse would look wrong in a way no
    // equivalence test would notice, because both sides would swap together.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      LocalSolarEclipse partial = null;
      double from = 2451545.0;
      for (int attempt = 0; attempt < 12 && partial == null; attempt++) {
        LocalSolarEclipse candidate = ephemeris.nextLocalSolarEclipse(
            JulianDayUT.of(from), TAIPEI, SearchDirection.FORWARD, Ephemeris.SWISS);
        if (candidate.kind() == SolarEclipseKind.PARTIAL
            && candidate.appearance().magnitude() > 0.2
            && candidate.appearance().magnitude() < 0.9) {
          partial = candidate;
        }
        from = candidate.maximum().value() + 1;
      }
      assertNotEquals(null, partial, "找不到台北可見的偏食可供檢查");

      double magnitude = partial.appearance().magnitude();
      double obscuration = partial.appearance().obscuration();
      // Area always lags diameter for a partial phase: covering half the diameter hides much
      // less than half the disc.
      assertTrue(obscuration < magnitude,
                 "偏食時遮蔽面積比例必定小於食分（直徑比），實得 mag=" + magnitude
                 + " obsc=" + obscuration);
      assertTrue(obscuration > 0 && magnitude < 1.0);
    }
  }

  @Test
  void theTwoWhenCallsUseDifferentSlotLayouts() {
    // The single most misleading thing about the legacy API, pinned as a property: for the same
    // eclipse, the global call's "begin" and the local call's "first contact" are different
    // instants, even though both live in a double[10] and neither signature explains itself.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      LocalSolarEclipse local = ephemeris.nextLocalSolarEclipse(
          JulianDayUT.of(2451545.0), TAIPEI, SearchDirection.FORWARD, Ephemeris.SWISS);
      GlobalSolarEclipse global = ephemeris.nextGlobalSolarEclipse(
          JulianDayUT.of(local.maximum().value() - 1), SearchDirection.FORWARD, Ephemeris.SWISS,
          EnumSet.noneOf(SolarEclipseKind.class));

      // Same eclipse, within a day.
      assertTrue(Math.abs(global.maximum().value() - local.maximum().value()) < 1,
                 "應該是同一次日食");
      // The eclipse starts somewhere on Earth before it starts in Taipei, and ends after.
      assertTrue(global.begin().value() <= local.firstContact().value(),
                 "全球初虧不會晚於某地初虧");
      assertTrue(global.end().value() >= local.fourthContact().value(),
                 "全球復圓不會早於某地復圓");
    }
  }

  @Test
  void searchingBackwardsFindsAnEarlierEclipse() {
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      JulianDayUT from = JulianDayUT.of(2455000.0);
      double forward = ephemeris.nextGlobalSolarEclipse(
          from, SearchDirection.FORWARD, Ephemeris.SWISS,
          EnumSet.noneOf(SolarEclipseKind.class)).maximum().value();
      double backward = ephemeris.nextGlobalSolarEclipse(
          from, SearchDirection.BACKWARD, Ephemeris.SWISS,
          EnumSet.noneOf(SolarEclipseKind.class)).maximum().value();

      assertTrue(forward > from.value(), "往前找應該找到之後的日食");
      assertTrue(backward < from.value(), "往回找應該找到之前的日食");
      // Solar eclipses come roughly twice a year, so neither should be far away.
      assertTrue(forward - backward < 400, "前後兩次日食不該相隔超過一年多");
    }
  }

  @Test
  void restrictingTheKindDoesNotSendTheSearchRunningOffTheEndOfTime() {
    // The legacy filter checks centrality the same way it checks kind, so ifltype = SE_ECL_TOTAL
    // alone means "total, but neither central nor non-central" —— which every eclipse fails. The
    // search then walks forward for centuries and dies on a missing data file, saying nothing
    // about the filter. The typed API adds the centrality bits; this makes sure it keeps doing so.
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      for (SolarEclipseKind kind : SolarEclipseKind.values()) {
        GlobalSolarEclipse e = ephemeris.nextGlobalSolarEclipse(
            JulianDayUT.of(2451545.0), SearchDirection.FORWARD, Ephemeris.SWISS, EnumSet.of(kind));
        assertEquals(kind, e.kind(), "限定 " + kind + " 卻拿到 " + e.kind());
        // Every kind of solar eclipse recurs within a couple of decades; anything beyond that
        // means the filter is rejecting candidates it should have accepted.
        assertTrue(e.maximum().value() - 2451545.0 < 25 * 365.25,
                   "限定 " + kind + " 之後搜尋跑到了 " + e.maximum() + " —— 過濾條件把該接受的也拒絕了");
      }
    }
  }

  @Test
  void restrictingTheKindActuallyFilters() {
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      JulianDayUT from = JulianDayUT.of(2451545.0);
      GlobalSolarEclipse any = ephemeris.nextGlobalSolarEclipse(
          from, SearchDirection.FORWARD, Ephemeris.SWISS, EnumSet.noneOf(SolarEclipseKind.class));
      GlobalSolarEclipse total = ephemeris.nextGlobalSolarEclipse(
          from, SearchDirection.FORWARD, Ephemeris.SWISS, EnumSet.of(SolarEclipseKind.TOTAL));

      assertEquals(SolarEclipseKind.TOTAL, total.kind());
      if (any.kind() != SolarEclipseKind.TOTAL) {
        assertTrue(total.maximum().value() > any.maximum().value(),
                   "限定全食應該跳過比較早的非全食");
      }

      for (LunarEclipseKind kind : List.of(LunarEclipseKind.TOTAL, LunarEclipseKind.PENUMBRAL)) {
        LunarEclipse e = ephemeris.nextLunarEclipse(
            from, SearchDirection.FORWARD, Ephemeris.SWISS, EnumSet.of(kind));
        assertEquals(kind, e.kind(), "限定 " + kind + " 卻拿到 " + e.kind());
      }
    }
  }
}
