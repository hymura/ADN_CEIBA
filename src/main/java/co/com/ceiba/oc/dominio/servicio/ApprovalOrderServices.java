package co.com.ceiba.oc.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.com.ceiba.oc.dominio.ApprovalOrderEntity;
import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepository;

@Service
@Transactional(readOnly = true)

public class ApprovalOrderServices {
	
	
	private final ApprovalOrderRepository approvalOrderRepository = null;
	
	/**
	 * M�todo para realizar la operaci�n de guardar una orden  para aprobacion 
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public ApprovalOrderEntity create(ApprovalOrderEntity approvalOrder) {
		return this.approvalOrderRepository.save(approvalOrder);
	}

	/**
	 * M�todo para realizar la operaci�n de actualizar una orden  para aprobacion
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public ApprovalOrderEntity update(ApprovalOrderEntity approvalOrder) {
		return this.approvalOrderRepository.save(approvalOrder);
	}

	
	
	/**
	 * Definici�n de m�todo para Consultar las Oc por numero de OC
	 * @param poHeaderId
	 * @return
	 */
	public ApprovalOrderEntity findByIdOc(int poHeaderId) {
		return this.approvalOrderRepository.findByIdOc(poHeaderId);
	}
	
	/**
	 * Definici�n de m�todo para buscar ordenes por id de aprobador
	 * @param ApprovalId
	 * @return
	 */
	
	public ApprovalOrderEntity findByApprovalId(int ApprovalId) {
		return approvalOrderRepository.findByApprovalId(ApprovalId);		
	}
	
	/**
	 * Definici�n de m�todo para buscar ordenes por estado
	 * @param status
	 * @return
	 */
	
	//@Query("SELECT ph FROM PO_HEADER ph WHERE ph.status = ?1")	
	
	public List<ApprovalOrderEntity> findByUserId(int userId){
		return approvalOrderRepository.findByUserId(userId);
	}

	
	/**
	 * Definici�n de m�todo para buscar todas las ordenes
	 * @params
	 * @return
	 */
	public List<ApprovalOrderEntity> findAll(){
		return approvalOrderRepository.findAll();
	}
	
	
}
