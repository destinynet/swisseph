package destiny.swisseph.api;

import destiny.swisseph.SmokeTestSupport;
import destiny.swisseph.SweConst;
import destiny.swisseph.SwissEph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link SwissEphemeris} must return exactly what the call it wraps returns —— bit for bit.
 *
 * <p>The facade's own work is assembling the flag mask from typed parts ({@link Ephemeris},
 * {@link CalcOption}, {@link Centre}, {@link Zodiac}) and pairing it with the mutate-then-call
 * setters. Both are easy to get subtly wrong in a way no other test would notice: a dropped
 * {@code SEFLG_TOPOCTR} still returns a perfectly plausible geocentric position. So each case
 * here is computed twice —— once through the new API, once by hand through the old one —— and the
 * two must agree to the last bit.
 *
 * <p>The golden master pins the library's behaviour; this pins the translation on top of it.
 */
class SwissEphemerisEquivalenceTest {

  private record Case(double tjd, Body body, Ephemeris ephemeris,
                      Set<CalcOption> options, Centre centre, Zodiac zodiac) { }

  private static List<Case> cases() {
    List<Case> out = new ArrayList<>();
    double[] dates = {2299160.5, 2451545.0, 2460841.5};
    Body[] bodies = {Body.Point.SUN, Body.Point.MOON, Body.Point.SATURN,
                     Body.Point.TRUE_LUNAR_NODE, Body.Point.CHIRON,
                     new Body.FixedStar("Aldebaran")};
    Ephemeris[] ephemerides = {Ephemeris.MOSHIER, Ephemeris.SWISS};
    List<Set<CalcOption>> optionSets = List.of(
        EnumSet.noneOf(CalcOption.class),
        EnumSet.of(CalcOption.SPEED),
        EnumSet.of(CalcOption.EQUATORIAL),
        EnumSet.of(CalcOption.SPEED, CalcOption.EQUATORIAL),
        EnumSet.of(CalcOption.CARTESIAN),
        EnumSet.of(CalcOption.TRUE_POSITION, CalcOption.NO_NUTATION));
    List<Centre> centres = List.of(
        Centre.geocentric(),
        Centre.topocentric(121.5, 25.0, 10.0),
        Centre.heliocentric());
    List<Zodiac> zodiacs = List.of(
        Zodiac.tropical(),
        Zodiac.sidereal(SweConst.SE_SIDM_LAHIRI),
        Zodiac.siderealUserDefined(JulianDayUT.of(2451545.0), 23.85));

    for (double tjd : dates) {
      for (Body body : bodies) {
        for (Ephemeris ephemeris : ephemerides) {
          for (Set<CalcOption> options : optionSets) {
            for (Centre centre : centres) {
              for (Zodiac zodiac : zodiacs) {
                out.add(new Case(tjd, body, ephemeris, options, centre, zodiac));
              }
            }
          }
        }
      }
    }
    return out;
  }

  /** The same request, spelled out the old way. Each case gets a fresh instance, as the new API's
   *  first call on a thread does, so the two runs start from the same state. */
  private static String legacy(String ephePath, Case c) {
    SwissEph se = new SwissEph(ephePath);
    try {
      int iflag = c.ephemeris().bit() | c.centre().bit() | c.zodiac().bit();
      for (CalcOption option : c.options()) {
        iflag |= option.bit();
      }
      if (c.centre() instanceof Centre.Topocentric topo) {
        se.swe_set_topo(topo.longitudeDeg(), topo.latitudeDeg(), topo.altitudeMetres());
      }
      if (c.zodiac() instanceof Zodiac.Sidereal sidereal) {
        se.swe_set_sid_mode(sidereal.ayanamsaMode(), 0, 0);
      } else if (c.zodiac() instanceof Zodiac.SiderealUserDefined user) {
        se.swe_set_sid_mode(SweConst.SE_SIDM_USER, user.referenceJulianDay().value(), user.ayanamsaDeg());
      }

      double[] xx = new double[6];
      StringBuffer serr = new StringBuffer();
      int rc;
      if (c.body() instanceof Body.FixedStar star) {
        rc = se.swe_fixstar_ut(new StringBuffer(star.name()), c.tjd(), iflag, xx, serr);
      } else if (c.body() instanceof Body.Point point) {
        rc = se.swe_calc_ut(c.tjd(), point.number(), iflag, xx, serr);
      } else {
        throw new IllegalStateException("unhandled body " + c.body());
      }
      return renderLegacy(rc, xx, c.options());
    } finally {
      se.swe_close();
    }
  }

