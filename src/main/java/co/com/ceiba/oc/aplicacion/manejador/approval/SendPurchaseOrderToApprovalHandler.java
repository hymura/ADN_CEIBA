package co.com.ceiba.oc.aplicacion.manejador.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;

@Component
public class SendPurchaseOrderToApprovalHandler {
	
	private final ApprovalOrderServices approvalOrderServices;
	
	@Autowired
	public SendPurchaseOrderToApprovalHandler( ApprovalOrderServices approvalOrderServices) {
			this.approvalOrderServices=approvalOrderServices;
	}

	@Transactional
	public ApprovalOrder execute (PurchaseOrder purchaseOrder, ApproverAmount approverAmount) {
	
		return approvalOrderServices.sendToapproval(purchaseOrder,approverAmount);		
		
	}
	   

}
