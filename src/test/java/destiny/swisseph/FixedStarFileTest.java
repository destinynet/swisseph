package destiny.swisseph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The fixed-star catalogue is read once and shared.
 *
 * <p>Before this change every lookup re-read {@code sefstars.txt} from the start, through a
 * reader that fetched one byte at a time, and the file handle was then held open for the life
 * of the instance. A twenty-star chart walked all 1290 lines twenty times.
 */
class FixedStarFileTest {

  private static final double J2000 = 2451545.0;

  private static double lookup(SwissEph se, String star) {
    double[] xx = new double[6];
    StringBuffer serr = new StringBuffer();
    int rc = se.swe_fixstar_ut(new StringBuffer(star), J2000, SweConst.SEFLG_MOSEPH, xx, serr);
    assertTrue(rc >= 0, "swe_fixstar_ut(" + star + ") failed: rc=" + rc + " serr=" + serr);
    return xx[0];
  }

  /** Read once: two instances over the same path end up holding the very same object. */
  @Test
  void instancesOverTheSamePathShareOneCatalogue() {
    SwissEph a = new SwissEph(SmokeTestSupport.ephePath());
    SwissEph b = new SwissEph(SmokeTestSupport.ephePath());
    try {
      lookup(a, "Aldebaran");
      lookup(b, "Regulus");
      assertNotNull(a.fixedStars);
      assertSame(a.fixedStars, b.fixedStars,
                 "the catalogue was read twice for the same file");
    } finally {
      a.swe_close();
      b.swe_close();
    }
  }

  /**
   * The reference must go on close, because swe_set_ephe_path() closes before it changes the
   * path — holding on would keep answering from the old directory's catalogue.
   */
  @Test
  void closeReleasesTheCatalogue() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      lookup(se, "Spica");
      assertNotNull(se.fixedStars);
      se.swe_close();
      assertNull(se.fixedStars, "swe_close() left the catalogue attached");

      // Still usable afterwards: the next lookup reloads (from the shared cache).
      assertNotEquals(0.0, lookup(se, "Spica"));
    } finally {
      se.swe_close();
    }
  }

  /**
   * The one-entry cache that used to sit in front of the file is gone. Alternating between
   * stars used to defeat it completely; now it simply is not there, so the point worth
   * pinning is that alternating gives the same answers as asking each star on its own.
   */
  @Test
  void alternatingLookupsAgreeWithIsolatedOnes() {
    String[] stars = {"Aldebaran", "Regulus", "Spica", "Antares"};
    double[] alone = new double[stars.length];
    for (int i = 0; i < stars.length; i++) {
      SwissEph one = new SwissEph(SmokeTestSupport.ephePath());
      try {
        alone[i] = lookup(one, stars[i]);
      } finally {
        one.swe_close();
      }
    }

    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      for (int round = 0; round < 3; round++) {
        for (int i = 0; i < stars.length; i++) {
          assertEquals(alone[i], lookup(se, stars[i]),
                       stars[i] + " differed when asked among others");
        }
      }
    } finally {
      se.swe_close();
    }
  }

  /** All three ways of naming a star still resolve, and to the same star. */
  @Test
  void nameNomenclatureAndLineNumberAddressTheSameStar() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double byName = lookup(se, "Polaris");
      double byNomenclature = lookup(se, ",alUMi");
      assertEquals(byName, byNomenclature,
                   "the traditional name and the nomenclature should reach the same star");

      // Line numbers count non-comment lines; whichever star line 1 is, it must resolve.
      double[] xx = new double[6];
      StringBuffer name = new StringBuffer("1");
      int rc = se.swe_fixstar_ut(name, J2000, SweConst.SEFLG_MOSEPH, xx, new StringBuffer());
      assertTrue(rc >= 0, "lookup by line number failed");
      assertTrue(name.length() > 1, "the star name should have been filled in, got: " + name);
    } finally {
      se.swe_close();
    }
  }

  @Test
  void anUnknownStarIsReportedAsNotFound() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double[] xx = new double[6];
      StringBuffer serr = new StringBuffer();
      int rc = se.swe_fixstar_ut(new StringBuffer("NoSuchStarAtAll"), J2000,
                                 SweConst.SEFLG_MOSEPH, xx, serr);
      assertEquals(SweConst.ERR, rc);
      assertTrue(serr.toString().contains("not found"), "unexpected message: " + serr);
    } finally {
      se.swe_close();
    }
  }
}
