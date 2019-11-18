package co.com.ceiba.oc.dominio.model;


public class ApproverAmount {	
	private int userId;
	private String userName; 
	private int appovalAmountInit;
	private int appovalAmountEnd;
	private String status;
	private static final String ESTADO_ACTIVO="ACTIVO";

	public ApproverAmount() {
		
	}
		
	public ApproverAmount(int userId, String userName, int appovalAmountInit, int appovalAmountEnd, String status) {
		this.userId = userId;
		this.userName = userName;
		this.appovalAmountInit = appovalAmountInit;
		this.appovalAmountEnd = appovalAmountEnd;
		this.status = status;
	}
	
	
	public ApproverAmount(int userId, String userName, int appovalAmountInit, int appovalAmountEnd) {
		this.userId = userId;
		this.userName = userName;
		this.appovalAmountInit = appovalAmountInit;
		this.appovalAmountEnd = appovalAmountEnd;
		this.status = ESTADO_ACTIVO;
	}
	
	
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
		
		if (appovalAmountInit>0) {
		this.appovalAmountInit = appovalAmountInit;
		}else {
			throw new IllegalArgumentException("El rango inicial debe ser mayor a 0 :"+appovalAmountInit);
		}
	}
	
	public int getAppovalAmountEnd() {
		return appovalAmountEnd;
	}
	
	public void setAppovalAmountEnd(int appovalAmountEnd) {
		if (appovalAmountEnd>this.appovalAmountInit) {
		     this.appovalAmountEnd = appovalAmountEnd;
		}else {
			throw new IllegalArgumentException("El rango final :"+appovalAmountEnd+" Debe ser mayor al inicial "+this.appovalAmountInit);
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
				      this.status = status;	
	}
	
	
}
