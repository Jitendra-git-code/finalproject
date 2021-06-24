package vldms.models;



public class OrderResult {

	private int status;
	private  Order_detail_table content; 
	private String reason;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Order_detail_table getContent() {
		return content;
	}
	public void setContent(Order_detail_table content) {
		this.content = content;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public OrderResult(int status, Order_detail_table content, String reason) {
		super();
		this.status = status;
		this.content = content;
		this.reason = reason;
	}
	public OrderResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
