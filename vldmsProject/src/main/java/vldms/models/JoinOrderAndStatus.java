package vldms.models;


import java.sql.Timestamp;



public class JoinOrderAndStatus
{
    private int  order_id; 
    private VaccineType type_of_vaccine ;
    private String ordered_by;
    private Timestamp date_of_order;
    
	private Companyname Company_Name ;
    private deststate Destination_State ;
    private RegCenter State_regional_office;
    private int Quantity_of_vaccine;
    private mrf_loaction Manufacturer_Location;
    private boolean upadted_Quantity;
   
	private Status order_Status_of_Approval;
    private String comment_text ;
    private Timestamp date_of_Update_Status;
    private String action_performed_by ;
    
    
    public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public Timestamp getDate_of_order() {
		return date_of_order;
	}
	public void setDate_of_order(Timestamp date_of_order) {
		this.date_of_order = date_of_order;
	}
	public VaccineType getType_of_vaccine() {
		return type_of_vaccine;
	}
	public void setType_of_vaccine(VaccineType type_of_vaccine) {
		this.type_of_vaccine = type_of_vaccine;
	}
	public String getOrdered_by() {
		return ordered_by;
	}
	public void setOrdered_by(String ordered_by) {
		this.ordered_by = ordered_by;
	}
	public Companyname getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(Companyname company_Name) {
		Company_Name = company_Name;
	}
	public deststate getDestination_State() {
		return Destination_State;
	}
	public void setDestination_State(deststate destination_State) {
		Destination_State = destination_State;
	}
	public RegCenter getState_regional_office() {
		return State_regional_office;
	}
	public void setState_regional_office(RegCenter state_regional_office) {
		State_regional_office = state_regional_office;
	}
	public int getQuantity_of_vaccine() {
		return Quantity_of_vaccine;
	}
	public void setQuantity_of_vaccine(int quantity_of_vaccine) {
		Quantity_of_vaccine = quantity_of_vaccine;
	}
	public mrf_loaction getManufacturer_Location() {
		return Manufacturer_Location;
	}
	public void setManufactur_Location(mrf_loaction manufacturer_Location) {
		Manufacturer_Location = manufacturer_Location;
	}
	 public boolean isUpadted_Quantity() {
			return upadted_Quantity;
		}
		public void setUpadted_Quantity(boolean upadted_Quantity) {
			this.upadted_Quantity = upadted_Quantity;
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
	public void setDate_of_Update_Status(Timestamp date_of_Update_Status) {
		this.date_of_Update_Status = date_of_Update_Status;
	}
	public String getAction_performed_by() {
		return action_performed_by;
	}
	public void setAction_performed_by(String action_performed_by) {
		this.action_performed_by = action_performed_by;
	}
	
	
}
