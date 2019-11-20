package co.com.ceiba.oc.aplicacion.manejador.approver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;


@Component
public class UpdateApproverHandler {
	
	private final  AppoverAmountServices appoverAmountServices;
    @Autowired
	public UpdateApproverHandler(AppoverAmountServices appoverAmountServices) {
		this.appoverAmountServices = appoverAmountServices;
	}
	

	@Transactional(readOnly = true)	
	public ApproverAmount execute(ApproverAmount approverAmount) {		
		return appoverAmountServices.update(approverAmount);				
	}


	
	

}
