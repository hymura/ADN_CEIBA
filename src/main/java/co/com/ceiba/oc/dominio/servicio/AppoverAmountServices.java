package co.com.ceiba.oc.dominio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
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
	 * M�todo para realizar la operaci�n de guardar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public ApproverAmount create(ApproverAmount AppoverAmount) {
		return this.approverAmountRepository.save(AppoverAmount);
	}

	/**
	 * M�todo para realizar la operaci�n de actualizar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public ApproverAmount update(ApproverAmount AppoverAmount) {
		return this.approverAmountRepository.save(AppoverAmount);
	}

	/**
	 * M�todo para realizar la operaci�n de eliminar un aprobador
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(ApproverAmount AppoverAmount) {
		this.approverAmountRepository.delete(AppoverAmount);
	}

	/**
	 * Definici�n de m�todo para consultar aprobadores por nombre y estado 
	 * @param totalAmount
	 * @param status
	 * @return
	 */
	
	public  Optional<ApproverAmount> findByApprover(int  userId){
		return this.approverAmountRepository.findByApprover(userId);
				}
				
	
	public ApproverAmount findByAmountApprover(int amountTotal, String status){
		return this.approverAmountRepository.findByAmountApprover(amountTotal,status);
	}
	
	public List<ApproverAmount> findAll(){
		return this.approverAmountRepository.findAll();		
	}
	
}
