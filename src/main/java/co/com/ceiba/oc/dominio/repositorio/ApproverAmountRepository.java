package co.com.ceiba.oc.dominio.repositorio;


import java.util.List;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;


public interface ApproverAmountRepository {
	
	public AppoverAmountEntity findByApprover(int userId);	
	public AppoverAmountEntity findByAmountApprover(int amountTotal, String status);
	public List<ApproverAmount> findAll();
	public AppoverAmountEntity save (AppoverAmountEntity appoverAmount);
	public void delete(AppoverAmountEntity AppoverAmount);
	public AppoverAmountEntity update(AppoverAmountEntity AppoverAmount);
		

}
