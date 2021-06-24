package vldms.models;

import java.sql.Timestamp;

public class DistrictJoinInformation 
{
	private int order_id; 
	private int  batch_no;
	private CgDistrict district_name;
	private Timestamp  distribution_Date_from_State;
	private int issue_Vaccine_from_State ;
	private int consignment_no; 
	private Office_loc vacc_office_location; 
	private int issue_vaccine_quantity_from_district ;
	private Timestamp distribution_date_from_district; 
	private int total_quantity;
	private int consumed;
	private int damaged;
	private int remaining;
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(int batch_no) {
		this.batch_no = batch_no;
	}
	public CgDistrict getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(CgDistrict district_name) {
		this.district_name = district_name;
	}
	public Timestamp getDistribution_Date_from_State() {
		return distribution_Date_from_State;
	}
	public void setDistribution_Date_from_State(Timestamp distribution_Date_from_State) {
		this.distribution_Date_from_State = distribution_Date_from_State;
	}
	public int getIssue_Vaccine_from_State() {
		return issue_Vaccine_from_State;
	}
	public void setIssue_Vaccine_from_State(int issue_Vaccine_from_State) {
		this.issue_Vaccine_from_State = issue_Vaccine_from_State;
	}
	public int getConsignment_no() {
		return consignment_no;
	}
	public void setConsignment_no(int consignment_no) {
		this.consignment_no = consignment_no;
	}
	public Office_loc getVacc_office_location() {
		return vacc_office_location;
	}
	public void setVacc_office_location(Office_loc vacc_office_location) {
		this.vacc_office_location = vacc_office_location;
	}
	public int getIssue_vaccine_quantity_from_district() {
		return issue_vaccine_quantity_from_district;
	}
	public void setIssue_vaccine_quantity_from_district(int issue_vaccine_quantity_from_district) {
		this.issue_vaccine_quantity_from_district = issue_vaccine_quantity_from_district;
	}
	public Timestamp getDistribution_date_from_district() {
		return distribution_date_from_district;
	}
	public void setDistribution_date_from_district(Timestamp distribution_date_from_district) {
		this.distribution_date_from_district = distribution_date_from_district;
	}
	public int getTotal_quantity() {
		return total_quantity;
	}
	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}
	public int getConsumed() {
		return consumed;
	}
	public void setConsumed(int consumed) {
		this.consumed = consumed;
	}
	public int getDamaged() {
		return damaged;
	}
	public void setDamaged(int damaged) {
		this.damaged = damaged;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	

	
	
	
}
