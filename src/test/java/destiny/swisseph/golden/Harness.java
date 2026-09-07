package destiny.swisseph.golden;

import destiny.swisseph.SwissEph;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Runs the case list in the two modes the fixture compares.
 *
 * <p>The two modes exist to separate two things that the original library conflates:
 * what a call computes, and what a call leaves behind. Running identical cases against
 * fresh instances and against one shared instance, then diffing, isolates the second.
 */
public final class Harness {

  private Harness() {}

  /** Every case gets its own SwissEph. Nothing can leak between cases. */
  public static Recorder runCold(String ephePath) {
    Recorder rec = new Recorder(ephePath);
    for (Cases.Case c : Cases.all()) {
      SwissEph se = new SwissEph(ephePath);
      try {
        c.body().accept(se, rec);
      } catch (Throwable t) {
        rec.thrown(c.key(), t);
      } finally {
        try {
          se.swe_close();
        } catch (Throwable ignored) {
          // a failure to close is not what this fixture is measuring
        }
      }
    }
    return rec;
  }

  /** One SwissEph for the whole run, cases in order. Anything left behind is carried forward. */
  public static Recorder runWarm(String ephePath) {
    Recorder rec = new Recorder(ephePath);
    SwissEph se = new SwissEph(ephePath);
    try {
      for (Cases.Case c : Cases.all()) {
        try {
          c.body().accept(se, rec);
        } catch (Throwable t) {
          rec.thrown(c.key(), t);
        }
      }
    } finally {
      try {
        se.swe_close();
      } catch (Throwable ignored) {
      }
    }
    return rec;
  }

  public static int caseCount() {
    return Cases.all().size();
  }

  /**
   * Locates the ephemeris directory. The classpath resource is the normal path (running
   * under surefire); the system property is what the one-off reconciliation run against the
   * upstream jar uses, since that runs outside this module's test classpath.
   */
  public static String ephePath() {
    String prop = System.getProperty("ephe.path");
    if (prop != null && !prop.isEmpty()) {
      return requireDir(new File(prop));
    }
    URL url = Harness.class.getResource("/ephe");
    if (url == null) {
      throw new IllegalStateException(
          "ephemeris directory not found: no /ephe on the classpath and no -Dephe.path given");
    }
    return requireDir(new File(url.getPath()));
  }

  private static String requireDir(File dir) {
    if (!dir.isDirectory()) {
      throw new IllegalStateException("not a directory: " + dir);
    }
    return dir.getAbsolutePath();
  }


  /**
   * The keys whose cold and warm lines differ, in order. This is the measured size of the
   * state that leaks between calls, and it is recorded as a fixture in its own right so
   * that shrinking it is visible in version control.
   */
  public static List<String> divergentKeys(List<String> cold, List<String> warm) {
    List<String> out = new java.util.ArrayList<>();
    int n = Math.min(cold.size(), warm.size());
    for (int i = 0; i < n; i++) {
      if (!cold.get(i).equals(warm.get(i))) {
        out.add(keyOf(cold.get(i)));
      }
    }
    return out;
  }

  /** The stable identifier at the head of a recorded line. */
  public static String keyOf(String line) {
    int bar = line.indexOf(" | ");
    return bar < 0 ? line : line.substring(0, bar);
  }

  /** Returns the first differing line numbers, or an empty list if the two agree. */
  public static List<String> diff(List<String> a, List<String> b, int limit) {
    List<String> out = new java.util.ArrayList<>();
    int n = Math.min(a.size(), b.size());
    for (int i = 0; i < n && out.size() < limit; i++) {
      if (!a.get(i).equals(b.get(i))) {
        out.add("line " + (i + 1) + "\n  a: " + a.get(i) + "\n  b: " + b.get(i));
      }
    }
    if (a.size() != b.size() && out.size() < limit) {
      out.add("line count differs: " + a.size() + " vs " + b.size());
    }
    return out;
  }
}
