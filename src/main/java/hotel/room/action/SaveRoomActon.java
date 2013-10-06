package hotel.room.action;

import hotel.room.biz.RoomBiz;
import hotel.room.entity.Room;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 增加房间
 * @author dream
 *
 */
public class SaveRoomActon extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Room room;
   private RoomBiz roomBiz;
   public String saveRoom(){
	   try {
		     roomBiz.addRoom(room);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	   return SUCCESS;
   }
public Room getRoom() {
	return room;
}
public void setRoom(Room room) {
	this.room = room;
}
public RoomBiz getRoomBiz() {
	return roomBiz;
}
public void setRoomBiz(RoomBiz roomBiz) {
	this.roomBiz = roomBiz;
}
}
