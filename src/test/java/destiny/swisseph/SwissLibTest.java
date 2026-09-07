package destiny.swisseph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * White-box tests for the coordinate and angle utilities.
 *
 * <p>These assert properties — round trips, known identities, sign conventions — rather than
 * recorded numbers. Properties are what a refactoring must preserve, and unlike a fixture
 * they say why: a failure here names the invariant that broke.
 */
class SwissLibTest {

  private final SwissLib sl = new SwissLib();

  private static final double EPS = 1e-12;

  // ------------------------------------------------------------------- normalising

  @Test
  void degnormWrapsIntoZeroTo360() {
    assertEquals(0.0, sl.swe_degnorm(0.0));
    assertEquals(1.0, sl.swe_degnorm(361.0), EPS);
    assertEquals(359.0, sl.swe_degnorm(-1.0), EPS);
    assertEquals(180.0, sl.swe_degnorm(-180.0), EPS);
    assertEquals(0.0, sl.swe_degnorm(720.0));
    assertEquals(0.0, sl.swe_degnorm(-720.0));
    // Values within 1e-13 of a whole turn are snapped to exactly zero, not left as 3.6e-14.
    assertEquals(0.0, sl.swe_degnorm(360.0 + 1e-14));
  }

  @Test
  void radnormWrapsIntoZeroToTwoPi() {
    double twoPi = 2 * Math.PI;
    assertEquals(0.0, sl.swe_radnorm(0.0), EPS);
    assertEquals(Math.PI, sl.swe_radnorm(-Math.PI), EPS);
    assertTrue(sl.swe_radnorm(-0.5) > 0 && sl.swe_radnorm(-0.5) < twoPi);
    assertTrue(sl.swe_radnorm(3 * twoPi + 1.0) >= 0 && sl.swe_radnorm(3 * twoPi + 1.0) < twoPi);
  }

  @Test
  void angnormShiftsByOneTurnAtMost() {
    double twoPi = SwephData.TWOPI;
    assertEquals(1.0, sl.swi_angnorm(1.0), EPS);
    assertEquals(twoPi - 1.0, sl.swi_angnorm(-1.0), EPS);
    assertEquals(1.0, sl.swi_angnorm(twoPi + 1.0), EPS);
  }

  // ------------------------------------------------------------------- differences

  @Test
  void difdeg2nReturnsTheSignedShortWayRound() {
    assertEquals(10.0, sl.swe_difdeg2n(10.0, 0.0), EPS);
    assertEquals(-10.0, sl.swe_difdeg2n(0.0, 10.0), EPS);
    // The short way from 350 to 10 is +20, not -340.
    assertEquals(20.0, sl.swe_difdeg2n(10.0, 350.0), EPS);
    assertEquals(-20.0, sl.swe_difdeg2n(350.0, 10.0), EPS);
    // Exactly opposite resolves to -180, not +180.
    assertEquals(-180.0, sl.swe_difdeg2n(180.0, 0.0), EPS);
    assertTrue(sl.swe_difdeg2n(123.4, 56.7) > -180.0 && sl.swe_difdeg2n(123.4, 56.7) <= 180.0);
  }

  @Test
  void degMidpointSitsOnTheShortArc() {
    assertEquals(5.0, sl.swe_deg_midp(10.0, 0.0), EPS);
    // Midpoint of 350 and 10 is 0, i.e. across the wrap, not 180.
    assertEquals(0.0, sl.swe_deg_midp(10.0, 350.0), EPS);
    assertEquals(180.0, sl.swe_deg_midp(190.0, 170.0), EPS);
  }

  /**
   * The radian form is a wrapper that converts to degrees, calls the degree form, and converts
   * back. Away from the wrap the two agree outright; across it they agree only modulo a full
   * turn, because the degree/radian round trip perturbs 350 to 350.000...6 and
   * {@code swe_degnorm} is discontinuous at 0. Pinned as "equal modulo 360" so that a
   * refactoring is free to normalise either way, but not free to move the angle.
   */
  @Test
  void radMidpointAgreesWithTheDegreeVersionModuloAFullTurn() {
    assertMidpointsAgree(40.0, 20.0);   // away from the wrap
    assertMidpointsAgree(10.0, 350.0);  // across it
  }

  private void assertMidpointsAgree(double a, double b) {
    double d = sl.swe_deg_midp(a, b);
    double r = Math.toDegrees(sl.swe_rad_midp(Math.toRadians(a), Math.toRadians(b)));
    assertEquals(0.0, sl.swe_difdeg2n(d, r), 1e-9,
                 "midpoints of " + a + " and " + b + " differ: " + d + " vs " + r);
  }

