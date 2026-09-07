package destiny.swisseph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * White-box tests for the file reading layer.
 *
 * <p>Phase 3 replaces this class outright — the byte-at-a-time reads, the duplicated buffer,
 * and the HTTP transport all go. These tests exist so that the replacement can be checked
 * against the behaviour rather than against a reading of the old code, and they deliberately
 * use a tiny buffer so that every read crosses a refill boundary: getting the boundary
 * arithmetic wrong is the most likely way to break a rewrite of this class.
 */
class FilePtrTest {

  /** Small enough that almost every multi-byte read spans a refill. */
  private static final int BUFSIZE = 8;

  private FilePtr open(Path file) throws IOException {
    RandomAccessFile raf = new RandomAccessFile(file.toFile(), "r");
    return new FilePtr(raf, file.toString(), raf.length(), BUFSIZE);
  }

  private Path write(Path dir, String name, byte[] bytes) throws IOException {
    Path p = dir.resolve(name);
    Files.write(p, bytes);
    return p;
  }

  // ------------------------------------------------------------------ primitives

  @Test
  void readsSignedAndUnsignedBytes(@TempDir Path dir) throws IOException {
    Path f = write(dir, "bytes.bin", new byte[]{0x00, 0x7F, (byte) 0x80, (byte) 0xFF});
    try (FilePtr fp = open(f)) {
      assertEquals(0, fp.readByte());
      assertEquals(127, fp.readByte());
      assertEquals(-128, fp.readByte());
      assertEquals(-1, fp.readByte());

      fp.seek(0);
      assertEquals(0, fp.readUnsignedByte());
      assertEquals(127, fp.readUnsignedByte());
      assertEquals(128, fp.readUnsignedByte());
      assertEquals(255, fp.readUnsignedByte());
    }
  }

  @Test
  void readsShortsInBothEndiannesses(@TempDir Path dir) throws IOException {
    Path f = write(dir, "short.bin", new byte[]{0x12, 0x34, (byte) 0xFF, (byte) 0xFE});
    try (FilePtr fp = open(f)) {
      assertEquals((short) 0x1234, fp.readShort());
      assertEquals((short) 0xFFFE, fp.readShort());
    }
    try (FilePtr fp = open(f)) {
      fp.setBigendian(false);
      assertEquals((short) 0x3412, fp.readShort());
      assertEquals((short) 0xFEFF, fp.readShort());
    }
  }

