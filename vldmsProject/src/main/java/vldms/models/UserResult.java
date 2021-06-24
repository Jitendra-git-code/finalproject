package vldms.models;



public class UserResult {

	private int status;
	private  User_table  content; 
	private String reason;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User_table getContent() {
		return content;
	}
	public void setContent(User_table content) {
		this.content = content;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public UserResult(int status, User_table content, String reason) {
		super();
		this.status = status;
		this.content = content;
		this.reason = reason;
	}
	public UserResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
