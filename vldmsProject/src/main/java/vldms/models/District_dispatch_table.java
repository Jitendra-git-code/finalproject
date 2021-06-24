package vldms.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class District_dispatch_table 
{

	@Id 
	 private int batch_no ;
	
	@Column(name = "source_address")
	@Enumerated(EnumType.STRING)
	 private RegCenter source_address ;
	@Column(name = "destination_address")
	@Enumerated(EnumType.STRING)
	 private  CgDistrict destination_address ;
	 private  Timestamp last_update_date ;
	 private  Timestamp dispatch_date ;
	 private  String dispatched_by ;
	 private String received_by;
	 
	 
	 
	 public District_dispatch_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public District_dispatch_table(int batch_no, RegCenter source_address, CgDistrict destination_address,
			Timestamp last_update_date, Timestamp dispatch_date, String dispatched_by, String received_by) {
		super();
		this.batch_no = batch_no;
		this.source_address = source_address;
		this.destination_address = destination_address;
		this.last_update_date = last_update_date;
		this.dispatch_date = dispatch_date;
		this.dispatched_by = dispatched_by;
		this.received_by = received_by;
	}
	public int getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(int batch_no) {
		this.batch_no = batch_no;
	}
	public RegCenter getSource_address() {
		return source_address;
	}
	public void setSource_address(RegCenter source_address) {
		this.source_address = source_address;
	}
	public CgDistrict getDestination_address() {
		return destination_address;
	}
	public void setDestination_address(CgDistrict destination_address) {
		this.destination_address = destination_address;
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
	public void setDispatch_date(Timestamp dispatch_date) {
		this.dispatch_date = dispatch_date;
	}
	public String getDispatched_by() {
		return dispatched_by;
	}
	public void setDispatched_by(String dispatched_by) {
		this.dispatched_by = dispatched_by;
	}
	public String getReceived_by() {
		return received_by;
	}
	public void setReceived_by(String received_by) {
		this.received_by = received_by;
	}
	
	 
	 
	 
}
