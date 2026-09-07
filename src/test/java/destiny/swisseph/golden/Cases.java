package destiny.swisseph.golden;

import destiny.swisseph.DblObj;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import destiny.swisseph.TCPlanet;
import destiny.swisseph.TCPlanetPlanet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Builds the ordered list of measured cases.
 *
 * <p><b>Each case is self-contained.</b> A case that needs {@code swe_set_topo} or
 * {@code swe_set_sid_mode} performs that setup itself, on whichever instance it is handed.
 * That is what makes the cold and warm runs comparable: cold gives every case a fresh
 * instance, warm runs every case in order against one shared instance, and since each case
 * establishes its own preconditions either way, <em>any difference between the two files is
 * state leaking between cases</em> rather than a legitimate consequence of the stateful API.
 */
final class Cases {

  private Cases() {}

  /** One measured case: a stable key, and the calls that produce its line(s). */
  record Case(String key, BiConsumer<SwissEph, Recorder> body) {}

  static List<Case> all() {
    List<Case> cases = new ArrayList<>();
    calcUt(cases);
    fixstarUt(cases);
    houses(cases);
    ayanamsa(cases);
    riseTrans(cases);
    azalt(cases);
    nodApsUt(cases);
    timeEqu(cases);
    solarEclipses(cases);
    lunarEclipses(cases);
    transits(cases);
    return cases;
  }

  // ---------------------------------------------------------------- swe_calc_ut

  private static void calcUt(List<Case> out) {
    // Dense sweep: every body against every flag combination, at three dates.
    for (double tjd : Matrix.DENSE_DATES) {
      for (int ephe : Matrix.EPHE_FLAGS) {
        for (int mod : Matrix.FLAG_MODIFIERS) {
          for (int body : Matrix.ALL_BODIES) {
            int iflag = ephe | mod;
            String key = "calc_ut/dense/tjd=" + f(tjd) + "/ipl=" + body + "/iflag=" + iflag;
            out.add(new Case(key, (se, rec) -> {
              prepareForFlags(se, iflag);
              double[] xx = new double[6];
              StringBuffer serr = new StringBuffer();
              int rc = se.swe_calc_ut(tjd, body, iflag, xx, serr);
              rec.call(key, rc, xx, serr);
            }));
          }
        }
      }
    }

    // Date sweep: the seams and the extrapolation regions, against a small body subset.
    for (double base : Matrix.DATES) {
      for (double frac : Matrix.DAY_FRACTIONS) {
        double tjd = base + frac;
        for (int ephe : Matrix.EPHE_FLAGS) {
          int iflag = ephe | SweConst.SEFLG_SPEED;
          for (int body : Matrix.CORE_BODIES) {
            String key = "calc_ut/dates/tjd=" + f(tjd) + "/ipl=" + body + "/iflag=" + iflag;
            out.add(new Case(key, (se, rec) -> {
              double[] xx = new double[6];
              StringBuffer serr = new StringBuffer();
              int rc = se.swe_calc_ut(tjd, body, iflag, xx, serr);
              rec.call(key, rc, xx, serr);
            }));
          }
        }
      }
    }
  }

  /**
   * SEFLG_TOPOCTR and SEFLG_SIDEREAL are meaningless until the corresponding setter has been
   * called; the C API treats calling them without setup as undefined. Every case that uses
   * those bits therefore establishes the same fixed precondition.
   */
  private static void prepareForFlags(SwissEph se, int iflag) {
    if ((iflag & SweConst.SEFLG_TOPOCTR) != 0) {
      se.swe_set_topo(121.5, 25.05, 10.0);
    }
    if ((iflag & SweConst.SEFLG_SIDEREAL) != 0) {
      se.swe_set_sid_mode(SweConst.SE_SIDM_FAGAN_BRADLEY);
    }
  }

  // ------------------------------------------------------------- swe_fixstar_ut

  private static void fixstarUt(List<Case> out) {
    for (double tjd : Matrix.DENSE_DATES) {
      for (int ephe : Matrix.EPHE_FLAGS) {
        for (int mod : new int[]{0, SweConst.SEFLG_SPEED, SweConst.SEFLG_EQUATORIAL, SweConst.SEFLG_J2000}) {
          for (String star : Matrix.FIXED_STARS) {
            int iflag = ephe | mod;
            String key = "fixstar_ut/tjd=" + f(tjd) + "/star=" + star + "/iflag=" + iflag;
            out.add(new Case(key, (se, rec) -> {
              // swe_fixstar rewrites the StringBuffer in place with the resolved name,
              // so the buffer after the call is part of the result, not just an input.
              StringBuffer name = new StringBuffer(star);
              double[] xx = new double[6];
              StringBuffer serr = new StringBuffer();
              int rc = se.swe_fixstar_ut(name, tjd, iflag, xx, serr);
              rec.call(key + "/resolved=" + name, rc, xx, serr);
            }));
          }
        }
      }
    }
  }

