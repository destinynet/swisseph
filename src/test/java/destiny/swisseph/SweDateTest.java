package destiny.swisseph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * White-box tests for the calendar and delta-T layer.
 *
 * <p>This is where Phase 2 does most of its work — {@code SweDate} holds the static fields
 * ({@code sw}, {@code tid_acc}, {@code is_tid_acc_manual}, {@code init_dt_done}) that make
 * instances of the whole library depend on one another. Two kinds of test live here:
 * calendar arithmetic, asserted against dates whose Julian Day numbers are independently
 * known; and a tripwire on the shared state itself, so that removing it is a visible event
 * rather than a silent one.
 */
class SweDateTest {

  private static final double SECOND = 1.0 / 86400.0;

  // ------------------------------------------------------------------ known epochs

  @Test
  void knownEpochsConvertBothWays() {
    // J2000.0: 2000-01-01 12:00 UT.
    assertEquals(2451545.0, SweDate.getJulDay(2000, 1, 1, 12.0, SweDate.SE_GREG_CAL));
    // The Unix epoch, which the class also exposes as JD0.
    assertEquals(2440587.5, SweDate.getJulDay(1970, 1, 1, 0.0, SweDate.SE_GREG_CAL));
    assertEquals(2440587.5, SweDate.JD0);
    // Julian Day zero is noon on -4712-01-01 in the Julian calendar.
    assertEquals(0.0, SweDate.getJulDay(-4712, 1, 1, 12.0, SweDate.SE_JUL_CAL));

    SweDate d = new SweDate(2451545.0, SweDate.SE_GREG_CAL);
    assertEquals(2000, d.getYear());
    assertEquals(1, d.getMonth());
    assertEquals(1, d.getDay());
    assertEquals(12.0, d.getHour(), 1e-9);
  }

  @Test
  void julianDaysStartAtNoon() {
    // Midnight is the half day; the same calendar day at noon is the whole one.
    assertEquals(2451544.5, SweDate.getJulDay(2000, 1, 1, 0.0, SweDate.SE_GREG_CAL));
    assertEquals(2451545.0, SweDate.getJulDay(2000, 1, 1, 12.0, SweDate.SE_GREG_CAL));
  }

  // ------------------------------------------------------------------- round trips

  @Test
  void calendarRoundTripsOverTheWholeRange() {
    int[][] dates = {
        {-3000, 1, 1}, {-1000, 6, 15}, {0, 12, 31}, {1000, 2, 28},
        {1582, 10, 4}, {1582, 10, 15}, {1600, 2, 29}, {1700, 3, 1},
        {1900, 2, 28}, {2000, 2, 29}, {2024, 12, 31}, {2100, 3, 1},
        {2500, 7, 4}, {3000, 1, 1},
    };
    for (boolean cal : new boolean[]{SweDate.SE_GREG_CAL, SweDate.SE_JUL_CAL}) {
      for (int[] ymd : dates) {
        for (double hour : new double[]{0.0, 6.5, 12.0, 23.75}) {
          double jd = SweDate.getJulDay(ymd[0], ymd[1], ymd[2], hour, cal);
          SweDate back = new SweDate(jd, cal);
          String what = ymd[0] + "-" + ymd[1] + "-" + ymd[2] + " " + hour + " greg=" + cal;
          assertEquals(ymd[0], back.getYear(), what);
          assertEquals(ymd[1], back.getMonth(), what);
          assertEquals(ymd[2], back.getDay(), what);
          assertEquals(hour, back.getHour(), 1e-6, what);
        }
      }
    }
  }

  @Test
  void oneJulianDayIsOneCalendarDay() {
    double jd = SweDate.getJulDay(2024, 2, 28, 0.0, SweDate.SE_GREG_CAL);
    SweDate next = new SweDate(jd + 1, SweDate.SE_GREG_CAL);
    assertEquals(29, next.getDay(), "2024 is a leap year");

    double nonLeap = SweDate.getJulDay(2023, 2, 28, 0.0, SweDate.SE_GREG_CAL);
    assertEquals(3, new SweDate(nonLeap + 1, SweDate.SE_GREG_CAL).getMonth());
  }

  // ------------------------------------------------------- the calendar changeover

