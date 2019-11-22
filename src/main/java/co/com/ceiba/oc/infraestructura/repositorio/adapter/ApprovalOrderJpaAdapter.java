package co.com.ceiba.oc.infraestructura.repositorio.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepositoy;
import co.com.ceiba.oc.infraestructura.repositorio.ApprovalOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.PurchaseOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.factory.ApprovalOrderFactory;
import co.com.ceiba.oc.infraestructura.repositorio.entity.factory.PurchaseOrderFactory;


@Repository
public class ApprovalOrderJpaAdapter implements ApprovalOrderRepositoy  {
	private ApprovalOrderRepositoryBd approvalOrderRepositoyBd;
	private PurchaseOrderRepositoryBd purchaseOrderRepositoryBd;
	

	@Autowired
	public ApprovalOrderJpaAdapter(ApprovalOrderRepositoryBd approvalOrderRepositoyBd,
								   PurchaseOrderRepositoryBd purchaseOrderRepositoryBd) {
		this.purchaseOrderRepositoryBd = purchaseOrderRepositoryBd;
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
		PurchaseOrderEntity entity2= PurchaseOrderFactory.toEntity(approvalOrder.getPurchaseOder());
		PurchaseOrderFactory.toModel(purchaseOrderRepositoryBd.saveAndFlush(entity2));
				
        return ApprovalOrderFactory.toModel(approvalOrderRepositoyBd.saveAndFlush(entity));
	}

/*	
	@Override
	public List<ApprovalOrder> updateList(List<ApprovalOrder> approvalOrder) {
		// TODO Auto-generated method stub
		
		List<ApprovalOrderEntity> listApproval=new ArrayList<>();
		List<PurchaseOrderEntity> listapurchase=new ArrayList<>();
		
		for(ApprovalOrder ApprovalOrderBd: approvalOrder) {
			
			//ApprovalOrderEntity entity = ApprovalOrderFactory.toEntity(ApprovalOrderBd);
			//PurchaseOrderEntity entity2= PurchaseOrderFactory.toEntity(ApprovalOrderBd.getPurchaseOder());	
			listApproval.add(ApprovalOrderFactory.toEntity(ApprovalOrderBd));
			listapurchase.add(PurchaseOrderFactory.toEntity(ApprovalOrderBd.getPurchaseOder()));
							
		}
		
		PurchaseOrderFactory.toModel((PurchaseOrderEntity) purchaseOrderRepositoryBd.saveAll(listapurchase));
		ApprovalOrderFactory.toModel((ApprovalOrderEntity) approvalOrderRepositoyBd.saveAll(listApproval));
		
		return approvalOrder;
	}
*/
	
}
