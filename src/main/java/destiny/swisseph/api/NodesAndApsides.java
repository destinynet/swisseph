/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

import java.util.List;
import java.util.Objects;

/**
 * The four points that describe a body's orbit as seen from the centre of reference.
 *
 * <p>The legacy call fills four separate {@code double[6]} arrays the caller allocates, in an
 * order given only by the parameter names ({@code xnasc}, {@code xndsc}, {@code xperi},
 * {@code xaphe}). Mixing up which array was which produces four perfectly plausible positions in
 * the wrong roles.
 *
 * @param ascendingNode  where the orbit crosses the reference plane going north
 * @param descendingNode where it crosses going south
 * @param perihelion     the closest point to the centre of reference
 * @param aphelion       the furthest point —— or the orbit's second focus, if
 *                       {@link ApsisOption#FOCAL_POINT} was requested
 * @param warnings       degradations that did not prevent a result
 */
public record NodesAndApsides(Position ascendingNode,
                              Position descendingNode,
                              Position perihelion,
                              Position aphelion,
                              List<Warning> warnings) {

  public NodesAndApsides {
    Objects.requireNonNull(ascendingNode, "ascendingNode");
    Objects.requireNonNull(descendingNode, "descendingNode");
    Objects.requireNonNull(perihelion, "perihelion");
    Objects.requireNonNull(aphelion, "aphelion");
    warnings = List.copyOf(warnings);
  }

  /** True when the calculation was degraded in some way; see {@link #warnings()} for what. */
  public boolean hasWarnings() {
    return !warnings.isEmpty();
  }
}
