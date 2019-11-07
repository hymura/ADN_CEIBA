package co.com.ceiba.oc.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.oc.dominio.AppoverAmountEntity;
import co.com.ceiba.oc.dominio.repositorio.AppoverAmountRepository;


/**
* Clase para definir los servicios del aprobador
* 
* @author hymura
*
*/
@Service
@Transactional(readOnly = true)

public class AppoverAmountServices {
	
		
	private final AppoverAmountRepository appoverAmountRepository=null;
	
	
	/**
	 * Método para realizar la operación de guardar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public AppoverAmountEntity create(AppoverAmountEntity AppoverAmount) {
		return this.appoverAmountRepository.save(AppoverAmount);
	}

	/**
	 * Método para realizar la operación de actualizar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public AppoverAmountEntity update(AppoverAmountEntity AppoverAmount) {
		return this.appoverAmountRepository.save(AppoverAmount);
	}

	/**
	 * Método para realizar la operación de eliminar un aprobador
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(AppoverAmountEntity AppoverAmount) {
		this.appoverAmountRepository.delete(AppoverAmount);
	}

	/**
	 * Definición de método para consultar aprobadores por el monto OC y estado 
	 * @param totalAmount
	 * @param status
	 * @return
	 */
	
	public AppoverAmountEntity findByApprover(String UserName,String status){
		return this.appoverAmountRepository.findByApprover(UserName,status);
				}
	
	public AppoverAmountEntity findByAmountApprover(double amountTotal, String status){
		return this.appoverAmountRepository.findByAmountApprover(amountTotal,status);
	}
	
	public List<AppoverAmountEntity> findAll(){
		return this.appoverAmountRepository.findAll();		
	}
	
}
