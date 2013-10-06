package hotel.common.util;

import hotel.common.constant.Constant;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 7/1/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProxyHelper {
    public static void applyProxy() {
        System.getProperties().put("http.proxySet", Constant.PROXY_ENABLE);
        System.getProperties().put("http.proxyHost", Constant.PROXY_HOST);
        System.getProperties().put("http.proxyPost", Constant.PROXY_PORT);
        System.getProperties().put("https.proxySet", Constant.PROXY_ENABLE);
        System.getProperties().put("https.proxyHost", Constant.PROXY_HOST);
        System.getProperties().put("https.proxyPost", Constant.PROXY_PORT);
    }

    public static Proxy makeHTTPProxy() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(Constant.PROXY_HOST, Constant.PROXY_PORT));
    }

    public static Proxy makeProxy(Proxy.Type type) {
        return new Proxy(type, new InetSocketAddress(Constant.PROXY_HOST, Constant.PROXY_PORT));
    }
}
