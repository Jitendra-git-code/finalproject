package vldms.service;


import java.sql.Date;
import java.util.List;

import vldms.models.CgDistrict;
import vldms.models.Companyname;
import vldms.models.Consignment_usage_table;
import vldms.models.Distribution_to_district_table;
import vldms.models.DistrictJoinInformation;
import vldms.models.DistrictResult;
import vldms.models.District_dispatch_table;
import vldms.models.JoinOrderAndStatus;
import vldms.models.OrderDispatchResult;
import vldms.models.OrderResult;
import vldms.models.Order_detail_table;
import vldms.models.Order_dispatch_table;
import vldms.models.Order_status_table;
import vldms.models.Status;
import vldms.models.UserResult;
import vldms.models.UserTypeEnum;
import vldms.models.User_table;
import vldms.models.VO_dispatch_table;
import vldms.models.Vaccination_office_distribution;

public interface ServiceInfV 
{

	
	User_table userlogin(String userid,String password,UserTypeEnum usertype);

	UserResult registerUser(User_table e);

	OrderResult createOrder(Order_detail_table c_order);

	//Order_detail_table viewOrder(int order_id, String order_by);

	//Order_status_table viewStatus(int order_id);

	List<JoinOrderAndStatus> viewAllStatus();

	Order_status_table cancelOrder(int order_id, String order_by);

	Order_status_table approvedorder(int order_id, String order_by);

	Order_status_table updateOrder(int order_id, String order_by,int quantity);

	Order_status_table rejectorder(int order_id, String reject_by);

	Order_dispatch_table dispatchorder(int order_id, String dispatched_by,Date manf_date);

	Order_dispatch_table acknowledgeorder(int order_id, String received_by, Date manf_date, int quantity_of_vaccine,
			Companyname company_Name);

	Distribution_to_district_table distribute_district(Distribution_to_district_table dOrder) throws Exception;

	District_dispatch_table acknowledgementOfOrder(int batch_no, String received_by, int quantity_of_vaccine);

	List<JoinOrderAndStatus> viewBothStatus(Integer order_id);

	List<JoinOrderAndStatus> viewBothStatusbypending(Status status);
	
	VO_dispatch_table voacknowledge(int order_id, int batch_no, String received_by, int consignment_no, int issue_vaccine_quantity);

	Vaccination_office_distribution distribute_vaccineOffice(Vaccination_office_distribution voOrder);

   Consignment_usage_table vacconsumptionrecords(int order_id, int batch_no, int consignment_no, int total_quantity,
			int consumed, int damaged, int remaining);

     List<DistrictJoinInformation> viewallDetailbyDistrict(CgDistrict district_name);

	List<JoinOrderAndStatus> viewAllCancelledAndReject(Status status);
}
