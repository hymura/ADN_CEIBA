package co.com.ceiba.oc.aplicacion.manejador.approval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;

@Component
public class FindAllApprovalHandler {
	
	private final  ApprovalOrderServices approvalOrderServices;
    @Autowired
	public FindAllApprovalHandler(ApprovalOrderServices approvalOrderServices) {	
		this.approvalOrderServices = approvalOrderServices;
	}
	
	
	public List<ApprovalOrder>  execute() {	
		return approvalOrderServices.findAll();		
	}
	
	
	

}
