package vldms.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Order_dispatch_table 
{
	
	@Id 
	private int  order_id; 
	
	private String Dispatched_by;
	private String Received_by;
	private Timestamp dispatch_date;
	private Timestamp last_update_date;
	private Date manufacture_date_of_vaccine;
	
	@Column(name = "Destination_State")
	@Enumerated(EnumType.STRING)
	 private deststate Destination_State ;
	
	 @Column(name = "Destination_address")
	 @Enumerated(EnumType.STRING)
	  private RegCenter Destination_address;
	 
	 @Column(name = "manufacture_location")
	 @Enumerated(EnumType.STRING)
	private mrf_loaction manufacture_location;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getDispatched_by() {
		return Dispatched_by;
	}

	public void setDispatched_by(String dispatched_by) {
		Dispatched_by = dispatched_by;
	}

	public String getReceived_by() {
		return Received_by;
	}

	public void setReceived_by(String received_by) {
		Received_by = received_by;
	}

	public Timestamp getDispatch_date() {
		return dispatch_date;
	}

	public void setDispatch_date(Timestamp dispatch_date) {
		this.dispatch_date = dispatch_date;
	}

	public Timestamp getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Timestamp last_update_date) {
		this.last_update_date = last_update_date;
	}

	public Date getManufacture_date_of_vaccine() {
		return manufacture_date_of_vaccine;
	}

	public void setManufacture_date_of_vaccine(Date manufacture_date_of_vaccine) {
		this.manufacture_date_of_vaccine = manufacture_date_of_vaccine;
	}

	public deststate getDestination_State() {
		return Destination_State;
	}

	public void setDestination_State(deststate destination_State) {
		Destination_State = destination_State;
	}

	public RegCenter getDestination_address() {
		return Destination_address;
	}

	public void setDestination_address(RegCenter destination_address) {
		Destination_address = destination_address;
	}

	public mrf_loaction getManufacture_location() {
		return manufacture_location;
	}

	public void setManufacture_location(mrf_loaction manufacture_location) {
		this.manufacture_location = manufacture_location;
	}

	public Order_dispatch_table(int order_id, String dispatched_by, String received_by, Timestamp dispatch_date,
			Timestamp last_update_date, Date manufacture_date_of_vaccine, deststate destination_State,
			RegCenter destination_address, mrf_loaction manufacture_location) {
		super();
		this.order_id = order_id;
		Dispatched_by = dispatched_by;
		Received_by = received_by;
		this.dispatch_date = dispatch_date;
		this.last_update_date = last_update_date;
		this.manufacture_date_of_vaccine = manufacture_date_of_vaccine;
		Destination_State = destination_State;
		Destination_address = destination_address;
		this.manufacture_location = manufacture_location;
	}

	public Order_dispatch_table() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order_dispatch_table [order_id=");
		builder.append(order_id);
		builder.append(", Dispatched_by=");
		builder.append(Dispatched_by);
		builder.append(", Received_by=");
		builder.append(Received_by);
		builder.append(", dispatch_date=");
		builder.append(dispatch_date);
		builder.append(", last_update_date=");
		builder.append(last_update_date);
		builder.append(", manufacture_date_of_vaccine=");
		builder.append(manufacture_date_of_vaccine);
		builder.append(", Destination_State=");
		builder.append(Destination_State);
		builder.append(", Destination_address=");
		builder.append(Destination_address);
		builder.append(", manufacture_location=");
		builder.append(manufacture_location);
		builder.append("]");
		return builder.toString();
	}
	 
	 

}
