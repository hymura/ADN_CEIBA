package co.com.ceiba.oc.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.infraestructura.repositorio.ApprovalOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;

@Service
@Transactional(readOnly = true)

public class ApprovalOrderServices {
	
	
	private final ApprovalOrderRepositoryBd approvalOrderRepository ;
			
	public ApprovalOrderServices(ApprovalOrderRepositoryBd approvalOrderRepository) {		
		this.approvalOrderRepository = approvalOrderRepository;
	}

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
	 * Definici�n de m�todo para buscar ordenes por id de aprobador
	 * @param ApprovalId
	 * @return
	 */
	
	public ApprovalOrderEntity findByApprovalId(int approvalId) {
		return approvalOrderRepository.findByApprovalId(approvalId);		
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
