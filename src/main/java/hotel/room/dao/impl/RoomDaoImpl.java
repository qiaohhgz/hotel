package hotel.room.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import hotel.common.db.HibernateDao;
import hotel.manager.dao.impl.ManagerDaoImpl;
import hotel.manager.entity.Manager;
import hotel.room.dao.RoomDao;
import hotel.room.entity.Room;
/**
 * 房间接口实现类
 * @author dream
 *
 */
public class RoomDaoImpl extends HibernateDao<Room> implements RoomDao {
	  private static final Logger log = Logger.getLogger(ManagerDaoImpl.class);
	@Override
	public Room addRoom(final Room room) {
		 return getHibernateTemplate().execute(new HibernateCallback<Room>() {
	            @Override
	            public Room doInHibernate(Session session) throws HibernateException, SQLException {
	                session.save(room);
	                session.flush();
	                session.refresh(room);
	                return room;
	            }
	        });
	}

	@Override
	public Room deleteRoom(final Room room) {
		 return getHibernateTemplate().execute(new HibernateCallback<Room>() {
	            @Override
	            public Room doInHibernate(Session session) throws HibernateException, SQLException {
	                session.delete(room);
	                session.flush();
	                session.refresh(room);
	                return room;
	            }
	        });
		
	}

	@Override
	public Room getRoomById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Room.class, id);
	}

	@Override
	public List<Room> queryRoom(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room updateRoom(final Room room) {
		 return getHibernateTemplate().execute(new HibernateCallback<Room>() {
	            @Override
	            public Room doInHibernate(Session session) throws HibernateException, SQLException {
	                session.update(room);
	                session.flush();
	                session.refresh(room);
	                return room;
	            }
	        });
	}

}
