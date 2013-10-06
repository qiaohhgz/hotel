package hotel.room.dao.impl;

import hotel.room.dao.RoomDao;

import hotel.room.entity.Room;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

/**
 * 
 * @author zhou
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "txManager")
public class TestRoomDaoImpl extends AbstractJUnit4SpringContextTests{
	
  private Logger log=Logger.getLogger(TestRoomDaoImpl.class);
  private RoomDao roomDao;
  public void testAddRoom(){
	  
	Assert.notNull(roomDao);
	Room room =new Room("123",0, 123.00, "111", 123.00, "1", 0, "123");
	roomDao.addRoom(room);
	log.debug("room.getId()"+room.getId());
	assert room.getId()!=null;
  }

}
