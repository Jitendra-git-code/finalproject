package vldms.models;

public class DistrictResult {
	private int status;
	private  Distribution_to_district_table content; 
	private String reason;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Distribution_to_district_table getContent() {
		return content;
	}
	public void setContent(Distribution_to_district_table content) {
		this.content = content;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public DistrictResult(int status, Distribution_to_district_table content, String reason) {
		super();
		this.status = status;
		this.content = content;
		this.reason = reason;
	}
	public DistrictResult() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	
	
}
