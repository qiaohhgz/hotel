package hotel.common.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hotel.common.util.ProxyHelper;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 7/1/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestGoogleLocalSearchHelper {
    public static final Logger log = Logger.getLogger(TestGoogleLocalSearchHelper.class);

    @Test
    public void testParse() throws Exception {
        ProxyHelper.applyProxy();
        GoogleLocalSearchHelper helper = new GoogleLocalSearchHelper();
        helper.setPageSize(8);
        String json;
        for (int i = 0; i < 8; i++) {
            log.debug("==========   Page " + (i + 1) + "   ==========");
            helper.setPageNumber(i * 8);
            json = helper.parse("Flower, New York");
//            json = helper.parse("Flower, Shanghai");
            print(json);
        }
    }

    private void print(String json) {
//        log.debug("json = " + json);
        JsonObject object = new JsonParser().parse(json).getAsJsonObject();
        JsonElement status = object.get("responseStatus");
//        log.debug("status = " + status);
        JsonArray results = object.get("responseData").getAsJsonObject().get("results").getAsJsonArray();
        printPage(results);
//        log.debug("results = " + results.size());
//        JsonObject result = results.get(0).getAsJsonObject();
//        JsonElement title = result.get("title");
//        log.debug("title = " + title);
//        JsonElement url = result.get("url");
//        log.debug("url = " + url);
//        JsonElement staticMapUrl = result.get("staticMapUrl");
//        log.debug("staticMapUrl = " + staticMapUrl);
    }

    private void printPage(JsonArray results) {
        for (int i = 0; i < 8; i++) {
            JsonObject result = results.get(i).getAsJsonObject();
            JsonElement title = result.get("title");
            log.debug("title = " + title);
        }
    }
}
