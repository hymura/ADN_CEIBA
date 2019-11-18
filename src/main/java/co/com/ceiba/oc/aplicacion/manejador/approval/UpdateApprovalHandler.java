package co.com.ceiba.oc.aplicacion.manejador.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.aplicacion.servicio.ApprovalOrderServices;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;

@Component
public class UpdateApprovalHandler {
	
	private final  ApprovalOrderServices approvalOrderServices;
    @Autowired
	public UpdateApprovalHandler(ApprovalOrderServices approvalOrderServices) {
		
		this.approvalOrderServices = approvalOrderServices;
	}	

	@Transactional(readOnly = true)	
	public ApprovalOrder execute(ApprovalOrder approvalOrder) {		
		return approvalOrderServices.update(approvalOrder);				
	}
	

}
