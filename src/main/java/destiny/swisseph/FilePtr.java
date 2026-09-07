/*
   This is a port of the Swiss Ephemeris Free Edition, Version 2.00.00
   of Astrodienst AG, Switzerland from the original C Code to Java. For
   copyright see the original copyright notices below and additional
   copyright notes in the file named LICENSE, or - if this file is not
   available - the copyright notes at http://www.astro.ch/swisseph/ and
   following. 

   For any questions or comments regarding this port to Java, you should
   ONLY contact me and not Astrodienst, as the Astrodienst AG is not involved
   in this port in any way.

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

  The choice must be made before the software developer distributes software
  containing parts of Swiss Ephemeris to others, and before any public
  service using the developed software is activated.

  If the developer choses the GNU GPL software license, he or she must fulfill
  the conditions of that license, which includes the obligation to place his
  or her whole software project under the GNU GPL or a compatible license.
  See http://www.gnu.org/licenses/old-licenses/gpl-2.0.html

  If the developer choses the Swiss Ephemeris Professional license,
  he must follow the instructions as found in http://www.astro.com/swisseph/
  and purchase the Swiss Ephemeris Professional Edition from Astrodienst
  and sign the corresponding license contract.

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

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Buffered random-access reading of the Swiss Ephemeris data files.
 *
 * <p>This class used to double as an HTTP client: it could fetch byte ranges of an ephemeris
 * file over a hand-rolled HTTP/1.1 conversation on a raw socket, so that a Java applet could
 * read data files it had no filesystem access to. That was written in 2001, the applet
 * deployment model it served is long gone, and nothing in this project ever used it. It has
 * been removed, along with the second buffer that existed only to stage bytes on their way in
 * from the network — reads now land in the buffer they are served from.
 */
public class FilePtr implements AutoCloseable {

  /** Initial capacity for {@link #readLine()}'s accumulator. */
  private static final int STRING_BUFFER_SIZE = 200;

  RandomAccessFile fp;
  String fnamp;

  /**
   * The whole file, when it was small enough to hold. Non-null means reads are array indexing
   * and no file handle is kept; null means the buffered {@link RandomAccessFile} path below.
   */
  private byte[] contents;

  private long fpos = 0;
  private final int BUFSIZE;

  /** Holds at most BUFSIZE bytes of the file: [startIdx, endIdx] in file coordinates. */
  private final byte[] data;
  private long startIdx = -1;
  private long endIdx = -1;

  private long savedLength;

  private boolean bigendian = true;

  /**
   * @param fp         an open file, already positioned anywhere
   * @param fnamp      the resolved file name, kept for error messages and cache keys
   * @param fileLength the file length if already known, or a negative value to ask the file
   * @param bufsize    how many bytes to fetch per refill
   */
  public FilePtr(RandomAccessFile fp, String fnamp, long fileLength, int bufsize) {
    this.fp = fp;
    this.fnamp = fnamp;
    this.savedLength = fileLength;
    this.BUFSIZE = bufsize;
    this.data = new byte[bufsize];
  }

  /**
   * Reads from a copy of the file already in memory. No file handle is held.
   *
   * @param contents the file, shared and never modified
   * @param fnamp    the resolved file name, kept for error messages
   */
  FilePtr(byte[] contents, String fnamp) {
    this.contents = contents;
    this.fnamp = fnamp;
    this.savedLength = contents.length;
    this.BUFSIZE = 0;
    this.data = null;
  }

  /** True while this reader can still serve bytes. */
  boolean isOpen() {
    return contents != null || fp != null;
  }

  public void setBigendian(boolean bigendian) {
    this.bigendian = bigendian;
  }

  /**
   * Reads one (signed) byte.
   *
   * @return One signed 8 bit byte.
   * @throws IOException  if an I/O error occurs.
   * @throws EOFException if the end of file is reached <i>before</i> the
   *                      byte could be read.
   */
  public byte readByte() throws IOException, EOFException {
    if (contents != null) {
      if (fpos < 0 || fpos >= contents.length) {
        throw new EOFException("Filepointer position " + fpos + " exceeds file" +
            " length by " + (fpos - contents.length + 1) + " byte(s).");
      }
      return contents[(int) fpos++];
    }
    if (startIdx < 0 || fpos < startIdx || fpos > endIdx) {
      readToBuffer();
    }
    return data[(int) (fpos++ - startIdx)];
  }

