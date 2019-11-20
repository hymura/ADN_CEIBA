package co.com.ceiba.oc.aplicacion.manejador.approver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;

@Component
public class DeleteApproverHandler {
	private final AppoverAmountServices appoverAmountServices;

	@Autowired
	public DeleteApproverHandler(AppoverAmountServices appoverAmountServices) {

		this.appoverAmountServices = appoverAmountServices;
	}

	@Transactional(readOnly = true)
	public void execute(ApproverAmount approverAmount) {
		appoverAmountServices.delete(approverAmount);

	}

}