  @Test
  void d2lRoundsHalfAwayFromZero() {
    assertEquals(1, sl.swe_d2l(0.5));
    assertEquals(1, sl.swe_d2l(1.4));
    assertEquals(2, sl.swe_d2l(1.5));
    assertEquals(-1, sl.swe_d2l(-0.5));
    assertEquals(-2, sl.swe_d2l(-1.5));
    assertEquals(0, sl.swe_d2l(0.0));
  }

  // ---------------------------------------------------------------- vector algebra

  @Test
  void cartesianPolarRoundTrips() {
    double[][] samples = {
        {1, 0, 0}, {0, 1, 0}, {0, 0, 1},
        {1, 1, 1}, {-3, 4, -5}, {0.001, -0.002, 0.003},
    };
    for (double[] xyz : samples) {
      double[] polar = new double[3];
      double[] back = new double[3];
      sl.swi_cartpol(xyz, polar);
      sl.swi_polcart(polar, back);
      assertArrayEquals(xyz, back, 1e-10, "round trip failed for " + java.util.Arrays.toString(xyz));
    }
  }

  @Test
  void cartesianPolarRoundTripsWithSpeeds() {
    double[] xyz = {1.0, 2.0, 3.0, 0.01, -0.02, 0.03};
    double[] polar = new double[6];
    double[] back = new double[6];
    sl.swi_cartpol_sp(xyz, polar);
    sl.swi_polcart_sp(polar, back);
    assertArrayEquals(xyz, back, 1e-10);
  }

  @Test
  void coordinateRotationIsReversedByTheOppositeAngle() {
    double eps = 23.4392911;
    double[] in = {123.45, 6.78, 1.0};
    double[] mid = new double[3];
    double[] back = new double[3];
    sl.swe_cotrans(in, mid, eps);
    sl.swe_cotrans(mid, back, -eps);
    assertEquals(sl.swe_degnorm(in[0]), sl.swe_degnorm(back[0]), 1e-9);
    assertEquals(in[1], back[1], 1e-9);
    assertEquals(in[2], back[2], 1e-9);
  }

  @Test
  void coortrfRotationIsReversedByTheOppositeAngle() {
    double eps = 23.4392911;
    double[] in = {0.3, -0.5, 0.81};
    double[] mid = new double[3];
    double[] back = new double[3];
    sl.swi_coortrf(in, mid, eps);
    sl.swi_coortrf(mid, back, -eps);
    assertArrayEquals(in, back, 1e-12);
  }

  @Test
  void crossProductIsPerpendicularToBothInputs() {
    double[] a = {1, 2, 3};
    double[] b = {4, 5, 6};
    double[] c = new double[3];
    sl.swi_cross_prod(a, 0, b, 0, c, 0);
    assertEquals(0.0, c[0] * a[0] + c[1] * a[1] + c[2] * a[2], 1e-12);
    assertEquals(0.0, c[0] * b[0] + c[1] * b[1] + c[2] * b[2], 1e-12);
    assertArrayEquals(new double[]{-3, 6, -3}, c, 1e-12);
  }

  @Test
  void dotProductOfUnitVectorsIsTheCosineOfTheAngle() {
    assertEquals(1.0, sl.swi_dot_prod_unit(new double[]{2, 0, 0}, new double[]{5, 0, 0}), 1e-12);
    assertEquals(0.0, sl.swi_dot_prod_unit(new double[]{1, 0, 0}, new double[]{0, 1, 0}), 1e-12);
    assertEquals(-1.0, sl.swi_dot_prod_unit(new double[]{1, 0, 0}, new double[]{-4, 0, 0}), 1e-12);
  }

  @Test
  void squareSumIsTheSquaredLength() {
    assertEquals(14.0, sl.square_sum(new double[]{1, 2, 3}), 1e-12);
    assertEquals(25.0, sl.square_sum(new double[]{9, 3, 4, 0}, 1), 1e-12);
  }

  // -------------------------------------------------------------------- formatting

  @Test
  void splitDegDecomposesAndKeepsTheSign() {
    IntObj deg = new IntObj(), min = new IntObj(), sec = new IntObj(), sgn = new IntObj();
    DblObj frac = new DblObj(0.0);

    sl.swe_split_deg(123.5125, 0, deg, min, sec, frac, sgn);
    assertEquals(1, sgn.val);
    assertEquals(123, deg.val);
    assertEquals(30, min.val);
    assertEquals(45, sec.val);

    sl.swe_split_deg(-10.25, 0, deg, min, sec, frac, sgn);
    assertEquals(-1, sgn.val, "sign is reported separately, magnitude stays positive");
    assertEquals(10, deg.val);
    assertEquals(15, min.val);
  }

