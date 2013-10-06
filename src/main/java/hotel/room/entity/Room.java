package hotel.room.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * entity: room  
 * @author dream
 * date:13-7-1 
 * time: 21:14
 */
@Entity
@Table(name="h_room")
public class Room {
	   private Integer id;
	   private String roomId;
	   private int type;
	   private Double price;
	   private String charge;
	   private Double chargeNum;
	   private String window;
	   private int status;
	   private String comment;
	   public Room(String roomId,int type,Double price,String charge,Double chargeNum,String window,int status,String comment ){
		   this.roomId=roomId;
		   this.type=type;
		   this.price=price;
		   this.charge=charge;
		   this.chargeNum =chargeNum;
		   this.window=window;
		   this.status=status;
		   this.comment=comment;
		   
	   }
   public void setId(Integer id) {
		this.id = id;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public void setChargeNum(Double chargeNum) {
		this.chargeNum = chargeNum;
	}
	public void setWindow(String window) {
		this.window = window;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Id
	@GeneratedValue
   public Integer getId() {
		return id;
	}
	@Column(name="ROOMID",length=50)
	public String getRoomId() {
		return roomId;
	}
	@Column(name="TYPE",length=8)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(name="PRICE",length=50)
	public Double getPrice() {
		return price;
	}
	@Column(name="CHARGE" ,length=8)
	public String getCharge() {
		return charge;
	}
	@Column(name="CHARGENUM",length=50)
	public Double getChargeNum() {
		return chargeNum;
	}
	@Column(name="WINDOW",length=8)
	public String getWindow() {
		return window;
	}
	@Column(name="STATUS",length=8)
	public int getStatus() {
		return status;
	}
	@Column(name="COMMENT",length=255)
	public String getComment() {
		return comment;
	}

   
   
}
