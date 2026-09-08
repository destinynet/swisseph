package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Equivalence and sanity for the obliquity call, which the legacy API hides behind body -1. */
class ObliquityTest {

  @Test
  void matchesTheLegacyCall() {
    String ephePath = SmokeTestSupport.ephePath();
    for (double tjd : new double[]{2299160.5, 2415020.5, 2451545.0, 2460841.5}) {
      String expected;
      SwissEph se = new SwissEph(ephePath);
      try {
        double[] xx = new double[6];
        se.swe_calc_ut(tjd, SweConst.SE_ECL_NUT, 0, xx, new StringBuffer());
        expected = Double.toHexString(xx[0]) + ',' + Double.toHexString(xx[1])
                   + ',' + Double.toHexString(xx[2]) + ',' + Double.toHexString(xx[3]);
      } finally {
        se.swe_close();
      }

      try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
        ObliquityAndNutation o = ephemeris.obliquityAndNutation(JulianDayUT.of(tjd));
        String actual = Double.toHexString(o.trueObliquityDeg()) + ',' + Double.toHexString(o.meanObliquityDeg())
                        + ',' + Double.toHexString(o.nutationInLongitudeDeg())
                        + ',' + Double.toHexString(o.nutationInObliquityDeg());
        assertEquals(expected, actual, "differs at tjd=" + tjd);
      }
    }
  }

  @Test
  void theFourComponentsAreInTheRolesTheirNamesClaim() {
    String ephePath = SmokeTestSupport.ephePath();
    try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
      ObliquityAndNutation o = ephemeris.obliquityAndNutation(JulianDayUT.of(2451545.0));

      // The Earth's tilt is a shade over 23.4 degrees and drifts very slowly.
      assertTrue(o.meanObliquityDeg() > 23.4 && o.meanObliquityDeg() < 23.5,
                 "平均黃赤交角應該在 23.4~23.5 度，實得 " + o.meanObliquityDeg());
      // Nutation is tens of arcseconds —— thousandths of a degree.
      assertTrue(Math.abs(o.nutationInLongitudeDeg()) < 0.01,
                 "黃經章動應該是弧秒等級，實得 " + o.nutationInLongitudeDeg());
      assertTrue(Math.abs(o.nutationInObliquityDeg()) < 0.01,
                 "交角章動應該是弧秒等級，實得 " + o.nutationInObliquityDeg());
      // And the true obliquity is exactly the mean plus the nutation in obliquity —— which is the
      // relation that tells slot 0 from slot 1.
      assertEquals(o.meanObliquityDeg() + o.nutationInObliquityDeg(), o.trueObliquityDeg(), 1e-12,
                   "真交角必定等於平交角加上交角章動");
    }
  }
}
