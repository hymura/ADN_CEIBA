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
	 * Método para realizar la operación de guardar una OC
	 * 
	 * @param purchaseOrder
	 * @return
	 */
	public PurchaseOrder create(PurchaseOrder purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}

	/**
	 * Método para realizar la operación de actualizar una OC
	 * 
	 * @param purchaseOrder
	 * @return
	 */
	public PurchaseOrder update(PurchaseOrder purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}

	/**
	 * Método para realizar la operación de eliminar una OC
	 * 
	 * @param purchaseOrder
	 */
	public void delete(PurchaseOrder purchaseOrder) {
		this.purchaseOrderRepository.delete(purchaseOrder);
	}

	/**
	 * Método para consultar por numero de OC
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
	 * Método para consultar todas las OC
	 * @return
	 */
	public List<PurchaseOrder> findAll(){
		return this.purchaseOrderRepository.findAll();
	}
	
	
	

}
