package destiny.swisseph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The same question, asked twice, must get the same answer.
 *
 * <p>This library keeps a great deal of state between calls, and some of it changes what a
 * later call returns. The golden master measures how much: it records the whole matrix twice,
 * once with a fresh SwissEph per call and once with one shared instance, and pins the set of
 * calls whose answers differ between the two. That set is the remaining defect, and it is
 * large.
 *
 * <p>This class is the other half of that: as each cause is understood and fixed, the property
 * it violated is asserted here in a form that says what the rule is, rather than only that a
 * number moved. A fixture tells you something changed; a test here tells you what was wrong.
 */
class CallHistoryIndependenceTest {

  /** 1582-10-15, the first Gregorian day — a date where nutation is comfortably non-zero. */
  private static final double TJD = 2299160.5;

  private static double[] eclNut(SwissEph se, int iflag) {
    double[] xx = new double[6];
    int rc = se.swe_calc_ut(TJD, SweConst.SE_ECL_NUT, iflag, xx, new StringBuffer());
    assertTrue(rc >= 0, "swe_calc_ut(SE_ECL_NUT) failed with rc=" + rc);
    return xx;
  }

  /**
   * SEFLG_NONUT means "do not apply nutation". Asking for the ecliptic and nutation with that
   * flag set must report no nutation — on a fresh instance and equally on one that has already
   * computed something else.
   *
   * <p>It did not: {@code swi_check_nutation} skips updating {@code swed.nut} when NONUT is
   * set, and the SE_ECL_NUT branch then reported whatever the previous call had left there. A
   * fresh instance answered correctly only because its cache happened to be zero.
   */
  @Test
  void nonutIsHonouredOnAnInstanceThatHasAlreadyComputedSomething() {
    int iflag = SweConst.SEFLG_MOSEPH | SweConst.SEFLG_NONUT;

    SwissEph fresh = new SwissEph(SmokeTestSupport.ephePath());
    SwissEph used = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double[] onFresh = eclNut(fresh, iflag);

      // Warm the second instance up with an ordinary call, which populates swed.nut.
      double[] scratch = new double[6];
      used.swe_calc_ut(TJD, SweConst.SE_SUN, SweConst.SEFLG_MOSEPH, scratch, new StringBuffer());
      double[] onUsed = eclNut(used, iflag);

      assertEquals(0.0, onFresh[2], "nutation in longitude, fresh instance");
      assertEquals(0.0, onFresh[3], "nutation in obliquity, fresh instance");
      assertEquals(0.0, onUsed[2], "nutation in longitude leaked from an earlier call");
      assertEquals(0.0, onUsed[3], "nutation in obliquity leaked from an earlier call");

      assertEquals(onUsed[0], onUsed[1],
                   "with NONUT the true and mean ecliptic must coincide");
      assertArrayEquals(onFresh, onUsed, 0.0,
                        "SE_ECL_NUT with NONUT depended on what the instance had done before");
    } finally {
      fresh.swe_close();
      used.swe_close();
    }
  }

  /** Without NONUT the nutation is real, so the test above is not passing for a trivial reason. */
  @Test
  void withoutNonutTheNutationIsNonZero() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double[] xx = eclNut(se, SweConst.SEFLG_MOSEPH);
      assertNotEquals(0.0, xx[2], "nutation in longitude should be non-zero at this date");
      assertNotEquals(0.0, xx[3], "nutation in obliquity should be non-zero at this date");
      assertNotEquals(xx[0], xx[1], "true and mean ecliptic differ by the nutation in obliquity");
    } finally {
      se.swe_close();
    }
  }

  // ---------------------------------------------------- the ephemeris file index

  /** 2025-06-15, inside the range of the sepl_18.se1 shipped with these tests. */
  private static final double IN_FILE_RANGE = 2460841.5;

  private static String sunLongitude(SwissEph se, int iflag, StringBuffer serr) {
    double[] xx = new double[6];
    int rc = se.swe_calc_ut(IN_FILE_RANGE, SweConst.SE_SUN, iflag, xx, serr);
    return rc + ":" + Double.toHexString(xx[0]);
  }

  /**
   * A Moshier calculation must not break the file-based calculations that follow it.
   *
   * <p>It did, and permanently. {@code free_planets()} runs whenever the caller switches
   * ephemeris, and it zeroes the index that was read from the {@code .se1} header — while
   * leaving the file open. The header is only read when a file is opened, so the index was
   * never restored, and the next segment lookup computed its file offset from zeroes:
   * {@code Filepointer position 2147483645}, which is {@code Integer.MAX_VALUE - 2}. Every
   * later file-based call on that instance failed the same way.
   *
   * <p>Two calls were enough to trigger it, and the calling application mixes ephemerides
   * without meaning to: a date outside the available file falls back to Moshier on its own.
   */
  @Test
  void aMoshierCalculationDoesNotBreakLaterFileBasedOnes() {
    SwissEph alone = new SwissEph(SmokeTestSupport.ephePath());
    String expected;
    try {
      expected = sunLongitude(alone, SweConst.SEFLG_SWIEPH, new StringBuffer());
      assertTrue(expected.startsWith("2:"), "the file-based calculation itself failed: " + expected);
    } finally {
      alone.swe_close();
    }

    SwissEph mixed = new SwissEph(SmokeTestSupport.ephePath());
    try {
      sunLongitude(mixed, SweConst.SEFLG_MOSEPH, new StringBuffer());

      StringBuffer serr = new StringBuffer();
      String first = sunLongitude(mixed, SweConst.SEFLG_SWIEPH, serr);
      assertEquals(expected, first,
                   "a preceding Moshier call changed the file-based result (serr=" + serr + ")");

      // The corruption used to be permanent, so check that it has not merely been deferred.
      assertEquals(expected, sunLongitude(mixed, SweConst.SEFLG_SWIEPH, new StringBuffer()));
      assertEquals(expected, sunLongitude(mixed, SweConst.SEFLG_SWIEPH, new StringBuffer()));
    } finally {
      mixed.swe_close();
    }
  }

  /**
   * The same thing the other way round, and repeatedly: switching ephemeris back and forth
   * must leave both answers stable.
   */
  @Test
  void switchingEphemerisRepeatedlyIsStable() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      String swieph = sunLongitude(se, SweConst.SEFLG_SWIEPH, new StringBuffer());
      String moseph = sunLongitude(se, SweConst.SEFLG_MOSEPH, new StringBuffer());
      assertNotEquals(swieph, moseph, "the two ephemerides should not agree bit for bit");

      for (int i = 0; i < 4; i++) {
        assertEquals(swieph, sunLongitude(se, SweConst.SEFLG_SWIEPH, new StringBuffer()),
                     "SWIEPH drifted on round " + i);
        assertEquals(moseph, sunLongitude(se, SweConst.SEFLG_MOSEPH, new StringBuffer()),
                     "MOSEPH drifted on round " + i);
      }
    } finally {
      se.swe_close();
    }
  }

  // ---------------------------------------------------------------------------------------
  // Mixing ephemerides
  // ---------------------------------------------------------------------------------------

  /**
   * The sharpest case there was: nodes and apsides asked for after the instance had already
   * computed something with a different ephemeris used to come back up to half a degree away
   * from the same request asked first. Half a degree is a chart-changing amount —— it moves a
   * point across a sign boundary.
   *
   * <p>Two things caused it, and both are now dealt with. The tidal acceleration was latched
   * from whichever ephemeris ran last, and delta-T is derived from it; and the file state the
   * constructor leaves behind was torn down by the switch and not put back, so the second
   * request started from somewhere the first one never was.
   */
  @Test
  void nodesAndApsidesDoNotDependOnWhatRanBeforeThem() {
    String ephe = SmokeTestSupport.ephePath();
    int swiss = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED;

    for (int ipl : new int[]{SweConst.SE_MOON, SweConst.SE_MERCURY, SweConst.SE_MARS,
                             SweConst.SE_JUPITER, SweConst.SE_SATURN}) {
      double[] a1 = new double[6], d1 = new double[6], p1 = new double[6], f1 = new double[6];
      SwissEph fresh = new SwissEph(ephe);
      try {
        fresh.swe_nod_aps_ut(TJD, ipl, swiss, SweConst.SE_NODBIT_OSCU, a1, d1, p1, f1, new StringBuffer());
      } finally {
        fresh.swe_close();
      }

      double[] a2 = new double[6], d2 = new double[6], p2 = new double[6], f2 = new double[6];
      SwissEph used = new SwissEph(ephe);
      try {
        // The history that used to poison it: a Moshier calculation, then a Swiss one.
        double[] scratch = new double[6];
        used.swe_calc_ut(TJD, SweConst.SE_SUN, SweConst.SEFLG_MOSEPH | SweConst.SEFLG_SPEED,
                         scratch, new StringBuffer());
        used.swe_nod_aps_ut(TJD, ipl, swiss, SweConst.SE_NODBIT_OSCU, a2, d2, p2, f2, new StringBuffer());
      } finally {
        used.swe_close();
      }

      assertArrayEquals(a1, a2, 0.0, "ascending node of ipl=" + ipl + " changed with call history");
      assertArrayEquals(d1, d2, 0.0, "descending node of ipl=" + ipl + " changed with call history");
      assertArrayEquals(p1, p2, 0.0, "perihelion of ipl=" + ipl + " changed with call history");
      assertArrayEquals(f1, f2, 0.0, "aphelion of ipl=" + ipl + " changed with call history");
    }
  }

  /**
   * House division needs delta-T, and delta-T needs a tidal acceleration —— but house division
   * chooses no ephemeris, so it used to read whichever one the last calculation had latched.
   * Same request, different answer, depending on what came before.
   */
  @Test
  void houseCuspsDoNotDependOnWhatRanBeforeThem() {
    String ephe = SmokeTestSupport.ephePath();

    double[] cusp1 = new double[13], ascmc1 = new double[10];
    SwissEph fresh = new SwissEph(ephe);
    try {
      fresh.swe_houses(TJD, 0, 25.0, 121.5, (int) 'P', cusp1, ascmc1);
    } finally {
      fresh.swe_close();
    }

    // Every ephemeris in turn, since the point is that none of them should matter here.
    for (int epheflag : new int[]{SweConst.SEFLG_MOSEPH, SweConst.SEFLG_SWIEPH}) {
      double[] cusp2 = new double[13], ascmc2 = new double[10];
      SwissEph used = new SwissEph(ephe);
      try {
        double[] scratch = new double[6];
        used.swe_calc_ut(TJD, SweConst.SE_SUN, epheflag | SweConst.SEFLG_SPEED, scratch, new StringBuffer());
        used.swe_houses(TJD, 0, 25.0, 121.5, (int) 'P', cusp2, ascmc2);
      } finally {
        used.swe_close();
      }
      assertArrayEquals(cusp1, cusp2, 0.0, "cusps changed after a calculation with epheflag=" + epheflag);
      assertArrayEquals(ascmc1, ascmc2, 0.0, "angles changed after a calculation with epheflag=" + epheflag);
    }
  }

  /** The same, for the equation of time and for horizon coordinates. */
  @Test
  void solarTimeAndHorizonDoNotDependOnWhatRanBeforeThem() {
    String ephe = SmokeTestSupport.ephePath();

    double[] e1 = new double[1];
    SwissEph fresh = new SwissEph(ephe);
    try {
      fresh.swe_time_equ(TJD, e1, new StringBuffer());
    } finally {
      fresh.swe_close();
    }

    double[] e2 = new double[1];
    SwissEph used = new SwissEph(ephe);
    try {
      double[] scratch = new double[6];
      used.swe_calc_ut(TJD, SweConst.SE_SUN, SweConst.SEFLG_MOSEPH, scratch, new StringBuffer());
      used.swe_time_equ(TJD, e2, new StringBuffer());
    } finally {
      used.swe_close();
    }
    assertEquals(e1[0], e2[0], 0.0, "the equation of time changed with call history");
  }
}
