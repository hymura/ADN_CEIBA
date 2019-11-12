package co.com.ceiba.oc.dominio.repositorio;

import java.util.List;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;

public interface PurchaseOrderRepository {
	public PurchaseOrderEntity findByOrderNumber(String orderNumber);
	public PurchaseOrderEntity findByIdOc(int PoheaderId);
	public List<PurchaseOrder> findAll();
	public PurchaseOrderEntity save (PurchaseOrderEntity purchaseOrder);
	public void delete(PurchaseOrderEntity purchaseOrder);
	public PurchaseOrderEntity update(PurchaseOrderEntity purchaseOrder);

}
