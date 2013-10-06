package hotel.room.biz;

import hotel.room.entity.Room;

import java.util.List;
/**
 * 业务借口
 * @author dream
 *
 */
public interface RoomBiz {
	 /**
     * room 增加
     * @param room
     * @return
     */
    public Room addRoom(Room room);
    /**
     * room 删除
     * @param Room
     * @return 
     */
    public Room deleteRoom(Room room);
    /**
     * room 修改
     * @param room
     * @return
     */
    public Room updateRoom(Room room);
    /**
     * room 根据id查询
     * @param id
     * @return
     */
    public Room getRoomById(int id);
    /**
     * room 根据 room对象查询 (如果对象是空的查询全部)
     * @param room
     * @return List<Room>
     */
    public List<Room> queryRoom(Room room);
}