  private static String renderLegacy(int rc, double[] xx, Set<CalcOption> options) {
    if (rc == SweConst.ERR) {
      return "ERR";
    }
    StringBuilder sb = new StringBuilder(ephemerisName(rc));
    sb.append(',').append(Double.toHexString(xx[0]))
      .append(',').append(Double.toHexString(xx[1]))
      .append(',').append(Double.toHexString(xx[2]));
    if (options.contains(CalcOption.SPEED)) {
      sb.append(',').append(Double.toHexString(xx[3]))
        .append(',').append(Double.toHexString(xx[4]))
        .append(',').append(Double.toHexString(xx[5]));
    }
    return sb.toString();
  }

  private static String ephemerisName(int rc) {
    if ((rc & SweConst.SEFLG_JPLEPH) != 0) return "JPL";
    if ((rc & SweConst.SEFLG_SWIEPH) != 0) return "SWISS";
    return "MOSHIER";
  }

  private static String renderModern(CalcResult r) {
    StringBuilder sb = new StringBuilder(r.usedEphemeris().name());
    double a, b, c;
    if (r.position() instanceof Position.Ecliptic e) {
      a = e.longitudeDeg(); b = e.latitudeDeg(); c = e.distanceAu();
    } else if (r.position() instanceof Position.Equatorial q) {
      a = q.rightAscensionDeg(); b = q.declinationDeg(); c = q.distanceAu();
    } else {
      Position.Cartesian xyz = (Position.Cartesian) r.position();
      a = xyz.x(); b = xyz.y(); c = xyz.z();
    }
    sb.append(',').append(Double.toHexString(a))
      .append(',').append(Double.toHexString(b))
      .append(',').append(Double.toHexString(c));
    r.motion().ifPresent(m -> sb.append(',').append(Double.toHexString(m.first()))
                                .append(',').append(Double.toHexString(m.second()))
                                .append(',').append(Double.toHexString(m.third())));
    return sb.toString();
  }

  @Test
  void theNewApiReturnsExactlyWhatTheOldOneReturns() {
    String ephePath = SmokeTestSupport.ephePath();
    List<Case> cases = cases();
    assertTrue(cases.size() > 500, "the matrix collapsed to " + cases.size() + " cases");

    int checked = 0;
    int produced = 0;
    for (Case c : cases) {
      String expected = legacy(ephePath, c);
      // A fresh instance per case on this side too, so neither side carries state from the last.
      String actual;
      try (SwissEphemeris ephemeris = SwissEphemeris.at(ephePath)) {
        actual = renderModern(ephemeris.calculate(
            JulianDayUT.of(c.tjd()), c.body(), c.ephemeris(), c.options(), c.centre(), c.zodiac()));
      } catch (SwissEphemerisException e) {
        actual = "ERR";
      }
      assertEquals(expected, actual,
                   "differs for tjd=" + c.tjd() + " body=" + c.body().displayName()
                   + " eph=" + c.ephemeris() + " opts=" + c.options()
                   + " centre=" + c.centre() + " zodiac=" + c.zodiac());
      checked++;
      if (!"ERR".equals(actual)) {
        produced++;
      }
    }
    assertEquals(cases.size(), checked);
    // Guard against a vacuous pass: if every case errored out, both sides would agree on "ERR"
    // and this test would prove nothing.
    assertTrue(produced > cases.size() * 9 / 10,
               "only " + produced + " of " + cases.size() + " cases produced a position");
  }
}
