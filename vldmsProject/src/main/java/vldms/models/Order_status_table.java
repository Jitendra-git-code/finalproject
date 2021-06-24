package vldms.models;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Order_status_table 
{


//	@OneToMany(targetEntity = Order_detail_table.class,cascade = CascadeType.ALL)
//	@JoinColumn(name="order_id",referencedColumnName ="order_id" )
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id ;
	
	@Column(name = "order_Status_of_Approval")
	@Enumerated(EnumType.STRING)
	private Status order_Status_of_Approval;
	@Column(columnDefinition = "TEXT")
	private String comment_text ;
	
	@jdk.jfr.Timestamp
	private Timestamp date_of_Update_Status;
	
	
//	@OneToMany(targetEntity = User_table.class,cascade = CascadeType.ALL)
//	@JoinColumn(name="order_by",referencedColumnName ="user_id" )
	private String action_performed_by ;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id", nullable=false)
	private Order_detail_table ot;


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public Status getOrder_Status_of_Approval() {
		return order_Status_of_Approval;
	}


	public void setOrder_Status_of_Approval(Status order_Status_of_Approval) {
		this.order_Status_of_Approval = order_Status_of_Approval;
	}


	public String getComment_text() {
		return comment_text;
	}


	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}


	public Timestamp getDate_of_Update_Status() {
		return date_of_Update_Status;
	}


	public void setDate_of_Update_Status(Timestamp timestamp) {
		this.date_of_Update_Status = timestamp;
	}


	public String getAction_performed_by() {
		return action_performed_by;
	}


	public void setAction_performed_by(String action_performed_by) {
		this.action_performed_by = action_performed_by;
	}


	public Order_status_table() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order_status_table(int order_id, Status order_Status_of_Approval, String comment_text,
			Timestamp date_of_Update_Status, String action_performed_by) {
		super();
		this.order_id = order_id;
		this.order_Status_of_Approval = order_Status_of_Approval;
		this.comment_text = comment_text;
		this.date_of_Update_Status = date_of_Update_Status;
		this.action_performed_by = action_performed_by;
	}
	 
	
	
	
}
