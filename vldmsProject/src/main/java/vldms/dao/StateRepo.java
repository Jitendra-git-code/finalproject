package vldms.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vldms.models.CgDistrict;
import vldms.models.Distribution_to_district_table;

@Repository
public interface StateRepo extends JpaRepository<Distribution_to_district_table,Integer>

{
	
	
	
	@Query("select rdt.order_id, rdt.batch_no,rdt.district_name,rdt.distribution_Date as distribution_Date_from_State,"
			+" rdt.issue_Vaccine_quantity as issue_Vaccine_from_State ,"
			+ "cm.consignment_no, cm.vacc_office_location, "
			+ "cm.issue_vaccine_quantity as issue_vaccine_quantity_from_district ,"
			+ "cm.distribution_date as distribution_date_from_district, "
			+ "cmt.total_quantity,cmt.consumed,cmt.damaged,cmt.remaining,"
			+"cmt.date as date_of_vaccination"
			+ " FROM Distribution_to_district_table AS rdt "
			+ "JOIN rdt.vod_list AS cm JOIN cm.cut as cmt where rdt.district_name = :district_name")

	        List<Object> find_Alldetail_by_district(CgDistrict district_name);
	
	
       @Query("SELECT d FROM Distribution_to_district_table d  where d.order_id = :order_id")
	   public List<Distribution_to_district_table> findByOrderId(int order_id);
	
}
