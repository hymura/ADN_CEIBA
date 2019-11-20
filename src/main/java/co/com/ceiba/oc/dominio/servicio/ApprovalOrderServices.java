package co.com.ceiba.oc.dominio.servicio;


import java.util.List;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepositoy;


public class ApprovalOrderServices {
	
	
	private final ApprovalOrderRepositoy approvalOrderRepository ;
			
	public ApprovalOrderServices(ApprovalOrderRepositoy approvalOrderRep) {		
		this.approvalOrderRepository = approvalOrderRep;
	}

	/**
	 * Metodo para realizar la operacion de guardar una orden  para aprobacion 
	 * 
	 * @param cliente
	 * @return
	 */

		public ApprovalOrder create(ApprovalOrder approvalOrder) {
		return this.approvalOrderRepository.save(approvalOrder);
	}

	/**
	 * Metodo para realizar la operacion de actualizar una orden  para aprobacion
	 * 
	 * @param cliente
	 * @return
	 */

	public ApprovalOrder update(ApprovalOrder approvalOrder) {
		return this.approvalOrderRepository.save(approvalOrder);
	}
	
	/**
	 * Definicion de metodo para buscar ordenes por id de aprobador
	 * @param ApprovalId
	 * @return
	 */
	
	public ApprovalOrder findByApprovalId(int approvalId) {
		return approvalOrderRepository.findByApprovalId(approvalId);		
	}
			
	/**
	 * Definicion de metodo para buscar todas las ordenes
	 * @params
	 * @return
	 */
	public List<ApprovalOrder> findAll(){
		return approvalOrderRepository.findAll();
	}

	public ApprovalOrder generateApproval(ApprovalOrder approvalOrder) {
			approvalOrder.approvePurchase();			
			return this.approvalOrderRepository.update(approvalOrder);
			
	}
}
