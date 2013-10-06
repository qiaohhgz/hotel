package hotel.common.db;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/24/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateDao<T> extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(HibernateDao.class);

    @Autowired
    public void initSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
