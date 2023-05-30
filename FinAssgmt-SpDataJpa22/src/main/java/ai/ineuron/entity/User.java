 package ai.ineuron.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="User_FA22")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long uid;
	
	private String uname;
	private String uemail;
	
	//user can place multiplee orders and hence injecting thee list of products
	@OneToMany(targetEntity = Order.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="User_Id",referencedColumnName = "uid")
	private List<Order> orderDetails;
	
	public User() {}
	
	public User (String uname,String uemail) {
		super();
		this.uname = uname;
		this.uemail = uemail;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public List<Order> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Order> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + "]";
	}
	
	
	
}
