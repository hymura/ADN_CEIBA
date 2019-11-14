package co.com.ceiba.oc.dominio.servicio;

import java.util.List;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;


/**
* Clase para definir los servicios de orden de compra
* 
* @author hymura
*
*/


public class PurchaseOrderService {
	
	private final PurchaseOrderRepository purchaseOrderRepository ;
	
	
	public PurchaseOrderService(PurchaseOrderRepository purchaseOrder) {
		this.purchaseOrderRepository = purchaseOrder;
	}
	
	
	/**
	 * M�todo para realizar la operaci�n de guardar una OC
	 * 
	 * @param purchaseOrder
	 * @return
	 */
	public PurchaseOrder create(PurchaseOrder purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}

	/**
	 * M�todo para realizar la operaci�n de actualizar una OC
	 * 
	 * @param purchaseOrder
	 * @return
	 */
	public PurchaseOrder update(PurchaseOrder purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}

	/**
	 * M�todo para realizar la operaci�n de eliminar una OC
	 * 
	 * @param purchaseOrder
	 */
	public void delete(PurchaseOrder purchaseOrder) {
		this.purchaseOrderRepository.delete(purchaseOrder);
	}

	/**
	 * M�todo para consultar por numero de OC
	 * 
	 * @param identificacionCli
	 * @return
	 */
	public PurchaseOrder findByOrderNumber(String orderNumber) {
		return this.purchaseOrderRepository.findByOrderNumber(orderNumber);
	}
	
/*	
	public PurchaseOrder findByIdOc(int PoheaderId) {
		return this.purchaseOrderRepository.findByIdOc(PoheaderId);
		
	}
	
*/	
	/**
	 * M�todo para consultar todas las OC
	 * @return
	 */
	public List<PurchaseOrder> findAll(){
		return this.purchaseOrderRepository.findAll();
	}
	
	
	

}
