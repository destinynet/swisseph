package destiny.swisseph;

import java.io.File;
import java.net.URL;

/** Locates the ephemeris directory shared by the tests in this package. */
final class SmokeTestSupport {

  private SmokeTestSupport() {}

  static String ephePath() {
    String prop = System.getProperty("ephe.path");
    File dir = (prop != null && !prop.isEmpty())
               ? new File(prop)
               : fromClasspath();
    if (!dir.isDirectory()) {
      throw new IllegalStateException("not a directory: " + dir);
    }
    return dir.getAbsolutePath();
  }

  private static File fromClasspath() {
    URL url = SmokeTestSupport.class.getResource("/ephe");
    if (url == null) {
      throw new IllegalStateException("test resource /ephe not on the classpath");
    }
    return new File(url.getPath());
  }
}
