package co.com.ceiba.oc.aplicacion.manejador.approver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;

@Component
public class FindAllApproverHandler {
	private final AppoverAmountServices appoverAmountServices;

	@Autowired
	public FindAllApproverHandler(AppoverAmountServices appoverAmountServices) {

		this.appoverAmountServices = appoverAmountServices;
	}

	public List<ApproverAmount> execute() {
		return appoverAmountServices.findAll();
	}

}
