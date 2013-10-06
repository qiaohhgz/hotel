package hotel.manager.entity;


import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-23
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "H_Manager")
public class Manager {
    private Integer id;
    private String userName;
    private String password;

    public Manager() {
    }

    public Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @Column(name = "userName", length = 50)
    public String getUserName() {
        return userName;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
