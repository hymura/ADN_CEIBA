package co.com.ceiba.oc.dominio.model;

import java.util.Date;

import static java.util.Objects.requireNonNull;

public class ApprovalOrder {
	
	private int approvalId;
	private Date approvalDate;
	private int appovalAmount;
	private PurchaseOrder purchaseOder;
	private ApproverAmount approverAmount; 
	//private StatusPurchase statusPurchase;
	
	
	public ApprovalOrder(int approvalId, Date approvalDate,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount) {

			this.approvalId = approvalId;
			this.approvalDate = approvalDate;
			this.appovalAmount = appovalAmount;
			this.purchaseOder = requireNonNull(purchaseOder);
			this.approverAmount = requireNonNull(approverAmount);		
	}
	
	public ApprovalOrder() {
		super();
	}

	private void validaAprobador(ApproverAmount approverAmount2, PurchaseOrder purchaseOrder ) {
		
		if (!(this.purchaseOder.getTotalAmount()>=approverAmount2.getAppovalAmountInit() && this.purchaseOder.getTotalAmount()<=approverAmount2.getAppovalAmountEnd())) {
			throw new ExcepcionRule("NO cumple en el rango del aprobador");
		}
		
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

	public PurchaseOrder getPurchaseOder() {
		return purchaseOder;
	}

	public void setPurchaseOder(PurchaseOrder purchaseOder) {
		this.purchaseOder = purchaseOder;
	}


	public ApproverAmount getApproverAmount() {
		return approverAmount;
	}


	public void setApproverAmount(ApproverAmount approverAmount) {
		this.approverAmount = approverAmount;
	}
	

/*

	public StatusPurchase getStatusPurchase() {
		return statusPurchase;
	}

	public void setStatusPurchase(StatusPurchase statusPurchase) {
		this.statusPurchase = statusPurchase;
	}
	
	*/
	

}
