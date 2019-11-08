package co.com.ceiba.oc.dominio.repositorio;



import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.ceiba.oc.dominio.ApprovalOrderEntity;

public interface ApprovalOrderRepository extends JpaRepository<ApprovalOrderEntity, String>{
	

	
	/**
	 * Definición de método para buscar por id aprobacion 
	 * @param ApprovalId
	 * @return
	 */
	@Query("Select pao from ApprovalOrderEntity pao where pao.approvalId =:approvalId")
    public ApprovalOrderEntity findByApprovalId(@Param("approvalId") int approvalId);
	
   
	

}