  @Test
  void splitDegZodiacalPutsTheSignNumberInIsgn() {
    IntObj deg = new IntObj(), min = new IntObj(), sec = new IntObj(), sgn = new IntObj();
    DblObj frac = new DblObj(0.0);

    // 123.5 degrees is 3 whole signs (90) plus 33.5 into the fourth.
    sl.swe_split_deg(123.5, SweConst.SE_SPLIT_DEG_ZODIACAL, deg, min, sec, frac, sgn);
    assertEquals(4, sgn.val);
    assertEquals(3, deg.val);
    assertEquals(30, min.val);
  }

  @Test
  void splitDegRoundingLiftsTheValue() {
    IntObj deg = new IntObj(), min = new IntObj(), sec = new IntObj(), sgn = new IntObj();
    DblObj frac = new DblObj(0.0);

    sl.swe_split_deg(29.9999, SweConst.SE_SPLIT_DEG_ROUND_DEG, deg, min, sec, frac, sgn);
    assertEquals(30, deg.val);

    // KEEP_DEG suppresses the rounding when it would carry into the next degree.
    sl.swe_split_deg(29.9999, SweConst.SE_SPLIT_DEG_ROUND_DEG | SweConst.SE_SPLIT_DEG_KEEP_DEG,
                     deg, min, sec, frac, sgn);
    assertEquals(29, deg.val);
  }

  // ------------------------------------------------------------------------ misc

  @Test
  void keplerSolutionSatisfiesTheEquation() {
    for (double ecc : new double[]{0.0, 0.1, 0.5, 0.9}) {
      for (double m : new double[]{0.1, 1.0, 3.0, 5.0}) {
        double e = sl.swi_kepler(m, m, ecc);
        assertEquals(m, e - ecc * Math.sin(e), 1e-8,
                     "E - e*sin(E) should return M (e=" + ecc + ", M=" + m + ")");
      }
    }
  }

  @Test
  void fk4Fk5ConversionsAreInverses() {
    double[] x = {0.3, 0.5, 0.81, 0.001, -0.002, 0.003};
    double[] back = x.clone();
    sl.swi_FK4_FK5(back, 2451545.0);
    sl.swi_FK5_FK4(back, 2451545.0);
    assertArrayEquals(x, back, 1e-9);
  }

  @Test
  void generatedFilenameSelectsTheBlockContainingTheDate() {
    // sepl_18 covers 1800-2400; the 1582 date falls in the preceding block.
    assertEquals("sepl_18.se1", SwissLib.swi_gen_filename(2451545.0, SweConst.SE_SUN));
    assertEquals("sepl_12.se1", SwissLib.swi_gen_filename(2299160.5, SweConst.SE_SUN));
    assertEquals("semo_18.se1", SwissLib.swi_gen_filename(2451545.0, SweConst.SE_MOON));
  }

  @Test
  void cutstrSplitsOnAnyOfTheGivenDelimiters() {
    String[] parts = new String[20];
    int n = sl.swi_cutstr("alpha,beta;gamma", ",;", parts, 20);
    assertEquals(3, n);
    assertEquals("alpha", parts[0]);
    assertEquals("beta", parts[1]);
    assertEquals("gamma", parts[2]);
    assertNull(parts[3], "the slot after the last field is nulled when n < nmax");
  }

  @Test
  void cutstrStopsAtTheFirstLineBreak() {
    String[] parts = new String[20];
    assertEquals(2, sl.swi_cutstr("a,b\nc,d", ",", parts, 20));
    assertEquals("a", parts[0]);
    assertEquals("b", parts[1]);
  }

  /**
   * A trap for callers: {@code swi_cutstr} writes {@code cpos[19]} unconditionally, whatever
   * {@code nmax} says, so the array must hold at least 20 entries even when the caller only
   * wants a few. Pinned rather than relied upon — Phase 4 should give this a signature that
   * cannot be called wrongly.
   */
  @Test
  void cutstrRequiresAnArrayOfAtLeastTwentyRegardlessOfNmax() {
    String[] tooSmall = new String[8];
    assertThrows(ArrayIndexOutOfBoundsException.class,
                 () -> sl.swi_cutstr("alpha,beta", ",", tooSmall, 8));
  }

  @Test
  void siderealTimeStaysWithinTwentyFourHours() {
    for (double tjd : new double[]{2299160.5, 2451545.0, 2460841.5, 2488069.5}) {
      double st = sl.swe_sidtime(tjd);
      assertTrue(st >= 0.0 && st < 24.0, "sidereal time out of range at " + tjd + ": " + st);
    }
  }

  @Test
  void chebyshevEvaluationMatchesAHandComputedSeries() {
    // T0=1, T1=x, T2=2x^2-1. swi_echeb halves the leading coefficient by convention.
    double[] coef = {2.0, 3.0, 4.0};
    double x = 0.5;
    double expected = 0.5 * coef[0] + coef[1] * x + coef[2] * (2 * x * x - 1);
    assertEquals(expected, sl.swi_echeb(x, coef, 0, 3), 1e-12);
  }
}
