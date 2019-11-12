package co.com.ceiba.oc.infraestructura.repositorio.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.repositorio.ApproverAmountRepository;
import co.com.ceiba.oc.infraestructura.repositorio.AppoverAmountRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;

@Repository
public class ApproverAmuntJpaAdapter  implements ApproverAmountRepository {
	
	@Autowired
	private AppoverAmountRepositoryBd approverAmountRepositoryBd; 

	@Override
	public AppoverAmountEntity findByApprover(int userId) {
		// TODO Auto-generated method stub
		return approverAmountRepositoryBd.findByApprover(userId);
	}

	@Override
	public AppoverAmountEntity findByAmountApprover(int amountTotal, String status) {
		// TODO Auto-generated method stub
		return approverAmountRepositoryBd.findByAmountApprover(amountTotal, status);
	}

	@Override
	public List<ApproverAmount> findAll() {
		// TODO Auto-generated method stub
		List<ApproverAmount> listApproverAmount= new ArrayList<>();				
		
		for(AppoverAmountEntity approverAmountBd :approverAmountRepositoryBd.findAll()) {
			listApproverAmount.add(new ApproverAmount(approverAmountBd.getUserId(), "Mister "+approverAmountBd.getUserName(), approverAmountBd.getAppovalAmountInit(), approverAmountBd.getAppovalAmountEnd(), approverAmountBd.getStatus()));
		}
		return listApproverAmount;
	}

	@Override
	public AppoverAmountEntity save(AppoverAmountEntity appoverAmount) {
		// TODO Auto-generated method stub
		return approverAmountRepositoryBd.save(appoverAmount);
	}

	@Override
	public void delete(AppoverAmountEntity AppoverAmount) {
		// TODO Auto-generated method stub
		 approverAmountRepositoryBd.delete(AppoverAmount);
		
	}

	@Override
	public AppoverAmountEntity update(AppoverAmountEntity AppoverAmount) {
		// TODO Auto-generated method stub
		return approverAmountRepositoryBd.save(AppoverAmount);
	}
	
	

}
