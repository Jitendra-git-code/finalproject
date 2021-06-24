package vldms.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class VO_dispatch_table 
{
	
	private int order_id;
	private int batch_no;
	@Id
	private int consignment_no ;
	@Column(name = "source_addresss")
	@Enumerated(EnumType.STRING)
	private  CgDistrict  source_addresss;
	@Column(name = "destination_address")
	@Enumerated(EnumType.STRING)
	private Office_loc destination_address;
	private Timestamp last_update_date;
	private Timestamp dispatch_date;
	private String dispatched_by ;
	private String received_by;
	
	public int getOrder_id() 
	{
		return order_id;
	}
	public void setOrder_id(int order_id) 
	{
		this.order_id = order_id;
	}
	public int getBatch_no() 
	{
		return batch_no;
	}
	public void setBatch_no(int batch_no) 
	{
		this.batch_no = batch_no;
	}
	public int getConsignment_no() 
	{
		return consignment_no;
	}
	public void setConsignment_no(int consignment_no)
	{
		this.consignment_no = consignment_no;
	}
	public  CgDistrict  getSource_addresss() 
	{
		return source_addresss;
	}
	public void setSource_addresss( CgDistrict  source_addresss) 
	{
		this.source_addresss = source_addresss;
	}
	public Office_loc getDestination_address() 
	{
		return destination_address;
	}
	public void setDestination_address(Office_loc destination_address) 
	{
		this.destination_address = destination_address;
	}
	
	public String getDispatched_by() 
	{
		return dispatched_by;
	}
	public void setDispatched_by(String dispatched_by) 
	{
		this.dispatched_by = dispatched_by;
	}
	public String getReceived_by() 
	{
		return received_by;
	}
	public void setReceived_by(String received_by) 
	{
		this.received_by = received_by;
	}
	

	public Timestamp getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(Timestamp last_update_date) {
		this.last_update_date = last_update_date;
	}
	public Timestamp getDispatch_date() {
		return dispatch_date;
	}
	public void setDispatch_date(Timestamp dispatch_date) 
	{
		this.dispatch_date = dispatch_date;
	}
	public VO_dispatch_table(int order_id, int batch_no, int consignment_no, CgDistrict source_addresss,
			Office_loc destination_address, Timestamp last_update_date, Timestamp dispatch_date, String dispatched_by,
			String received_by) {
		super();
		this.order_id = order_id;
		this.batch_no = batch_no;
		this.consignment_no = consignment_no;
		this.source_addresss = source_addresss;
		this.destination_address = destination_address;
		this.last_update_date = last_update_date;
		this.dispatch_date = dispatch_date;
		this.dispatched_by = dispatched_by;
		this.received_by = received_by;
	}
	
	
	public VO_dispatch_table()
	{
		super();
	}
	
}
