package ai.ineuron.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="Order_FA22")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	private String odetail;
	private Integer oqnty;
	
	@ManyToOne(targetEntity = User.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="User_Id",referencedColumnName = "uid")
	private User user;

	public Order() {}
		
	

	public Order(String odetail, Integer oqnty) {
		super();
		this.odetail = odetail;
		this.oqnty = oqnty;
//		this.user=user;
	
	}




	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getOdetail() {
		return odetail;
	}

	public void setOdetail(String odetail) {
		this.odetail = odetail;
	}

	public Integer getOqnty() {
		return oqnty;
	}

	public void setOqnty(Integer oqnty) {
		this.oqnty = oqnty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Orders ordered By "+ getUser().getUname()+ "=======>Id:" + oid + ", Order:" + odetail + ", Qnty: " + oqnty;
	}
	
	
}
