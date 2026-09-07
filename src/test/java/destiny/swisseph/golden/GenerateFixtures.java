package destiny.swisseph.golden;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Writes the golden-master fixtures.
 *
 * <p>Run it deliberately, never as part of the build:
 * <pre>
 *   mvn -o test-compile
 *   java -cp target/classes:target/test-classes \
 *        destiny.swisseph.golden.GenerateFixtures src/test/resources/golden
 * </pre>
 *
 * <p>Regenerating is how a behavioural change gets accepted, so the diff of these files is
 * the review artifact. If a refactoring produces a diff here, either the refactoring is
 * wrong or the change is intended and the commit message has to say what moved and by how
 * much.
 */
public final class GenerateFixtures {

  public static void main(String[] args) throws IOException {
    Path outDir = Path.of(args.length > 0 ? args[0] : "src/test/resources/golden");
    Files.createDirectories(outDir);

    String ephe = Harness.ephePath();
    System.out.println("ephemeris path : " + ephe);
    System.out.println("cases          : " + Harness.caseCount());

    long t0 = System.nanoTime();
    Recorder cold = Harness.runCold(ephe);
    long t1 = System.nanoTime();
    Recorder warm = Harness.runWarm(ephe);
    long t2 = System.nanoTime();

    write(outDir.resolve("cold.txt"), cold);
    write(outDir.resolve("warm.txt"), warm);

    System.out.printf("cold           : %d lines in %.1f s%n", cold.size(), (t1 - t0) / 1e9);
    System.out.printf("warm           : %d lines in %.1f s%n", warm.size(), (t2 - t1) / 1e9);

    var divergent = Harness.divergentKeys(cold.lines(), warm.lines());
    Path divPath = outDir.resolve("cold-warm-divergence.txt");
    try (Writer w = new OutputStreamWriter(Files.newOutputStream(divPath), StandardCharsets.UTF_8)) {
      for (String k : divergent) {
        w.write(k);
        w.write('\n');
      }
    }
    System.out.println("wrote          : " + divPath);
    System.out.printf("divergence     : %d of %d lines (%.1f%%) differ between cold and warm%n",
                      divergent.size(), cold.size(), 100.0 * divergent.size() / cold.size());
  }

  private static void write(Path path, Recorder rec) throws IOException {
    try (Writer w = new OutputStreamWriter(Files.newOutputStream(path), StandardCharsets.UTF_8)) {
      rec.write(w);
    }
    System.out.println("wrote          : " + path);
  }
}
