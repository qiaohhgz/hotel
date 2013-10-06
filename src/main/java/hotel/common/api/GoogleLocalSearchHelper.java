package hotel.common.api;

import hotel.common.util.ProxyHelper;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 7/1/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleLocalSearchHelper {
    protected static final Logger log = Logger.getLogger(GoogleLocalSearchHelper.class);
    protected static final String BASE_URL = "http://ajax.googleapis.com/ajax/services/search/local?v=1.0";
    private int pageSize;
    private int pageNumber;

    public String parse(String value) throws Exception {
        String searchUrl = getSearchUrl(value);
        log.info("searchUrl = " + searchUrl);

        URL url = new URL(searchUrl);
        URLConnection connection = url.openConnection(ProxyHelper.makeHTTPProxy());

        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    private String getSearchUrl(String value) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer(BASE_URL);
        sb.append("&rsz=");
        sb.append(getPageSize() == 0 ? 4 : getPageSize());
        sb.append("&start=");
        sb.append(getPageNumber());
        sb.append("&q=");
        sb.append(URLEncoder.encode(value, "UTF-8"));
        return sb.toString();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
