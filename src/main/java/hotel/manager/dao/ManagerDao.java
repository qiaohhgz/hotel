package hotel.manager.dao;

import hotel.manager.entity.Manager;

/**
 * Created with IntelliJ IDEA.
 * User: Jim_qiao
 * Date: 6/24/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ManagerDao {
    public Manager addManager(Manager manager);

    public Manager getManagerById(int id);

    public Manager getManagerByName(String userName);
}
