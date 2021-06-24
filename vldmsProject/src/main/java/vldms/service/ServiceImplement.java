package vldms.service;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vldms.dao.Consignment_usage_Repo;
import vldms.dao.CreateOrderRepo;
import vldms.dao.DispatchRepo;
import vldms.dao.DistrictDispatchRepo;
import vldms.dao.OrderStatusRepo;
import vldms.dao.StateRepo;
import vldms.dao.UserLoginRepo;
import vldms.dao.VO_dispatch_Repo;
import vldms.dao.Vacc_Offi_Repo;
import vldms.models.CgDistrict;
import vldms.models.Companyname;
import vldms.models.Consignment_usage_table;
import vldms.models.Distribution_to_district_table;
import vldms.models.DistrictJoinInformation;
import vldms.models.DistrictResult;
import vldms.models.District_dispatch_table;
import vldms.models.JoinOrderAndStatus;
import vldms.models.Office_loc;
import vldms.models.OrderDispatchResult;
import vldms.models.OrderResult;
import vldms.models.Order_detail_table;
import vldms.models.Order_dispatch_table;
import vldms.models.Order_status_table;
import vldms.models.RegCenter;
import vldms.models.Status;
import vldms.models.UserResult;
import vldms.models.UserTypeEnum;
import vldms.models.User_table;
import vldms.models.VO_dispatch_table;
import vldms.models.Vaccination_office_distribution;
import vldms.models.VaccineType;
import vldms.models.deststate;
import vldms.models.mrf_loaction;


@Service
public class ServiceImplement implements ServiceInfV
{
	    @Autowired
		private UserLoginRepo rp;
	    @Autowired
	    private CreateOrderRepo crp;
	    @Autowired
	    private OrderStatusRepo st;
	    @Autowired
	    private DispatchRepo dpr;
	    @Autowired
	    private StateRepo srp;
	    @Autowired
	    private DistrictDispatchRepo ddrp;
	    @Autowired
	    private Vacc_Offi_Repo vr;
	    @Autowired
	    private VO_dispatch_Repo vd;
	    @Autowired
	    private Consignment_usage_Repo cu;
	    
	    
	    User_table logged_user = new User_table();
	    Order_detail_table order_detail= new Order_detail_table();
	    Order_status_table order_Status= new Order_status_table();
	    Order_dispatch_table order_Dispatch= new Order_dispatch_table();
	    Distribution_to_district_table distribute_district= new Distribution_to_district_table();
	    District_dispatch_table district_dispatch  = new District_dispatch_table();
	    Vaccination_office_distribution  vo_dist=new Vaccination_office_distribution ();
	    VO_dispatch_table vo_disp=new VO_dispatch_table();
	    Consignment_usage_table con= new Consignment_usage_table();
	   
	    
	    @Override
	public User_table userlogin(String userid, String password, UserTypeEnum usertype) 
	{
//		//System.out.println("Inside Service Implementation "+rp.f1(userid,password,usertype));
//		Optional<User_table2> e = rp.f1(userid,password,usertype);
//	     logged_user=e.get();
//		
//		
//		//System.out.println(e.toString());
//		return Optional.of(logged_user);
		
		Optional<User_table> e = rp.findById(userid);
		
		if(e.isEmpty())
		{
			System.out.println("Userid not present");
			logged_user = null;
		}
	     
		else if(e.get().getPassword().equalsIgnoreCase(password)&& e.get().getType_of_user().equals(usertype))
		    {
			   
			   System.out.println("user is logged successfully  ");
		     	
		     	logged_user=e.get();
		     	logged_user.setPassword("XX");
		     	
		    }

		    
		    else
		    {
		    	System.out.println(" either userid/password or User type is not correct ");
		    	logged_user = null;
		    	
		    }
		
		
		return logged_user;
		
	}

