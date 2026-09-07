package destiny.swisseph;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Phase 0 smoke test: proves the test harness itself works before any golden-master
 * fixture is built on top of it.
 *
 * <p>It verifies three things, and deliberately nothing more:
 * <ol>
 *   <li>the renamed package compiles and loads,</li>
 *   <li>the ephemeris test resources are reachable as a real filesystem directory
 *       (the SwissEph API takes a path, not a classpath resource),</li>
 *   <li>both ephemeris modes produce a plausible answer for a known date.</li>
 * </ol>
 */
class SmokeTest {

  /** 2000-01-01 12:00 UT */
  private static final double J2000_UT = 2451545.0;

  private static String ephePath() {
    URL url = SmokeTest.class.getResource("/ephe");
    assertNotNull(url, "test resource /ephe not on classpath");
    File dir = new File(url.getPath());
    assertTrue(dir.isDirectory(), "/ephe is not a directory: " + dir);
    return dir.getAbsolutePath();
  }

  @Test
  void epheFilesArePresent() {
    File dir = new File(ephePath());
    assertTrue(new File(dir, "sepl_18.se1").isFile(), "sepl_18.se1 missing");
    assertTrue(new File(dir, "seas_18.se1").isFile(), "seas_18.se1 missing");
    assertTrue(new File(dir, "sefstars.txt").isFile(), "sefstars.txt missing");
  }

  /**
   * The Sun's geocentric ecliptic longitude at J2000.0 is a little over 280 degrees
   * (the Sun sits in Capricorn on Jan 1st). A loose bound is enough here: this test
   * is asking "did it compute anything at all", not "is it correct" — correctness is
   * the golden master's job in Phase 1.
   */
  private void sunLongitudeIsPlausible(int ephemerisFlag) {
    SwissEph se = new SwissEph(ephePath());
    try {
      double[] xx = new double[6];
      StringBuffer serr = new StringBuffer();
      int rc = se.swe_calc_ut(J2000_UT, SweConst.SE_SUN, ephemerisFlag, xx, serr);

      assertTrue(rc >= 0, "swe_calc_ut failed, rc=" + rc + ", serr=" + serr);
      assertTrue(xx[0] > 279.0 && xx[0] < 281.0,
                 "Sun longitude at J2000 out of expected range: " + xx[0] + " (serr=" + serr + ")");
    } finally {
      se.swe_close();
    }
  }

  @Test
  void sunLongitudeInMoshierMode() {
    sunLongitudeIsPlausible(SweConst.SEFLG_MOSEPH);
  }

  @Test
  void sunLongitudeInFileMode() {
    sunLongitudeIsPlausible(SweConst.SEFLG_SWIEPH);
  }
}
