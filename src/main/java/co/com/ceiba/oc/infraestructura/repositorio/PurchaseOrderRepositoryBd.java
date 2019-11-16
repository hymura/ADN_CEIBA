package co.com.ceiba.oc.infraestructura.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;

public interface  PurchaseOrderRepositoryBd  extends JpaRepository<PurchaseOrderEntity, String>{
		
	
	/**
	 * Definicin de mtodo para buscar las Oc por numero de OC
	 * @param orderNumber
	 * @return
	 */
	@Query("Select pao from PurchaseOrderEntity pao where pao.orderNumber =:orderNumber")
	public PurchaseOrderEntity findByOrderNumber(@Param("orderNumber")  String orderNumber);
	

	@Query("Select pao from PurchaseOrderEntity pao where pao.poHeaderId =:PoheaderId")
	public PurchaseOrderEntity findByIdOc(int PoheaderId);
	
	/**
	 * Definicin de mtodo para buscar todas las OC
	 * @param status
	 * @return
	 */
	public List<PurchaseOrderEntity> findAll();


	

}
