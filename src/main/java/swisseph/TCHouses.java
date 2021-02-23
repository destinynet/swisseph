package swisseph;

/**
* This class implements a TransitCalculator for ascendant and
* other house aspects.<p>
* You would create a TransitCalculator from this class and
* use the SwissEph.getTransit() methods to actually calculate
* a transit, e.g.:
* <pre>
* SwissEph sw = new SwissEph(...);
* ...
* int flags = SweConst.SEFLG_TRANSIT_LONGITUDE;
* boolean backwards = false;
* 
* TransitCalculator tc = new TCHouses(
*                                  sw,
*                                  SweConst.SE_ASC,
*                                  SweConst.SE_HSYS_PLACIDUS,
*                                  52.22, 11.0, 0
*                                  flags,
*                                  30);
* ...
* double nextTransitUT = sw.getTransitUT(tc, jdUT, backwards);
* </pre>
* This would calculate the (UT-) date, when the ascendant is at 30 degree
* longitude next time.
*/
public class TCHouses extends TransitCalculator
    implements java.io.Serializable
    {

  private int houseObject;
  private double geolon, geolat;
  private int hsys;
  private int idx = 0; // The index into the xx[] array in swe_calc() to use:
  private int tflags = 0; // The transit flags
  private  int flags = 0;  // The calculation flags for swe_calc()
  private  double min = 0;
  private  double max = 0;
  // The y = f(x) value to reach, mathematically spoken...
  private double offset = 0.;



double minVal = 0., maxVal = 0.;  // Thinking about it...


  /**
  * Creates a new TransitCalculator for transits of any house cusps or
  * ascendant, mc, armc, vertex, equasc ("equatorial ascendant"),
  * coasc1 ("co-ascendant" (W. Koch)), coasc2 ("co-ascendant" (M. Munkasey)),
  * polasc ("polar ascendant") in the tropical or sidereal zodiac.<p>
  * @param sw A SwissEph object, if you have one available. May be null,
  * if you don't use sidereal mode.<br>
  * Be sure to set sidereal mode on the SwissEph object before trying to
  * calculate a transit if using sidereal mode.
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
  * @param hsys The house system to use. Choose one from:<br>
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
  * @param geolon Longitude for house calculation
  * @param geolat Latitude for house calculation
  * @param flags The calculation type flags (SweConst.SEFLG_TRANSIT_LONGITUDE
  * only). Optionally flags modifying the basic planet calculations, this is
  * SweConst.SEFLG_SIDEREAL only.
  * @param offset This is the desired transit degree.
  * @see swisseph.TCPlanetPlanet#TCPlanetPlanet(SwissEph, int, int, int, double)
  * @see swisseph.TCPlanet#TCPlanet(SwissEph, int, int, double)
  * @see swisseph.SweConst#SEFLG_TRANSIT_LONGITUDE
  * @see swisseph.SweConst#SEFLG_SIDEREAL
  * @see swisseph.SweConst#SE_HOUSE1
  * @see swisseph.SweConst#SE_HOUSE2
  * @see swisseph.SweConst#SE_HOUSE3
  * @see swisseph.SweConst#SE_HOUSE4
  * @see swisseph.SweConst#SE_HOUSE5
  * @see swisseph.SweConst#SE_HOUSE6
  * @see swisseph.SweConst#SE_HOUSE7
  * @see swisseph.SweConst#SE_HOUSE8
  * @see swisseph.SweConst#SE_HOUSE9
  * @see swisseph.SweConst#SE_HOUSE10
  * @see swisseph.SweConst#SE_HOUSE11
  * @see swisseph.SweConst#SE_HOUSE12
  * @see swisseph.SweConst#SE_ASC
  * @see swisseph.SweConst#SE_MC
  * @see swisseph.SweConst#SE_ARMC
  * @see swisseph.SweConst#SE_VERTEX
  * @see swisseph.SweConst#SE_EQUASC
  * @see swisseph.SweConst#SE_COASC1
  * @see swisseph.SweConst#SE_COASC2
  * @see swisseph.SweConst#SE_POLASC
  * @see swisseph.SweConst#SE_HSYS_PLACIDUS
  * @see swisseph.SweConst#SE_HSYS_KOCH
  * @see swisseph.SweConst#SE_HSYS_PORPHYRIUS
  * @see swisseph.SweConst#SE_HSYS_REGIOMONTANUS
  * @see swisseph.SweConst#SE_HSYS_CAMPANUS
  * @see swisseph.SweConst#SE_HSYS_EQUAL
  * @see swisseph.SweConst#SE_HSYS_VEHLOW
  * @see swisseph.SweConst#SE_HSYS_MERIDIAN
  * @see swisseph.SweConst#SE_HSYS_HORIZONTAL
  * @see swisseph.SweConst#SE_HSYS_POLICH_PAGE
  * @see swisseph.SweConst#SE_HSYS_ALCABITIUS
//  * @see swisseph.SweConst#SE_HSYS_GAUQUELIN_SECTORS
  * @see swisseph.SweConst#SE_HSYS_MORINUS
  * @see swisseph.SweConst#SE_HSYS_KRUSINSKI
  * @see swisseph.SweConst#SE_HSYS_WHOLE_SIGN
  */
  public TCHouses(SwissEph sw, int houseObject, int hsys, double geolon, double geolat, int flags, double offset) {
    // Check parameter: //////////////////////////////////////////////////////
    // List of all valid flags:
    this.houseObject = houseObject;
    this.geolon = geolon;
    this.geolat = geolat;

    this.tflags = flags;
    int vFlags = SweConst.SEFLG_EPHMASK |  // don't care
                 SweConst.SEFLG_SIDEREAL |
                 SweConst.SEFLG_TOPOCTR |	// don't care
                 SweConst.SEFLG_TRANSIT_LONGITUDE;
    if ((flags&~vFlags) != 0) {
      throw new IllegalArgumentException("Invalid flag(s): "+(flags&~vFlags));
    }

    // Allow only SEFLG_TRANSIT_LONGITUDE:
    int type = flags&(SweConst.SEFLG_TRANSIT_LONGITUDE);
    if (type != SweConst.SEFLG_TRANSIT_LONGITUDE &&
        type != 0) {
      throw new IllegalArgumentException("Invalid flag '" + flags +
        "': specify exactly one of SEFLG_TRANSIT_LONGITUDE (" +
        SweConst.SEFLG_TRANSIT_LONGITUDE + ").");
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
      throw new IllegalArgumentException("Invalid or multiple objects given: " + object);
    }
    if (hsys != SweConst.SE_HSYS_PLACIDUS &&
        hsys != SweConst.SE_HSYS_KOCH &&
        hsys != SweConst.SE_HSYS_PORPHYRIUS &&
        hsys != SweConst.SE_HSYS_REGIOMONTANUS &&
        hsys != SweConst.SE_HSYS_CAMPANUS &&
        hsys != SweConst.SE_HSYS_EQUAL &&
        hsys != SweConst.SE_HSYS_VEHLOW &&
        hsys != SweConst.SE_HSYS_MERIDIAN &&
        hsys != SweConst.SE_HSYS_HORIZONTAL &&
        hsys != SweConst.SE_HSYS_POLICH_PAGE &&
        hsys != SweConst.SE_HSYS_ALCABITIUS &&
//        hsys != SweConst.SE_HSYS_GAUQUELIN_SECTORS &&
        hsys != SweConst.SE_HSYS_MORINUS &&
        hsys != SweConst.SE_HSYS_KRUSINSKI &&
        hsys != SweConst.SE_HSYS_WHOLE_SIGN) {
      throw new IllegalArgumentException(
          "Unsupported house system '" + hsys + "'.");
    }

    this.hsys = hsys;

    this.sw = sw;
    if (this.sw == null) {
      this.sw = new SwissEph();
    }


    // Eliminate SEFLG_TRANSIT_* flags for use in swe_houses():
    flags &= ~(SweConst.SEFLG_TRANSIT_LONGITUDE);
    this.flags = flags;

    rollover = true;

    this.offset = checkOffset(offset);

    max = TransitBase.getHouseSpeed(false, hsys, object, geolat);
    min = TransitBase.getHouseSpeed(true, hsys, object, geolat);
    if (Double.isInfinite(max) || Double.isInfinite(min)) {
      throw new IllegalArgumentException(
          ((flags&SweConst.SEFLG_TOPOCTR)!=0?"Topo":((flags&SweConst.SEFLG_HELCTR)!=0?"Helio":"Geo")) +
          "centric transit calculations of " + SwissEph.getHouseobjectname(houseObject) +
          " not possible: extreme speeds of the object not available.");
    }
    if (max == 0 && min == 0) {
      throw new IllegalArgumentException(
          "Transit calculation of " + SwissEph.getHouseobjectname(houseObject) + " on latitude of " + geolat +
          " with house system '" + hsys + "' not possible.");
    }
  }

  /**
  * @return Returns true, if one position value is identical to another
  * position value. E.g., 360 degree is identical to 0 degree in
  * circular angles.
  * @see #rolloverVal
  */
  public boolean getRollover() {
    return rollover;
  }
  /**
  * This sets the degree or other value for the position or speed of
  * the planet to transit. It will be used on the next call to getTransit().
  * @param value The desired offset value.
  * @see #getOffset()
  */
  public void setOffset(double value) {
    offset = checkOffset(value);
  }
  /**
  * This returns the degree or other value of the position or speed of
  * the planet to transit.
  * @return The currently set offset value.
  * @see #setOffset(double)
  */
  public double getOffset() {
    return offset;
  }
  /**
  * This sets the longitude and latitude for the house calculations.
  * It will be used on the next call to getTransit().
  * @param geolon The longitude used by the calculations. Western
  * positions have values less than zero, eastern positions use
  * positive values.
  * @param geolat The latitude to be used by the calculations.
  * Nothern positions are positive, southern negative.
  * @see #getLongitude()
  * @see #getLatitude()
  */
  public void setGeopos(double geolon, double geolat) {
    this.geolon = geolon;
    this.geolat = geolat;
  }
  /**
  * This returns the longitudinal position used by the house
  * calculations.
  * @return The currently used longitudinal value.
  * @see #setGeopos(double, double)
  */
  public double getLongitude() {
    return this.geolon;
  }
  /**
  * This returns the latitudinal position used by the house
  * calculations.
  * @return The currently used latitudinal value.
  * @see #getLongitude()
  * @see #setGeopos(double, double)
  */
  public double getLatitude() {
    return this.geolat;
  }
  /**
  * This returns the object number as an Integer object.
  * @return An array of identifiers identifying the calculated objects.
  */
  public Object[] getObjectIdentifiers() {
    return new Integer[]{houseObject};
  }




  //////////////////////////////////////////////////////////////////////////////

  protected double calc(double jd) {
    double[] cusps = new double[(this.hsys == SweConst.SE_HSYS_GAUQUELIN_SECTORS ? 37 : 13)];
    double[] ascmc = new double[10];


    sw.swe_set_topo(geolon, geolat, 0);
    int ret = sw.swe_houses(jd, flags, geolat, geolon, this.hsys, cusps, ascmc);

    if (ret<0) {
      throw new SwissephException(jd, SwissephException.UNDEFINED_ERROR,
          "Calculation failed with return code "+ret+".");
    }

    if (houseObject < 0) {	// Houses have negative index
      return cusps[Math.abs(houseObject)];
    }
    return ascmc[houseObject];
  }


  protected double getMaxSpeed() {
    return max;
  }
  protected double getMinSpeed() {
    return min;
  }


  protected double getTimePrecision(double degPrec) {
    // Recalculate degPrec to mean the minimum  time, in which the planet can
    // possibly move that degree:
    double maxTimePerDeg = SMath.max(SMath.abs(min),SMath.abs(max));
    if (maxTimePerDeg != 0.) {
      return degPrec / maxTimePerDeg;
    }
    return 1E-9;
  }

  protected double getDegreePrecision(double jd) {
    // Take degPrec to be the minimum exact degree in longitude
    double degPrec = 0.5;
    degPrec /= 3600.;
    degPrec *= 0.5; // We take the precision to BETTER THAN ... as it is stated somewhere

    return degPrec;
  }


  //////////////////////////////////////////////////////////////////////////////

  private double checkOffset(double val) {
    // Similar rollover considerations for the latitude will be necessary, if
    // swe_calc() would return latitudinal values beyond -90 and +90 degrees.

    if (rollover) {        // Longitude from 0 to 360 degrees:
      while (val < 0.) { val += 360.; }
      val %= 360.;
      minVal = 0.;
      maxVal = 360.;
    } else if (idx == 1) { // Latitude from -90 to +90 degrees:
      while (val < -90.) { val += 180.; }
      while (val >  90.) { val -= 180.; }
      minVal = -90.;
      maxVal = +90.;
    }
    return val;
  }


  public String toString() {
    return "TCHouses [Object:" + houseObject + "];Offset:" + getOffset();
  }
}
