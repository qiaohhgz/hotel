package hotel.common.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 7/1/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestProxyHelper {
    public static final Logger log = Logger.getLogger(TestProxyHelper.class);

    @Test
    public void testProxy() throws Exception {
        ProxyHelper.makeHTTPProxy();
    }

    @Test
    public void testName() throws Exception {
        Map<String,String> getenv = System.getenv();
        for (String key : getenv.keySet()) {
            log.info("key = " + key + "\t value = " + getenv.get(key));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println("arg = " + arg);
        }
    }
}
