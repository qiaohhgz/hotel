package hotel.common.build;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/29/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestModulePropertyManager {

    @Test
    public void buildLocalForJim() throws Exception {
        ModulePropertyManager module = new ModulePropertyManager();
        module.buildLocal("src/main/resources/dynamic", "dev", "src/main/resources");
    }

    @Test
    public void buildLocalForZhou() throws Exception {
        ModulePropertyManager module = new ModulePropertyManager();
        module.buildLocal("src/main/resources/dynamic", "dev", "src/main/resources");
    }
}
