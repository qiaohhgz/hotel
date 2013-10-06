package hotel.common.constant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/29/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "txManager")
public class TestConstantHelper extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private ConstantHelper constantHelper;

    @Test
    public void testConstructor() throws Exception {
        Assert.notNull(constantHelper);
        Assert.notNull(Constant.PROXY_ENABLE);
        Assert.notNull(Constant.PROXY_HOST);
        Assert.notNull(Constant.PROXY_PORT);
        logger.debug("Constant.PROXY_ENABLE = " + Constant.PROXY_ENABLE);
        logger.debug("Constant.PROXY_HOST = " + Constant.PROXY_HOST);
        logger.debug("Constant.PROXY_PORT = " + Constant.PROXY_PORT);
    }
}
