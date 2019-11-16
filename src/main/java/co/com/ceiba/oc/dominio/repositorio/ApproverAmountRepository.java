package co.com.ceiba.oc.dominio.repositorio;


import java.util.List;


import co.com.ceiba.oc.dominio.model.ApproverAmount;



public interface ApproverAmountRepository {
	
	public ApproverAmount findByAmountApprover(int amountTotal, String status);
	public List<ApproverAmount> findAll();
	public ApproverAmount save (ApproverAmount appoverAmount);
	public void delete(ApproverAmount AppoverAmount);
	public ApproverAmount update(ApproverAmount AppoverAmount);
	public ApproverAmount findByApprover(int userId);
		

}
