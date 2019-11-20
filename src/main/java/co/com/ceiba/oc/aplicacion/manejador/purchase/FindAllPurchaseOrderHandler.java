package co.com.ceiba.oc.aplicacion.manejador.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;

@Component
public class FindAllPurchaseOrderHandler {
	private final PurchaseOrderService purchaseOrderService;
    @Autowired
	public FindAllPurchaseOrderHandler(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	

public List<PurchaseOrder>  execute() {
		
		return purchaseOrderService.findAll();
				
	}
	

}
