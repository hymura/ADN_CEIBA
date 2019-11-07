package co.com.ceiba.oc.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.PurchaseOrderEntity;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;

/**
* Clase para definir los servicios de orden de compra
* 
* @author hymura
*
*/

@Service
@Transactional(readOnly = true)
public class PurchaseOrderService {
	
	private final PurchaseOrderRepository purchaseOrderRepository ;
	
	
	public PurchaseOrderService(PurchaseOrderRepository purchaseOrder) {
		this.purchaseOrderRepository = purchaseOrder;
	}
	
	
	/**
	 * Método para realizar la operación de guardar una OC
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public PurchaseOrderEntity create(PurchaseOrderEntity purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}

	/**
	 * Método para realizar la operación de actualizar una OC
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public PurchaseOrderEntity update(PurchaseOrderEntity purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}

	/**
	 * Método para realizar la operación de eliminar una OC
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(PurchaseOrderEntity purchaseOrder) {
		this.purchaseOrderRepository.delete(purchaseOrder);
	}

	/**
	 * Método para consultar por numero de OC
	 * 
	 * @param identificacionCli
	 * @return
	 */
	public PurchaseOrderEntity findByOrderNumber(String orderNumber) {
		return this.purchaseOrderRepository.findByOrderNumber(orderNumber);
	}
	
	/**
	 * Método para consultar todas las OC
	 * @return
	 */
	public List<PurchaseOrderEntity> findAll(){
		return this.purchaseOrderRepository.findAll();
	}
	
	
	

}
