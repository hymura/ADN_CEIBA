package co.com.ceiba.oc.dominio.servicio;

import java.util.List;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.repositorio.ApproverAmountRepository;


/**
* Clase para definir los servicios del aprobador
* 
* @author hymura
*
*/

public class AppoverAmountServices {
	
			
	private final ApproverAmountRepository approverAmountRepository;
	
	
	public AppoverAmountServices(ApproverAmountRepository appoverAmountRepository) {	
		this.approverAmountRepository = appoverAmountRepository;
	}

	/**
	 * Metodo para realizar la operacion de guardar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	public ApproverAmount create(ApproverAmount appoverAmount) {
		return this.approverAmountRepository.save(appoverAmount);
	}

	/**
	 * Metodo para realizar la operacion de actualizar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	public ApproverAmount update(ApproverAmount appoverAmount) {
		return this.approverAmountRepository.save(appoverAmount);
	}

	/**
	 * Metodo para realizar la operacion de eliminar un aprobador
	 * 
	 * @param cliente
	 */
	public void delete(ApproverAmount appoverAmount) {
		this.approverAmountRepository.delete(appoverAmount);
	}

	/**
	 * Definicion de metodo para consultar aprobadores por nombre y estado 
	 * @param totalAmount
	 * @param status
	 * @return
	 */
	
	public  ApproverAmount findByApprover(int  userId){
		return this.approverAmountRepository.findByApprover(userId);
				}
				
	
	public ApproverAmount findByAmountApprover(int amountTotal, String status){
		return this.approverAmountRepository.findByAmountApprover(amountTotal,status);
	}
	
	public List<ApproverAmount> findAll(){
		return this.approverAmountRepository.findAll();		
	}
	
}
