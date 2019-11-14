package co.com.ceiba.oc.dominio.repositorio;


import java.util.List;
import java.util.Optional;

import co.com.ceiba.oc.dominio.model.ApproverAmount;



public interface ApproverAmountRepository {
	
	public Optional<ApproverAmount> findByApprover(int userId);	
	public ApproverAmount findByAmountApprover(int amountTotal, String status);
	public List<ApproverAmount> findAll();
	public ApproverAmount save (ApproverAmount appoverAmount);
	public void delete(ApproverAmount AppoverAmount);
	public ApproverAmount update(ApproverAmount AppoverAmount);
		

}
