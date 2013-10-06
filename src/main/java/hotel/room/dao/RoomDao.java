package hotel.room.dao;

import java.util.List;

import hotel.room.entity.Room;

/**
 * room interface 
 * @author dream
 * date 13-7-1
 */
public interface RoomDao {
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
