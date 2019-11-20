package co.com.ceiba.oc.aplicacion.manejador.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;

@Component
public class CreatePurchaseHandler {
	
	private final PurchaseOrderService purchaseOrderService;
	
    @Autowired
	public CreatePurchaseHandler(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	@Transactional(readOnly = true)
	public PurchaseOrder execute(PurchaseOrder purchaserOrder) {
		
		return purchaseOrderService.create(purchaserOrder);
				
	}

}
