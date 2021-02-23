
package swisseph;

/**
* This class implements a TransitCalculator for a planet with a
* house object in relative positions to each other.<p>
* You would create a TransitCalculator from this class and
* use the SwissEph.getTransit() methods to actually calculate
* a transit, e.g.:
* <pre>
* SwissEph sw = new SwissEph(...);
* ...
* int flags = SweConst.SEFLG_SWIEPH |
*             SweConst.SEFLG_TRANSIT_LONGITUDE;
* boolean backwards = true;
* 
* TransitCalculator tc = new TCPlanetHouse(
*                                  sw,
*                                  SweConst.SE_MERCURY,
*                                  SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SIDEREAL,
*                                  SweConst.SE_ASC,
*                                  SweConst.SE_HSYS_PLACIDUS,
*                                  SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SIDEREAL,
*                                  52.22, 11.0, 0
*                                  flags,
*                                  30);
* ...
* double nextTransitUT = sw.getTransitUT(tc, jdUT, backwards);
* </pre>
* This would calculate the last (UT-) date, when Mercury and Venus
* had the same longitudinal position.
*/
public class TCPlanetHouse extends TransitCalculator
        	implements java.io.Serializable
        	{
  int precalcCount = 100;


  private int planet;
  private int idx = 0; // The index into the xx[] array in swe_calc() to use; here only zero is used
  private int transitFlags = 0; // The transit flags; here only SEFLG_TRANSIT_LONGITUDE is used
  private int planetFlags = 0;  // The calculation flags for swe_calc()
  private int houseObject = 0;
  private int houseSystem = 0;
  private int houseFlags = 0;  // The calculation flags for swe_houses(); 0 or SEFLG_SIDEREAL
  private double houseGeolon, houseGeolat;
  private double minSpeed1, maxSpeed1;
  private double minSpeed2, maxSpeed2;
  private double minSpeed, maxSpeed;
  // The y = f(x) value to reach, speaking mathematically...
  private double offset = 0.;



  /**
  * Creates a new TransitCalculator for relative transits of a planet
  * over a house object.<p>
  * When calculating topocentric planet positions, be sure to call
  * sw.swe_set_topo(...), when calculating in sidereal mode call
  * sw.swe_set_sid_mode(...) prior to using this TransitCalculator.<p>
  * Be sure to understand that planet and house calculations use
  * distinct flags with one exception: if both use sidereal mode,
  * both use the same sidereal mode.
  * @param sw A SwissEph object, if you have one available. May be null,
  * if you don't use topocentric or sidereal mode.
  * @param planet The planet number of the transiting planet.<br>
  * Planets from SweConst.SE_SUN up to SweConst.SE_INTP_PERG (with the
  * exception of SweConst.SE_EARTH) have their extreme speeds saved, so
  * these extreme speeds will be used on calculation.<br>Other objects 
  * calculate extreme speeds by randomly calculating by default 200 speed
  * values and multiply them by 1.4 as a safety factor.<br>
  * ATTENTION: be sure to understand that you have some theoretical chance
  * to miss some transit or you might get a rather bad transit time in very
  * rare circumstances when running with randomly calculated extreme speeds.<br>
  * Use SweConst.SE_AST_OFFSET + asteroid number for planets with a
  * planet number not defined by SweConst.SEFLG_*.
  * @param planetFlags The flags for calculation of the planet.<p>
  * These are SweConst.SEFLG_TRANSIT_LONGITUDE and flags modifying
  * the basic planet calculations: SweConst.SEFLG_TOPOCTR,
  * SweConst.SEFLG_EQUATORIAL, SweConst.SEFLG_HELCTR, SweConst.SEFLG_TRUEPOS,
  * and SweConst.SEFLG_SIDEREAL (also effects house object calculation),
  * plus the ephemeris
  * flags SweConst.SEFLG_MOSEPH, SweConst.SEFLG_SWIEPH, or
  * SweConst.SEFLG_JPLEPH optionally.
  * @param houseObject The house object to be transited. One of:
  * <BLOCKQUOTE><CODE>
  * SweConst.SE_HOUSE1<br>
  * ...<br>
  * SweConst.SE_HOUSE12<br>
  * SweConst.SE_ASC<br>
  * SweConst.SE_MC<br>
  * SweConst.SE_ARMC (sidereal time)<br>
  * SweConst.SE_VERTEX,<br>
  * SweConst.SE_EQUASC<br>
  * SweConst.SE_COASC1<br>
  * SweConst.SE_COASC2<br>
  * SweConst.SE_POLASC<br>
  * </CODE></BLOCKQUOTE>
  * @param houseSystem The house system to use. Choose one from:<br>
  * <BLOCKQUOTE><CODE>
  * SweConst.SE_HSYS_PLACIDUS<BR>
  * SweConst.SE_HSYS_KOCH<BR>
  * SweConst.SE_HSYS_PORPHYRIUS<BR>
  * SweConst.SE_HSYS_REGIOMONTANUS<BR>
  * SweConst.SE_HSYS_CAMPANUS<BR>
  * SweConst.SE_HSYS_EQUAL (cusp 1 is ascendant)<BR>
  * SweConst.SE_HSYS_VEHLOW (asc. in middle of house 1)<BR>
  * SweConst.SE_HSYS_MERIDIAN (axial rotation system/ Meridian houses)<BR>
  * SweConst.SE_HSYS_HORIZONTAL (azimuthal or horizontal system)<BR>
  * SweConst.SE_HSYS_POLICH_PAGE ('topocentric' system)<BR>
  * SweConst.SE_HSYS_ALCABITIUS<BR>
//  * SweConst.SE_HSYS_GAUQUELIN_SECTORS<BR>
  * SweConst.SE_HSYS_MORINUS<BR>
  * SweConst.SE_HSYS_KRUSINSKI<BR>
  * SweConst.SE_HSYS_WHOLE_SIGN
  * </CODE></BLOCKQUOTE>
  * @param houseFlags The flags for house calculation (0 or SweConst.SEFLG_SIDEREAL)
  * and optionally SweConst.SEFLG_TRANSIT_LONGITUDE if not yet used in
  * planetFlags
  * @param houseGeolon Longitude for house calculation only
  * @param houseGeolat Latitude for house calculation only
  * @param offset This is the desired transit degree =
  * <code>"position_of_planet - position_of_house_object"</code>.
  * @see swisseph.TCPlanetPlanet#TCPlanetPlanet(SwissEph, int, int, int, double, int, double)
  * @see swisseph.TCPlanet#TCPlanet(SwissEph, int, int, double)
  * @see swisseph.TCHouses#TCHouses(SwissEph, int, int, double, double, int, double)
  * @see swisseph.SweConst#SEFLG_TRANSIT_LONGITUDE
  * @see swisseph.SweConst#SE_AST_OFFSET
  * @see swisseph.SweConst#SEFLG_TOPOCTR
  * @see swisseph.SweConst#SEFLG_EQUATORIAL
  * @see swisseph.SweConst#SEFLG_HELCTR
  * @see swisseph.SweConst#SEFLG_TRUEPOS
  * @see swisseph.SweConst#SEFLG_SIDEREAL
  * @see swisseph.SweConst#SEFLG_MOSEPH
  * @see swisseph.SweConst#SEFLG_SWIEPH
  * @see swisseph.SweConst#SEFLG_JPLEPH
  */
  public TCPlanetHouse(SwissEph sw, int planet, int planetFlags, int houseObject, int houseSystem, int houseFlags, double houseGeolon, double houseGeolat, double offset) {
    this(sw, planet, planetFlags, houseObject, houseSystem, houseFlags, houseGeolon, houseGeolat, offset, 200, 1.4);
  }
  /**
  * Creates a new TransitCalculator for relative transits of a planet
  * over a house object.<p>
  * When calculating topocentric planet positions, be sure to call
  * sw.swe_set_topo(...), when calculating in sidereal mode call
  * sw.swe_set_sid_mode(...) prior to using this TransitCalculator.<p>
  * Be sure to understand that planet and house calculations use
  * distinct flags with one exception: if both use sidereal mode,
  * both use the same sidereal mode.
  * @param sw A SwissEph object, if you have one available. May be null,
  * if you don't use topocentric or sidereal mode.
  * @param planet The planet number of the transiting planet.<br>
  * Planets from SweConst.SE_SUN up to SweConst.SE_INTP_PERG (with the
  * exception of SweConst.SE_EARTH) have their extreme speeds saved, so
  * these extreme speeds will be used on calculation.<br>Other objects 
  * calculate extreme speeds by randomly calculating by default 200 speed
  * values and multiply them by 1.4 as a safety factor.<br>
  * ATTENTION: be sure to understand that you have some theoretical chance
  * to miss some transit or you might get a rather bad transit time in very
  * rare circumstances when running with randomly calculated extreme speeds.<br>
  * Use SweConst.SE_AST_OFFSET + asteroid number for planets with a
  * planet number not defined by SweConst.SEFLG_*.
  * @param planetFlags The flags for calculation of the planet.<p>
  * These are SweConst.SEFLG_TRANSIT_LONGITUDE and flags modifying
  * the basic planet calculations: SweConst.SEFLG_TOPOCTR,
  * SweConst.SEFLG_EQUATORIAL, SweConst.SEFLG_HELCTR, SweConst.SEFLG_TRUEPOS,
  * and SweConst.SEFLG_SIDEREAL (also effects house object calculation),
  * plus the ephemeris
  * flags SweConst.SEFLG_MOSEPH, SweConst.SEFLG_SWIEPH, or
  * SweConst.SEFLG_JPLEPH optionally.
  * @param houseObject The house object to be transited. One of:
  * <BLOCKQUOTE><CODE>
  * SweConst.SE_HOUSE1<br>
  * ...<br>
  * SweConst.SE_HOUSE12<br>
  * SweConst.SE_ASC<br>
  * SweConst.SE_MC<br>
  * SweConst.SE_ARMC (sidereal time)<br>
  * SweConst.SE_VERTEX,<br>
  * SweConst.SE_EQUASC<br>
  * SweConst.SE_COASC1<br>
  * SweConst.SE_COASC2<br>
  * SweConst.SE_POLASC<br>
  * </CODE></BLOCKQUOTE>
  * @param houseSystem The house system to use. Choose one from:<br>
  * <BLOCKQUOTE><CODE>
  * SweConst.SE_HSYS_PLACIDUS<BR>
  * SweConst.SE_HSYS_KOCH<BR>
  * SweConst.SE_HSYS_PORPHYRIUS<BR>
  * SweConst.SE_HSYS_REGIOMONTANUS<BR>
  * SweConst.SE_HSYS_CAMPANUS<BR>
  * SweConst.SE_HSYS_EQUAL (cusp 1 is ascendant)<BR>
  * SweConst.SE_HSYS_VEHLOW (asc. in middle of house 1)<BR>
  * SweConst.SE_HSYS_MERIDIAN (axial rotation system/ Meridian houses)<BR>
  * SweConst.SE_HSYS_HORIZONTAL (azimuthal or horizontal system)<BR>
  * SweConst.SE_HSYS_POLICH_PAGE ('topocentric' system)<BR>
  * SweConst.SE_HSYS_ALCABITIUS<BR>
//  * SweConst.SE_HSYS_GAUQUELIN_SECTORS<BR>
  * SweConst.SE_HSYS_MORINUS<BR>
  * SweConst.SE_HSYS_KRUSINSKI<BR>
  * SweConst.SE_HSYS_WHOLE_SIGN
  * </CODE></BLOCKQUOTE>
  * @param houseFlags The flags for house calculation (0 or SweConst.SEFLG_SIDEREAL)
  * and optionally SweConst.SEFLG_TRANSIT_LONGITUDE if not yet used in
  * planetFlags
  * @param houseGeolon Longitude for house calculation only
  * @param houseGeolat Latitude for house calculation only
  * @param offset This is the desired transit degree =
  * <code>"position_of_planet - position_of_house_object"</code>.
  * @param precalcCount Only for objects without known extreme speeds
  * (esp. asteroids or similar): count of random calculations to determine
  * the maximum and minimum speed of the planet or house system. Defaults
  * to 200 calculations, minimum will be 100 calculations.
  * @param precalcSafetyfactor Only for objects without known extreme speeds
  * (esp. asteroids or similar): increase the calculated random speeds
  * by multiplying them with this safety factor. Defaults to 1.4, minimum will be 1.1.
  * @see swisseph.TCPlanetPlanet#TCPlanetPlanet(SwissEph, int, int, int, double, int, double)
  * @see swisseph.TCPlanet#TCPlanet(SwissEph, int, int, double)
  * @see swisseph.TCHouses#TCHouses(SwissEph, int, int, double, double, int, double)
  * @see swisseph.SweConst#SEFLG_TRANSIT_LONGITUDE
  * @see swisseph.SweConst#SE_AST_OFFSET
  * @see swisseph.SweConst#SEFLG_TOPOCTR
  * @see swisseph.SweConst#SEFLG_EQUATORIAL
  * @see swisseph.SweConst#SEFLG_HELCTR
  * @see swisseph.SweConst#SEFLG_TRUEPOS
  * @see swisseph.SweConst#SEFLG_SIDEREAL
  * @see swisseph.SweConst#SEFLG_MOSEPH
  * @see swisseph.SweConst#SEFLG_SWIEPH
  * @see swisseph.SweConst#SEFLG_JPLEPH
  */
  public TCPlanetHouse(SwissEph sw, int planet, int planetFlags, int houseObject, int houseSystem, int houseFlags, double houseGeolon, double houseGeolat, double offset, int precalcCount, double precalcSafetyfactor) {
    this.sw = sw;
    if (this.sw == null) {
      this.sw = new SwissEph();
    }

    // Check parameter: //////////////////////////////////////////////////////
    precalcCount = Math.max(precalcCount, 100);
    precalcSafetyfactor = Math.max(precalcSafetyfactor, 1.1);

    // List of all valid flags:
    this.transitFlags = ((planetFlags | houseFlags) & SweConst.SEFLG_TRANSIT_LONGITUDE);

    // Check planet flags:
    int vPlFlags = SweConst.SEFLG_EPHMASK |
                 SweConst.SEFLG_TOPOCTR |
                 SweConst.SEFLG_EQUATORIAL |
                 SweConst.SEFLG_HELCTR |
                 SweConst.SEFLG_NOABERR |
                 SweConst.SEFLG_NOGDEFL |
                 SweConst.SEFLG_SIDEREAL |
                 SweConst.SEFLG_TRUEPOS |
                 SweConst.SEFLG_TRANSIT_LONGITUDE;
    // NOABERR and NOGDEFL is allowed for HELCTR, as they get set
    // anyway.
    if ((planetFlags & SweConst.SEFLG_HELCTR) != 0) {
      vPlFlags |= SweConst.SEFLG_NOABERR | SweConst.SEFLG_NOGDEFL;
    }
    if ((planetFlags&~vPlFlags) != 0) {
      throw new IllegalArgumentException("Invalid flag(s): "+(planetFlags&~vPlFlags));
    }


    // Allow SEFLG_TRANSIT_LONGITUDE only
    if (this.transitFlags != SweConst.SEFLG_TRANSIT_LONGITUDE) {
      throw new IllegalArgumentException("Invalid flag combination (" + planetFlags + " or " + houseFlags + ")" +
        ": only SEFLG_TRANSIT_LONGITUDE (" +
        SweConst.SEFLG_TRANSIT_LONGITUDE + ") is allowed as transit method.");
    }
    if ((planetFlags & SweConst.SEFLG_HELCTR) != 0 &&
        (planet == SweConst.SE_MEAN_APOG ||
         planet == SweConst.SE_OSCU_APOG ||
         planet == SweConst.SE_MEAN_NODE ||
         planet == SweConst.SE_TRUE_NODE)) {
      throw new IllegalArgumentException(
          "Unsupported planet number " + planet + " (" +
              sw.swe_get_planet_name(planet) + ") for heliocentric " +
              "calculations");
    }



    // Check house flags:
    int vHFlags = SweConst.SEFLG_EPHMASK |  // don't care
                 SweConst.SEFLG_SIDEREAL |
                 SweConst.SEFLG_TOPOCTR |	// don't care
                 SweConst.SEFLG_TRANSIT_LONGITUDE;
    if ((houseFlags&~vHFlags) != 0) {
      throw new IllegalArgumentException("Invalid flag(s): "+(houseFlags&~vHFlags));
    }
    int object = houseObject&(SweConst.SE_HOUSE1 |
        SweConst.SE_HOUSE2 |
        SweConst.SE_HOUSE3 |
        SweConst.SE_HOUSE4 |
        SweConst.SE_HOUSE5 |
        SweConst.SE_HOUSE6 |
        SweConst.SE_HOUSE7 |
        SweConst.SE_HOUSE8 |
        SweConst.SE_HOUSE9 |
        SweConst.SE_HOUSE10 |
        SweConst.SE_HOUSE11 |
        SweConst.SE_HOUSE12 |
        SweConst.SE_ASC |
        SweConst.SE_MC |
        SweConst.SE_ARMC |
        SweConst.SE_VERTEX |
        SweConst.SE_EQUASC |
        SweConst.SE_COASC1 |
        SweConst.SE_COASC2 |
        SweConst.SE_POLASC);
    if (object != SweConst.SE_HOUSE1 &&
        object != SweConst.SE_HOUSE2 &&
        object != SweConst.SE_HOUSE3 &&
        object != SweConst.SE_HOUSE4 &&
        object != SweConst.SE_HOUSE5 &&
        object != SweConst.SE_HOUSE6 &&
        object != SweConst.SE_HOUSE7 &&
        object != SweConst.SE_HOUSE8 &&
        object != SweConst.SE_HOUSE9 &&
        object != SweConst.SE_HOUSE10 &&
        object != SweConst.SE_HOUSE11 &&
        object != SweConst.SE_HOUSE12 &&
        object != SweConst.SE_ASC &&
        object != SweConst.SE_MC &&
        object != SweConst.SE_ARMC &&
        object != SweConst.SE_VERTEX &&
        object != SweConst.SE_EQUASC &&
        object != SweConst.SE_COASC1 &&
        object != SweConst.SE_COASC2 &&
        object != SweConst.SE_POLASC) {
      throw new IllegalArgumentException("Invalid or multiple house objects given: " + object);
    }
    if (houseSystem != SweConst.SE_HSYS_PLACIDUS &&
        houseSystem != SweConst.SE_HSYS_KOCH &&
        houseSystem != SweConst.SE_HSYS_PORPHYRIUS &&
        houseSystem != SweConst.SE_HSYS_REGIOMONTANUS &&
        houseSystem != SweConst.SE_HSYS_CAMPANUS &&
        houseSystem != SweConst.SE_HSYS_EQUAL &&
        houseSystem != SweConst.SE_HSYS_VEHLOW &&
        houseSystem != SweConst.SE_HSYS_MERIDIAN &&
        houseSystem != SweConst.SE_HSYS_HORIZONTAL &&
        houseSystem != SweConst.SE_HSYS_POLICH_PAGE &&
        houseSystem != SweConst.SE_HSYS_ALCABITIUS &&
//        houseSystem != SweConst.SE_HSYS_GAUQUELIN_SECTORS &&
        houseSystem != SweConst.SE_HSYS_MORINUS &&
        houseSystem != SweConst.SE_HSYS_KRUSINSKI &&
        houseSystem != SweConst.SE_HSYS_WHOLE_SIGN) {
      throw new IllegalArgumentException(
          "Unsupported house system '" + houseSystem + "'.");
    }


    // Eliminate SEFLG_TRANSIT_* flags for use in swe_calc():
    planetFlags &= ~(SweConst.SEFLG_TRANSIT_LONGITUDE);

    // Eliminate SEFLG_TRANSIT_* flags for use in swe_houses():
    houseFlags &= ~(SweConst.SEFLG_TRANSIT_LONGITUDE);

    this.planet = planet;
    this.planetFlags = planetFlags;
    this.houseObject = houseObject;
    this.houseSystem = houseSystem;
    this.houseFlags = houseFlags;
    this.houseGeolon = houseGeolon;
    this.houseGeolat = houseGeolat;

    // Calculate basic parameters: ///////////////////////////////////////////
    rollover = true;

    this.offset = offset;

    maxSpeed1=getSpeed(false,planet);
    minSpeed1=getSpeed(true,planet);
    maxSpeed2=TransitBase.getHouseSpeed(false,houseSystem,houseObject,houseGeolat);
    minSpeed2=TransitBase.getHouseSpeed(true,houseSystem,houseObject,houseGeolat);
//System.err.println(minSpeed1 + " -> " + maxSpeed1 + ", " + minSpeed2 + " -> " + maxSpeed2);
    if (Double.isInfinite(maxSpeed1) || Double.isInfinite(minSpeed1)) {
    // Trying to find some reasonable min- and maxSpeed by randomly testing some speed values.
    // Limited to ecliptical(?) non-speed calculations so far:
      if (idx < 3) {
        double[] minmax = getTestspeed(planet, idx, precalcCount, precalcSafetyfactor);
        minSpeed1 = minmax[0];
        maxSpeed1 = minmax[1];
// System.err.println("testspeed: " + minSpeed1 / precalcSafetyfactor + " .. " + maxSpeed1 / precalcSafetyfactor);
      }
    }

    if (Double.isInfinite(maxSpeed1) || Double.isInfinite(minSpeed1)) {
      throw new IllegalArgumentException(
          ((planetFlags&SweConst.SEFLG_TOPOCTR)!=0?"Topo":((planetFlags&SweConst.SEFLG_HELCTR)!=0?"Helio":"Geo")) +
          "centric transit calculations with planet number " + planet + " ("+
          sw.swe_get_planet_name(planet) + ") not possible: extreme speeds" +
          " of the planet " +
          ((planetFlags & SweConst.SEFLG_EQUATORIAL) != 0 ? "in equatorial system " : "") +
          "not available.");
    }


    if (Double.isInfinite(maxSpeed2) || Double.isInfinite(minSpeed2)) {	// Shouldn't happen...
//      // Trying to find some reasonable min- and maxSpeed by randomly testing some speed values.
//      // Limited to ecliptical(?) non-speed calculations so far:
//      if (idx < 3) {
//        double[] minmax = getTestspeedHouse(pl2, idx, precalcCount, precalcSafetyfactor);
//        minSpeed2 = minmax[0];
//        maxSpeed2 = minmax[1];
//      }
    }

    if (Double.isInfinite(maxSpeed2) || Double.isInfinite(minSpeed2)) {
      throw new IllegalArgumentException(
          ((houseFlags&SweConst.SEFLG_TOPOCTR)!=0?"Topo":((houseFlags&SweConst.SEFLG_HELCTR)!=0?"Helio":"Geo")) +
          "centric transit calculations with house object " + houseObject + " ("+
          SwissEph.getHouseobjectname(houseObject) + ") not possible: extreme " +
          ((houseFlags & SweConst.SEFLG_SPEED) != 0 ? "accelerations" : "speeds") +
          " of the house system " +
          ((houseFlags & SweConst.SEFLG_EQUATORIAL) != 0 ? "in equatorial system " : "") +
          "not available.");
    }

    minSpeed = (maxSpeed1>maxSpeed2)?minSpeed1-maxSpeed2:minSpeed2-maxSpeed1;
    maxSpeed = (maxSpeed1>maxSpeed2)?maxSpeed1-minSpeed2:maxSpeed2-minSpeed1;

    sw.swe_set_topo(houseGeolon, houseGeolat, 0);
  }


  /**
  * @return Returns true, if one position value is identical to another
  * position value. E.g., 360 degree is identical to 0 degree in
  * circle angles.
  * @see #rolloverVal
  */
  public boolean getRollover() {
    return rollover;
  }
  /**
  * This sets the transit degree for the difference of the positions of the
  * house object minus planet. It will be used on the next call to getTransit().
  * @param value The offset value.
  * @see #getOffset()
  */
  public void setOffset(double value) {
    offset = value;
  }
  /**
  * This returns the transit degree of the relative position of the planets
  * and the house object.
  * @return The current offset value.
  * @see #setOffset(double)
  */
  public double getOffset() {
    return offset;
  }
  /**
  * This returns the planet number, the house object, and the house system
  * as Strings.
  * @return An array of identifiers identifying the calculated objects.
  */
  public Object[] getObjectIdentifiers() {
    return new String[]{"" + planet, "" + houseObject, "" + houseSystem};
  }



///////////////////////////////////////////////////////////////////////////////
  protected double getMaxSpeed() {
    return maxSpeed;
  }
  protected double getMinSpeed() {
    return minSpeed;
  }

  protected double calc(double jdET) {
    StringBuffer serr = new StringBuffer();
    double[] xx = new double[6];

    double[] cusps = new double[(this.houseSystem == SweConst.SE_HSYS_GAUQUELIN_SECTORS ? 37 : 13)];
    double[] ascmc = new double[10];


    // Planet calculation:
    int ret = sw.swe_calc(jdET, planet, planetFlags, xx, serr);
    if (ret<0) {
      int type = SwissephException.UNDEFINED_ERROR;
      if (serr.toString().matches("jd 2488117.1708818264 > Swiss Eph. upper limit 2487932.5;")) {
        type = SwissephException.BEYOND_USER_TIME_LIMIT;
      }
System.err.println("SERR: " + serr);
      throw new SwissephException(jdET, type,
            "Calculation failed with return code " + ret + ":\n" +
            serr.toString());
    }


    // House calculation:
    ret = sw.swe_houses(jdET - SweDate.getDeltaT(jdET), houseFlags, houseGeolat, houseGeolon, houseSystem, cusps, ascmc);

    if (ret<0) {
      throw new SwissephException(jdET, SwissephException.UNDEFINED_ERROR,
            "Calculation failed with return code "+ret+".");
    }
    double h = 0;
    if (houseObject < 0) {	// Houses have negative index
      h = cusps[Math.abs(houseObject)];
    } else {
      h = ascmc[houseObject];
    }

    return xx[0] - h;
  }



  protected double getTimePrecision(double degPrec) {
    // Recalculate degPrec to mean the minimum  time, in which the planet can
    // possibly move that degree:
    double amin = SMath.min(SMath.abs(minSpeed1),SMath.abs(minSpeed2));
    double amax = SMath.min(SMath.abs(maxSpeed1),SMath.abs(maxSpeed2));

    double maxVal = SMath.max(SMath.abs(amin),SMath.abs(amax));
    if (maxVal != 0.) {
      return degPrec / maxVal;
    }
    return 1E-9;
  }

  protected double getDegreePrecision(double jd) {
    // Calculate the planet's minimum movement regarding the maximum available
    // precision.
    //
    // For all calculations, we assume the following minimum exactnesses
    // based on the discussions on http://www.astro.com/swisseph, even though
    // these values are nothing more than very crude estimations which should
    // leave us on the save side always, even more, when seeing that we always
    // consider the maximum possible speed / acceleration of a planet in the
    // transit calculations and not the real speed.
    //
    // Take degPrec to be the minimum exact degree in longitude
    double degPrec = 0.005;
    if (idx>2) { // Speed
      // "The speed precision is now better than 0.002" for all planets"
      degPrec = 0.002;
    } else { // Degrees
      // years 1980 to 2099:              0.005"
      // years before 1980:               0.08"   (from sun to jupiter)
      // years 1900 to 1980:              0.08"   (from saturn to neptune) (added: nodes)
      // years before 1900:               1"      (from saturn to neptune) (added: nodes)
      // years after 2099:                same as before 1900
      //
      if (planet>=SweConst.SE_SUN && planet<=SweConst.SE_JUPITER) {
        if (jd<1980 || jd>2099) {
          degPrec = 0.08;
        }
      } else {
        if (jd>=1900 && jd<1980) {
          degPrec = 0.08;
        } else if (jd<1900 || jd>2099) { // Unclear about true nodes...
          degPrec = 1;
        }
      }
//    if (pl2>=SweConst.SE_SUN && pl2<=SweConst.SE_JUPITER) {
//      if (jd<1980 || jd>2099) {
//        degPrec = SMath.max(0.08,degPrec);
//      }
//    } else {
//      if (jd>=1900 && jd<1980) {
//        degPrec = SMath.max(0.08,degPrec);
//      } else if (jd<1900 || jd>2099) { // Unclear about true nodes...
//        degPrec = SMath.max(1,degPrec);
//      }
//    }
    }
    degPrec/=3600.;
    degPrec*=0.5; // We take the precision to be BETTER THAN ... as it is stated somewhere

    return degPrec;

    // Barycentre:
    //            0.981683040      1.017099581  (Barycenter of the earth!)
    // Sun:       0.982747149 AU   1.017261973 AU
    // Moon:      0.980136691 AU   1.019846623 AU
    // Mercury:   0.307590579 AU   0.466604085 AU
    // Venus:     0.717960758 AU   0.728698831 AU
    // Mars:      1.382830768 AU   0.728698831 AU
    // Jupiter:   5.448547595 AU   4.955912195 AU
    // Saturn:   10.117683425 AU   8.968685733 AU
    // Uranus:   18.327870391 AU  19.893326756 AU
    // Neptune:  29.935653168 AU  30.326750627 AU
    // Pluto:    29.830132096 AU  41.499626899 AU
    // MeanNode:  0.002569555 AU   0.002569555 AU
    // TrueNode:  0.002361814 AU   0.002774851 AU

  }


//////////////////////////////////////////////////////////////////////////////


  private double getSpeed(boolean min, int planet) {
    boolean lon = ((transitFlags&SweConst.SEFLG_TRANSIT_LONGITUDE) != 0);
    boolean topo = ((planetFlags&SweConst.SEFLG_TOPOCTR) != 0);
    boolean helio = ((planetFlags&SweConst.SEFLG_HELCTR) != 0);
    boolean rect = ((planetFlags&SweConst.SEFLG_EQUATORIAL) != 0);

    try {
      // Some topocentric speeds are very different to the geocentric
      // speeds, so we use other values than for geocentric calculations:
      if (topo) {
        if (!sw.swed.geopos_is_set) {
          throw new IllegalArgumentException("Geographic position is not set for "+
                                             "requested topocentric calculations.");
        }
//        if (sw.swed.topd.geoalt>50000.) {
//          throw new IllegalArgumentException("Topocentric transit calculations "+
//                                             "are restricted to a maximum "+
//                                             "altitude of 50km so far.");
//        } else if (sw.swed.topd.geoalt<-12000000) {
//          throw new IllegalArgumentException("Topocentric transit calculations "+
//                                             "are restricted to a minimum "+
//                                             "altitude of -12000km so far.");
//        }
        if (sw.swed.topd.geoalt>50000. || sw.swed.topd.geoalt<-12000000) {
          return 1./0.;
        }
        if (rect) {
          return (min?SwephData.minTopoRectSpeed[planet]:SwephData.maxTopoRectSpeed[planet]);
        } else if (lon) {
          return (min?SwephData.minTopoLonSpeed[planet]:SwephData.maxTopoLonSpeed[planet]);
        }
      }

      // Heliocentric speeds are very different to the geocentric speeds, so
      // we use other values than for geocentric calculations:
      if (helio) {
        if (rect) {
          return (min?SwephData.minHelioRectSpeed[planet]:SwephData.maxHelioRectSpeed[planet]);
        } else if (lon) {
          return (min?SwephData.minHelioLonSpeed[planet]:SwephData.maxHelioLonSpeed[planet]);
        }
      }

      // Geocentric:
      if (rect) {
        return (min?SwephData.minRectSpeed[planet]:SwephData.maxRectSpeed[planet]);
      } else if (lon) {
        return (min?SwephData.minLonSpeed[planet]:SwephData.maxLonSpeed[planet]);
      }
      return 1./0.;
    } catch (Exception e) {
      return 1./0.;
    }
  }

  protected boolean checkIdenticalResult(double offset, double val) {
    return val == offset;
  }


  // This routine returns extreme speed values by randomly calculating the speed
  // of the planet. Doesn't work for accelerations so far.
  double[] getTestspeed(int planet, int idx, int precalcCount, double precalcSafetyfactor) {
    StringBuffer serr = new StringBuffer();
    double min = Double.MAX_VALUE;
    double max = -Double.MAX_VALUE;

    double[] timerange = new double[] { SwephData.MOSHPLEPH_START, SwephData.MOSHPLEPH_END };
    if (planet > SweConst.SE_AST_OFFSET) {
      // get filename:
      String fn = SwissLib.swi_gen_filename(2457264.5 /* don't care */, planet);
      // Unfortunately, the name from swi_gen_filename may be slightly different,
      // so we have to test opening the filename and change the filename if
      // the file does not exist or is not readable:
      FilePtr fptr = null;
      SwissephException se = null;
      try {
        fptr = sw.swi_fopen(SwephData.SEI_FILE_ANY_AST, fn, sw.swed.ephepath, serr);
      } catch (SwissephException se1) {
        se = se1;
      }
      if (fptr == null) {
        /*
         * try also for short files (..s.se1)
         */
        if (fn.indexOf("s.") <= 0) {
          fn = fn.substring(0, fn.indexOf(".")) + "s." + SwephData.SE_FILE_SUFFIX;
        }
        try {
          fptr = sw.swi_fopen(SwephData.SEI_FILE_ANY_AST, fn, sw.swed.ephepath, serr);
        } catch (SwissephException se2) {
          se = se2;
        }
      }
      if (fptr == null) {
          throw se;
      }
      try {
        fptr.close();
      } catch (Exception e) { }

      // Now finally we have a filename for which we can get the time range,
      // if the file can be found and is readable:
      try {
        timerange = sw.getDatafileTimerange(fn);
      } catch (SwissephException se3) {
      }
    }

    java.util.Random rd = new java.util.Random();
    double[] xx = new double[6];
    for(int f = 0; f < precalcCount; f++) {
      double jdET = rd.nextDouble();
      jdET = jdET * (timerange[1] - timerange[0]) + timerange[0];
      int ret = sw.swe_calc(jdET, planet, planetFlags | SweConst.SEFLG_SPEED, xx, serr);
      if (ret<0) {
//              throw new SwissephException(jdET, SwissephException.UNDEFINED_ERROR,
//                  "Calculation failed with return code "+ret+":\n"+serr.toString());
            continue;
      }
      if (min > xx[idx+3]) { min = xx[idx+3]; }
      if (max < xx[idx+3]) { max = xx[idx+3]; }
    }
    if (min == max || min == Double.MAX_VALUE || max == -Double.MAX_VALUE) {
      min = 1./0.;  // Use as flag
    } else {
      // Apply safety factor for randomly calculated extreme speeds:
      switch ((int)Math.signum(min)) {
        case -1 : min *= precalcSafetyfactor; break;
        case  0 : min = -0.1; break;
        case  1 : min /= precalcSafetyfactor; break;
      }
      switch ((int)Math.signum(max)) {
        case -1 : max /= precalcSafetyfactor; break;
        case  0 : max = 0.1; break;
        case  1 : max *= precalcSafetyfactor; break;
      }
    }
    return new double[] {min, max};
  }

  public String toString() {
    return "[Planet/house/house system:" + planet + "/" + houseObject + "/" + houseSystem + "];Offset:" + getOffset();
  }
}
