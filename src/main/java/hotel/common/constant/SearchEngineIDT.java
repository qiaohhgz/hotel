package hotel.common.constant;


/**
 * Defines internal WR codes (lookup codes)
 * for the various SEs/channels/partners
 * that are supported by WR.
 */
public class SearchEngineIDT {
    @Deprecated
    public static final int SEARCH_ENGINE_ID_YAHOO = 1;
    public static final int SEARCH_ENGINE_ID_GOOGLE = 2;
    @Deprecated
    public static final int SEARCH_ENGINE_ID_GOOGLE_LOCAL = 7;
    @Deprecated
    public static final int SEARCH_ENGINE_ID_YAHOO_LOCAL = 8;
    public static final int SEARCH_ENGINE_ID_MSN = 9;
    @Deprecated
    public static final int SEARCH_ENGINE_ID_YAHOO_SSP = 10;
    public static final int SEARCH_ENGINE_ID_MEX_BASIC = 11;
    public static final int SEARCH_ENGINE_ID_FACEBOOK = 12;
    public static final int SEARCH_ENGINE_ID_ADHERE = 13;
    public static final int SEARCH_ENGINE_ID_CITYGRID = 14;
    public static final int SEARCH_ENGINE_ID_IPROMOTE = 15;

    public static final String SEARCH_ENGINE_NAME_UPPER_GOOGLE = "Google";
    public static final String SEARCH_ENGINE_NAME_UPPER_YAHOO = "Yahoo";
    public static final String SEARCH_ENGINE_NAME_UPPER_MSN = "MSN";
    public static final String SEARCH_ENGINE_NAME_UPPER_MAX_BASIC = "Marchex Basic";
    public static final String SEARCH_ENGINE_NAME_UPPER_MAX_ADHERE = "Marchex Adhere";

    public static final String SEARCH_ENGINE_NAME_LOWER_GOOGLE = "google";
    public static final String SEARCH_ENGINE_NAME_LOWER_YAHOO = "yahoo";
    public static final String SEARCH_ENGINE_NAME_LOWER_MSN = "msn";
    public static final String SEARCH_ENGINE_NAME_LOWER_MAX_BASIC = "marchex";
    public static final String SEARCH_ENGINE_NAME_LOWER_MAX_ADHERE = "marchexAdHere";

    public static String getAbbreviation(int searchEngineId) {
        if (searchEngineId == SEARCH_ENGINE_ID_GOOGLE) {
            return "G";
        } else if (searchEngineId == SEARCH_ENGINE_ID_GOOGLE_LOCAL) {
            return "GL";
        } else if (searchEngineId == SEARCH_ENGINE_ID_YAHOO) {
            return "Y";
        } else if (searchEngineId == SEARCH_ENGINE_ID_YAHOO_LOCAL) {
            return "YL";
        } else if (searchEngineId == SEARCH_ENGINE_ID_YAHOO_SSP) {
            return "SSP";
        } else if (searchEngineId == SEARCH_ENGINE_ID_MSN) {
            return "MSN";
        } else if (searchEngineId == SEARCH_ENGINE_ID_MEX_BASIC) {
            return "BASIC";
        } else if (searchEngineId == SEARCH_ENGINE_ID_FACEBOOK) {
            return "FB";
        } else if (searchEngineId == SEARCH_ENGINE_ID_ADHERE) {
            return "MX";
        } else if (searchEngineId == SEARCH_ENGINE_ID_CITYGRID) {
            return "CG";
        } else if (searchEngineId == SEARCH_ENGINE_ID_IPROMOTE) {
            return "IP";
        }
        return "Invalid Search Engine ID [" + searchEngineId + "]";
    }

    public static String getName(int searchEngineId) {
        if (searchEngineId == SEARCH_ENGINE_ID_GOOGLE) {
            return "Google";
        } else if (searchEngineId == SEARCH_ENGINE_ID_GOOGLE_LOCAL) {
            return "Google Local";
        } else if (searchEngineId == SEARCH_ENGINE_ID_YAHOO) {
            return "Yahoo";
        } else if (searchEngineId == SEARCH_ENGINE_ID_YAHOO_LOCAL) {
            return "Yahoo Local";
        } else if (searchEngineId == SEARCH_ENGINE_ID_YAHOO_SSP) {
            return "Yahoo SSP";
        } else if (searchEngineId == SEARCH_ENGINE_ID_MSN) {
            return "MSN Bing";
        } else if (searchEngineId == SEARCH_ENGINE_ID_MEX_BASIC) {
            return "Marchex Basic";
        } else if (searchEngineId == SEARCH_ENGINE_ID_FACEBOOK) {
            return "Facebook";
        } else if (searchEngineId == SEARCH_ENGINE_ID_ADHERE) {
            return "Marchex Adhere";
        } else if (searchEngineId == SEARCH_ENGINE_ID_CITYGRID) {
            return "City Grid";
        } else if (searchEngineId == SEARCH_ENGINE_ID_IPROMOTE) {
            return "iPromote";
        }
        return "Invalid Search Engine ID [" + searchEngineId + "]";
    }

    public static int getID(String seName) {
        if (seName.equals("Google")) {
            return SEARCH_ENGINE_ID_GOOGLE;
        } else if (seName.equalsIgnoreCase("Yahoo")) {
            return SEARCH_ENGINE_ID_YAHOO;
        } else if (seName.equalsIgnoreCase("MSN Bing")) {
            return SEARCH_ENGINE_ID_MSN;
        } else if (seName.equalsIgnoreCase("Basic")) {
            return SEARCH_ENGINE_ID_MEX_BASIC;
        } else if (seName.equalsIgnoreCase("Marchex Basic")) {
            return SEARCH_ENGINE_ID_MEX_BASIC;
        } else if (seName.equalsIgnoreCase("facebook")) {
            return SEARCH_ENGINE_ID_FACEBOOK;
        } else if (seName.equalsIgnoreCase("marchex adhere")) {
            return SEARCH_ENGINE_ID_ADHERE;
        } else if (seName.equalsIgnoreCase("City Grid")) {
            return SEARCH_ENGINE_ID_CITYGRID;
        } else if (seName.equalsIgnoreCase("iPromote")) {
            return SEARCH_ENGINE_ID_IPROMOTE;
        }

        return -1;
    }
}
