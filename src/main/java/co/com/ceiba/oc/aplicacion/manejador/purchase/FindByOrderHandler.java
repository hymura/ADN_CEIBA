package co.com.ceiba.oc.aplicacion.manejador.purchase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;


@Component
public class FindByOrderHandler {
	private final PurchaseOrderService purchaseOrderService;
    @Autowired
	public FindByOrderHandler(PurchaseOrderService purchaseOrderService) {

		this.purchaseOrderService = purchaseOrderService;
	}

	
	//public List<PurchaseOrder> execute(PurchaseOrder purchaseOrder){
public PurchaseOrder execute(String orderNumber ) {

    return purchaseOrderService.findByOrderNumber(orderNumber);
				
	}
	

}
