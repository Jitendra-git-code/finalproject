package vldms.models;

public class OrderDispatchResult 
{
	private int status;
	private  Order_dispatch_table content; 
	private String reason;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Order_dispatch_table getContent() {
		return content;
	}
	public void setContent(Order_dispatch_table content) {
		this.content = content;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public OrderDispatchResult(int status, Order_dispatch_table content, String reason) {
		super();
		this.status = status;
		this.content = content;
		this.reason = reason;
	}
	public OrderDispatchResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDispatchResult [status=");
		builder.append(status);
		builder.append(", content=");
		builder.append(content);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}
	
}
