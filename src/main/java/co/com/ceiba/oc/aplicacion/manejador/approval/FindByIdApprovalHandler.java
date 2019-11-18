package co.com.ceiba.oc.aplicacion.manejador.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.oc.aplicacion.servicio.ApprovalOrderServices;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;

@Component
public class FindByIdApprovalHandler {
	
	private final ApprovalOrderServices approvalOrderServices;
    @Autowired
	public FindByIdApprovalHandler(ApprovalOrderServices approvalOrderServices) {	
		this.approvalOrderServices = approvalOrderServices;
	}
	    
	
public ApprovalOrder execute(int approvalId) {

    return approvalOrderServices.findByApprovalId(approvalId);
				
	}




}
