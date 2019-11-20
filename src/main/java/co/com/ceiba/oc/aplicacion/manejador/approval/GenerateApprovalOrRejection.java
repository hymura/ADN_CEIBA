package co.com.ceiba.oc.aplicacion.manejador.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;

@Component
public class GenerateApprovalOrRejection {

	private final ApprovalOrderServices approvalOrderServices;
	private final PurchaseOrderService purchaseOrderService;

	@Autowired
	public GenerateApprovalOrRejection(ApprovalOrderServices approvalOrderServices,
									   PurchaseOrderService purchaseOrderService) {
		this.approvalOrderServices = approvalOrderServices;
		this.purchaseOrderService = purchaseOrderService;
	}

	@Transactional
	public ApprovalOrder execute(ApprovalOrder approvalOrder) {
		//PurchaseOrder purchaseOrder = purchaseOrderService.update(approvalOrder.getPurchaseOder());
		//approvalOrder.setPurchaseOder(approvalOrder.getPurchaseOder());
		return approvalOrderServices.generateApproval(approvalOrder);
	}
}
