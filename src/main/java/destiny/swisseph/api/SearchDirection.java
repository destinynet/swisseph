/*
   Part of destiny-swisseph. Unlike the ported files in this package, this one is not
   derived from Thomas Mack's Java port or from Astrodienst's C original — it is new
   code that presents those calculations through a modern API. It is distributed under
   the same dual licensing terms; see the file named LICENSE.
*/

package destiny.swisseph.api;

/** Which way in time to search from a starting instant. */
public enum SearchDirection {

  /** Later than the starting instant. */
  FORWARD(0),

  /** Earlier than the starting instant. */
  BACKWARD(1);

  private final int flag;

  SearchDirection(int flag) {
    this.flag = flag;
  }

  int flag() {
    return flag;
  }
}