	 @Override
	public UserResult registerUser(User_table e)
	{
		
		UserResult e1= new UserResult(0, e, "failed due to user not ");
		  try {
			   rp.save(e);
			  e1.setReason("Succesfully register");
			  e1.setStatus(1);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
          return e1;
	}
	@Override
	public OrderResult createOrder(Order_detail_table c_order)
	{
		OrderResult e1= new OrderResult(0, c_order, "failed due to user not found");
		  try {
			     System.out.println("before " + order_detail.getOrder_id());
			     
			     Order_detail_table order= crp.save(c_order);
			     
			   
			     System.out.println("after " + order.getOrder_id());
			     System.out.println("after " + c_order.getOrder_id());
			    	 
			     order_Status.setDate_of_Update_Status(new Timestamp(System.currentTimeMillis()));		   
			     order_Status.setOrder_id(order.getOrder_id());
			     order_Status.setAction_performed_by(order.getOrdered_by());
			     order_Status.setOrder_Status_of_Approval(Status.Pending);
			     order_Status.setComment_text("Waiting for approval");
			     st.save(order_Status);
			     
			     
			  e1.setReason("Succesfully register");
			  e1.setStatus(1);
		}  catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
        return e1;
		
	}
	/*	@Override
	public Order_detail_table viewOrder(int order_id, String order_by)
	{
		Optional<Order_detail_table> e = crp.findById(order_id);
	     
		   if(e.get().getOrdered_by().equalsIgnoreCase(order_by))
		    {
			   
			   System.out.println("Order is found");
			   order_detail=e.get();
		    }

		    
		    else
		    {
		    	System.out.println(" Something went wrong incorrect entries");
		    }
		
		
		return order_detail;
	}
	@Override
	public Order_status_table viewStatus(int order_id) {
		Optional<Order_status_table> or = st.findById(order_id);
	     
		   if(or.isPresent())
		    {
			   
			   System.out.println("Order is found");
			   order_Status=or.get();
		    }

		    
		    else
		    {
		    	System.out.println("Incrrocet");
		    }
		
		
		return order_Status;
	}*/
	@Override
	public List<JoinOrderAndStatus> viewAllStatus() //view by Moh
	{
            List<Object> list1 = st.find_All_orderdetail_Status_Order();
    	 
    	 

    	 List<JoinOrderAndStatus> joinResult = new ArrayList<JoinOrderAndStatus>();
   	    for (Object obj  : list1 )
 		{
   		    Object [] temp= (Object []) obj;
   		   JoinOrderAndStatus temp2 = new JoinOrderAndStatus();
   		   temp2.setOrder_id((int)temp[0]);
   		   temp2.setOrdered_by((String) temp[1]);
   		   temp2.setDate_of_order((Timestamp) temp[2]);
   		   temp2.setType_of_vaccine((VaccineType)temp[3]);
   		   temp2.setCompany_Name((Companyname)temp[4]);
   		   temp2.setDestination_State((deststate)temp[5]);
   		   temp2.setState_regional_office((RegCenter)temp[6]);
   		   temp2.setQuantity_of_vaccine((int) temp[7]);
   		   temp2.setManufactur_Location((mrf_loaction)temp[8]);
   		   temp2.setUpadted_Quantity((boolean) temp[9]);
   		   
   		   temp2.setOrder_Status_of_Approval((Status)temp[10]);
   		   temp2.setComment_text((String)temp[11]);
   		   temp2.setAction_performed_by((String)temp[12]);
   		   temp2.setDate_of_Update_Status((Timestamp)temp[13]);
   		   joinResult.add(temp2);
 			
 		}
    	 
    	 System.out.println(joinResult.toString());
    	 
	    
			return joinResult;
		
	}
	
	@Override
	public Order_status_table cancelOrder(int order_id,String ordered_by)
  {
		Optional<Order_status_table> or = st.findById(order_id);
		order_Status=or.get();
		try{
			 if(order_Status.getOrder_Status_of_Approval().equals(Status.Pending))
		{
			
			 order_Status.setDate_of_Update_Status(or.get().getDate_of_Update_Status());
		     order_Status.setAction_performed_by(or.get().getAction_performed_by());
		     order_Status.setOrder_Status_of_Approval(Status.Cancelled);
		     order_Status.setComment_text("Wrong entry");
		     st.save(order_Status);
		}
		else
		{
           System.out.println("Order is not cancel becouse either it is approved or already canceled");
           return order_Status=null;
		}
	}
		 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 }
		return order_Status;
	}

	
	