  // ------------------------------------------------------------------ swe_houses

  private static void houses(List<Case> out) {
    for (double tjd : Matrix.DENSE_DATES) {
      for (double[] place : Matrix.PLACES) {
        for (int hsys : Matrix.HOUSE_SYSTEMS) {
          for (int iflag : new int[]{0, SweConst.SEFLG_SIDEREAL}) {
            String key = "houses/tjd=" + f(tjd) + "/lon=" + f(place[0]) + "/lat=" + f(place[1])
                         + "/hsys=" + (char) hsys + "/iflag=" + iflag;
            out.add(new Case(key, (se, rec) -> {
              if (iflag == SweConst.SEFLG_SIDEREAL) {
                se.swe_set_sid_mode(SweConst.SE_SIDM_LAHIRI);
              }
              double[] cusp = new double[13];
              double[] ascmc = new double[10];
              int rc = se.swe_houses(tjd, iflag, place[1], place[0], hsys, cusp, ascmc);
              rec.call(key + "/cusp", rc, cusp, "");
              rec.out(key + "/ascmc", ascmc, ascmc.length);
            }));
          }
        }
      }
    }
  }

  // ------------------------------------------------------------- ayanamsa / sid mode

  private static void ayanamsa(List<Case> out) {
    for (double tjd : Matrix.DATES) {
      for (int sidMode : Matrix.SID_MODES) {
        String key = "ayanamsa_ut/tjd=" + f(tjd) + "/sidm=" + sidMode;
        out.add(new Case(key, (se, rec) -> {
          se.swe_set_sid_mode(sidMode);
          rec.value(key, se.swe_get_ayanamsa_ut(tjd));
        }));
      }
      // The user-defined sidereal mode takes a reference epoch and an initial ayanamsha.
      String key = "ayanamsa_ut/tjd=" + f(tjd) + "/sidm=USER";
      out.add(new Case(key, (se, rec) -> {
        se.swe_set_sid_mode(SweConst.SE_SIDM_USER, 2451545.0, 24.0);
        rec.value(key, se.swe_get_ayanamsa_ut(tjd));
      }));
    }
  }

  // -------------------------------------------------------------- swe_rise_trans

  private static void riseTrans(List<Case> out) {
    for (double tjd : Matrix.DENSE_DATES) {
      for (double[] place : Matrix.PLACES) {
        for (int body : new int[]{SweConst.SE_SUN, SweConst.SE_MOON, SweConst.SE_MARS}) {
          for (int rsmi : Matrix.RISE_TRANS_EVENTS) {
            for (int ephe : Matrix.EPHE_FLAGS) {
              String key = "rise_trans/tjd=" + f(tjd) + "/lon=" + f(place[0]) + "/lat=" + f(place[1])
                           + "/ipl=" + body + "/rsmi=" + rsmi + "/ephe=" + ephe;
              out.add(new Case(key, (se, rec) -> {
                DblObj tret = new DblObj(0.0);
                StringBuffer serr = new StringBuffer();
                int rc = se.swe_rise_trans(tjd, body, null, ephe, rsmi, place,
                                           1013.25, 15.0, tret, serr);
                rec.call(key, rc, new double[]{tret.val}, serr);
              }));
            }
          }
        }
      }
    }
  }

  // ------------------------------------------------------------------- swe_azalt

  private static void azalt(List<Case> out) {
    for (double tjd : Matrix.DENSE_DATES) {
      for (double[] place : Matrix.PLACES) {
        for (int calcFlag : new int[]{SweConst.SE_ECL2HOR, SweConst.SE_EQU2HOR}) {
          for (double[] xin : new double[][]{{0, 0, 1}, {123.456, 4.5, 1.0}, {270.0, -20.0, 0.98}}) {
            String key = "azalt/tjd=" + f(tjd) + "/lon=" + f(place[0]) + "/lat=" + f(place[1])
                         + "/cf=" + calcFlag + "/xin=" + f(xin[0]) + "," + f(xin[1]) + "," + f(xin[2]);
            out.add(new Case(key, (se, rec) -> {
              double[] xaz = new double[6];
              se.swe_azalt(tjd, calcFlag, place, 1013.25, 15.0, xin.clone(), xaz);
              rec.out(key, xaz, 3);
            }));
          }
        }
      }
    }
  }

