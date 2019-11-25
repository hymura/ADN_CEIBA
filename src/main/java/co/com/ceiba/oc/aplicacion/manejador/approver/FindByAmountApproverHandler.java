package co.com.ceiba.oc.aplicacion.manejador.approver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;

@Component
public class FindByAmountApproverHandler {
	private final AppoverAmountServices appoverAmountServices;
	private static final String ESTADO_ACTIVO = "ACTIVO";
	@Autowired
	public FindByAmountApproverHandler(AppoverAmountServices appoverAmountServices) {
		this.appoverAmountServices = appoverAmountServices;
	}

	public ApproverAmount execute(int totalAmount) {
		return appoverAmountServices.findByAmountApprover(totalAmount, ESTADO_ACTIVO);
	}

}