	@Override
	public Order_status_table updateOrder(int order_id, String order_by,int quantity) {
		Optional<Order_status_table> or = st.findById(order_id);
		order_Status=or.get();
		Optional<Order_detail_table> e1 = crp.findById(order_id);
		Order_detail_table up= e1.get();
		
		try {
			if(order_Status.getOrder_Status_of_Approval().equals(Status.Pending))
			{
				  order_detail.setQuantity_of_vaccine(quantity);
				  order_detail.setUpadted_Quantity(true);
				  order_detail.setCompany_Name(up.getCompany_Name());
				  order_detail.setDate_of_order(up.getDate_of_order());
				  order_detail.setManufacturer_Location(up.getManufacturer_Location());
				  order_detail.setState_regional_office(up.getState_regional_office());
				  order_detail.setType_of_vaccine(up.getType_of_vaccine());
				  order_detail.setOrdered_by(up.getOrdered_by());
				  order_detail.setOrder_id(up.getOrder_id());
				  order_detail.setDestination_State(up.getDestination_State());
				  crp.save(order_detail);
				  
				  
				 order_Status.setDate_of_Update_Status(new Timestamp(System.currentTimeMillis()));
			     order_Status.setOrder_Status_of_Approval(Status.Pending);
			     order_Status.setAction_performed_by(order_by);
			     order_Status.setComment_text("Order placed after updation");
			     st.save(order_Status);
			}
			else
			{
               System.out.println("rejected order not found");
               return order_Status=null;
			}
		}
			 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order_Status;
	}
	
