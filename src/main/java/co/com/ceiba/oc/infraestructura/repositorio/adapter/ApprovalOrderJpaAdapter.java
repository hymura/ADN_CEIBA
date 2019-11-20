package co.com.ceiba.oc.infraestructura.repositorio.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepositoy;
import co.com.ceiba.oc.infraestructura.repositorio.ApprovalOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.factory.ApprovalOrderFactory;


@Repository
public class ApprovalOrderJpaAdapter implements ApprovalOrderRepositoy  {
	private ApprovalOrderRepositoryBd approvalOrderRepositoyBd;
	

	@Autowired
	public ApprovalOrderJpaAdapter(ApprovalOrderRepositoryBd approvalOrderRepositoyBd) {
		
		this.approvalOrderRepositoyBd = approvalOrderRepositoyBd;
	
	}

	@Override
	public List<ApprovalOrder> findAll() {
		   return approvalOrderRepositoyBd.findAll().stream()
	                .map(ApprovalOrderFactory::toModel)
	                .collect(Collectors.toList());
	}


	@Override
	public ApprovalOrder findByApprovalId(int approvalId) {
		
		ApprovalOrderEntity approvalOrderEntity= approvalOrderRepositoyBd.findByApprovalId(approvalId);
		return ApprovalOrderFactory.toModel(approvalOrderEntity);
	}

	@Override
	public ApprovalOrder save(ApprovalOrder approvalOrder) {
		
		ApprovalOrderEntity entity = ApprovalOrderFactory.toEntity(approvalOrder);
        return ApprovalOrderFactory.toModel(approvalOrderRepositoyBd.save(entity));
	}

	@Override
	public ApprovalOrder create(ApprovalOrder approvalOrder) {

		ApprovalOrderEntity entity = ApprovalOrderFactory.toEntity(approvalOrder);
        return ApprovalOrderFactory.toModel(approvalOrderRepositoyBd.save(entity));
	}

	@Override
	public ApprovalOrder update(ApprovalOrder approvalOrder) {

		ApprovalOrderEntity entity = ApprovalOrderFactory.toEntity(approvalOrder);		
        return ApprovalOrderFactory.toModel(approvalOrderRepositoyBd.saveAndFlush(entity));
	}
}
