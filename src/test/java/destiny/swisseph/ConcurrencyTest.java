package destiny.swisseph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instances must not reach each other.
 *
 * <p>Each thread gets its own SwissEph, which is how the calling application uses this library.
 * That arrangement was <em>not</em> safe before Phase 2, despite looking like it should be:
 * {@code SweDate} held a static reference that every constructor overwrote, so one thread's
 * delta-T went through another thread's instance; the tidal acceleration derived from one
 * thread's ephemeris was used by all of them; and fifteen of {@code Swemmoon}'s working
 * variables were static, so two threads computing the Moon at once overwrote each other's
 * intermediate values.
 *
 * <p>The check is exact: each thread's answers must equal, bit for bit, what the same
 * calculation produces with nothing else running. Anything less would not distinguish a race
 * from a rounding difference.
 *
 * <p>This does <em>not</em> claim a single shared instance is safe. It is not, and the golden
 * master measures how far from safe it is.
 */
class ConcurrencyTest {

  private static final int THREADS = 8;
  private static final int ROUNDS = 6;

  /** Deliberately mixed: two ephemeris backends, dates in and out of the available file. */
  private record Task(double tjd, int body, int iflag) {}

  private static List<Task> tasks() {
    List<Task> out = new ArrayList<>();
    double[] dates = {2299160.5, 2415020.5, 2451545.0, 2458849.5, 2460841.5};
    int[] bodies = {SweConst.SE_SUN, SweConst.SE_MOON, SweConst.SE_MERCURY,
                    SweConst.SE_JUPITER, SweConst.SE_PLUTO, SweConst.SE_MEAN_NODE};
    int[] flags = {SweConst.SEFLG_MOSEPH,
                   SweConst.SEFLG_MOSEPH | SweConst.SEFLG_SPEED,
                   SweConst.SEFLG_SWIEPH,
                   SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED,
                   SweConst.SEFLG_SWIEPH | SweConst.SEFLG_EQUATORIAL};
    for (double tjd : dates) {
      for (int b : bodies) {
        for (int f : flags) {
          out.add(new Task(tjd, b, f));
        }
      }
    }
    return out;
  }

  /** One task on a fresh instance, rendered exactly. */
  private static String compute(String ephe, Task t) {
    SwissEph se = new SwissEph(ephe);
    try {
      double[] xx = new double[6];
      StringBuffer serr = new StringBuffer();
      int rc = se.swe_calc_ut(t.tjd(), t.body(), t.iflag(), xx, serr);
      StringBuilder sb = new StringBuilder().append(rc);
      for (double d : xx) {
        sb.append(',').append(Double.toHexString(d));
      }
      return sb.toString();
    } finally {
      se.swe_close();
    }
  }

  @Test
  void oneInstancePerThreadGivesTheSameAnswersAsRunningAlone() throws Exception {
    String ephe = SmokeTestSupport.ephePath();
    List<Task> tasks = tasks();

    // Baseline, single-threaded, nothing else touching the library.
    List<String> expected = new ArrayList<>(tasks.size());
    for (Task t : tasks) {
      expected.add(compute(ephe, t));
    }

    ExecutorService pool = Executors.newFixedThreadPool(THREADS);
    CountDownLatch start = new CountDownLatch(1);
    List<Future<String>> failures = new ArrayList<>();
    AtomicInteger checks = new AtomicInteger();

    try {
      for (int thread = 0; thread < THREADS; thread++) {
        // Each thread walks the task list from a different offset, so the threads are doing
        // different work at the same moment rather than marching in step.
        final int offset = thread;
        failures.add(pool.submit(() -> {
          start.await();
          for (int round = 0; round < ROUNDS; round++) {
            for (int i = 0; i < tasks.size(); i++) {
              int idx = (i + offset * 7) % tasks.size();
              Task t = tasks.get(idx);
              String got = compute(ephe, t);
              checks.incrementAndGet();
              if (!expected.get(idx).equals(got)) {
                return "tjd=" + t.tjd() + " ipl=" + t.body() + " iflag=" + t.iflag()
                       + "\n  alone     : " + expected.get(idx)
                       + "\n  concurrent: " + got;
              }
            }
          }
          return null;
        }));
      }
      start.countDown();

      List<String> problems = new ArrayList<>();
      for (Future<String> f : failures) {
        String p = f.get(5, TimeUnit.MINUTES);
        if (p != null) {
          problems.add(p);
        }
      }
      assertTrue(problems.isEmpty(),
                 problems.size() + " of " + THREADS + " threads disagreed with the "
                 + "single-threaded result:\n" + String.join("\n", problems));
      assertEquals(THREADS * ROUNDS * tasks.size(), checks.get(), "not every check ran");
    } finally {
      pool.shutdownNow();
    }
  }
}