  /**
   * Reads one unsigned byte.
   *
   * @return One unsigned 8 bit byte as an int.
   * @throws IOException  if an I/O error occurs.
   * @throws EOFException if the end of file is reached <i>before</i> the
   *                      byte could be read.
   */
  public int readUnsignedByte() throws IOException, EOFException {
    return ((int) readByte()) & 0xff;
  }

  /**
   * Reads a (signed) short value.
   *
   * @return One signed 16 bit short value.
   * @throws IOException if an I/O error occurs.
   */
  public short readShort() throws IOException {
    if (bigendian) {
      return (short) ((readByte() << 8) + readUnsignedByte());
    }
    return (short) (readUnsignedByte() + (readByte() << 8));
  }

  /**
   * Reads a (signed) int value.
   *
   * @return One signed 32 bit int value.
   * @throws IOException if an I/O error occurs.
   */
  public int readInt() throws IOException {
    if (bigendian) {
      return (((int) readByte()) << 24) +
          (readUnsignedByte() << 16) +
          (readUnsignedByte() << 8) +
          readUnsignedByte();
    }
    return readUnsignedByte() +
        (readUnsignedByte() << 8) +
        (readUnsignedByte() << 16) +
        (((int) readByte()) << 24);
  }

  /**
   * Reads a double value.
   *
   * @return One 64 bit double value.
   * @throws IOException if an I/O error occurs.
   */
  public double readDouble() throws IOException {
    long ldb = (bigendian ?
        (
            (((long) readUnsignedByte()) << 56) +
                (((long) readUnsignedByte()) << 48) +
                (((long) readUnsignedByte()) << 40) +
                (((long) readUnsignedByte()) << 32) +
                (((long) readUnsignedByte()) << 24) +
                (((long) readUnsignedByte()) << 16) +
                (((long) readUnsignedByte()) << 8) +
                (long) readUnsignedByte()
        ) :
        (
            (long) readUnsignedByte() +
                (((long) readUnsignedByte()) << 8) +
                (((long) readUnsignedByte()) << 16) +
                (((long) readUnsignedByte()) << 24) +
                (((long) readUnsignedByte()) << 32) +
                (((long) readUnsignedByte()) << 40) +
                (((long) readUnsignedByte()) << 48) +
                (((long) readUnsignedByte()) << 56)
        )
    );
    return Double.longBitsToDouble(ldb);
  }

  /**
   * Reads a line, terminator included. Splits on '\n' only, so a '\r' stays in the line.
   *
   * <p>At end of input this throws rather than returning null, even though every caller in
   * this library is written as {@code while ((s = readLine()) != null)}; those loops actually
   * end on the exception.
   *
   * @throws EOFException at end of input, when nothing could be read at all.
   */
  public String readLine() throws IOException {
    StringBuilder sout = new StringBuilder(STRING_BUFFER_SIZE);
    try {
      char ch;
      while ((ch = (char) readUnsignedByte()) != '\n') {
        sout.append(ch);
      }
      sout.append(ch);
    } catch (EOFException e) {
      if (sout.length() == 0) {
        throw e;
      }
    }
    return sout.toString();
  }

  /**
   * Closes the file.
   *
   * @throws IOException if an I/O error occurs.
   */
  @Override
  public void close() throws IOException {
    fnamp = "";
    startIdx = -1;
    endIdx = -1;
    savedLength = -1;
    // The array is shared and outlives this reader; only the reference is dropped.
    contents = null;
    if (fp != null) {
      RandomAccessFile toClose = fp;
      fp = null;
      toClose.close();
    }
  }

  public long getFilePointer() {
    return fpos;
  }

  public long length() throws IOException {
    if (contents != null) {
      return contents.length;
    }
    if (fp != null && savedLength < 0) {
      savedLength = fp.length();
    }
    return savedLength;
  }

  public void seek(long pos) {
    fpos = pos;
  }

  /** Refills the buffer so that it covers {@link #fpos}. */
  private void readToBuffer() throws IOException {
    fp.seek(fpos);
    int cnt = fp.read(data);
    if (cnt == -1) {
      throw new EOFException("Filepointer position " + fpos + " exceeds file" +
          " length by " + (fpos - length() + 1) + " byte(s).");
    }
    startIdx = fpos;
    endIdx = fpos + cnt - 1;
  }
}
