package co.com.ceiba.oc.dominio.repositorio;

import java.util.List;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;


public interface PurchaseOrderRepository {
	
	public PurchaseOrder findByOrderNumber(String orderNumber);
	public PurchaseOrder findByIdOc(int poheaderId);
	public List<PurchaseOrder> findAll();
	public PurchaseOrder save (PurchaseOrder purchaseOrder);
	public void delete(PurchaseOrder purchaseOrder);
	
}
