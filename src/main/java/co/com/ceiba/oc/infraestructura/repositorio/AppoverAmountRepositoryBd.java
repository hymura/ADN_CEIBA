package co.com.ceiba.oc.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import co.com.ceiba.oc.dominio.repositorio.ApproverAmountRepository;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;


public interface AppoverAmountRepositoryBd extends JpaRepository<AppoverAmountEntity, String> {
		
	@Query("Select paa from AppoverAmountEntity paa where paa.userId =:userId")		
	public AppoverAmountEntity findByApprover(@Param("userId") int userId);
	//public AppoverAmountEntity findByApprover(int userId);

	
	@Query("Select paa from AppoverAmountEntity paa where paa.appovalAmountInit>=:amountTotal and paa.appovalAmountEnd<=:amountTotal and paa.status=:status")
	public AppoverAmountEntity findByAmountApprover(@Param("amountTotal") int amountTotal,@Param("status") String status);
	//public AppoverAmountEntity findByAmountApprover( int amountTotal,String status);
	
	/**
	 * Definición de método para buscar todoa los aprobadores
	 * @params
	 * @return
	 */
	public List<AppoverAmountEntity> findAll();


	


}
