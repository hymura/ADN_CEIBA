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
	 * Método para realizar la operación de guardar una orden  para aprobacion 
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public ApprovalOrderEntity create(ApprovalOrderEntity approvalOrder) {
		return this.approvalOrderRepository.save(approvalOrder);
	}

	/**
	 * Método para realizar la operación de actualizar una orden  para aprobacion
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public ApprovalOrderEntity update(ApprovalOrderEntity approvalOrder) {
		return this.approvalOrderRepository.save(approvalOrder);
	}

	
	/**
	 * Definición de método para buscar ordenes por id de aprobador
	 * @param ApprovalId
	 * @return
	 */
	
	public ApprovalOrderEntity findByApprovalId(int approvalId) {
		return approvalOrderRepository.findByApprovalId(approvalId);		
	}
	
		
	
	/**
	 * Definición de método para buscar todas las ordenes
	 * @params
	 * @return
	 */
	public List<ApprovalOrderEntity> findAll(){
		return approvalOrderRepository.findAll();
	}
	
	
}