	@Override
	public Order_status_table approvedorder(int order_id, String ordered_by)
	{
		Optional<Order_status_table> or = st.findById(order_id);
		order_Status=or.get();
		//need to add checking current order status
		
		   try {
			if(order_Status.getOrder_Status_of_Approval().equals(Status.Pending))
			   {   
			     order_Status.setDate_of_Update_Status(new Timestamp(System.currentTimeMillis()));
			     order_Status.setAction_performed_by(ordered_by);
			     order_Status.setOrder_Status_of_Approval(Status.Approved);
			     order_Status.setComment_text("Your Order is Approved");
			     st.save(order_Status);
			   }
			
			else
			{
				 //System.out.println("Order is not approved becouse either it is canceled or rejected or already approved");
				  order_Status=null;
				 throw new Exception("Order is not approved becouse either it is canceled or rejected or already approved");
	          
	          
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return order_Status;
	}
	@Override
	public Order_status_table rejectorder(int order_id, String action_performed_by) {
		Optional<Order_status_table> or = st.findById(order_id);
		order_Status=or.get();
		
		
		try {
			if(order_Status.getOrder_Status_of_Approval().equals(Status.Pending))
				
			{
			     order_Status.setDate_of_Update_Status(new Timestamp(System.currentTimeMillis()));
			     order_Status.setAction_performed_by(action_performed_by);
			     order_Status.setOrder_Status_of_Approval(Status.Reject);
			     order_Status.setComment_text("Your Order is Rejected due to wrong quantity");
			     st.save(order_Status);
			}
			else
			{
			   System.out.println("Order is not rejected becouse either it is canceled or already approved");
			   return order_Status=null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order_Status;
	}
	@Override
	public Order_dispatch_table dispatchorder(int order_id, String dispatched_by,Date manf_date ) 
	{
		
		
		try {
		       Optional<Order_detail_table> query_op = crp.findById(order_id);
		       System.out.println(query_op.get().toString());
		       Order_detail_table order_table_obj =query_op.get();
		       
		       Optional<Order_status_table> status = st.findById(order_id);
		       order_Status =status.get();
		       
		       if(order_Status.getOrder_Status_of_Approval().equals(Status.Approved))
		       {
			    	order_Dispatch.setOrder_id(order_table_obj.getOrder_id());
					order_Dispatch.setManufacture_location(order_table_obj.getManufacturer_Location());
					order_Dispatch.setManufacture_date_of_vaccine(manf_date);
					order_Dispatch.setDestination_State(order_table_obj.getDestination_State());
					order_Dispatch.setDestination_address(order_table_obj.getState_regional_office());
					order_Dispatch.setDispatch_date(new Timestamp(System.currentTimeMillis()));
					order_Dispatch.setDispatched_by(dispatched_by);
					order_Dispatch.setReceived_by(null);
					order_Dispatch.setLast_update_date(new Timestamp(System.currentTimeMillis()));
					System.out.println("Final order status object to be writtten "+order_Dispatch.toString());
					dpr.save(order_Dispatch);
				
		       }
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				System.out.println("Order id is not present in the system please check");
				
			
			}
	  
			
		
		return order_Dispatch;
	}
	@Override
	public Order_dispatch_table acknowledgeorder(int order_id, String received_by, Date manufacture_date_of_vaccine,
			int quantity_of_vaccine, Companyname company_Name) {
		
		 Optional<Order_detail_table> query_op = crp.findById(order_id);
		 System.out.println(query_op.get().toString());
		  order_detail = query_op.get();
		  
		  Optional<Order_dispatch_table> query_op2 = dpr.findById(order_id);
		  order_Dispatch = query_op2.get();
		  
		  if(order_detail.getOrder_id()==order_id && order_detail.getQuantity_of_vaccine()==quantity_of_vaccine
		      && order_detail.getCompany_Name().equals(company_Name)
		      && order_Dispatch.getManufacture_date_of_vaccine().equals(manufacture_date_of_vaccine))
		  {
			  order_Dispatch.setLast_update_date(new Timestamp(System.currentTimeMillis()));
			  order_Dispatch.setReceived_by(received_by);
			  
			  System.out.println("Order is received");
			  dpr.save(order_Dispatch);
			  
		  }
		  else {
		
	 		  
				System.out.println("Order id is not present in the system please check");
				
		  }
			
	  
			
		
		return order_Dispatch;
	}
	@Override
	public Distribution_to_district_table distribute_district(Distribution_to_district_table dOrder) throws Exception
	{
		System.out.println("order id is "+ dOrder.getOrder_id());
		List<Distribution_to_district_table> list_of_entry_already_distributed = srp.findByOrderId(dOrder.getOrder_id());
		System.out.println("no of record in db "+list_of_entry_already_distributed.size());
		
		//distribute_district = query_op.get();
		//System.out.println("db rows "+ distribute_district.toString());
		
		int consumed= 0;
		
		
		Optional<Order_detail_table> query_op1 = crp.findById(dOrder.getOrder_id());
		Order_detail_table orderDObj = query_op1.get();
		Optional<Order_dispatch_table> query_op2 = dpr.findById(dOrder.getOrder_id());
		Order_dispatch_table orderStatus = query_op2.get();
	
		if(list_of_entry_already_distributed.isEmpty())
		{
			if(dOrder.getIssue_Vaccine_quantity()<=orderDObj.getQuantity_of_vaccine())
			{
				dOrder.setDistribution_Date(new Timestamp(System.currentTimeMillis()));
				srp.save(dOrder);
				district_dispatch.setBatch_no(dOrder.getBatch_no());
				district_dispatch.setDestination_address(dOrder.getDistrict_name());
				district_dispatch.setDispatch_date(new Timestamp(System.currentTimeMillis()));
				district_dispatch.setDispatched_by(orderStatus.getReceived_by());
				district_dispatch.setLast_update_date(new Timestamp(System.currentTimeMillis()));
				district_dispatch.setReceived_by(null);
				district_dispatch.setSource_address(orderDObj.getState_regional_office());
				System.out.println("1st distribution to district "+ district_dispatch.toString());
				ddrp.save(district_dispatch);
				
			}
			else
			{
				dOrder=null;
				System.out.println("Quantity of vaccine entered to allocate is higher then total quantity available for this order");
				throw new Exception("Quantity of vaccine entered to allocate is higher then total quantity available for this order");
				
			}
			
		}
		else
		{
			
			System.out.println("inside list logic");
		  //List<Distribution_to_district_table> list_of_issue_quantity = srp.findAll();
			
			for(Distribution_to_district_table list:list_of_entry_already_distributed)
			{
				if (list.getOrder_id()==dOrder.getOrder_id())
				{
					consumed=consumed+list.getIssue_Vaccine_quantity();
				}
			       
			}	
	    	System.out.println(consumed);
	    	
	    	if(dOrder.getIssue_Vaccine_quantity()<=orderDObj.getQuantity_of_vaccine()-consumed)
			{
	    		
				dOrder.setDistribution_Date(new Timestamp(System.currentTimeMillis()));
				srp.save(dOrder);
				
				district_dispatch.setBatch_no(dOrder.getBatch_no());
				district_dispatch.setDestination_address(dOrder.getDistrict_name());
				district_dispatch.setDispatch_date(new Timestamp(System.currentTimeMillis()));
				district_dispatch.setDispatched_by(orderStatus.getReceived_by());
				district_dispatch.setLast_update_date(new Timestamp(System.currentTimeMillis()));
				district_dispatch.setReceived_by(null);
				district_dispatch.setSource_address(orderDObj.getState_regional_office());
				
				
				System.out.println("already some part is distributed "+ district_dispatch.toString());
				ddrp.save(district_dispatch);
				System.out.println("your order is Ready to distribute");
			}
			else
			{
				dOrder=null;
				System.out.println("Quantity of vaccine entered to allocate is not available");
			}
			
		}
		
		
		
		return dOrder;
	}	

	
	
	@Override
	public District_dispatch_table acknowledgementOfOrder(int batch_no, String received_by,
			              int issue_Vaccine_quantity)
	{
		Optional<District_dispatch_table> query_op = ddrp.findById(batch_no);
		District_dispatch_table  district_dispatch = query_op.get();
		 Optional<Distribution_to_district_table> query_op1 = srp.findById(batch_no);
		 distribute_district=query_op1.get();
		 
		  
		  if(distribute_district.getBatch_no()==batch_no && 
				  distribute_district.getIssue_Vaccine_quantity()==issue_Vaccine_quantity )
		  {
			  district_dispatch.setLast_update_date(new Timestamp(System.currentTimeMillis()));
			  district_dispatch.setReceived_by(received_by);
			  ddrp.save(district_dispatch);
			  System.out.println("Order is received");
			  
		  }
		  else
		  {
		
			  
			   district_dispatch=null;
				System.out.println("Batch no is not present in the system please check");
				
		  }
			
	  
			
		
		return district_dispatch;
	}
	@Override
	public List<JoinOrderAndStatus> viewBothStatus(Integer order_id) 
	{
		 List<Object> list3 =st.FindBothOrderDetailAndStatus(order_id);
		 List<JoinOrderAndStatus> joinResult = new ArrayList<JoinOrderAndStatus>();
	   	    for (Object obj  : list3 )
	 		{
	   		    Object [] temp= (Object []) obj;
	   		   JoinOrderAndStatus temp2 = new JoinOrderAndStatus();
	   		   temp2.setOrder_id((int)temp[0]);
	   		   temp2.setOrdered_by((String) temp[1]);
	   		   temp2.setDate_of_order((Timestamp) temp[2]);
	   		   temp2.setType_of_vaccine((VaccineType)temp[3]);
	   		   temp2.setCompany_Name((Companyname)temp[4]);
	   		   temp2.setDestination_State((deststate)temp[5]);
	   		   temp2.setState_regional_office((RegCenter)temp[6]);
	   		   temp2.setQuantity_of_vaccine((int) temp[7]);
	   		   temp2.setManufactur_Location((mrf_loaction)temp[8]);
	   		   temp2.setUpadted_Quantity((boolean) temp[9]);
	   		   
	   		   temp2.setOrder_Status_of_Approval((Status)temp[10]);
	   		   temp2.setComment_text((String)temp[11]);
	   		   temp2.setAction_performed_by((String)temp[12]);
	   		   temp2.setDate_of_Update_Status((Timestamp)temp[13]);
	   		   joinResult.add(temp2);
	 			
	 		}
	    	 
	    	 
	    	 
		    
				return joinResult;
	}
	
	@Override
	public List<JoinOrderAndStatus> viewBothStatusbypending(Status status) 
	{
	
		 List<Object> list2 =st.find_All_orderdetail_by_pending_Status(status);
		
		 List<JoinOrderAndStatus> joinResult = new ArrayList<JoinOrderAndStatus>();
	   	    for (Object obj  : list2 )
	 		{
	   		    Object [] temp= (Object []) obj;
	   		   JoinOrderAndStatus temp2 = new JoinOrderAndStatus();
	   		   temp2.setOrder_id((int)temp[0]);
	   		   temp2.setOrdered_by((String) temp[1]);
	   		   temp2.setDate_of_order((Timestamp) temp[2]);
	   		   temp2.setType_of_vaccine((VaccineType)temp[3]);
	   		   temp2.setCompany_Name((Companyname)temp[4]);
	   		   temp2.setDestination_State((deststate)temp[5]);
	   		   temp2.setState_regional_office((RegCenter)temp[6]);
	   		   temp2.setQuantity_of_vaccine((int) temp[7]);
	   		   temp2.setManufactur_Location((mrf_loaction)temp[8]);
	   		   temp2.setUpadted_Quantity((boolean) temp[9]);
	   		   
	   		   temp2.setOrder_Status_of_Approval((Status)temp[10]);
	   		   temp2.setComment_text((String)temp[11]);
	   		   temp2.setAction_performed_by((String)temp[12]);
	   		   temp2.setDate_of_Update_Status((Timestamp)temp[13]);
	   		   joinResult.add(temp2);
	 			
	 		}
	    	 
	    	 
	    	 
		    
				return joinResult;
		
		
	
	}
	
	
	
	
	@Override
	public VO_dispatch_table voacknowledge(int order_id, int batch_no,String received_by, int consignment_no, int issue_vaccine_quantity) 
	{
		Optional<VO_dispatch_table> query_op2= vd.findById(consignment_no);
		 vo_disp =query_op2.get();
		 System.out.println(vo_disp.toString());
		 
		 Optional<Vaccination_office_distribution> query_op3= vr.findById(consignment_no);
		 vo_dist= query_op3.get();
		
		 		 
		 if(vo_disp.getOrder_id() == order_id && vo_disp.getBatch_no() == batch_no
				 && vo_disp.getConsignment_no()==consignment_no
				&& vo_dist.getIssue_vaccine_quantity()== issue_vaccine_quantity)
		 {
			 vo_disp.setLast_update_date(new Timestamp(System.currentTimeMillis()));
			 vo_disp.setReceived_by(received_by);
			 vd.save(vo_disp);
			 System.out.println("Consignment is received"); 
		 }
		 else 
		 {
			 vo_dist=null;
			 System.out.println("Consignment id is not present in the system please check");
		 }
		 
		return vo_disp;
	}



	@Override
	public Vaccination_office_distribution distribute_vaccineOffice(Vaccination_office_distribution voOrder) 
	{
		System.out.println(voOrder.toString());
		
		
		List<Vaccination_office_distribution> list_of_entry_already_distributed=vr.findByBatch_no(voOrder.getBatch_no());
		int consumed= 0;
		Optional<District_dispatch_table> query_op1 = ddrp.findById(voOrder.getBatch_no());
		District_dispatch_table  op1 = query_op1.get();
		 Optional<Distribution_to_district_table> query_op2 = srp.findById(voOrder.getBatch_no());
		 distribute_district =query_op2.get();
		System.out.println("district dispatch table "+ distribute_district.toString());
		
		
	    
		if(list_of_entry_already_distributed.isEmpty())
		{
			if(voOrder.getIssue_vaccine_quantity()<=distribute_district.getIssue_Vaccine_quantity())
			{
				
				voOrder.setDistribution_date(new Timestamp(System.currentTimeMillis()));
				vr.save(voOrder);
     			vo_disp.setOrder_id(distribute_district.getOrder_id());
     			vo_disp.setBatch_no(voOrder.getBatch_no());
     			vo_disp.setConsignment_no(voOrder.getConsignment_no());
     			vo_disp.setDestination_address(voOrder.getVacc_office_location());
     			vo_disp.setDispatch_date(voOrder.getDistribution_date());
     			vo_disp.setLast_update_date(new Timestamp(System.currentTimeMillis()));
     			vo_disp.setDispatched_by(op1.getDispatched_by());
     			vo_disp.setReceived_by(null);
     			vo_disp.setSource_addresss(distribute_district.getDistrict_name());
     			vo_disp.setLast_update_date(new Timestamp(System.currentTimeMillis()));
     			vd.save(vo_disp);
				System.out.println("Rock and Roll");
			}
			else
			{
				voOrder=null;
				System.out.println("Quantity of vaccine entered to allocate is higher then total quantity available for this order");
			}
		}
		
		
		else
		{
			
			System.out.println("inside list logic");
			  
				
				for(Vaccination_office_distribution list:list_of_entry_already_distributed)
				{
					if((list.getBatch_no()==voOrder.getBatch_no()))
					consumed=consumed+list.getIssue_vaccine_quantity();
				}
					
				
					
		    	System.out.println(consumed);
		    	
		    	if(voOrder.getIssue_vaccine_quantity()<=distribute_district.getIssue_Vaccine_quantity())
				{
					
					voOrder.setDistribution_date(new Timestamp(System.currentTimeMillis()));
					vr.save(voOrder);
	     			vo_disp.setOrder_id(distribute_district.getOrder_id());
	     			vo_disp.setBatch_no(voOrder.getBatch_no());
	     			vo_disp.setConsignment_no(voOrder.getConsignment_no());
	     			vo_disp.setDestination_address(voOrder.getVacc_office_location());
	     			vo_disp.setDispatch_date(voOrder.getDistribution_date());
	     			vo_disp.setLast_update_date(new Timestamp(System.currentTimeMillis()));
	     			vo_disp.setDispatched_by(op1.getDispatched_by());
	     			vo_disp.setReceived_by(null);
	     			vo_disp.setSource_addresss(distribute_district.getDistrict_name());
	     			vo_disp.setLast_update_date(new Timestamp(System.currentTimeMillis()));
	     			vd.save(vo_disp);
					System.out.println("Rock and Roll");
				}
				else
				{
					voOrder=null;
					System.out.println("Quantity of vaccine entered to allocate is higher then total quantity available for this order");
				}
			
		}
		
		return voOrder;
	}



	@Override
	public Consignment_usage_table vacconsumptionrecords(int order_id, int batch_no, int consignment_no,
			int total_quantity, int consumed, int damaged, int remaining) 
	{
		//Optional<Consignment_usage_table> query_op=cu.findById(consignment_no);
		//con=query_op.get();
		
//		Optional<VO_dispatch_table> query_op2= vd.findById(consignment_no);
//		 vo_disp =query_op2.get(); 
		 
		 Optional<Vaccination_office_distribution> query_op3= vr.findById(consignment_no);
		 vo_dist= query_op3.get();
		 
		
		if(vo_dist.getOrder_id()==order_id && vo_dist.getBatch_no()==batch_no && vo_dist.getConsignment_no()==consignment_no
					&& vo_dist.getIssue_vaccine_quantity()==total_quantity)
		{
			con.setConsignment_no(consignment_no);
			con.setTotal_quantity(total_quantity);
			con.setConsumed(consumed);
			con.setDamaged(damaged);
			con.setRemaining(remaining);
			con.setDate(new Timestamp(System.currentTimeMillis()));
			cu.save(con);
				 System.out.println("Consignment Data is saved into the table"); 
		}
		else 
		{
				System.out.println("Consignment id is not present in the system please check");
		}
			 
			return con;

  }
	@Override
	public List<DistrictJoinInformation> viewallDetailbyDistrict(CgDistrict district_name) 
	{
		List<Object> detail_list = srp.find_Alldetail_by_district(district_name);
		
		
		
		
		List<DistrictJoinInformation> joinResult = new ArrayList<DistrictJoinInformation>();
	   	   for (Object obj  : detail_list )
	 		{
	   		    Object [] temp= (Object []) obj;
	   		 DistrictJoinInformation temp2 = new DistrictJoinInformation();
	   		   temp2.setOrder_id((int)temp[0]);
	   		   temp2.setBatch_no((int) temp[1]);
	   		   temp2.setDistrict_name((CgDistrict) temp[2]);
	   		   temp2.setDistribution_Date_from_State((Timestamp) temp[3]);
	   		   temp2.setIssue_Vaccine_from_State((int) temp[4]);
	   		   temp2.setConsignment_no((int) temp[5]);
	   		   temp2.setVacc_office_location((Office_loc) temp[6]);
	   		   temp2.setIssue_vaccine_quantity_from_district((int) temp[7]);
	   		   temp2.setDistribution_date_from_district((Timestamp) temp[8]);
	   		   temp2.setTotal_quantity((int)temp[9]); 
               temp2.setConsumed((int)temp[10]);
	   		   temp2.setDamaged((int)temp[11]);
	   		   temp2.setRemaining((int)temp[12]);
	   		   
	   		   
	   		
	   		 joinResult.add(temp2);
	 			
	 		}
	    	 
	    	  System.out.println(joinResult.toString());
		
		return joinResult;
	
	}
	
	
	
	@Override
	public List<JoinOrderAndStatus> viewAllCancelledAndReject(Status status) 
	{
		List<Object> list2 =st.find_All_orderdetail_by_pending_Status(status);
		
		 List<JoinOrderAndStatus> joinResult = new ArrayList<JoinOrderAndStatus>();
	   	    for (Object obj  : list2 )
	 		{
	   		    Object [] temp= (Object []) obj;
	   		   JoinOrderAndStatus temp2 = new JoinOrderAndStatus();
	   		   
	   		   temp2.setOrder_id((int)temp[0]);
	   		   temp2.setOrdered_by((String) temp[1]);
	   		   temp2.setDate_of_order((Timestamp) temp[2]);
	   		   temp2.setType_of_vaccine((VaccineType)temp[3]);
	   		   temp2.setCompany_Name((Companyname)temp[4]);
	   		   temp2.setDestination_State((deststate)temp[5]);
	   		   temp2.setState_regional_office((RegCenter)temp[6]);
	   		   temp2.setQuantity_of_vaccine((int) temp[7]);
	   		   temp2.setManufactur_Location((mrf_loaction)temp[8]);
	   		   temp2.setUpadted_Quantity((boolean) temp[9]);
	   		   temp2.setOrder_Status_of_Approval((Status)temp[10]);
	   		   temp2.setComment_text((String)temp[11]);
	   		   temp2.setAction_performed_by((String)temp[12]);
	   		   temp2.setDate_of_Update_Status((Timestamp)temp[13]);
	   		   joinResult.add(temp2);
	 			
	 		}
	    	 
	    	 
	    	 
		    
				return joinResult;
	}
}
