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
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The bytes of an ephemeris data file, read once and shared.
 *
 * <p>An {@code .se1} file is read-only, small, and identical for every reader, so keeping one
 * copy in memory is both cheaper and simpler than the alternative. The alternative was a
 * {@link RandomAccessFile} per SwissEph instance, seeking and refilling a 300-byte buffer, and
 * — because closing it would have meant re-opening on the next call — left open for the life
 * of the instance. That is where the ephemeris file handles went.
 *
 * <p>Sharing is safe because the array is never written after construction. It is exposed
 * directly rather than through a wrapper because {@link FilePtr} indexes it on the hot path;
 * nothing else touches it.
 *
 * <p>Files above {@link #MAX_IN_MEMORY_BYTES} are not loaded, and the caller keeps reading
 * them the buffered way. Every standard Swiss Ephemeris file is far below that; the limit is
 * there so that an unusually large asteroid file cannot quietly cost a process hundreds of
 * megabytes.
 */
final class EphemerisFile {

  /**
   * Largest file that will be held in memory. The biggest files Astrodienst ships are a few
   * megabytes, so this is generous on purpose.
   */
  static final long MAX_IN_MEMORY_BYTES = 16L * 1024 * 1024;

  /** Keyed by resolved file name; contents are immutable, so every reader can share one copy. */
  private static final Map<String, byte[]> CACHE = new ConcurrentHashMap<>();

  private EphemerisFile() {}

  /**
   * Returns the whole file, reading it if this is the first request for that name.
   *
   * @param raf  an open file; neither its position nor its openness is disturbed on failure
   * @param name the resolved file name, used as the cache key
   * @return the contents, or null if the file is too large to hold or could not be read
   */
  static byte[] contentsOf(RandomAccessFile raf, String name) {
    byte[] cached = CACHE.get(name);
    if (cached != null) {
      return cached;
    }
    try {
      long len = raf.length();
      if (len <= 0 || len > MAX_IN_MEMORY_BYTES) {
        return null;
      }
      byte[] bytes = new byte[(int) len];
      raf.seek(0);
      raf.readFully(bytes);
      byte[] raced = CACHE.putIfAbsent(name, bytes);
      return raced != null ? raced : bytes;
    } catch (IOException | OutOfMemoryError e) {
      // Fall back to reading the file the buffered way; nothing is broken by not caching.
      return null;
    }
  }

  /** Discards every cached file. Intended for tests that change files on disk. */
  static void clearCache() {
    CACHE.clear();
  }

  /** Number of files currently held. Exposed for tests. */
  static int cachedFileCount() {
    return CACHE.size();
  }
}