  @Test
  void readsIntsInBothEndiannesses(@TempDir Path dir) throws IOException {
    Path f = write(dir, "int.bin",
                   new byte[]{0x01, 0x02, 0x03, 0x04, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
    try (FilePtr fp = open(f)) {
      assertEquals(0x01020304, fp.readInt());
      assertEquals(-1, fp.readInt());
    }
    try (FilePtr fp = open(f)) {
      fp.setBigendian(false);
      assertEquals(0x04030201, fp.readInt());
      assertEquals(-1, fp.readInt());
    }
  }

  /** Eight bytes at a buffer size of eight: this read always straddles a refill. */
  @Test
  void readsDoublesInBothEndiannesses(@TempDir Path dir) throws IOException {
    double value = -1234.56789;
    long bits = Double.doubleToLongBits(value);

    byte[] be = new byte[8];
    for (int i = 0; i < 8; i++) {
      be[i] = (byte) (bits >>> (56 - 8 * i));
    }
    byte[] le = new byte[8];
    for (int i = 0; i < 8; i++) {
      le[i] = be[7 - i];
    }

    // A leading byte pushes the double off the buffer boundary rather than onto it.
    byte[] padded = new byte[9];
    padded[0] = 0x5A;
    System.arraycopy(be, 0, padded, 1, 8);

    try (FilePtr fp = open(write(dir, "be.bin", be))) {
      assertEquals(value, fp.readDouble());
    }
    try (FilePtr fp = open(write(dir, "le.bin", le))) {
      fp.setBigendian(false);
      assertEquals(value, fp.readDouble());
    }
    try (FilePtr fp = open(write(dir, "padded.bin", padded))) {
      assertEquals(0x5A, fp.readByte());
      assertEquals(value, fp.readDouble(), "a double straddling a buffer refill");
    }
  }

  // ---------------------------------------------------------------- positioning

  @Test
  void seekAndFilePointerTrackEachOther(@TempDir Path dir) throws IOException {
    byte[] data = new byte[64];
    for (int i = 0; i < data.length; i++) {
      data[i] = (byte) i;
    }
    try (FilePtr fp = open(write(dir, "seq.bin", data))) {
      assertEquals(64, fp.length());
      assertEquals(0, fp.getFilePointer());

      fp.seek(40);
      assertEquals(40, fp.getFilePointer());
      assertEquals(40, fp.readUnsignedByte());
      assertEquals(41, fp.getFilePointer());

      // Backwards, into a region the buffer has already passed.
      fp.seek(3);
      assertEquals(3, fp.readUnsignedByte());

      // Forwards again, far enough to force a fresh refill.
      fp.seek(63);
      assertEquals(63, fp.readUnsignedByte());
    }
  }

  @Test
  void readingPastTheEndThrowsEof(@TempDir Path dir) throws IOException {
    try (FilePtr fp = open(write(dir, "tiny.bin", new byte[]{1, 2}))) {
      fp.readByte();
      fp.readByte();
      assertThrows(EOFException.class, fp::readByte);
    }
  }

  // --------------------------------------------------------------------- lines

  @Test
  void readLineKeepsTheTerminatorAndSplitsOnNewlineOnly(@TempDir Path dir) throws IOException {
    // Deliberately CRLF: the reader splits on \n only, so \r stays in the line.
    byte[] text = "alpha\nbeta\r\ngamma\n".getBytes(StandardCharsets.UTF_8);
    try (FilePtr fp = open(write(dir, "lines.txt", text))) {
      assertEquals("alpha\n", fp.readLine());
      assertEquals("beta\r\n", fp.readLine());
      assertEquals("gamma\n", fp.readLine());
    }
  }

  @Test
  void readLineReturnsAnUnterminatedFinalLine(@TempDir Path dir) throws IOException {
    try (FilePtr fp = open(write(dir, "noeol.txt", "one\ntwo".getBytes(StandardCharsets.UTF_8)))) {
      assertEquals("one\n", fp.readLine());
      assertEquals("two", fp.readLine());
    }
  }

  /**
   * At end of input readLine throws rather than returning null, even though every caller in
   * this library is written as {@code while ((s = fp.readLine()) != null)}. Those loops
   * actually terminate on the exception, which is caught outside. Pinned here because a
   * rewrite that "fixes" readLine to return null would silently change how those loops end.
   */
  @Test
  void readLineThrowsAtEndOfInputRatherThanReturningNull(@TempDir Path dir) throws IOException {
    try (FilePtr fp = open(write(dir, "one.txt", "only\n".getBytes(StandardCharsets.UTF_8)))) {
      assertEquals("only\n", fp.readLine());
      assertThrows(EOFException.class, fp::readLine);
    }
  }

  /** A line longer than the buffer must still come back whole. */
  @Test
  void readLineSpansManyBufferRefills(@TempDir Path dir) throws IOException {
    String line = "x".repeat(BUFSIZE * 7 + 3);
    try (FilePtr fp = open(write(dir, "long.txt", (line + "\n").getBytes(StandardCharsets.UTF_8)))) {
      assertEquals(line + "\n", fp.readLine());
    }
  }

  // -------------------------------------------------------------- the real files

  /**
   * The ephemeris files this library actually reads are big-endian and start with a text
   * header. This is a shape check on the real data, not on a fixture of our own making.
   */
  @Test
  void readsTheHeaderOfARealEphemerisFile() throws IOException {
    Path se1 = Path.of(SmokeTestSupport.ephePath(), "sepl_18.se1");
    assertTrue(Files.isRegularFile(se1), "test resource missing: " + se1);
    try (FilePtr fp = open(se1)) {
      assertTrue(fp.length() > 400_000, "unexpected file length: " + fp.length());
      String first = fp.readLine();
      assertTrue(first.startsWith("SWISSEPH"),
                 "expected a SWISSEPH header, got: " + first.strip());
    }
  }
}
