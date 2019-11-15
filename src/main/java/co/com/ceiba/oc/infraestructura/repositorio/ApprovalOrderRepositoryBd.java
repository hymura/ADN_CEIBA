package co.com.ceiba.oc.infraestructura.repositorio;



import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ApprovalOrderRepositoryBd extends JpaRepository<ApprovalOrderEntity, String>{

	/**
	 * Definicin de mtodo para buscar por id aprobacion 
	 * @param ApprovalId
	 * @return
	 */
	@Query("Select pao from ApprovalOrderEntity pao where pao.approvalId =:approvalId")
    public ApprovalOrderEntity findByApprovalId(@Param("approvalId") int approvalId);
	//public ApprovalOrderEntity findByApprovalId(int approvalId);
	
	/**
	 * Definicion de metodo para buscar en toda la bandeja de aprobacion
	 * @param 
	 * @return
	 */
	public List<ApprovalOrderEntity>  findAll();

}
