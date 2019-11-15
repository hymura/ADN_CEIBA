package co.com.ceiba.oc.dominio.model;


public class ApproverAmount {	
	private int userId;
	private String userName; 
	private int appovalAmountInit;
	private int appovalAmountEnd;
	private String status;
	

	public ApproverAmount() {
		super();
	}
	
	public ApproverAmount(int userId, String userName, int appovalAmountInit, int appovalAmountEnd, String status) {
		this.userId = userId;
		this.userName = userName;
		this.appovalAmountInit = appovalAmountInit;
		this.appovalAmountEnd = appovalAmountEnd;
		this.status = status;
	}
/*	
	public ApproverAmount(int userId) {
		this.userId = userId;
	}
	
*/	
		
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAppovalAmountInit() {
		return appovalAmountInit;
	}
	public void setAppovalAmountInit(int appovalAmountInit) {
		this.appovalAmountInit = appovalAmountInit;
	}
	public int getAppovalAmountEnd() {
		return appovalAmountEnd;
	}
	public void setAppovalAmountEnd(int appovalAmountEnd) {
		this.appovalAmountEnd = appovalAmountEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
