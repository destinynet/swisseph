/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

/**
 * The modern face of Swiss Ephemeris: values in, values out, safe to share between threads.
 *
 * <p>Start at {@link destiny.swisseph.api.SwissEphemeris}.
 *
 * <h2>Nullness</h2>
 *
 * <p>This package is {@link org.jspecify.annotations.NullMarked}: unless a declaration says
 * otherwise, nothing here is null —— not a parameter, not a return value, not a type argument.
 * "Absent" is spelled {@link java.util.Optional}, which is a different thing and cannot be
 * dereferenced by accident.
 *
 * <p>The point is the caller. Kotlin reading an unannotated Java API sees platform types
 * ({@code String!}), which it will let you use as either nullable or not and which therefore
 * carry no guarantee at all; reading this package it sees {@code String}. The legacy package
 * {@code destiny.swisseph} is deliberately left unannotated —— several of its entry points really
 * do accept null (a null ephemeris path, for one), and claiming otherwise would be worse than
 * saying nothing.
 */
@NullMarked
package destiny.swisseph.api;

import org.jspecify.annotations.NullMarked;
