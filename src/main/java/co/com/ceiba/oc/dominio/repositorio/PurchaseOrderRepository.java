package co.com.ceiba.oc.dominio.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.ceiba.oc.dominio.PurchaseOrderEntity;

public interface  PurchaseOrderRepository  extends JpaRepository<PurchaseOrderEntity, String>{
		
	
	/**
	 * Definición de método para buscar las Oc por numero de OC
	 * @param orderNumber
	 * @return
	 */
	@Query("Select pao from PurchaseOrderEntity pao where pao.orderNumber =:orderNumber")
	public PurchaseOrderEntity findByOrderNumber(String orderNumber);
	
	/**
	 * Definición de método para buscar ordenes por estado
	 * @param status
	 * @return
	 */
	

	
		
	

	


	

}
