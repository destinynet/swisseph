/*
   This is a port of the Swiss Ephemeris Free Edition, Version 2.00.00
   of Astrodienst AG, Switzerland from the original C Code to Java. For
   copyright see the original copyright notices below and additional
   copyright notes in the file named LICENSE, or - if this file is not
   available - the copyright notes at http://www.astro.ch/swisseph/ and
   following.

   Thomas Mack, mack@ifis.cs.tu-bs.de, 23rd of April 2001
*/
/* Copyright (C) 1997 - 2008 Astrodienst AG, Switzerland.  All rights reserved.

  License conditions
  ------------------

  This file is part of Swiss Ephemeris.

  Swiss Ephemeris is distributed with NO WARRANTY OF ANY KIND.  No author
  or distributor accepts any responsibility for the consequences of using it,
  or for whether it serves any particular purpose or works at all, unless he
  or she says so in writing.

  Swiss Ephemeris is made available by its authors under a dual licensing
  system. The software developer, who uses any part of Swiss Ephemeris
  in his or her software, must choose between one of the two license models,
  which are
  a) GNU public license version 2 or later
  b) Swiss Ephemeris Professional License

  The License grants you the right to use, copy, modify and redistribute
  Swiss Ephemeris, but only under certain conditions described in the License.
  Among other things, the License requires that the copyright notices and
  this notice be preserved on all copies.

  Authors of the Swiss Ephemeris: Dieter Koch and Alois Treindl

  The authors of Swiss Ephemeris have no control or influence over any of
  the derived works, i.e. over software or services created by other
  programmers which use Swiss Ephemeris functions.

  The names of the authors or of the copyright holder (Astrodienst) must not
  be used for promoting any software, product or service which uses or contains
  the Swiss Ephemeris. This copyright notice is the ONLY place where the
  names of the authors can legally appear, except in cases where they have
  given special permission in writing.

  The trademarks 'Swiss Ephemeris' and 'Swiss Ephemeris inside' may be used
  for promoting such software, products or services.
*/

package destiny.swisseph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The contents of a fixed-star catalogue file, read once and held in memory.
 *
 * <p>The original reads the file afresh on every lookup: it seeks to the start and scans line
 * by line until the star matches, through a reader that fetches one byte at a time and
 * allocates a StringBuffer per line. A chart wanting twenty stars therefore walked all 1290
 * lines of {@code sefstars.txt} twenty times. That cost is why the layer above had to cache
 * every result.
 *
 * <p>The file is small (about 100 KB) and never changes while a process runs, so it is read
 * once and shared. Sharing is safe precisely because this object is immutable — it is the
 * "shared read-only" half of the state, as opposed to the per-call scratch that must not be
 * shared.
 *
 * <p>Lines are kept in file order and unparsed. Lookup remains a scan, because the original's
 * matching rules are prefix-based and first-match-wins, and reproducing them exactly matters
 * more than turning the scan into a hash lookup: a scan over 1290 strings already in memory
 * costs microseconds.
 */
final class FixedStarFile {

  /**
   * Keyed by the resolved file name, so two SwissEph instances pointing at different ephemeris
   * directories do not share a catalogue. Static because the contents are immutable and
   * identical for every reader of the same file.
   */
  private static final Map<String, FixedStarFile> CACHE = new ConcurrentHashMap<>();

  /** Every line of the file, in order, comments included. */
  final List<String> lines;

  /** {@code lines} lowercased, at matching indices, so a scan need not allocate per line. */
  final List<String> lowerCased;

  private FixedStarFile(List<String> lines) {
    this.lines = List.copyOf(lines);
    List<String> lower = new ArrayList<>(lines.size());
    for (String line : lines) {
      lower.add(line.toLowerCase());
    }
    this.lowerCased = List.copyOf(lower);
  }

  /**
   * Reads an open catalogue, or returns the copy already read from the same file.
   *
   * <p>The reader is consumed and closed either way: unlike the original, no handle on the
   * star file is kept open between calls.
   *
   * @param fp   an open reader, positioned anywhere; closed before this returns
   * @param name the resolved file name, used as the cache key
   */
  static FixedStarFile of(FilePtr fp, String name) throws IOException {
    FixedStarFile cached = CACHE.get(name);
    if (cached != null) {
      try {
        fp.close();
      } catch (IOException ignored) {
        // nothing was read from it
      }
      return cached;
    }
    List<String> lines = new ArrayList<>(2048);
    try {
      fp.seek(0);
      String line;
      // readLine() throws at end of input rather than returning null; see FilePtrTest.
      while ((line = fp.readLine()) != null) {
        lines.add(line);
      }
    } catch (IOException endOfFile) {
      // expected: this is how the reader signals that the file is exhausted
    } finally {
      try {
        fp.close();
      } catch (IOException ignored) {
      }
    }
    FixedStarFile loaded = new FixedStarFile(lines);
    FixedStarFile raced = CACHE.putIfAbsent(name, loaded);
    return raced != null ? raced : loaded;
  }

  /** Discards every cached catalogue. Intended for tests that change files on disk. */
  static void clearCache() {
    CACHE.clear();
  }
}
