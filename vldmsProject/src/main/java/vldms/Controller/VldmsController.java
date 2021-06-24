package vldms.Controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.helpers.ThrowableToStringArray;
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
import vldms.service.ServiceInfV;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class VldmsController 
{
	
	@Autowired
	private ServiceInfV s;
	User_table logged_user =null;
	Order_detail_table order_detail= null;
	Order_status_table order_Status= null;
	
	
	@GetMapping("/userlogin")
	public User_table userLogin(@RequestParam("user_id") String user_id,
			@RequestParam("password") String password,
			@RequestParam("type_of_user") UserTypeEnum type_of_user) throws Exception
	{
	
		
		try {
			System.out.println("user id java "+user_id);
			logged_user = s.userlogin(user_id,password,type_of_user);
			if(logged_user == null)
			{
				
				throw new Exception("Login Error");
			
				
//			logged_user = new User_table();
//			logged_user.setUser_id("");
				
			}
			
			//System.out.println(logged_user.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Login Error");
			
		}
		
		return logged_user;
	}
	
	
	
	
	@PutMapping("/add")
	public UserResult addemp(@RequestBody User_table e)
	{
		//System.out.println(e.toString());
		
		//System.out.println("inside add user");
		UserResult x=null;
		
		try {
			x = s.registerUser(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return x;
	}
	
	
	@PutMapping("/createOrder")
	public OrderResult createOrder(@RequestBody Order_detail_table c_order)
	{

		System.out.println("inside Create Order");
		System.out.println(c_order.toString());
		OrderResult x = s.createOrder(c_order);
		
		return x;
	}
	
//	@PostMapping("/view/{id}")
//	public Order_detail_table vieworder(@RequestParam("order_id") int order_id, @RequestParam ("ordered_by") String ordered_by)
//	{
//		order_detail=s.viewOrder(order_id,ordered_by);
//		return order_detail;
//	}
//	
//	@PostMapping("/orderStatus")
//	public Order_status_table viewOrderStatus(@RequestParam("x") int order_id)
//	{
//		order_Status= s.viewStatus(order_id);
//		 return order_Status;
//	}
//	
	@GetMapping("/viewcancelledOrder")
	public List<JoinOrderAndStatus> viewCancelledandReject (@RequestParam("Status") Status Status)
	{
		List<JoinOrderAndStatus> listCancelledRejet= s.viewAllCancelledAndReject(Status);
		 return listCancelledRejet;
	}
	
	
	
	@GetMapping("/view")
	public List<JoinOrderAndStatus> viewAll()
	{
		List<JoinOrderAndStatus> listall= s.viewAllStatus();
		 return listall;
	}
	
	@GetMapping("/canceltheorder")
	public Order_status_table cancelOrder(@RequestParam("order_id") int order_id,@RequestParam ("ordered_by") String ordered_by)
	{
		order_Status= s.cancelOrder(order_id,ordered_by);
		 return order_Status;
	}
	
	@GetMapping("/updateorder")
	public Order_status_table updateOrder(@RequestParam("order_id") int order_id,@RequestParam ("ordered_by") String ordered_by,
			@RequestParam ("quantity_of_vaccine") int quantity_of_vaccine)
	{
		order_Status= s.updateOrder(order_id,ordered_by,quantity_of_vaccine);
		 return order_Status;
	}
	
	@GetMapping("/approvetheorder")
	public Order_status_table approvedorder(@RequestParam("order_id") int order_id,@RequestParam ("ordered_by") String ordered_by)
	{
		order_Status= s.approvedorder(order_id,ordered_by);
		 return order_Status;
	}
	
	@GetMapping("/rejecttheorder")
	public Order_status_table rejectorder(@RequestParam("order_id") int order_id,@RequestParam ("action_performed_by") String action_performed_by)
	{
		order_Status= s.rejectorder(order_id,action_performed_by);
		 return order_Status;
	}
	
	@GetMapping("/dispatchorder")
	public Order_dispatch_table dispatchorder(@RequestParam("order_id") int order_id,
			@RequestParam ("dispatched_by") String dispatched_by,@RequestParam("manufacture_date_of_vaccine") Date manufacture_date_of_vaccine)
	{
		Order_dispatch_table order_Dispatch = s.dispatchorder(order_id,dispatched_by,manufacture_date_of_vaccine);
		 return order_Dispatch;
	}
	@GetMapping("/viewbothStatus")   //BY  MOH
	public List<JoinOrderAndStatus> viewBothOrderStatus(@RequestParam("order_id") Integer order_id)
	{
		List<JoinOrderAndStatus> listall= s.viewBothStatus(order_id);
		
		 return listall;
	}
	
	

	
	@GetMapping("/pendingStatus")
	public List<JoinOrderAndStatus> viewBothOrderStatusbyStatus()
	{
		List<JoinOrderAndStatus> listall= s.viewBothStatusbypending(Status.Pending);
		 return listall;
	}
	
	
	@GetMapping("/ackworder")
	public Order_dispatch_table acknowrder(@RequestParam("order_id") int order_id,
			@RequestParam ("received_by") String received_by,@RequestParam("manufacture_date_of_vaccine") Date manufacture_date_of_vaccine,
			@RequestParam ("quantity_of_vaccine") int quantity_of_vaccine,@RequestParam ("company_Name") Companyname company_Name)
	{
		Order_dispatch_table order_Dispatch = s.acknowledgeorder(order_id,received_by,manufacture_date_of_vaccine,quantity_of_vaccine,company_Name);
		 return order_Dispatch;
	}
	
	@PutMapping("/DistributeOrder")  //BY State Officer
	public Distribution_to_district_table distribute_district(@RequestBody Distribution_to_district_table dOrder) throws Exception
	{
		Distribution_to_district_table order_Distribute = s.distribute_district(dOrder);
		if(order_Distribute==null)
		{
			order_Distribute= new Distribution_to_district_table();
			order_Distribute.setBatch_no(0);
			
		}
		 return order_Distribute;
	}	
	@GetMapping("/acknowledgeOrderbyDistrict")
	public District_dispatch_table acknowledgementOfOrder(@RequestParam("batch_no") int batch_no,
			@RequestParam ("received_by") String received_by,@RequestParam ("issue_Vaccine_quantity")
          int issue_Vaccine_quantity)
	{
		District_dispatch_table order_Dispatch = s.acknowledgementOfOrder(batch_no,received_by,issue_Vaccine_quantity);
		if(order_Dispatch==null)
		{
			order_Dispatch= new District_dispatch_table();
			order_Dispatch.setBatch_no(0);
			
		}
		 return order_Dispatch;
		
	}
	
	@PutMapping("/DistConsignment")   //BY District Officer
	public Vaccination_office_distribution distribute_vaccineOffice(@RequestBody Vaccination_office_distribution VoOrder)
	{
		Vaccination_office_distribution Cons_Distribute = s.distribute_vaccineOffice(VoOrder);
		if(Cons_Distribute==null)
		{
			Cons_Distribute= new Vaccination_office_distribution ();
			Cons_Distribute.setConsignment_no(0);;
			
		}
		 return Cons_Distribute;
	}
	
	@GetMapping("/vo_ack_receipt") //BY Vaccination  Officer to district
	public VO_dispatch_table voacknowled( @RequestParam("order_id") int order_id,
			@RequestParam("batch_no") int batch_no,
			@RequestParam ("received_by") String received_by,
			@RequestParam("consignment_no") int consignment_no, 
			@RequestParam("issue_vaccine_quantity") int issue_vaccine_quantity
			)
	{
		System.out.println("Inside VO Acknowledgement..");
		VO_dispatch_table VO_dispatch=s.voacknowledge(order_id,batch_no,received_by,consignment_no,issue_vaccine_quantity);
		if(VO_dispatch==null)
		{
			VO_dispatch= new VO_dispatch_table();
			VO_dispatch.setConsignment_no(0);;
			
		}
		
		return VO_dispatch;
		
		
	}
	
	@GetMapping("/vaccine_records")    //BY Vacc  Officer 
	public Consignment_usage_table  vaccinerecords(@RequestParam("order_id") int order_id, @RequestParam("batch_no") int batch_no,
			@RequestParam("consignment_no")int consignment_no,@RequestParam("total_quantity")int total_quantity,
			@RequestParam("consumed")int consumed,@RequestParam("damaged")int damaged,@RequestParam("remaining")int remaining)
	{
		System.out.println("inside VO Records");
		
		Consignment_usage_table  x = s.vacconsumptionrecords(order_id,batch_no,consignment_no,total_quantity,consumed,damaged,remaining);
		
		return x;
	}
	
	
	
	//see District wise Vaccine Consumption
		@GetMapping("/byDistrict")   //BY state
		public List<DistrictJoinInformation>viewDetailbyDistrict(@RequestParam("district_name") CgDistrict district_name)
		{
			
			List<DistrictJoinInformation> listall= s.viewallDetailbyDistrict(district_name);
			System.out.println(listall.toString());
			return listall;
		}
		
		
		
}

