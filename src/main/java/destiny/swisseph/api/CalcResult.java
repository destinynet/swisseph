/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * The outcome of one position calculation: everything the call has to say, as a value.
 *
 * <p>The legacy signature is
 * {@code int swe_calc_ut(double tjd, int ipl, int iflag, double[] xx, StringBuffer serr)} ——
 * two out-parameters, a return code that is really a flag mask, and diagnostics as English prose.
 * This record replaces all four.
 *
 * <p>Note {@link #usedEphemeris()}: it is what the calculation actually used, which is not always
 * what was asked for. A request for {@link Ephemeris#SWISS} outside the range of the available
 * files comes back as {@link Ephemeris#MOSHIER} here, with a matching entry in
 * {@link #warnings()}. In the legacy API that fact is buried in the returned flag mask.
 *
 * @param position       where the body is; which variant depends on the options requested
 * @param motion         how fast it is moving, present only if {@link CalcOption#SPEED} was asked for
 * @param usedEphemeris  what the calculation actually ran on
 * @param resolvedName   for a {@link Body.FixedStar}, the catalogue's own full name for it;
 *                       empty for every other kind of body
 * @param warnings       degradations that did not prevent a result; empty on a clean call
 */
public record CalcResult(
    Position position,
    Optional<Motion> motion,
    Ephemeris usedEphemeris,
    Optional<String> resolvedName,
    List<Warning> warnings) {

  public CalcResult {
    Objects.requireNonNull(position, "position");
    Objects.requireNonNull(motion, "motion");
    Objects.requireNonNull(usedEphemeris, "usedEphemeris");
    Objects.requireNonNull(resolvedName, "resolvedName");
    warnings = List.copyOf(warnings);
  }

  /** True when the calculation was degraded in some way; see {@link #warnings()} for what. */
  public boolean hasWarnings() {
    return !warnings.isEmpty();
  }

  /** True when at least one warning is of the given kind. */
  public boolean warnedAbout(Warning.Kind kind) {
    return warnings.stream().anyMatch(w -> w.kind() == kind);
  }

  /**
   * The position as ecliptic coordinates, or an exception if it was not asked for in that system.
   *
   * <p>A convenience for the common case, so that callers who never pass
   * {@link CalcOption#EQUATORIAL} or {@link CalcOption#CARTESIAN} need not pattern-match.
   */
  public Position.Ecliptic ecliptic() {
    if (position instanceof Position.Ecliptic e) {
      return e;
    }
    throw new IllegalStateException(
        "position is " + position.getClass().getSimpleName() + ", not Ecliptic —— it was requested "
        + "in a different coordinate system");
  }

  /** Which options the underlying calculation reported it honoured. */
  public static Set<CalcOption> optionsFrom(int returnedFlags) {
    return CalcOption.decode(returnedFlags);
  }
}