  /**
   * The ten days that never happened: 1582-10-04 in the Julian calendar is followed by
   * 1582-10-15 in the Gregorian one, and the two are consecutive Julian Days.
   */
  @Test
  void theGregorianChangeoverIsContinuousInJulianDays() {
    double lastJulian = SweDate.getJulDay(1582, 10, 4, 0.0, SweDate.SE_JUL_CAL);
    double firstGregorian = SweDate.getJulDay(1582, 10, 15, 0.0, SweDate.SE_GREG_CAL);
    assertEquals(1.0, firstGregorian - lastJulian, 1e-9);
    assertEquals(2299160.5, firstGregorian);
  }

  @Test
  void gregorianChangeIsReportedAsAJulianDay() {
    assertEquals(2299160.5, new SweDate(2451545.0).getGregorianChange());
  }

  @Test
  void switchingCalendarKeepingTheDateMovesTheJulianDay() {
    SweDate d = new SweDate(1700, 3, 1, 0.0, SweDate.SE_GREG_CAL);
    double before = d.getJulDay();

    d.setCalendarType(SweDate.SE_JUL_CAL, SweDate.SE_KEEP_DATE);
    assertEquals(1700, d.getYear());
    assertEquals(3, d.getMonth());
    assertEquals(1, d.getDay());
    assertNotEquals(before, d.getJulDay(), "keeping the date must move the instant");
  }

  @Test
  void switchingCalendarKeepingTheJulianDayMovesTheDate() {
    SweDate d = new SweDate(1700, 3, 1, 0.0, SweDate.SE_GREG_CAL);
    double before = d.getJulDay();

    d.setCalendarType(SweDate.SE_JUL_CAL, SweDate.SE_KEEP_JD);
    assertEquals(before, d.getJulDay(), "keeping the JD must hold the instant fixed");
    assertNotEquals(1, d.getDay(), "the same instant falls on a different Julian date");
  }

  // ------------------------------------------------------------------ day of week

  @Test
  void dayOfWeekMatchesKnownDates() {
    // 2000-01-01 was a Saturday; 2026-09-08 is a Tuesday.
    assertEquals(SweDate.SATURDAY, SweDate.getDayOfWeekNr(2000, 1, 1));
    assertEquals(SweDate.TUESDAY, SweDate.getDayOfWeekNr(2026, 9, 8));
    assertEquals(SweDate.SATURDAY,
                 SweDate.getDayOfWeekNr(SweDate.getJulDay(2000, 1, 1, 12.0, SweDate.SE_GREG_CAL)));
    assertEquals(SweDate.SATURDAY, new SweDate(2000, 1, 1, 12.0).getDayOfWeekNr());
  }

  @Test
  void dayOfWeekAdvancesByOnePerDay() {
    double jd = SweDate.getJulDay(2024, 1, 1, 12.0, SweDate.SE_GREG_CAL);
    for (int i = 0; i < 14; i++) {
      int expected = (SweDate.getDayOfWeekNr(jd) + 1) % 7;
      assertEquals(expected, SweDate.getDayOfWeekNr(jd + 1), "day " + i);
      jd += 1;
    }
  }

  // ----------------------------------------------------------------- field setters

  @Test
  void settersMoveTheJulianDay() {
    SweDate d = new SweDate(2000, 1, 1, 0.0, SweDate.SE_GREG_CAL);
    double base = d.getJulDay();

    assertTrue(d.setDay(2));
    assertEquals(base + 1, d.getJulDay(), 1e-9);

    assertTrue(d.setHour(12.0));
    assertEquals(base + 1.5, d.getJulDay(), 1e-9);

    assertTrue(d.setMonth(2));
    assertEquals(2, d.getMonth());

    assertTrue(d.setYear(2001));
    assertEquals(2001, d.getYear());
  }

  @Test
  void checkedSettersRejectImpossibleValues() {
    SweDate d = new SweDate(2001, 1, 31, 0.0, SweDate.SE_GREG_CAL);
    assertFalse(d.setMonth(2, true), "2001-02-31 does not exist");
    assertFalse(d.setDay(32, true));
    assertFalse(d.setMonth(13, true));
  }

  @Test
  void checkDateAcceptsRealDatesAndRejectsInventedOnes() {
    SweDate d = new SweDate(2000, 1, 1, 0.0);
    assertTrue(d.checkDate(2024, 2, 29), "2024 is a leap year");
    assertFalse(d.checkDate(2023, 2, 29), "2023 is not");
    assertFalse(d.checkDate(2024, 13, 1));
    assertFalse(d.checkDate(2024, 4, 31));
    assertTrue(d.checkDate(2024, 12, 31, 23.99));
  }

