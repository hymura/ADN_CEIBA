package co.com.ceiba.oc.dominio.model;

import java.util.Date;



import static java.util.Objects.requireNonNull;

public class ApprovalOrder {
	
	private int approvalId;
	private Date approvalDate;
	private int appovalAmount;
	private PurchaseOrder purchaseOder;
	private ApproverAmount approvalAmount; 
	//private StatusPurchase statusPurchase;
	
	
	public ApprovalOrder(int approvalId, Date approvalDate,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approvalAmount) {

			this.approvalId = approvalId;
			this.approvalDate = approvalDate;
			this.appovalAmount = appovalAmount;
			this.purchaseOder = requireNonNull(purchaseOder);
			this.approvalAmount = requireNonNull(approvalAmount);		
	}
	
	
	

	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public int getAppovalAmount() {
		return appovalAmount;
	}
	public void setAppovalAmount(int appovalAmount) {
		this.appovalAmount = appovalAmount;
	}
		
	public int getPurchaseOder() {
		return purchaseOder.getPoHeaderId();
	}

	public void setPurchaseOder(PurchaseOrder purchaseOder) {
		this.purchaseOder = purchaseOder;
	}





	public ApproverAmount getApprovalAmount() {
		return approvalAmount;
	}


	public void setApprovalAmount(ApproverAmount approvalAmount) {
		this.approvalAmount = approvalAmount;
	}



/*	public StatusPurchase getStatusPurchase() {
		return statusPurchase;
	}

	public void setStatusPurchase(StatusPurchase statusPurchase) {
		this.statusPurchase = statusPurchase;
	}
	
	*/
	

}
