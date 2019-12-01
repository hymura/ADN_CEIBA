package co.com.ceiba.oc.builderstest;


import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;

public class ApprovalOrderBuilder {
	private int approvalId;
	private int appovalAmount;
	private String motivo;
	private PurchaseOrder purchaseOrder;
	private ApproverAmount approverAmount;
	
	  
	public ApprovalOrderBuilder() {
		this.approvalId = 1;
		this.appovalAmount = 3000;
		this.purchaseOrder = new PurchaseOrder(1,"2505",1,3000,"REQ_APPROVAL");
		this.approverAmount = new ApproverAmount(1, "ALEX.GOMEZ", 2000, 5000);
		this.motivo = "PENDIENTE POR APROBAR";
	}
	
	public ApprovalOrder build() {
		return new ApprovalOrder(approvalId, appovalAmount,purchaseOrder,approverAmount,motivo);
	}
	
	public  ApprovalOrderBuilder withApprovalId(int approvalId) {
		this.approvalId = approvalId;
		return this;
	}
	
	public  ApprovalOrderBuilder withAppovalAmount(int appovalAmount) {
		this.appovalAmount = appovalAmount;
		return this;
	}
	
	public  ApprovalOrderBuilder wiPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
		return this;
	}

	public  ApprovalOrderBuilder withApproverAmount(ApproverAmount approverAmount) {
		this.approverAmount = approverAmount;
		return this;
	}
	
	public  ApprovalOrderBuilder withMotivo(String motivo) {
		this.motivo = motivo;
		return this;
	}
	
	 public static ApprovalOrderBuilder anApprovalOrder(){
	        return new ApprovalOrderBuilder();
	    }
	 
	 
}
