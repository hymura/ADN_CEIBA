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
	
		
	private final AppoverAmountRepository appoverAmountRepository;
	
	
	public AppoverAmountServices(AppoverAmountRepository appoverAmountRepository) {	
		this.appoverAmountRepository = appoverAmountRepository;
	}

	/**
	 * M�todo para realizar la operaci�n de guardar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public AppoverAmountEntity create(AppoverAmountEntity AppoverAmount) {
		return this.appoverAmountRepository.save(AppoverAmount);
	}

	/**
	 * M�todo para realizar la operaci�n de actualizar un aprobador
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public AppoverAmountEntity update(AppoverAmountEntity AppoverAmount) {
		return this.appoverAmountRepository.save(AppoverAmount);
	}

	/**
	 * M�todo para realizar la operaci�n de eliminar un aprobador
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(AppoverAmountEntity AppoverAmount) {
		this.appoverAmountRepository.delete(AppoverAmount);
	}

	/**
	 * Definici�n de m�todo para consultar aprobadores por nombre y estado 
	 * @param totalAmount
	 * @param status
	 * @return
	 */
	
	public  AppoverAmountEntity findByApprover(int  UserId){
		return this.appoverAmountRepository.findByApprover(UserId);
				}
				
	
	public AppoverAmountEntity findByAmountApprover(Integer amountTotal, String status){
		return this.appoverAmountRepository.findByAmountApprover(amountTotal,status);
	}
	
	public List<AppoverAmountEntity> findAll(){
		return this.appoverAmountRepository.findAll();		
	}
	
}
