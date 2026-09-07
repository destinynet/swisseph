package destiny.swisseph.golden;

import destiny.swisseph.SweConst;

/**
 * The input matrix. Every value here is a literal: the fixture is only meaningful if its
 * inputs are stable, so nothing in this file may be derived from the code under test.
 *
 * <p>The Julian Day numbers were computed independently (not via {@link destiny.swisseph.SweDate})
 * so that a change in SweDate cannot silently move the inputs out from under the fixture.
 */
final class Matrix {

  private Matrix() {}

  /**
   * Dates chosen to sit on the seams rather than in the comfortable middle: the
   * Julian/Gregorian changeover, the ends of the delta-T tables, and the extrapolation
   * regions on either side.
   */
  static final double[] DATES = {
      625307.5,    // -3000-01-01 (proleptic Julian, 遠古外推區)
      1355807.5,   // -1000-01-01
      1721057.5,   // 0000-01-01
      2086307.5,   // 1000-01-01
      2299159.5,   // 1582-10-04, Julian 曆最後一天
      2299160.5,   // 1582-10-15, Gregorian 曆第一天
      2312752.5,   // 1620-01-01, delta-T 表起點
      2341972.5,   // 1700-01-01
      2378496.5,   // 1800-01-01
      2415020.5,   // 1900-01-01
      2435108.5,   // 1955-01-01, delta-T 表接縫
      2451545.0,   // 2000-01-01 12:00, J2000.0
      2458849.5,   // 2020-01-01
      2460841.5,   // 2025-06-15
      2488069.5,   // 2100-01-01, delta-T 外推區
      2634166.5,   // 2500-01-01
      2816787.5,   // 3000-01-01
  };

  /** Fractional offsets, to exercise time-of-day rather than only midnight/noon. */
  static final double[] DAY_FRACTIONS = { 0.0, 0.25, 0.5, 0.7734375 };

  /** Three dates used for the dense body x flag sweep. */
  static final double[] DENSE_DATES = { 2299160.5, 2451545.0, 2460841.5 };

  /** A cheap subset used where the full body list would only add noise. */
  static final int[] CORE_BODIES = {
      SweConst.SE_SUN,
      SweConst.SE_MOON,
      SweConst.SE_MERCURY,
      SweConst.SE_JUPITER,
      SweConst.SE_PLUTO,
      SweConst.SE_MEAN_NODE,
      SweConst.SE_CHIRON,
  };

  static final int[] ALL_BODIES = {
      SweConst.SE_SUN,
      SweConst.SE_MOON,
      SweConst.SE_MERCURY,
      SweConst.SE_VENUS,
      SweConst.SE_MARS,
      SweConst.SE_JUPITER,
      SweConst.SE_SATURN,
      SweConst.SE_URANUS,
      SweConst.SE_NEPTUNE,
      SweConst.SE_PLUTO,
      SweConst.SE_MEAN_NODE,
      SweConst.SE_TRUE_NODE,
      SweConst.SE_MEAN_APOG,
      SweConst.SE_OSCU_APOG,
      SweConst.SE_EARTH,
      SweConst.SE_CHIRON,
      SweConst.SE_PHOLUS,
      SweConst.SE_CERES,
      SweConst.SE_ECL_NUT,
  };

  /** The two ephemeris backends. Both are exercised everywhere. */
  static final int[] EPHE_FLAGS = { SweConst.SEFLG_MOSEPH, SweConst.SEFLG_SWIEPH };

  /**
   * Flag modifiers. The full cross product of every SEFLG_* bit is combinatorially absurd,
   * so this is a pairwise-style selection: each bit appears alone, and the pairs that the
   * upper layer actually uses (or that interact) appear together.
   */
  static final int[] FLAG_MODIFIERS = {
      0,
      SweConst.SEFLG_SPEED,
      SweConst.SEFLG_EQUATORIAL,
      SweConst.SEFLG_EQUATORIAL | SweConst.SEFLG_SPEED,
      SweConst.SEFLG_HELCTR,
      SweConst.SEFLG_HELCTR | SweConst.SEFLG_SPEED,
      SweConst.SEFLG_TOPOCTR,
      SweConst.SEFLG_TOPOCTR | SweConst.SEFLG_SPEED,
      SweConst.SEFLG_SIDEREAL,
      SweConst.SEFLG_SIDEREAL | SweConst.SEFLG_SPEED,
      SweConst.SEFLG_TRUEPOS,
      SweConst.SEFLG_J2000,
      SweConst.SEFLG_NONUT,
      SweConst.SEFLG_XYZ,
      SweConst.SEFLG_XYZ | SweConst.SEFLG_SPEED,
      SweConst.SEFLG_RADIANS,
      SweConst.SEFLG_BARYCTR,
      SweConst.SEFLG_NOGDEFL,
      SweConst.SEFLG_NOABERR,
  };

  /** lon, lat, altitude(m). Spread over hemispheres, the equator, and inside the Arctic circle. */
  static final double[][] PLACES = {
      { 121.5, 25.05, 10.0 },      // Taipei
      { -0.1276, 51.5072, 11.0 },  // London
      { -74.006, 40.7128, 10.0 },  // New York
      { 151.2093, -33.8688, 3.0 }, // Sydney
      { 0.0, 0.0, 0.0 },           // equator / prime meridian
      { 15.6, 78.22, 0.0 },        // Longyearbyen, inside the Arctic circle
  };

  /** House systems, as the single chars swe_houses() takes. */
  static final int[] HOUSE_SYSTEMS = {
      'P', 'K', 'O', 'R', 'C', 'E', 'W', 'B', 'M', 'A', 'H', 'T', 'G', 'V', 'X', 'U', 'Y',
  };

  static final int[] SID_MODES = {
      SweConst.SE_SIDM_FAGAN_BRADLEY,
      SweConst.SE_SIDM_LAHIRI,
      SweConst.SE_SIDM_RAMAN,
      SweConst.SE_SIDM_KRISHNAMURTI,
      SweConst.SE_SIDM_TRUE_CITRA,
      SweConst.SE_SIDM_J2000,
  };

  /**
   * Fixed stars, addressed the three different ways swe_fixstar() accepts: by traditional
   * name, by nomenclature (comma-prefixed), and by line number.
   */
  static final String[] FIXED_STARS = {
      "Aldebaran", "Regulus", "Spica", "Antares", "Sirius", "Algol", "Polaris",
      ",alUMi", ",alCMa",
      "1", "42",
      "NoSuchStarAtAll",
  };

  static final int[] RISE_TRANS_EVENTS = {
      SweConst.SE_CALC_RISE,
      SweConst.SE_CALC_SET,
      SweConst.SE_CALC_MTRANSIT,
      SweConst.SE_CALC_ITRANSIT,
  };

  /** Transit angles, in degrees. */
  static final double[] TRANSIT_ANGLES = { 0.0, 60.0, 90.0, 120.0, 180.0, 270.0 };
}
