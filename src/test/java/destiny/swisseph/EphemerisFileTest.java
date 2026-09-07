package destiny.swisseph;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Ephemeris files are read once and not held open.
 *
 * <p>This is the defect that made the calling application give up on file-based ephemerides
 * in 2016 and fall back to the Moshier approximation, with a note in its configuration saying
 * the leak could not be found and the only remedy was to hide the files. The leak was not
 * subtle in the end: an instance opened a {@code RandomAccessFile}, read through a 300-byte
 * buffer, and kept the handle for its own lifetime — and the application holds one instance
 * per request thread, indefinitely.
 */
class EphemerisFileTest {

  private static final double TJD = 2460841.5;   // 2025-06-15, inside sepl_18.se1's range

  /** The kernel's view of this process's open files, where the platform exposes one. */
  private static List<String> openDataFiles() throws IOException {
    Path dir = Path.of("/proc/self/fd");
    if (!Files.isDirectory(dir)) {
      dir = Path.of("/dev/fd");
    }
    assumeTrue(Files.isDirectory(dir),
               "this platform does not expose the process's open file descriptors");

    List<String> out = new ArrayList<>();
    try (var entries = Files.list(dir)) {
      for (Path fd : entries.toList()) {
        try {
          String target = fd.toRealPath().toString();
          if (target.endsWith(".se1") || target.endsWith("sefstars.txt")) {
            out.add(target);
          }
        } catch (IOException | RuntimeException ignored) {
          // the descriptor went away, or is not a file we can resolve
        }
      }
    }
    return out;
  }

  /**
   * Deliberately leaves the instances open, because that is how the application uses them:
   * one per thread, alive for as long as the thread is.
   */
  @Test
  void computingDoesNotLeaveEphemerisFilesOpen() throws IOException {
    List<String> before = openDataFiles();

    List<SwissEph> stillAlive = new ArrayList<>();
    try {
      for (int i = 0; i < 5; i++) {
        SwissEph se = new SwissEph(SmokeTestSupport.ephePath());
        stillAlive.add(se);
        double[] xx = new double[6];
        int rc = se.swe_calc_ut(TJD, SweConst.SE_SUN, SweConst.SEFLG_SWIEPH, xx, new StringBuffer());
        assertTrue(rc >= 0, "the file-based calculation itself failed, rc=" + rc);
        se.swe_fixstar_ut(new StringBuffer("Aldebaran"), TJD, SweConst.SEFLG_MOSEPH, xx,
                          new StringBuffer());
      }

      List<String> after = openDataFiles();
      assertEquals(before.size(), after.size(),
                   "five live SwissEph instances left data files open: " + after);
    } finally {
      for (SwissEph se : stillAlive) {
        se.swe_close();
      }
    }
  }

  /** Read once: a second instance over the same path does not read the file again. */
  @Test
  void theSameFileIsReadOnlyOnce() {
    EphemerisFile.clearCache();
    assertEquals(0, EphemerisFile.cachedFileCount());

    SwissEph a = new SwissEph(SmokeTestSupport.ephePath());
    SwissEph b = new SwissEph(SmokeTestSupport.ephePath());
    try {
      double[] xx = new double[6];
      a.swe_calc_ut(TJD, SweConst.SE_SUN, SweConst.SEFLG_SWIEPH, xx, new StringBuffer());
      int afterFirst = EphemerisFile.cachedFileCount();
      assertTrue(afterFirst > 0, "nothing was cached");

      b.swe_calc_ut(TJD, SweConst.SE_MARS, SweConst.SEFLG_SWIEPH, xx, new StringBuffer());
      assertEquals(afterFirst, EphemerisFile.cachedFileCount(),
                   "the second instance read the same file again");
    } finally {
      a.swe_close();
      b.swe_close();
    }
  }

  /**
   * A file larger than the ceiling is left on disk and read the buffered way, so that an
   * unusually large asteroid file cannot quietly cost a process hundreds of megabytes.
   */
  @Test
  void theInMemoryCeilingIsGenerousButFinite() {
    assertTrue(EphemerisFile.MAX_IN_MEMORY_BYTES >= 8L * 1024 * 1024,
               "the ceiling must clear every file Astrodienst ships");
    assertTrue(EphemerisFile.MAX_IN_MEMORY_BYTES <= 64L * 1024 * 1024,
               "the ceiling must still be a ceiling");
  }
}
