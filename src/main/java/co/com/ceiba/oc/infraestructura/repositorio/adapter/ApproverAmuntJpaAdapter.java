package co.com.ceiba.oc.infraestructura.repositorio.adapter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.repositorio.ApproverAmountRepository;
import co.com.ceiba.oc.infraestructura.repositorio.AppoverAmountRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;

import co.com.ceiba.oc.infraestructura.repositorio.entity.factory.ApproverFactory;



@Repository
public class ApproverAmuntJpaAdapter  implements ApproverAmountRepository {
	

	private AppoverAmountRepositoryBd approverAmountRepositoryBd;
	
	
	@Autowired
	public ApproverAmuntJpaAdapter(AppoverAmountRepositoryBd approverAmountRepositoryBd) {

		this.approverAmountRepositoryBd = approverAmountRepositoryBd;
	}

	@Override
	public ApproverAmount findByApprover(int userId) {
		
		AppoverAmountEntity appoverAmountEntity = approverAmountRepositoryBd.findByApprover(userId);
		return ApproverFactory.toModel(appoverAmountEntity);
	}

	@Override
	public ApproverAmount findByAmountApprover(int amountTotal, String status) {
		AppoverAmountEntity appoverAmountEntity = approverAmountRepositoryBd.findByAmountApprover(amountTotal,status);
		return ApproverFactory.toModel(appoverAmountEntity);
	}

	@Override
	public List<ApproverAmount> findAll() {
		
		 return approverAmountRepositoryBd.findAll().stream()
	                .map(ApproverFactory::toModel)
	                .collect(Collectors.toList());
	}

	@Override
	public ApproverAmount save(ApproverAmount appoverAmount) {
		
		AppoverAmountEntity entity = ApproverFactory.toEntity(appoverAmount);
        return ApproverFactory.toModel(approverAmountRepositoryBd.save(entity));
	}

	@Override
	public void delete(ApproverAmount appoverAmount) {
		AppoverAmountEntity entity = ApproverFactory.toEntity(appoverAmount);
		approverAmountRepositoryBd.delete(entity);		
	}
	
	

}
