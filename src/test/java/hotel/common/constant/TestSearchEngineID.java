package hotel.common.constant;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 7/8/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestSearchEngineID {
    @Test
    public void testName() throws Exception {
        SearchEngineID instance = SearchEngineID.getInstance(1);
        System.out.println("instance = " + instance);
    }
}
