# destiny-swisseph

A rework of **Thomas Mack's Swiss Ephemeris Java Library**, which is itself a port of
[Astrodienst AG's](https://www.astro.com/swisseph/) Swiss Ephemeris (Free Edition 2.00.00)
from the original C.

**This is a derivative work.** The algorithms, the ephemeris data formats, and the vast
majority of the code are the effort of Dieter Koch and Alois Treindl (Astrodienst AG) and
of Thomas Mack. The original copyright notices and author attributions are preserved
verbatim in the header of every source file and will stay there. Neither Astrodienst nor
Thomas Mack has any involvement in, or responsibility for, this fork — please do not
direct questions about it to them.

## Lineage

| | |
|---|---|
| `master` branch | Thomas Mack's original Java port, unmodified. Kept as the reference point. |
| `swissDev` branch | This work. `git diff master..swissDev` shows exactly what changed. |

## What this fork changes

The numerical behaviour is intended to be **identical** to the original — that is enforced
by a bit-for-bit golden-master test suite rather than asserted by hand. What changes is the
Java around it:

- **Coordinates**: package `swisseph` → `destiny.swisseph`; artifact `swisseph` →
  `destiny-swisseph`. This avoids classpath collision with the original library and makes
  it possible to load both in one JVM for differential testing.
- **Thread safety**: the original carries process-global mutable state (notably a `static`
  back-reference from `SweDate` to `SwissEph`), which makes instances unsafe to share and
  not fully isolated even when they are not shared. Being reworked so a single instance can
  be shared safely.
- **I/O**: the file-reading layer reads one byte at a time and rescans `sefstars.txt` in
  full on every fixed-star lookup. Being reworked.
- **API**: the C-transliterated signatures (`int` return codes, `double[]` and
  `StringBuffer` out-parameters) are being supplemented with typed, value-returning
  equivalents. The original signatures are retained as `@Deprecated` thin wrappers.
- **Removed**: the HTTP/Socket ephemeris-file reader, written in 2001 so Java applets could
  read data files over the network.

Design notes and rationale live outside this repository.

## Requirements

Java 21.

## License

GPL-2.0-or-later, being the GNU GPL option of Swiss Ephemeris' dual licensing scheme.
See [LICENSE](LICENSE) for the full terms, including the Swiss Ephemeris license conditions
reproduced verbatim.
