package co.com.ceiba.oc.aplicacion.manejador.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;

@Component
public class UpdatePurchaseHandler {

	private final PurchaseOrderService purchaseOrderService;

    @Autowired
	public UpdatePurchaseHandler(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

    public PurchaseOrder execute(PurchaseOrder purchaserOrder) {
		return purchaseOrderService.update(purchaserOrder);
	}
}
