package hotel.manager.dao.impl;

import hotel.common.db.HibernateDao;

import hotel.manager.dao.ManagerDao;
import hotel.manager.entity.Manager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/24/13
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ManagerDaoImpl extends HibernateDao<Manager> implements ManagerDao {
    private static final Logger log = Logger.getLogger(ManagerDaoImpl.class);
    @Override
    public Manager addManager(final Manager manager) {
        return getHibernateTemplate().execute(new HibernateCallback<Manager>() {
            @Override
            public Manager doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(manager);
                session.flush();
                session.refresh(manager);
                return manager;
            }
        });
    }

    @Override
    public Manager getManagerById(int id) {
        return getHibernateTemplate().get(Manager.class, id);
    }

    @Override
    public Manager getManagerByName(String userName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