  // -------------------------------------------------------------- swe_nod_aps_ut

  private static void nodApsUt(List<Case> out) {
    for (double tjd : Matrix.DENSE_DATES) {
      for (int ephe : Matrix.EPHE_FLAGS) {
        for (int method : new int[]{SweConst.SE_NODBIT_MEAN, SweConst.SE_NODBIT_OSCU,
                                    SweConst.SE_NODBIT_OSCU_BAR, SweConst.SE_NODBIT_FOPOINT}) {
          for (int body : new int[]{SweConst.SE_MOON, SweConst.SE_MERCURY, SweConst.SE_MARS,
                                    SweConst.SE_JUPITER, SweConst.SE_PLUTO}) {
            int iflag = ephe | SweConst.SEFLG_SPEED;
            String key = "nod_aps_ut/tjd=" + f(tjd) + "/ipl=" + body
                         + "/method=" + method + "/iflag=" + iflag;
            out.add(new Case(key, (se, rec) -> {
              double[] xnasc = new double[6];
              double[] xndsc = new double[6];
              double[] xperi = new double[6];
              double[] xaphe = new double[6];
              StringBuffer serr = new StringBuffer();
              int rc = se.swe_nod_aps_ut(tjd, body, iflag, method, xnasc, xndsc, xperi, xaphe, serr);
              rec.call(key + "/nasc", rc, xnasc, serr);
              rec.out(key + "/ndsc", xndsc, 6);
              rec.out(key + "/peri", xperi, 6);
              rec.out(key + "/aphe", xaphe, 6);
            }));
          }
        }
      }
    }
  }

  // ----------------------------------------------------------------- swe_time_equ

  private static void timeEqu(List<Case> out) {
    for (double base : Matrix.DATES) {
      for (double frac : Matrix.DAY_FRACTIONS) {
        double tjd = base + frac;
        String key = "time_equ/tjd=" + f(tjd);
        out.add(new Case(key, (se, rec) -> {
          double[] e = new double[1];
          StringBuffer serr = new StringBuffer();
          int rc = se.swe_time_equ(tjd, e, serr);
          rec.call(key, rc, e, serr);
        }));
      }
    }
  }

  // ------------------------------------------------------------- solar eclipses

  private static void solarEclipses(List<Case> out) {
    double[] starts = { 2415020.5, 2451545.0, 2458849.5, 2460841.5 };
    for (double tjd : starts) {
      for (int ephe : Matrix.EPHE_FLAGS) {
        for (int backward : new int[]{0, 1}) {
          String gk = "sol_eclipse_when_glob/tjd=" + f(tjd) + "/ephe=" + ephe + "/bw=" + backward;
          out.add(new Case(gk, (se, rec) -> {
            double[] tret = new double[10];
            StringBuffer serr = new StringBuffer();
            int rc = se.swe_sol_eclipse_when_glob(tjd, ephe, 0, tret, backward, serr);
            rec.call(gk, rc, tret, serr);
          }));

          for (double[] place : Matrix.PLACES) {
            String lk = "sol_eclipse_when_loc/tjd=" + f(tjd) + "/ephe=" + ephe + "/bw=" + backward
                        + "/lon=" + f(place[0]) + "/lat=" + f(place[1]);
            out.add(new Case(lk, (se, rec) -> {
              double[] tret = new double[10];
              double[] attr = new double[20];
              StringBuffer serr = new StringBuffer();
              int rc = se.swe_sol_eclipse_when_loc(tjd, ephe, place, tret, attr, backward, serr);
              rec.call(lk + "/tret", rc, tret, serr);
              rec.out(lk + "/attr", attr, attr.length);
            }));
          }
        }

        String wk = "sol_eclipse_where/tjd=" + f(tjd) + "/ephe=" + ephe;
        out.add(new Case(wk, (se, rec) -> {
          double[] geopos = new double[20];
          double[] attr = new double[20];
          StringBuffer serr = new StringBuffer();
          int rc = se.swe_sol_eclipse_where(tjd, ephe, geopos, attr, serr);
          rec.call(wk + "/geopos", rc, geopos, serr);
          rec.out(wk + "/attr", attr, attr.length);
        }));

        for (double[] place : Matrix.PLACES) {
          String hk = "sol_eclipse_how/tjd=" + f(tjd) + "/ephe=" + ephe
                      + "/lon=" + f(place[0]) + "/lat=" + f(place[1]);
          out.add(new Case(hk, (se, rec) -> {
            double[] attr = new double[20];
            StringBuffer serr = new StringBuffer();
            int rc = se.swe_sol_eclipse_how(tjd, ephe, place, attr, serr);
            rec.call(hk, rc, attr, serr);
          }));
        }
      }
    }
  }

