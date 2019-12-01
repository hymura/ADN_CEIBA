package co.com.ceiba.oc.builderstest;

import co.com.ceiba.oc.dominio.model.ApproverAmount;

public class ApproverAmountBuilder {
	private int userId;
	private String userName;
	private int appovalAmountInit;
	private int appovalAmountEnd;
	
		
	public ApproverAmountBuilder() {		
		this.userId=1;
		this.userName="ALEX.GOMEZ";
		this.appovalAmountInit=2000;
		this.appovalAmountEnd=5000;				
	}
		
	public ApproverAmount build() {
		return new ApproverAmount(userId, userName,appovalAmountInit,appovalAmountEnd);
	}
	
	public ApproverAmountBuilder withUserId(int userId) {
		this.userId = userId;
		return this;
	}
	
	public ApproverAmountBuilder withUerName(String userName) {
		this.userName = userName;
		return this;
	}
	
	public ApproverAmountBuilder withAppovalAmountInit(int appovalAmountInit) {
		this.appovalAmountInit = appovalAmountInit;
		return this;
	}
	
	public ApproverAmountBuilder withappovalAmountEnd(int appovalAmountEnd) {
		this.appovalAmountEnd = appovalAmountEnd;
		return this;
	}
	
	 public static ApproverAmountBuilder anApproverAmount(){
	        return new ApproverAmountBuilder();
	    }
}

