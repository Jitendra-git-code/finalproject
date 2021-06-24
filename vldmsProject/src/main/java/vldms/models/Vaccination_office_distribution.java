package vldms.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vaccination_office_distribution 
{
	private int order_id;
	
	private int batch_no;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int consignment_no ;
	
	@Column(name = "vacc_office_location")
	@Enumerated(EnumType.STRING)
	private Office_loc  vacc_office_location;
	
	private int issue_vaccine_quantity;
	
	private Timestamp distribution_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name="batch_no", nullable=false,insertable = false, updatable = false)
	   private Distribution_to_district_table dtd;
	   
	   @OneToOne(cascade = CascadeType.ALL, mappedBy = "vod" ,fetch = FetchType.LAZY)
	   private Consignment_usage_table cut;
	   
	   
	
	
	public Distribution_to_district_table getDtd() {
		return dtd;
	}

	public void setDtd(Distribution_to_district_table dtd) {
		this.dtd = dtd;
	}

	public Consignment_usage_table getCut() {
		return cut;
	}

	public void setCut(Consignment_usage_table cut) {
		this.cut = cut;
	}

	public Timestamp getDistribution_date() {
		return distribution_date;
	}

	public void setDistribution_date(Timestamp distribution_date) {
		this.distribution_date = distribution_date;
	}

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
	
	public Office_loc getVacc_office_location() 
	{
		return vacc_office_location;
	}
	
	public void setVacc_office_location(Office_loc vacc_office_location) 
	{
		this.vacc_office_location = vacc_office_location;
	}
	
	public int getIssue_vaccine_quantity() 
	{
		return issue_vaccine_quantity;
	}
	
	public void setIssue_vaccine_quantity(int issue_vaccine_quantity)
	{
		this.issue_vaccine_quantity = issue_vaccine_quantity;
	}

	/**
	 * @param order_id
	 * @param batch_no
	 * @param consignment_no
	 * @param vacc_office_location
	 * @param issue_vaccine_quantity
	 * @param distribution_date
	 * @param dtd
	 * @param cut
	 */
	public Vaccination_office_distribution(int order_id, int batch_no, int consignment_no,
			Office_loc vacc_office_location, int issue_vaccine_quantity, Timestamp distribution_date,
			Distribution_to_district_table dtd, Consignment_usage_table cut) {
		super();
		this.order_id = order_id;
		this.batch_no = batch_no;
		this.consignment_no = consignment_no;
		this.vacc_office_location = vacc_office_location;
		this.issue_vaccine_quantity = issue_vaccine_quantity;
		this.distribution_date = distribution_date;
		this.dtd = dtd;
		this.cut = cut;
	}

	/**
	 * 
	 */
	public Vaccination_office_distribution() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vaccination_office_distribution [order_id=");
		builder.append(order_id);
		builder.append(", batch_no=");
		builder.append(batch_no);
		builder.append(", consignment_no=");
		builder.append(consignment_no);
		builder.append(", vacc_office_location=");
		builder.append(vacc_office_location);
		builder.append(", issue_vaccine_quantity=");
		builder.append(issue_vaccine_quantity);
		builder.append(", distribution_date=");
		builder.append(distribution_date);
		builder.append(", dtd=");
		builder.append(dtd);
		builder.append(", cut=");
		builder.append(cut);
		builder.append("]");
		return builder.toString();
	}

	

	

	
}
