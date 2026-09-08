package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The property this class exists for: several threads sharing one {@link SwissEphemeris} get
 * exactly what they would have got alone.
 *
 * <p>That is stated carefully. It is not "every thread agrees on the answer to a given request" ——
 * that is a different property (independence from call history), which this library does not have
 * and which nothing here claims to give it. Two threads that have computed different things
 * beforehand can legitimately disagree, and they do so identically whether they run together or
 * apart. So each thread is given a fixed sequence, its answers are recorded from a run of that
 * sequence on its own instance, and the assertion is that running all the sequences at once
 * against one shared instance changes nothing.
 *
 * <p>Before {@code SwissEphemeris} existed, sharing one {@code SwissEph} across these same eight
 * threads produced, out of 150 distinct requests, 94 that returned more than one answer —— some of
 * them zero or NaN, with a success return code —— plus three NullPointerExceptions.
 */
class SwissEphemerisConcurrencyTest {

  private static final int THREADS = 8;
  private static final int ROUNDS = 6;

  /** Deliberately mixed: two ephemerides, dates inside and outside the available files. */
  private record Task(double tjd, Body body, Ephemeris ephemeris, Set<CalcOption> options) { }

  private static List<Task> allTasks() {
    List<Task> out = new ArrayList<>();
    double[] dates = {2299160.5, 2415020.5, 2451545.0, 2458849.5, 2460841.5};
    Body[] bodies = {Body.Point.SUN, Body.Point.MOON, Body.Point.MERCURY,
                     Body.Point.JUPITER, Body.Point.PLUTO, Body.Point.MEAN_LUNAR_NODE};
    Ephemeris[] ephemerides = {Ephemeris.MOSHIER, Ephemeris.SWISS};
    List<Set<CalcOption>> optionSets = List.of(
        EnumSet.noneOf(CalcOption.class),
        EnumSet.of(CalcOption.SPEED),
        EnumSet.of(CalcOption.EQUATORIAL));
    for (double tjd : dates) {
      for (Body body : bodies) {
        for (Ephemeris ephemeris : ephemerides) {
          for (Set<CalcOption> options : optionSets) {
            out.add(new Task(tjd, body, ephemeris, options));
          }
        }
      }
    }
    return out;
  }

  /** The sequence thread {@code n} walks: the whole list, entered at its own offset. */
  private static List<Task> sequenceFor(int thread, List<Task> tasks) {
    List<Task> sequence = new ArrayList<>(tasks.size() * ROUNDS);
    for (int round = 0; round < ROUNDS; round++) {
      for (int i = 0; i < tasks.size(); i++) {
        sequence.add(tasks.get((i + thread * 7) % tasks.size()));
      }
    }
    return sequence;
  }

  /** Renders one result exactly —— hex doubles, so nothing is lost to formatting. */
  private static String render(CalcResult r) {
    StringBuilder sb = new StringBuilder(r.usedEphemeris().name());
    switch (r.position()) {
      case Position.Ecliptic e -> {
        sb.append(",ecl,").append(Double.toHexString(e.longitudeDeg()))
          .append(',').append(Double.toHexString(e.latitudeDeg()))
          .append(',').append(Double.toHexString(e.distanceAu()));
        e.speed().ifPresent(v -> sb.append(",spd,").append(Double.toHexString(v.longitudeDegPerDay()))
                                   .append(',').append(Double.toHexString(v.latitudeDegPerDay()))
                                   .append(',').append(Double.toHexString(v.distanceAuPerDay())));
      }
      case Position.Equatorial q -> {
        sb.append(",equ,").append(Double.toHexString(q.rightAscensionDeg()))
          .append(',').append(Double.toHexString(q.declinationDeg()))
          .append(',').append(Double.toHexString(q.distanceAu()));
        q.speed().ifPresent(v -> sb.append(",spd,").append(Double.toHexString(v.rightAscensionDegPerDay()))
                                   .append(',').append(Double.toHexString(v.declinationDegPerDay()))
                                   .append(',').append(Double.toHexString(v.distanceAuPerDay())));
      }
      case Position.Cartesian c -> {
        sb.append(",xyz,").append(Double.toHexString(c.x()))
          .append(',').append(Double.toHexString(c.y()))
          .append(',').append(Double.toHexString(c.z()));
        c.speed().ifPresent(v -> sb.append(",spd,").append(Double.toHexString(v.xAuPerDay()))
                                   .append(',').append(Double.toHexString(v.yAuPerDay()))
                                   .append(',').append(Double.toHexString(v.zAuPerDay())));
      }
    }
    for (Warning w : r.warnings()) {
      sb.append(",warn,").append(w.kind());
    }
    return sb.toString();
  }

