package destiny.swisseph.golden;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Collects one line per measured call, in a form that survives byte-for-byte comparison.
 *
 * <p>Doubles are written with {@link Double#toHexString}: decimal formatting silently
 * discards low-order bits, and the whole point of this fixture is to notice when a
 * refactoring moves those bits. The hex form also distinguishes {@code -0.0} from
 * {@code 0.0}, which decimal formatting via {@code %f} does not.
 *
 * <p>Lines are emitted in insertion order rather than sorted, because the warm-mode run
 * deliberately shares one SwissEph instance across every case in sequence: the order is
 * part of what is being measured.
 */
final class Recorder {

  private final List<String> lines = new ArrayList<>(65536);

  /**
   * The ephemeris directory, redacted out of error messages. SwissEph embeds the absolute
   * search path in its "file not found" text, which differs between a run from the source
   * tree and a run under surefire — an environment difference, not a behavioural one, and
   * the fixture must not encode it.
   */
  private final String ephePath;

  Recorder(String ephePath) {
    this.ephePath = ephePath;
  }

  /** Result of a call that returns a status code plus values in an out-parameter array. */
  void call(String key, int rc, double[] values, CharSequence serr) {
    lines.add(key + " | rc=" + rc + " | " + doubles(values, values.length) + " | " + serr(serr));
  }

  /** As {@link #call}, but only the first {@code n} elements of {@code values} are meaningful. */
  void call(String key, int rc, double[] values, int n, CharSequence serr) {
    lines.add(key + " | rc=" + rc + " | " + doubles(values, n) + " | " + serr(serr));
  }

  /** Result of a call that returns a bare double and has no status code. */
  void value(String key, double v) {
    lines.add(key + " | rc=- | " + hex(v) + " | ");
  }

  /** Result of a void call whose effect is visible only through out-parameters. */
  void out(String key, double[] values, int n) {
    lines.add(key + " | rc=- | " + doubles(values, n) + " | ");
  }

  /**
   * A call that threw. The throwable's type and message are part of the contract just as
   * much as a returned value is, so they are recorded rather than swallowed.
   */
  void thrown(String key, Throwable t) {
    String msg = t.getMessage() == null ? "" : t.getMessage();
    lines.add(key + " | THROWN " + t.getClass().getName() + " | | " + escape(redact(msg)));
  }

  void write(Writer w) throws IOException {
    BufferedWriter bw = new BufferedWriter(w);
    for (String line : lines) {
      bw.write(line);
      bw.write('\n');
    }
    bw.flush();
  }

  int size() {
    return lines.size();
  }

  List<String> lines() {
    return lines;
  }

  private static String doubles(double[] values, int n) {
    StringBuilder sb = new StringBuilder(n * 24);
    for (int i = 0; i < n; i++) {
      if (i > 0) sb.append(',');
      sb.append(hex(values[i]));
    }
    return sb.toString();
  }

  private static String hex(double d) {
    return Double.toHexString(d);
  }

  private String serr(CharSequence serr) {
    return serr == null ? "" : escape(redact(serr.toString()));
  }

  private String redact(String s) {
    String r = ephePath == null ? s : s.replace(ephePath, "<EPHE>");
    return dropStackFrames(r);
  }

  /**
   * Some error paths append a whole stack trace to {@code serr}. The frames name whoever
   * called in, so they differ between the generator and the test that replays it — and they
   * would change under any refactoring that moves a line, which is exactly the noise this
   * fixture must not carry. The exception type and its message are kept; the frames are not.
   */
  private static String dropStackFrames(String s) {
    int at = s.indexOf("\n\tat ");
    return at < 0 ? s : s.substring(0, at) + " <frames omitted>";
  }

  /** Keeps every record on exactly one line and keeps the field separator unambiguous. */
  private static String escape(String s) {
    return s.replace("\\", "\\\\")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t")
            .replace("|", "\\v");
  }
}
