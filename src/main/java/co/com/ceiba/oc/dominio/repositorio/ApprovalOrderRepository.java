package co.com.ceiba.oc.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import co.com.ceiba.oc.dominio.ApprovalOrderEntity;

public interface ApprovalOrderRepository extends JpaRepository<ApprovalOrderEntity, String>{
	
	/**
	 * Definición de método para buscar las Oc id de OC
	 * @param poHeaderId
	 * @return
	 */
	public ApprovalOrderEntity findByIdOc(int poHeaderId);
	
	
	/**
	 * Definición de método para buscar por id aprobacion 
	 * @param ApprovalId
	 * @return
	 */
	
    public ApprovalOrderEntity findByApprovalId(int ApprovalId);
	
    /**
	 * Definición de método para buscar ordenes por id de aprobador
	 * @param userId
	 * @return
	 */

	public List<ApprovalOrderEntity> findByUserId(int userId);

	
	/**
	 * Definición de método para buscar todas las ordenes
	 * @params
	 * @return
	 */
	public List<ApprovalOrderEntity> findAll();

}
