package hotel.common.constant;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/29/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConstantHelper {
    private static final Logger log = Logger.getLogger(ConstantHelper.class);

    public ConstantHelper(boolean useProxy, String proxyHost, int proxyPort) {
        log.info("init Constant static field. PROXY_ENABLE = " + useProxy + " proxyHost = " + proxyHost + " proxyPort = " + proxyPort);
        Constant.PROXY_ENABLE = useProxy;
        Constant.PROXY_HOST = proxyHost;
        Constant.PROXY_PORT = proxyPort;
    }
}
