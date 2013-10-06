package hotel.user.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-23
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "H_USER")
public class User {
    public static final Integer SEX_WOMAN = 0;//女
    public static final Integer SEX_MAN = 1;//男
    /**
     * 未决定的
     */
    public static final Integer STATUS_PENDING = 0;
    /**
     * 已入住的
     */
    public static final Integer STATUS_LIVE = 1;
    /**
     * 离开的
     */
    public static final Integer STATUS_CLOSING = 2;
    private Integer id;
    private String userName;
    private String cardNum;
    private Integer sex = SEX_MAN;
    private String telephone;
    private Date createOn = new Date();
    private Float price;
    private Boolean doorCard;
    private Integer status = STATUS_PENDING;
    private String comment;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @Column(name = "userName", length = 50, nullable = false)
    public String getUserName() {
        return userName;
    }

    @Column(name = "cardNum", length = 18)
    public String getCardNum() {
        return cardNum;
    }

    @Column(name = "sex", length = 3)
    public Integer getSex() {
        return sex;
    }

    @Column(name = "telephone", length = 20)
    public String getTelephone() {
        return telephone;
    }

    @Column(name = "createOn", nullable = false)
    public Date getCreateOn() {
        return createOn;
    }

    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    @Column(name = "doorCard", length = 50)
    public Boolean getDoorCard() {
        return doorCard;
    }

    @Column(name = "status", length = 10, nullable = false)
    public Integer getStatus() {
        return status;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setDoorCard(Boolean doorCard) {
        this.doorCard = doorCard;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