  // -------------------------------------------------------------- lunar eclipses

  private static void lunarEclipses(List<Case> out) {
    double[] starts = { 2415020.5, 2451545.0, 2458849.5, 2460841.5 };
    for (double tjd : starts) {
      for (int ephe : Matrix.EPHE_FLAGS) {
        for (int backward : new int[]{0, 1}) {
          String wk = "lun_eclipse_when/tjd=" + f(tjd) + "/ephe=" + ephe + "/bw=" + backward;
          out.add(new Case(wk, (se, rec) -> {
            double[] tret = new double[10];
            StringBuffer serr = new StringBuffer();
            int rc = se.swe_lun_eclipse_when(tjd, ephe, 0, tret, backward, serr);
            rec.call(wk, rc, tret, serr);
          }));

          for (double[] place : Matrix.PLACES) {
            String lk = "lun_eclipse_when_loc/tjd=" + f(tjd) + "/ephe=" + ephe + "/bw=" + backward
                        + "/lon=" + f(place[0]) + "/lat=" + f(place[1]);
            out.add(new Case(lk, (se, rec) -> {
              double[] tret = new double[10];
              double[] attr = new double[20];
              StringBuffer serr = new StringBuffer();
              int rc = se.swe_lun_eclipse_when_loc(tjd, ephe, place, tret, attr, backward, serr);
              rec.call(lk + "/tret", rc, tret, serr);
              rec.out(lk + "/attr", attr, attr.length);
            }));
          }
        }

        for (double[] place : Matrix.PLACES) {
          String hk = "lun_eclipse_how/tjd=" + f(tjd) + "/ephe=" + ephe
                      + "/lon=" + f(place[0]) + "/lat=" + f(place[1]);
          out.add(new Case(hk, (se, rec) -> {
            double[] attr = new double[20];
            StringBuffer serr = new StringBuffer();
            int rc = se.swe_lun_eclipse_how(tjd, ephe, place, attr, serr);
            rec.call(hk, rc, attr, serr);
          }));
        }
      }
    }
  }

  // ------------------------------------------------------------------- transits

  private static void transits(List<Case> out) {
    double[] starts = { 2451545.0, 2460841.5 };
    for (double tjd : starts) {
      for (int ephe : Matrix.EPHE_FLAGS) {
        int flags = ephe | SweConst.SEFLG_TRANSIT_LONGITUDE;

        for (int body : new int[]{SweConst.SE_SUN, SweConst.SE_MOON, SweConst.SE_MARS, SweConst.SE_SATURN}) {
          for (double angle : Matrix.TRANSIT_ANGLES) {
            for (boolean backwards : new boolean[]{false, true}) {
              String key = "transit/planet/tjd=" + f(tjd) + "/ipl=" + body + "/angle=" + f(angle)
                           + "/ephe=" + ephe + "/bw=" + backwards;
              out.add(new Case(key, (se, rec) -> {
                try {
                  TCPlanet tc = new TCPlanet(se, body, flags, angle);
                  rec.value(key, se.getTransitUT(tc, tjd, backwards));
                } catch (Throwable t) {
                  rec.thrown(key, t);
                }
              }));
            }
          }
        }

        for (int[] pair : new int[][]{
            {SweConst.SE_SUN, SweConst.SE_MOON},
            {SweConst.SE_MARS, SweConst.SE_JUPITER},
            {SweConst.SE_JUPITER, SweConst.SE_SATURN}}) {
          for (double angle : Matrix.TRANSIT_ANGLES) {
            for (boolean backwards : new boolean[]{false, true}) {
              String key = "transit/pair/tjd=" + f(tjd) + "/pl1=" + pair[0] + "/pl2=" + pair[1]
                           + "/angle=" + f(angle) + "/ephe=" + ephe + "/bw=" + backwards;
              out.add(new Case(key, (se, rec) -> {
                try {
                  TCPlanetPlanet tc = new TCPlanetPlanet(se, pair[0], pair[1], flags, angle);
                  rec.value(key, se.getTransitUT(tc, tjd, backwards));
                } catch (Throwable t) {
                  rec.thrown(key, t);
                }
              }));
            }
          }
        }
      }
    }
  }

  /** Keys must be byte-stable across runs and locales, so no locale-sensitive formatting. */
  private static String f(double d) {
    return Double.toString(d);
  }
}
