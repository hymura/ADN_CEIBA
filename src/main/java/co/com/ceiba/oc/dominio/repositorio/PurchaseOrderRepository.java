package co.com.ceiba.oc.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.oc.dominio.PurchaseOrderEntity;

public interface  PurchaseOrderRepository  extends JpaRepository<PurchaseOrderEntity, String>{
		
	
	/**
	 * Definici�n de m�todo para buscar las Oc por numero de OC
	 * @param orderNumber
	 * @return
	 */
	public PurchaseOrderEntity findByOrderNumber(String orderNumber);
	
	/**
	 * Definici�n de m�todo para buscar ordenes por estado
	 * @param status
	 * @return
	 */
	
	//@Query("SELECT ph FROM PO_HEADER ph WHERE ph.status = ?1")	
	
		
	/**
	 * Definici�n de m�todo para buscar todas las ordenes
	 * @params
	 * @return
	 */
	public List<PurchaseOrderEntity> findAll();

	


	

}
