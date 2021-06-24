package vldms.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Distribution_to_district_table 
{
	
	   private int order_id ;
	    @Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int	batch_no ;
		
		@Column(name = "district_name")
		 @Enumerated(EnumType.STRING)
		private CgDistrict district_name ;
		
		Timestamp distribution_Date ;
		private int issue_Vaccine_quantity ;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "dtd" ,fetch = FetchType.LAZY)
	    private List<Vaccination_office_distribution> vod_list;
		
	    
	    
	    
		public List<Vaccination_office_distribution> getVod_list() {
			return vod_list;
		}
		public void setVod_list(List<Vaccination_office_distribution> vod_list) {
			this.vod_list = vod_list;
		}
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
		public Timestamp getDistribution_Date() {
			return distribution_Date;
		}
		public void setDistribution_Date(Timestamp distribution_Date) {
			this.distribution_Date = distribution_Date;
		}
		public int getIssue_Vaccine_quantity() {
			return issue_Vaccine_quantity;
		}
		public void setIssue_Vaccine_quantity(int issue_Vaccine_quantity) {
			this.issue_Vaccine_quantity = issue_Vaccine_quantity;
		}
		/**
		 * @param order_id
		 * @param batch_no
		 * @param district_name
		 * @param distribution_Date
		 * @param issue_Vaccine_quantity
		 * @param vod_list
		 */
		public Distribution_to_district_table(int order_id, int batch_no, CgDistrict district_name,
				Timestamp distribution_Date, int issue_Vaccine_quantity,
				List<Vaccination_office_distribution> vod_list) {
			super();
			this.order_id = order_id;
			this.batch_no = batch_no;
			this.district_name = district_name;
			this.distribution_Date = distribution_Date;
			this.issue_Vaccine_quantity = issue_Vaccine_quantity;
			this.vod_list = vod_list;
		}
		/**
		 * 
		 */
		public Distribution_to_district_table() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Distribution_to_district_table [order_id=");
			builder.append(order_id);
			builder.append(", batch_no=");
			builder.append(batch_no);
			builder.append(", district_name=");
			builder.append(district_name);
			builder.append(", distribution_Date=");
			builder.append(distribution_Date);
			builder.append(", issue_Vaccine_quantity=");
			builder.append(issue_Vaccine_quantity);
			builder.append(", vod_list=");
			builder.append(vod_list);
			builder.append("]");
			return builder.toString();
		}
		
		
		
	   
		
		
}
