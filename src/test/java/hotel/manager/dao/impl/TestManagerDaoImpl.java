package hotel.manager.dao.impl;


import hotel.manager.dao.ManagerDao;

import hotel.manager.entity.Manager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/24/13
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "txManager")
public class TestManagerDaoImpl extends AbstractTransactionalJUnit4SpringContextTests {
    private static final Logger log = Logger.getLogger(TestManagerDaoImpl.class);
    @Autowired
    private ManagerDao managerDao;

    @Test
    public void testAddManager() throws Exception {
        Assert.notNull(managerDao);
        Manager manager = new Manager("admin", "123456");
        managerDao.addManager(manager);
        log.debug("manager.getId() = " + manager.getId());

        assert manager.getId() != null;
    }
}
