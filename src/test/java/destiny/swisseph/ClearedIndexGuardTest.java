package destiny.swisseph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A cleared planet index on an open file must report itself, not seek to a nonsense position.
 *
 * <p>The segment size is zero when {@code free_planets()} has wiped a planet's index while the
 * file it indexes stayed open, so nothing re-read the header. What used to happen next is worth
 * spelling out, because the resulting message sent a real investigation down a blind alley:
 * dividing by a zero segment size gives infinity, casting that to {@code int} pins it at
 * {@link Integer#MAX_VALUE}, and {@code MAX_VALUE * 3} overflows to exactly 2147483645 —— which
 * was then used as a file position. The caller saw "Filepointer position 2147483645 exceeds file
 * length by 2147260644 byte(s)", which names neither the body nor the file nor the real fault.
 */
class ClearedIndexGuardTest {

  @Test
  void aClearedIndexIsReportedRatherThanSeekedInto() {
    SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double[] xx = new double[6];
      // Populate the planet file and its index.
      int rc = se.swe_calc_ut(2451545.0, SweConst.SE_JUPITER,
                              SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED, xx, new StringBuffer());
      assertTrue(rc >= 0, "setup: the Swiss calculation should have worked, rc=" + rc);

      PlanData pdp = se.swed.pldat[SwephData.SEI_JUPITER];
      assertTrue(pdp.dseg != 0, "setup: the index should be populated");

      // Exactly the state the bug leaves behind: index cleared, file still open.
      pdp.dseg = 0;
      assertTrue(se.swed.fidat[SwephData.SEI_FILE_PLANET].fptr != null,
                 "setup: the file must still be open for this to be the right situation");

      StringBuffer serr = new StringBuffer();
      int got = new FileData().get_new_segment(se.swed, 2451545.0, SwephData.SEI_JUPITER,
                                               SwephData.SEI_FILE_PLANET, serr);

      assertEquals(SwephData.NOT_AVAILABLE, got, "應該回報「取不到」而不是去 seek 一個垃圾位置");
      assertTrue(serr.toString().contains("index"),
                 "訊息應該說出是索引被清掉了，實得：" + serr);
      assertTrue(!serr.toString().contains("2147483645"),
                 "不該再出現那個沒人看得懂的溢位位置，實得：" + serr);
    } finally {
      se.swe_close();
    }
  }
}
