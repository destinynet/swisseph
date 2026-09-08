/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.Objects;

/**
 * Something the calculation wants the caller to know, on a call that nevertheless produced a
 * usable result.
 *
 * <p>This type exists because "succeeded" and "failed" are not the only two outcomes. Asking for
 * the Swiss ephemeris when no {@code .se1} file covers the date does not fail —— it quietly falls
 * back to Moshier and returns a position roughly an arcsecond off. The legacy API reports that
 * by writing English prose into a {@code StringBuffer serr} out-parameter, so the only way for a
 * caller to tell a degradation from a real failure was to match on the text:
 *
 * <pre>{@code
 * if (errBuffer.toString() != "") {
 *   if (!errBuffer.toString().contains("not found in the paths of"))
 *     throw RuntimeException(...)
 * }
 * }</pre>
 *
 * <p>That string match now lives here, once, instead of at every call site.
 *
 * @param kind    what sort of degradation this is
 * @param message the original text, kept verbatim —— {@link Kind#UNCLASSIFIED} would be useless
 *                without it, and even for a recognised kind it carries the file name and dates
 */
public record Warning(Kind kind, String message) {

  public Warning {
    Objects.requireNonNull(kind, "kind");
    Objects.requireNonNull(message, "message");
  }

  public enum Kind {
    /**
     * No data file covered the request, so the calculation fell back to a lower-precision
     * method. The result is usable; it is just less precise than what was asked for.
     */
    EPHEMERIS_FILE_MISSING,

    /**
     * The library said something this API does not recognise. Read {@link #message()}.
     *
     * <p>Not an error: the call still returned a result. A warning lands here rather than being
     * silently dropped, so that a message worth classifying shows up instead of disappearing.
     */
    UNCLASSIFIED
  }

  /** Classifies one message from the legacy {@code serr} out-parameter. */
  static Warning classify(String message) {
    // The legacy wording, from swe_calc()'s fallback path. Matching on prose is not lovely, but
    // it is the only signal the underlying implementation gives, and doing it here means doing
    // it once.
    if (message.contains("not found in the paths of")
        || message.contains("file not found")) {
      return new Warning(Kind.EPHEMERIS_FILE_MISSING, message);
    }
    return new Warning(Kind.UNCLASSIFIED, message);
  }

  @Override
  public String toString() {
    return kind + ": " + message;
  }
}
