package destiny.swisseph.golden;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The safety net. Replays the recorded matrix and asserts the results are unchanged,
 * bit for bit.
 *
 * <p>Doubles are compared as their hex representations, not with a tolerance. That is
 * deliberate: none of the planned refactorings (removing global state, replacing the I/O
 * layer, wrapping the API) changes the order of any floating-point operation, so any
 * movement at all is a signal rather than noise. A change that genuinely must move the
 * bits regenerates the fixtures and explains the magnitude in its commit message.
 *
 * <p><b>Why this is one test method rather than three.</b> The library keeps state in static
 * fields, so a "cold" run is only cold in a JVM that has not already used it. Splitting the
 * assertions across methods would make each one depend on which of its siblings ran first,
 * and the suite would stop being reproducible. One method, running cold then warm exactly as
 * the generator does, is the only arrangement that is deterministic today. The pom also sets
 * {@code reuseForks=false} so that other test classes in this module cannot warm the JVM up
 * before this one starts.
 *
 * <p>When Phase 2 removes the shared state, this constraint disappears and the assertions can
 * be split up again. Until then, needing it is itself a symptom worth leaving visible.
 */
class GoldenMasterTest {

  @Test
  void matrixIsUnchanged() throws IOException {
    String ephe = Harness.ephePath();

    // Same order as GenerateFixtures. Do not reorder without regenerating the fixtures.
    List<String> cold = Harness.runCold(ephe).lines();
    List<String> warm = Harness.runWarm(ephe).lines();

    assertMatches("cold.txt", cold);
    assertMatches("warm.txt", warm);
    assertDivergenceUnchanged(cold, warm);
  }

  private void assertMatches(String fixture, List<String> got) throws IOException {
    List<String> expected = readFixture(fixture);
    List<String> d = Harness.diff(expected, got, 5);
    assertTrue(d.isEmpty(),
               fixture + ": " + d.size() + " difference(s) from the recorded baseline "
               + "(expected vs actual):\n" + String.join("\n", d));
    assertEquals(expected.size(), got.size(), fixture + ": line count");
  }

  /**
   * Cold and warm do <em>not</em> currently agree: sharing one SwissEph across calls changes
   * roughly two fifths of the matrix, because the library carries state between calls that
   * the caller never asked it to carry. That is the defect this project exists to remove, so
   * the size and shape of the divergence is recorded as a fixture rather than asserted away.
   *
   * <p>This pins the divergence exactly. A refactoring that removes shared state makes the
   * recorded list shrink — regenerate it, and the diff shows precisely which calls stopped
   * depending on their history. A refactoring that introduces new sharing makes it grow, and
   * this fails.
   *
   * <p>The clearest single instance, and a good first target: calling
   * {@code swe_calc_ut(SE_ECL_NUT, SEFLG_NONUT)} on a fresh instance honours SEFLG_NONUT and
   * reports zero nutation, while the identical call on an instance that has computed anything
   * else reports the nutation left behind by that earlier call.
   */
  private void assertDivergenceUnchanged(List<String> cold, List<String> warm) throws IOException {
    List<String> expected = readFixture("cold-warm-divergence.txt");
    List<String> actual = Harness.divergentKeys(cold, warm);
    List<String> d = Harness.diff(expected, actual, 5);
    assertTrue(d.isEmpty(),
               "the set of calls whose result depends on call history has changed "
               + "(recorded " + expected.size() + ", now " + actual.size() + "):\n"
               + String.join("\n", d));
  }

  private static List<String> readFixture(String name) throws IOException {
    try (InputStream in = GoldenMasterTest.class.getResourceAsStream("/golden/" + name)) {
      assertNotNull(in, "fixture /golden/" + name + " not on the classpath — "
                        + "run GenerateFixtures to create it");
      List<String> lines = new ArrayList<>(65536);
      var br = new java.io.BufferedReader(new java.io.InputStreamReader(in, StandardCharsets.UTF_8));
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
      return lines;
    }
  }
}
