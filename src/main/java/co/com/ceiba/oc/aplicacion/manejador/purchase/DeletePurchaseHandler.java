package co.com.ceiba.oc.aplicacion.manejador.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.aplicacion.servicio.PurchaseOrderService;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;

@Component
public class DeletePurchaseHandler {
	private final PurchaseOrderService purchaseOrderService;
    @Autowired
	public DeletePurchaseHandler(PurchaseOrderService purchaseOrderService) {
	
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@Transactional(readOnly = true)	
public void  execute(PurchaseOrder purchaserOrder) {
					
		purchaseOrderService.delete(purchaserOrder);
				
	}
	
}