  @Test
  void makeValidDateNormalisesAnOverflowingDate() {
    SweDate d = new SweDate(2001, 1, 1, 0.0, SweDate.SE_GREG_CAL);
    d.setMonth(2, false);
    d.setDay(30, false);       // 2001-02-30, deliberately impossible
    d.makeValidDate();
    assertEquals(3, d.getMonth());
    assertEquals(2, d.getDay(), "Feb 30th of a non-leap year rolls to March 2nd");
  }

  // ---------------------------------------------------------------------- delta T

  /**
   * Delta T is asserted by its shape, not by exact values: it is large and positive in the
   * distant past, passes through a known minimum around 1900, and is about a minute today.
   * Exact values are pinned by the golden master, which drives them through swe_calc_ut.
   */
  @Test
  void deltaTHasTheExpectedShapeOverHistory() {
    double dtAncient = SweDate.getDeltaT(625307.5);   // -3000
    double dt1900 = SweDate.getDeltaT(2415020.5);
    double dt2000 = SweDate.getDeltaT(2451545.0);

    assertTrue(dtAncient / SECOND > 30000,
               "delta T at -3000 should be tens of thousands of seconds, was "
               + dtAncient / SECOND);
    assertTrue(Math.abs(dt1900 / SECOND) < 10,
               "delta T near 1900 should be within seconds of zero, was " + dt1900 / SECOND);
    assertEquals(63.8, dt2000 / SECOND, 1.0, "delta T at J2000 is about 64 seconds");
    assertTrue(dtAncient > dt1900, "delta T decreases from the distant past towards 1900");
  }

  @Test
  void deltaTIsContinuousAcrossTableBoundaries() {
    // 1620 is where the tabulated values begin, 1955 and 2020 are internal seams.
    for (double seam : new double[]{2312752.5, 2435108.5, 2458849.5}) {
      double before = SweDate.getDeltaT(seam - 1);
      double after = SweDate.getDeltaT(seam + 1);
      assertEquals(before / SECOND, after / SECOND, 1.0,
                   "delta T jumps across the seam at JD " + seam);
    }
  }

  @Test
  void instanceDeltaTAgreesWithTheStaticForm() {
    SweDate d = new SweDate(2451545.0);
    assertEquals(SweDate.getDeltaT(2451545.0), d.getDeltaT(), 1e-15);
  }

  // ------------------------------------------------------------- the shared state

  /**
   * The property that replaced a tripwire.
   *
   * <p>This test used to assert the opposite: that constructing a SwissEph moved a
   * process-wide tidal acceleration, and that {@code swe_close()} moved it back. That was the
   * defect. Phase 2 gave each instance its own {@code SwissData.tid_acc}, so what is worth
   * asserting now is that two instances cannot reach each other.
   *
   * <p>Tidal acceleration is derived from whichever ephemeris an instance actually loads, so
   * before this change an instance that fell back to Moshier could leave a value behind that
   * a different instance — on a different thread, with a different ephemeris path — would
   * then use for its own delta-T.
   */
  @Test
  void twoSwissEphInstancesDoNotShareTidalAcceleration() {
    SwissEph a = new SwissEph(SmokeTestSupport.ephePath());
    SwissEph b = new SwissEph(SmokeTestSupport.ephePath());
    try {
      SweDate.setGlobalTidalAcc(-25.0, a);
      SweDate.setGlobalTidalAcc(-26.0, b);

      assertEquals(-25.0, SweDate.getGlobalTidalAcc(a));
      assertEquals(-26.0, SweDate.getGlobalTidalAcc(b), "setting one instance moved the other");

      // Driving a calculation on one must not disturb the other's setting either.
      double[] xx = new double[6];
      a.swe_calc_ut(2451545.0, SweConst.SE_SUN, SweConst.SEFLG_MOSEPH, xx, new StringBuffer());
      assertEquals(-26.0, SweDate.getGlobalTidalAcc(b),
                   "calculating on one instance moved another instance's tidal acceleration");
    } finally {
      a.swe_close();
      b.swe_close();
    }
  }

