package vldms.models;


import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;






@Entity
public class Order_detail_table {
	
	 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  order_id; 
	 
	 
	 private String ordered_by;
	 
	 public String getOrdered_by() {
		return ordered_by;
	}
	public void setOrdered_by(String order_by) {
		this.ordered_by = order_by;
	}
	private Timestamp date_of_order;
	 
	 @Column(name = "type_of_vaccine")
	 @Enumerated(EnumType.STRING)
	 private VaccineType type_of_vaccine ;
	 
	 @Column(name = "Company_Name")
	 @Enumerated(EnumType.STRING)
	  private Companyname Company_Name ;
	 
	 @Column(name = "Destination_State")
	 @Enumerated(EnumType.STRING)
	  private deststate Destination_State ;

	 @Column(name = "State_regional_office")
	 @Enumerated(EnumType.STRING)
	  private RegCenter State_regional_office;

	 private int Quantity_of_vaccine;
	 
	 @Column(name = "Manufacturer_Location")
	 @Enumerated(EnumType.STRING)
	private mrf_loaction Manufacturer_Location;
	 
	private boolean upadted_Quantity;
	
	
	 @OneToOne(mappedBy="ot")
	 private Order_status_table ost;
	
//	@OneToMany(targetEntity = User_table.class,cascade = CascadeType.ALL)
//	@JoinColumn(name="order_by",referencedColumnName ="user_id" )
//	private User_table orderby;
	 
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
	public void setManufacturer_Location(mrf_loaction manufacturer_Location) {
		Manufacturer_Location = manufacturer_Location;
	}
	public boolean isUpdated_Quantity() {
		return upadted_Quantity;
	}
	public void setUpadted_Quantity(boolean upadted_Quantity) {
		this.upadted_Quantity = upadted_Quantity;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order_detail_table [order_id=");
		builder.append(order_id);
		builder.append(", ordered_by=");
		builder.append(ordered_by);
		builder.append(", date_of_order=");
		builder.append(date_of_order);
		builder.append(", type_of_vaccine=");
		builder.append(type_of_vaccine);
		builder.append(", Company_Name=");
		builder.append(Company_Name);
		builder.append(", Destination_State=");
		builder.append(Destination_State);
		builder.append(", State_regional_office=");
		builder.append(State_regional_office);
		builder.append(", Quantity_of_vaccine=");
		builder.append(Quantity_of_vaccine);
		builder.append(", Menufactur_Location=");
		builder.append(Manufacturer_Location);
		builder.append(", upadted_Quantity=");
		builder.append(upadted_Quantity);
		builder.append("]");
		return builder.toString();
	}
	public Order_detail_table(int order_id, String ordered_by, Timestamp date_of_order, VaccineType type_of_vaccine,
			Companyname company_Name, deststate destination_State, RegCenter state_regional_office,
			int quantity_of_vaccine, mrf_loaction manufacturer_Location, boolean updated_Quantity) {
		super();
		this.order_id = order_id;
		this.ordered_by = ordered_by;
		this.date_of_order = date_of_order;
		this.type_of_vaccine = type_of_vaccine;
		Company_Name = company_Name;
		Destination_State = destination_State;
		State_regional_office = state_regional_office;
		Quantity_of_vaccine = quantity_of_vaccine;
		Manufacturer_Location = manufacturer_Location;
		this.upadted_Quantity = upadted_Quantity;
	}
	public Order_detail_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
