/*
   This is an extension to the Java port of the Swiss Ephemeris package
   of Astrodienst AG, Zuerich (Switzerland).

   Thomas Mack, mack@ifis.cs.tu-bs.de, 25th of November, 2004

*/

package swisseph;


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
* Some supportive methods, mainly for internationalization.
* These methods are not available in the original Swiss
* Ephemeris package.
*/
public class Extlib
		implements java.io.Serializable
		{

  double transitVal = 0.;
  SimpleDateFormat df = null;
  String decTimeSeparator = ".";
  String decNumSeparator = ".";
  int secondsIdx = 0;



  /**
  * This class contains some additional method not contained
  * in the original Swiss Ephemeris package.
  * Currently, these methods deal with internationalization
  * primarily.
  */
  public Extlib() { }

  /**
  * This method is for debugging purposes only.
  * @param argv (unused parameter)
  */
  public static void main(String argv[]) {
    new Extlib();
  }

//////////----------------------

  /**
  * This method returns all available locale strings
  * @return array of locale names like en_US etc.
  */
  public String[] getLocales() {
    Locale[] locs = DateFormat.getAvailableLocales();
    String[] locStrings = new String[locs.length + 1]; // All locales plus "iso" locale (YYYY-MM-DD)

    locStrings[0] = "iso";
    for (int r=0; r<locs.length; r++) {
      locStrings[r+1] = locs[r].getLanguage();
      if (locs[r].getCountry().length() > 0) {
        locStrings[r+1] += "_"+locs[r].getCountry();
        if (locs[r].getVariant().length() > 0) {
          locStrings[r+1] += "_"+locs[r].getVariant();	// e.g. th_TH_TH
        }
      }
    }
    return locStrings;
  }

  /**
  * Returns the requested locale from a locale string.
  * @param locString A String describing the locale as a two letter
  * language code, a two letter language code plus a "_" plus a two
  * letter country code, or null or the empty string. Null or the
  * empty string will return the default locale, all others will
  * return the requested locale.
  * @return The locale
  */
  public Locale getLocale(String locString) {
    String lang = locString;
    String cntry = "";
    String variant = "";
    if (locString == null || "".equals(locString)) {
      return Locale.getDefault();
    }
    // Arabic numbers don't get used by default, see http://bugs.sun.com/view_bug.do?bug_id=4336841
    // Work around this for all "inherited" arabic locales:
    // ar:    \u0660
    // ar_AE: inherited	// from ar?
    // ar_BH: inherited
    // ar_DZ: 0
    // ar_EG: inherited
    // ar_IN: inherited
    // ar_IQ; inherited
    // ar_JO: inherited
    // ar_KW: inherited
    // ar_LB: inherited
    // ar_LY: inherited
    // ar_MA: 0
    // ar_OM: inherited
    // ar_QA: inherited
    // ar_SA: inherited
    // ar_SD: inherited
    // ar_SY: inherited
    // ar_TN: 0
    // ar_YE: inherited
    boolean arabicNumbers = (locString.startsWith("ar") &&
        !"ar_DZ".equals(locString) &&
        !"ar_MA".equals(locString) &&
        !"ar_TN".equals(locString));
    if (arabicNumbers) {
        return new Locale.Builder().setLanguageTag(locString.replace('_','-') + "-u-nu-arab").build();
    }

    String[] locparts = locString.split("_");
    int len = locparts.length;
    lang = locparts[0];
    if (len > 1) {
      cntry = locparts[1];
    }
    if (len > 2) {
      variant = locparts[2];
    }
    Locale loc = null;
    if (len == 1) {
      loc = new Locale(lang);
    } else if (len == 2) {
      loc = new Locale(lang, cntry);
    } else {
      loc = new Locale(lang, cntry, variant);
    }

    return loc;
  }


  /**
  * Creates a localized date time formatter suitable for tabular output with
  * 4 digit years and UTC timezone. You will format dates like this:<p>
  * <code>&nbsp;&nbsp;&nbsp;
  * SimpleDateFormat sdf = createLocDateTimeFormatter("da_DK", true);<br>
  * &nbsp;&nbsp;&nbsp;SweDate sd = new SweDate(2005,3,27);<br>
  * &nbsp;&nbsp;&nbsp;//...<br>
  * &nbsp;&nbsp;&nbsp;System.out.println(sdf.format(sd.getDate(0)));<br>
  * </code><p>
  * Years B.C. will be prefixed by a "-". Years are counted including year
  * "0", which differs from normal DateFormat output.
  * @param locString The input locale for which this date time format
  * should be created. See getLocale() for more infos.
  * @param force24h Force the use of the 24 hour date format even on 12h date formats
  * @return The normalized form of the DateFormat.
  */
  public SimpleDateFormat createLocDateTimeFormatter(String locString, boolean force24h) {

    // Get date format:
    Locale loc;
    SimpleDateFormat df;
    if (locString.equals("iso")) {
      df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    } else {
      loc = getLocale(locString);
      df = (SimpleDateFormat)DateFormat.getDateTimeInstance(
              java.text.DateFormat.SHORT, java.text.DateFormat.MEDIUM, loc);
    }

    // Revert to UTC:
    df.getCalendar().setTimeZone(TimeZone.getTimeZone("GMT"));

    // Change output pattern to our needs, this means 4 letter year etc.:
    String pattern = getNormalizedDatePattern(df.toPattern(), force24h);
    df.applyPattern(pattern);

    return df;
  }

  /**
  * Ensures a date pattern with four letter year, two letter month and day
  * and 24h time format, if requested.
  * @param pattern The date pattern to be normalized
  * @param force24h Force the use of the 24 hour date format even on 12h date formats
  * @return The normalized form of the DateFormat.
  */
  public String getNormalizedDatePattern(String pattern, boolean force24h) {
    int idx = 0;
//System.out.println(pattern);

    // force year, month, day, hour, minutes and seconds to appear with two digits:
    final String pats = ("yMdHhms");
    for (int n = 0; n < pats.length(); n++) {
      char ch = pats.charAt(n);
      String out = ch + "" + ch;
      idx = pattern.indexOf(out);
      if (idx < 0) {
        idx = pattern.indexOf(ch);
        if (idx >= 0) {
          pattern = pattern.substring(0,idx) + ch + pattern.substring(idx);
        }
      }
    }
    // force year to appear with four digits:
    idx = pattern.indexOf("yyyy");
    if (idx < 0) {
      idx = pattern.indexOf("yy");
      if (idx >= 0) {
        pattern = pattern.substring(0,idx) + "yy" + pattern.substring(idx);
      }
    }
    // Locale "mk" does not have a "seconds" part in its time pattern
    // (Java 1.4.2 / Linux).
    // Append it after the minutes pattern ("m"):
    if (pattern.indexOf("s") < 0) {
      idx = pattern.indexOf("mm");
      if (idx >= 0) { // If not, it not even has a minutes part???
        try {
          // We assume some non-digit char AFTER "mm" as it is the
          // case with "mk" here ("d.M.yy HH:mm:" original, "dd.MM.yyyy HH:mm:"
          // when changed):
          pattern = pattern.substring(0,idx+3) + "ss" + pattern.substring(idx+3);
        } catch (StringIndexOutOfBoundsException sb) {
          // In zh_SG, the format looks like dd/MM/yyyy a hh:mm (above assumption fails)
          pattern = pattern.substring(0,idx+2) + pattern.substring(idx-1,idx) + "ss" + pattern.substring(idx+2);
        }
      }
    }

    if (force24h) {
      idx = pattern.indexOf("a");
      if (idx >= 0) {
        pattern = pattern.substring(0,idx) + pattern.substring(idx+1);
        idx = pattern.indexOf("hh");
        pattern = pattern.substring(0,idx) + "HH" + pattern.substring(idx+2);
      }
    }

    return pattern;
  }

  /**
  * Returns the decimal separator of the NumberFormat
  * @param nf NumberFormat for which the decimal separator should be retrieved
  * @return Decimal separator for this NumberFormat
  */
  public String getDecimalSeparator(NumberFormat nf) {
    if (nf instanceof DecimalFormat) {
      return String.valueOf(((DecimalFormat)nf).getDecimalFormatSymbols().getDecimalSeparator());
    }
    return null;
  }

  /**
  * Returns the index in the formatter pattern of the given pattern 'what'
  * recalculated to the APPLIED pattern of the formatter.
  * E.g. for locale zh_HK the pattern is:
  *    yyyy'年'MM'月'dd'日' ahh:mm:ss
  * The index of 'ss' would NOT be 25, which we would get when simply counting in
  * the pattern string, but rather 20, when counting in the resulting string.
  * @param pattern Date pattern
  * @param what Search for this String in the pattern
  * @param dof The DateFormat to be used
  * @return Index after 'what' string in pattern
  */
  public int getPatternLastIdx(String pattern, String what, SimpleDateFormat dof) {
    // If we want to append fractions of a second, we have to know
    // at which position in the string this is to happen. We can
    // look for the "ss" part in the pattern string, but the pattern
    // can contain string constants delimited by the ' character.
    // Moreover, it can contain patterns expanding to more than
    // one letter when applied to a date and time. This is so far
    // known to be true for the 'a' pattern expanding to AM or PM
    // in english locales and expanding to still different values
    // in other locales.

    int idx = pattern.lastIndexOf(what) + 1;

    // Strip string constant delimiters from found pattern position:
    int last = idx;
    int i = 0;
    while (i < last) {
      if (pattern.charAt(i) == '\'') {
        idx--;
      }
      i++;
    }

    if (pattern.indexOf("a") >= 0 &&
        pattern.indexOf("a") < pattern.indexOf(what)) {
      int len = dof.getDateFormatSymbols().getAmPmStrings()[0].length(); // No input with fractions of a second?
      // We have to know the time when the length of the AM-String is
      // different from the length of the PM-String...
      // We don't care for now...
      idx += len - 1;
    }

    return idx;
  }

} // End of class Extlib