  /**
   * A SwissEph's lifecycle no longer touches the context-free default that
   * {@link SweDate#getDeltaT(double)} and the UTC conversions fall back on.
   */
  @Test
  void aSwissEphLifecycleLeavesTheContextFreeDefaultAlone() {
    double before = SweDate.getGlobalTidalAcc();

    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double[] xx = new double[6];
      se.swe_calc_ut(2451545.0, SweConst.SE_SUN, SweConst.SEFLG_SWIEPH, xx, new StringBuffer());
      assertEquals(before, SweDate.getGlobalTidalAcc(),
                   "constructing and using a SwissEph moved the process-wide default");
    } finally {
      se.swe_close();
    }
    assertEquals(before, SweDate.getGlobalTidalAcc(),
                 "closing a SwissEph moved the process-wide default");
  }

  // ------------------------------------------------------- mutation of an instance

  @Test
  void setJulDayReplacesTheWholeDate() {
    SweDate d = new SweDate(2000, 1, 1, 0.0, SweDate.SE_GREG_CAL);
    d.setJulDay(2451545.0);
    assertEquals(2451545.0, d.getJulDay());
    assertEquals(2000, d.getYear());
    assertEquals(1, d.getDay());
    assertEquals(12.0, d.getHour(), 1e-9);
  }

  @Test
  void setDateReplacesAllFieldsAtOnce() {
    SweDate d = new SweDate(2000, 1, 1, 0.0, SweDate.SE_GREG_CAL);
    assertTrue(d.setDate(2024, 2, 29, 6.0));
    assertEquals(SweDate.getJulDay(2024, 2, 29, 6.0, SweDate.SE_GREG_CAL), d.getJulDay(), 1e-9);

    assertTrue(d.setDate(2024, 12, 31, 23.5, true), "a real date passes the check");
    assertFalse(d.setDate(2023, 2, 29, 0.0, true), "an invented one does not");
  }

  @Test
  void setYearCheckedRejectsAnImpossibleCombination() {
    SweDate d = new SweDate(2024, 2, 29, 0.0, SweDate.SE_GREG_CAL);
    assertFalse(d.setYear(2023, true), "2023-02-29 does not exist");
    assertTrue(d.setYear(2028, true), "2028 is a leap year");
    assertEquals(2028, d.getYear());
  }

  /**
   * The changeover date is configurable — some historical calendars adopted the Gregorian
   * reform centuries later than 1582. Moving it changes how a given Julian Day reads.
   */
  @Test
  void theChangeoverDateCanBeMoved() {
    SweDate d = new SweDate(1700, 3, 1, 0.0, SweDate.SE_GREG_CAL);
    assertEquals(2299160.5, d.getGregorianChange());

    d.setGregorianChange(1752, 9, 14);   // Britain and its colonies
    assertEquals(SweDate.getJulDay(1752, 9, 14, 0.0, SweDate.SE_GREG_CAL), d.getGregorianChange());

    d.setGregorianChange(2299160.5);
    assertEquals(2299160.5, d.getGregorianChange());
  }

  @Test
  void updateCalendarTypePicksTheCalendarThatMatchesTheJulianDay() {
    SweDate before = new SweDate(2299159.5, SweDate.SE_GREG_CAL);
    before.updateCalendarType();
    assertEquals(SweDate.SE_JUL_CAL, before.getCalendarType(),
                 "a date before the changeover is Julian");

    SweDate after = new SweDate(2299160.5, SweDate.SE_JUL_CAL);
    after.updateCalendarType();
    assertEquals(SweDate.SE_GREG_CAL, after.getCalendarType(),
                 "a date after it is Gregorian");
  }

  @Test
  void toStringMentionsTheDateAndTheJulianDay() {
    String s = new SweDate(2000, 1, 1, 12.0, SweDate.SE_GREG_CAL).toString();
    assertTrue(s.contains("2000"), s);
    assertTrue(s.contains("2451545"), s);
  }

  @Test
  void theNoArgConstructorUsesTheCurrentInstant() {
    double now = System.currentTimeMillis() / 86400000.0 + SweDate.JD0;
    assertEquals(now, new SweDate().getJulDay(), 1.0,
                 "the default constructor should land within a day of now");
  }

  // -------------------------------------------------------------- UTC and leap seconds

  /**
   * UTC differs from the uniform time scales by an accumulating whole number of leap seconds.
   * These conversions are the only part of the class that knows about them, and they are not
   * exercised by anything else in the test suite, so they are covered directly.
   */
  @Test
  void utcRoundTripsThroughTerrestrialTime() {
    SweDate d = new SweDate(2451545.0);
    double[] jd = d.getJDfromUTC(2020, 6, 15, 10, 30, 15.5, SweDate.SE_GREG_CAL, true);
    double tjdEt = jd[0];
    double tjdUt1 = jd[1];

    assertTrue(tjdEt > tjdUt1, "ET runs ahead of UT1 by delta T");
    double deltaTseconds = (tjdEt - tjdUt1) * 86400.0;
    assertTrue(deltaTseconds > 60.0 && deltaTseconds < 80.0,
               "delta T in 2020 should be a little over a minute, was " + deltaTseconds);

    SDate back = d.getUTCfromJDET(tjdEt, SweDate.SE_GREG_CAL);
    assertEquals(2020, back.year);
    assertEquals(6, back.month);
    assertEquals(15, back.day);
    assertEquals(10, back.hour);
    assertEquals(30, back.minute);
    // A Julian Day near 2.46e6 has about 20 microseconds of resolution left in a double
    // (2.46e6 days x 86400 s x 1e-16), so a UTC second cannot round trip more precisely
    // than that. The loss is arithmetic, not a defect — but it is a real limit on what the
    // UTC API can promise, and Phase 4 should not claim more.
    assertEquals(15.5, back.second, 1e-4);

    SDate viaUt1 = d.getUTCfromJDUT1(tjdUt1, SweDate.SE_GREG_CAL);
    assertEquals(15, viaUt1.day);
    assertEquals(10, viaUt1.hour);
  }

  @Test
  void utcConversionRejectsAnInvalidDateWhenAsked() {
    SweDate d = new SweDate(2451545.0);
    assertThrows(SwissephException.class,
                 () -> d.getJDfromUTC(2023, 2, 29, 0, 0, 0.0, SweDate.SE_GREG_CAL, true));
  }

  /**
   * A trap in the inherited API. The method is named {@code getLocalTimeFromUTC} and its
   * javadoc opens with "Transform UTC to local time", but the implementation is
   * {@code dhour -= d_timezone} — so reaching UTC+8 requires passing <b>-8</b>. The C original
   * ({@code swe_utc_time_zone}) is a single subtract-the-offset routine used in both
   * directions, and the Java name only describes one of them.
   *
   * <p>Pinned in both directions so a rewrite cannot quietly pick the other convention.
   * Phase 4 should replace this with something that takes a signed offset and means it.
   */
  @Test
  void localTimeConversionSubtractsTheOffsetDespiteItsName() {
    SweDate d = new SweDate(2451545.0);

    // Passing +8 moves backwards, which is the local-time-to-UTC direction.
    SDate minusEight = d.getLocalTimeFromUTC(2020, 6, 15, 2, 30, 0.0, 8.0);
    assertEquals(14, minusEight.day);
    assertEquals(18, minusEight.hour, "02:30 minus 8 hours is 18:30 the previous day");
    assertEquals(30, minusEight.minute);

    // To actually read UTC 02:30 as a UTC+8 wall clock, the caller must negate the offset.
    SDate plusEight = d.getLocalTimeFromUTC(2020, 6, 15, 2, 30, 0.0, -8.0);
    assertEquals(2020, plusEight.year);
    assertEquals(6, plusEight.month);
    assertEquals(15, plusEight.day);
    assertEquals(10, plusEight.hour, "02:30 UTC is 10:30 in UTC+8");

    SDate acrossMidnight = d.getLocalTimeFromUTC(2020, 6, 15, 20, 0, 0.0, -8.0);
    assertEquals(16, acrossMidnight.day, "20:00 UTC rolls into the next day in UTC+8");
    assertEquals(4, acrossMidnight.hour);
  }

  @Test
  void deltaTIsDefinedInTheEarlyTabulatedPeriod() {
    // 1600-1620 uses a different branch of the delta T machinery than either neighbour.
    double dt1600 = SweDate.getDeltaT(SweDate.getJulDay(1600, 1, 1, 0.0, SweDate.SE_GREG_CAL));
    double dt1610 = SweDate.getDeltaT(SweDate.getJulDay(1610, 1, 1, 0.0, SweDate.SE_GREG_CAL));
    for (double dt : new double[]{dt1600, dt1610}) {
      assertTrue(dt / SECOND > 50 && dt / SECOND < 200,
                 "delta T around 1600 should be a couple of minutes, was " + dt / SECOND);
    }
  }

  /**
   * Every DE number Astrodienst has shipped an ephemeris for must map to its own tidal
   * acceleration, because delta-T is derived from it.
   *
   * <p>The table used to stop at DE431, so the files Astrodienst ships today —— built on DE441 ——
   * fell through to the default and were given DE431's value. The error is 0.136 arcsec/cy², which
   * is a tenth of an arcsecond on the Moon around 1800 and nothing in the present era; small, but
   * silent, and there is no reason to carry it.
   *
   * <p>Values are Astrodienst's own, from {@code swephexp.h}.
   */
  @Test
  void everyShippedDeNumberHasItsOwnTidalAcceleration() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      assertTidalAcc(se, 200, -23.8946);
      assertTidalAcc(se, 403, -25.580);
      assertTidalAcc(se, 404, -25.580);
      assertTidalAcc(se, 405, -25.826);
      assertTidalAcc(se, 406, -25.826);
      assertTidalAcc(se, 421, -25.85);
      assertTidalAcc(se, 422, -25.85);
      assertTidalAcc(se, 430, -25.82);
      assertTidalAcc(se, 431, -25.80);
      assertTidalAcc(se, 441, -25.936);

      // An unknown one still has to land somewhere sensible rather than throw.
      SweDate.swi_set_tid_acc(0, 0, 999, se);
      assertEquals(SweConst.SE_TIDAL_DEFAULT, SweDate.getGlobalTidalAcc(se), 0.0,
                   "未知的 DE 編號應該落到預設值");
    } finally {
      se.swe_close();
    }
  }

  private static void assertTidalAcc(SwissEph se, int denum, double expected) {
    SweDate.swi_set_tid_acc(0, 0, denum, se);
    assertEquals(expected, SweDate.getGlobalTidalAcc(se), 0.0,
                 "DE" + denum + " 的潮汐加速度");
  }

  /**
   * An ephemeris directory may carry a delta-T override file. Two instances pointing at
   * different directories must each get their own —— which sounds obvious, and was not true:
   * the table was a mutable static array behind a JVM-global "already loaded" flag, so whichever
   * instance ran first decided, for the whole process, whose overrides everybody would use.
   *
   * <p>Harmless in practice while nobody ships such a file, which is why it survived so long.
   * But it is the same defect as the ones already removed —— an answer that depends on who went
   * first —— and it is only invisible until someone does ship one.
   */
  @Test
  void twoDirectoriesDoNotShareDeltaTOverrides(@TempDir Path withOverride, @TempDir Path plain)
      throws Exception {
    // A wildly wrong value, so that using it is unmistakable.
    Files.writeString(withOverride.resolve("sedeltat.txt"), "1900 999.0\n");

    // Ask the plain directory first: under the old flag, it would have claimed the one chance to
    // load and left the other instance reading the built-in table.
    SwissEph plainEph = new SwissEph(plain.toString());
    SwissEph overriddenEph = new SwissEph(withOverride.toString());
    try {
      double plainDeltaT = SweDate.getDeltaT(J1900, plainEph);
      double overriddenDeltaT = SweDate.getDeltaT(J1900, overriddenEph);

      assertNotEquals(plainDeltaT, overriddenDeltaT,
                      "帶覆寫檔的目錄應該給出不同的 delta-T");
      // Not exactly 999: the table value is still corrected for tidal acceleration afterwards.
      // Close enough to be unmistakably that value and nothing else.
      assertEquals(999.0, overriddenDeltaT * 86400.0, 1.0,
                   "覆寫檔裡的 999 秒應該被採用（容許潮汐加速度的修正）");

      // And asking again the other way round must not change either of them.
      assertEquals(plainDeltaT, SweDate.getDeltaT(J1900, plainEph), 0.0,
                   "沒有覆寫檔的目錄不該被另一個目錄的覆寫檔污染");
    } finally {
      plainEph.swe_close();
      overriddenEph.swe_close();
    }
  }

  /** 1900-01-01, inside the table the override file patches. */
  private static final double J1900 = 2415020.5;
}
