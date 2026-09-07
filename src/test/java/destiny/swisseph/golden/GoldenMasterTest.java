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
   * The 948 recorded divergences that remain are inherited from the C original, not defects in
   * this port. That was established by comparing against Swiss Ephemeris 2.01.00 — the exact
   * version this library was ported from — function by function:
   *
   * <ul>
   *   <li><b>459 of them (48%) come from the tidal acceleration.</b> {@code SE_TIDAL_AUTOMATIC}
   *       derives it from whichever ephemeris was last used, delta-T depends on it, and
   *       {@code swe_houses} and friends depend on delta-T. C 2.01's {@code swe_houses} calls
   *       {@code swe_deltat(tjd_ut)} exactly as this does. Pinning the value with
   *       {@code SweDate.setGlobalTidalAcc} removes every one of the house, azimuth and
   *       equation-of-time divergences. This is the documented design, not a bug.</li>
   *   <li><b>The remaining 489 follow from the constructor.</b> C 2.01's
   *       {@code swe_set_ephe_path()} ends by computing the Moon at J2000 through the Swiss
   *       ephemeris, to read the DE number out of the lunar file's header — so a "fresh"
   *       instance has already done a full calculation, and later calls sit on that warm state
   *       until an ephemeris switch clears it. This port does the same thing because the C
   *       does.</li>
   * </ul>
   *
   * <p>Magnitudes, for judging whether any of it matters: the median difference is 0.0003
   * arcseconds. The tail is not negligible — {@code swe_nod_aps_ut} reaches 2033 arcseconds and
   * {@code swe_calc_ut} 158 — but reaching it needs deliberate mixing of ephemerides on one
   * instance. No return code differs anywhere.
   *
   * <p>Closing the gap would mean deliberately departing from Astrodienst's reference
   * implementation. That is a product decision, not a refactoring one, and it is not taken here.
   *
   * <p>What <em>was</em> fixed, because those genuinely were port errors, is recorded in the
   * design notes: {@code free_planets()} had {@code swe_close()}'s body copied into it,
   * {@code Swemmoon} had fifteen working variables left static, {@code SweDate} held a static
   * back-reference to SwissEph, {@code swe_close()} missed four caches of its own, and
   * {@code SEFLG_NONUT} returned nutation left over from an earlier call.
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
