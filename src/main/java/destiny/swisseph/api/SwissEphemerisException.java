/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/**
 * A calculation could not produce a result at all.
 *
 * <p>Reserved for genuine failure. A calculation that succeeded but had to degrade —— falling back
 * to a lower-precision ephemeris because no data file covered the date, say —— is not an exception:
 * it returns normally, carrying a {@link Warning}. Conflating the two is what forced callers of
 * the legacy API to match on the text of an error message to decide whether to throw.
 */
public class SwissEphemerisException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public SwissEphemerisException(String message) {
    super(message);
  }
}
