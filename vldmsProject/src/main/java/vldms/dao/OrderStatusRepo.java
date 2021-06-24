package vldms.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import vldms.models.Order_status_table;
import vldms.models.Status;

@Repository
public interface OrderStatusRepo extends JpaRepository<Order_status_table, Integer> 
{
	//@Query("FROM Order_status_table AS rdt JOIN WHERE rdt.ot.order_id = ?1")    //This is using a named query method
//	@Query("FROM Order_status_table AS rdt JOIN rdt.ot AS cm WHERE cm.order_id = ?1")
//    public List<Object> FindBothOrderDetailAndStatus(Integer id);
	
	@Query("select cm.order_id,cm.ordered_by,cm.date_of_order,cm.type_of_vaccine,"
			+ "cm.Company_Name,cm.Destination_State,cm.State_regional_office,"
			+ "cm.Quantity_of_vaccine,cm.Manufacturer_Location,cm.upadted_Quantity,"
			+ "rdt.order_Status_of_Approval,rdt.comment_text,"
			+ "rdt.action_performed_by,rdt.date_of_Update_Status"
			+ " FROM Order_status_table AS rdt JOIN rdt.ot AS cm WHERE cm.order_id = ?1")
    public List<Object> FindBothOrderDetailAndStatus(@Param("abc") Integer id);
	
	
	
	@Query("select cm.order_id,cm.ordered_by,cm.date_of_order,cm.type_of_vaccine,"
			+ "cm.Company_Name,cm.Destination_State,cm.State_regional_office,"
			+ "cm.Quantity_of_vaccine,cm.Manufacturer_Location,cm.upadted_Quantity,"
			+ "rdt.order_Status_of_Approval,rdt.comment_text,"
			+ "rdt.action_performed_by,rdt.date_of_Update_Status"
			+ " FROM Order_status_table AS rdt JOIN rdt.ot AS cm")
	public List<Object> find_All_orderdetail_Status_Order();
	
	
	
	@Query("select cm.order_id,cm.ordered_by,cm.date_of_order,cm.type_of_vaccine,"
			+ "cm.Company_Name,cm.Destination_State,cm.State_regional_office,"
			+ "cm.Quantity_of_vaccine,cm.Manufacturer_Location,cm.upadted_Quantity,"
			+ "rdt.order_Status_of_Approval,rdt.comment_text,"
			+ "rdt.action_performed_by,rdt.date_of_Update_Status"
			+ " FROM Order_status_table AS rdt JOIN rdt.ot AS cm where rdt.order_Status_of_Approval = :status")
	public List<Object> find_All_orderdetail_by_pending_Status(@Param("status") Status status);
	

	
}
