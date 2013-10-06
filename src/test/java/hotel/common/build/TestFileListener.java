package hotel.common.build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: shiju
 * Date: 13-6-30
 * Time: 上午9:56
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestFileListener extends AbstractJUnit4SpringContextTests {
    @Test
    public void testOnChange() throws Exception {
        FileListener fileListener = new FileListener(new File("src/main/resources/test.properties"));
        fileListener.setMillis(50);
        new Thread(fileListener).start();
        Thread.sleep(10000000);
    }

    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    @Test
    public void testSpringTaskExecutor() throws Exception {
        taskExecutor.execute(new FileListener(new File("src/main/resources/test.properties")));
        Thread.sleep(10000000);
    }
}
