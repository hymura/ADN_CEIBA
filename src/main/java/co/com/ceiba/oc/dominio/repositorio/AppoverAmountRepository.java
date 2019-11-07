package co.com.ceiba.oc.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import co.com.ceiba.oc.dominio.AppoverAmountEntity;




public interface AppoverAmountRepository extends JpaRepository<AppoverAmountEntity, String>{
	
	
	
	/**
	 * Definición de método para buscar aprobadores por el monto OC y estado 
	 * @param status
	 * @return
	 */
	
	//@Query("SELECT ph FROM PO_HEADER ph WHERE ph.status = ?1")		
		
	public AppoverAmountEntity findByApprover(String userName,String status);

	public AppoverAmountEntity findByAmountApprover(double amountTotal, String status);
	
	
	/**
	 * Definición de método para buscar todoa los aprobadores
	 * @params
	 * @return
	 */
	public List<AppoverAmountEntity> findAll();


	


}