  private static List<String> run(SwissEphemeris ephemeris, List<Task> sequence) {
    List<String> out = new ArrayList<>(sequence.size());
    for (Task t : sequence) {
      out.add(render(ephemeris.calculate(
          JulianDayUT.of(t.tjd()), t.body(), t.ephemeris(), t.options())));
    }
    return out;
  }

  @Test
  void sharingOneInstanceGivesEachThreadWhatItWouldGetAlone() throws Exception {
    String ephePath = SmokeTestSupport.ephePath();
    List<Task> tasks = allTasks();

    // Alone: each sequence on an instance of its own, one thread, nothing else running.
    List<List<String>> alone = new ArrayList<>(THREADS);
    for (int thread = 0; thread < THREADS; thread++) {
      try (SwissEphemeris privateInstance = SwissEphemeris.at(ephePath)) {
        alone.add(run(privateInstance, sequenceFor(thread, tasks)));
      }
    }

    // Together: the same sequences, at the same time, against one instance.
    List<List<String>> together;
    ExecutorService pool = Executors.newFixedThreadPool(THREADS);
    try (SwissEphemeris shared = SwissEphemeris.at(ephePath)) {
      CountDownLatch start = new CountDownLatch(1);
      List<Future<List<String>>> futures = new ArrayList<>(THREADS);
      for (int thread = 0; thread < THREADS; thread++) {
        List<Task> sequence = sequenceFor(thread, tasks);
        futures.add(pool.submit(() -> {
          start.await();
          return run(shared, sequence);
        }));
      }
      start.countDown();
      together = new ArrayList<>(THREADS);
      for (Future<List<String>> f : futures) {
        together.add(f.get(10, TimeUnit.MINUTES));
      }
    } finally {
      pool.shutdownNow();
    }

    int compared = 0;
    for (int thread = 0; thread < THREADS; thread++) {
      List<String> expected = alone.get(thread);
      List<String> actual = together.get(thread);
      assertEquals(expected.size(), actual.size(), "thread " + thread + " ran a different number of calls");
      for (int i = 0; i < expected.size(); i++) {
        List<Task> sequence = sequenceFor(thread, tasks);
        assertEquals(expected.get(i), actual.get(i),
                     "thread " + thread + ", call " + i + " (" + sequence.get(i) + ") differed when shared");
        compared++;
      }
    }
    assertTrue(compared >= THREADS * tasks.size() * ROUNDS,
               "expected to compare every call, compared only " + compared);
  }

  @Test
  void everyThreadGetsItsOwnContextRatherThanOneBeingShared() throws Exception {
    // A context carries the mutate-then-call state. If two threads shared one, a topocentric
    // position set by one would leak into the other's geocentric call. Here each thread sets a
    // different observer and checks it still sees its own.
    String ephePath = SmokeTestSupport.ephePath();
    ExecutorService pool = Executors.newFixedThreadPool(THREADS);
    try (SwissEphemeris shared = SwissEphemeris.at(ephePath)) {
      CountDownLatch start = new CountDownLatch(1);
      List<Future<String>> futures = new ArrayList<>();
      List<String> expected = Collections.synchronizedList(new ArrayList<>());

      for (int thread = 0; thread < THREADS; thread++) {
        final double longitude = -170 + thread * 40;
        futures.add(pool.submit(() -> {
          start.await();
          String last = null;
          for (int round = 0; round < 200; round++) {
            CalcResult r = shared.calculate(
                JulianDayUT.of(2451545.0), Body.Point.MOON, Ephemeris.MOSHIER,
                EnumSet.noneOf(CalcOption.class),
                Centre.topocentric(longitude, 25.0, 0.0), Zodiac.tropical());
            String rendered = render(r);
            if (last != null) {
              assertEquals(last, rendered, "the same request changed answer mid-run");
            }
            last = rendered;
          }
          expected.add(last);
          return last;
        }));
      }
      start.countDown();
      List<String> results = new ArrayList<>();
      for (Future<String> f : futures) {
        results.add(f.get(10, TimeUnit.MINUTES));
      }
      // Different observers must give different Moon positions —— if the contexts were shared,
      // whichever thread set its observer last would win and some of these would collide.
      assertEquals(THREADS, results.stream().distinct().count(),
                   "threads with different observers got colliding positions: " + results);
    } finally {
      pool.shutdownNow();
    }
  }
}
