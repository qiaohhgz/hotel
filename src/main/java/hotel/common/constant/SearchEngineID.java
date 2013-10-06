package hotel.common.constant;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 7/8/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public enum SearchEngineID implements IGetName<SearchEngineID> {
    Google(1, "google", "Google", "GL"),
    Yahoo(2, "yahoo", "Yahoo", "Y"),
    MSN(3, "msn", "MSN", "M");

    private int id;
    private String upperName;
    private String lowerName;
    private String shortName;

    private SearchEngineID(int id, String lowerName, String upperName, String shortName) {
        this.id = id;
        this.lowerName = lowerName;
        this.upperName = upperName;
        this.shortName = shortName;
    }

    public static SearchEngineID getInstance(int searchEngineId) {
        SearchEngineID[] values = getValues();
        for (SearchEngineID engine : values) {
            if (engine.getId() == searchEngineId) {
                return engine;
            }
        }
        return null;
    }

    public static SearchEngineID getByLowerName(String lowerName) {
        SearchEngineID[] values = getValues();
        for (SearchEngineID engine : values) {
            if (engine.getLowerName().equals(lowerName)) {
                return engine;
            }
        }
        return null;
    }

    public static SearchEngineID getByShortName(String shortName) {
        SearchEngineID[] values = getValues();
        for (SearchEngineID engine : values) {
            if (engine.getShortName().equals(shortName)) {
                return engine;
            }
        }
        return null;
    }

    public static SearchEngineID getByName(String name) {
        return SearchEngineID.valueOf(name);
    }

    public static SearchEngineID[] getValues() {
        return SearchEngineID.getValues();
    }

    public int getId() {
        return id;
    }

    public String getUpperName() {
        return upperName;
    }

    public String getLowerName() {
        return lowerName;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public SearchEngineID getName(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
