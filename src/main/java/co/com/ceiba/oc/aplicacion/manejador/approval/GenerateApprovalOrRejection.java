package co.com.ceiba.oc.aplicacion.manejador.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;

@Component
public class GenerateApprovalOrRejection {

	private final ApprovalOrderServices approvalOrderServices;

	@Autowired
	public GenerateApprovalOrRejection(ApprovalOrderServices approvalOrderServices) {
		this.approvalOrderServices = approvalOrderServices;
	}

	@Transactional
	public ApprovalOrder execute(ApprovalOrder approvalOrder) {
		return approvalOrderServices.generateApproval(approvalOrder);
	}
}
