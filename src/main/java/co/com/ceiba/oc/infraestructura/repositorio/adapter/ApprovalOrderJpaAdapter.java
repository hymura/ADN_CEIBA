package co.com.ceiba.oc.infraestructura.repositorio.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepositoy;
import co.com.ceiba.oc.infraestructura.repositorio.ApprovalOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;



public class ApprovalOrderJpaAdapter implements ApprovalOrderRepositoy {
	
	@Autowired
	private ApprovalOrderRepositoryBd approvalOrderRepositoyBd;

 

	@Override
	public List<ApprovalOrder> findAll() {
				
		//return approvalOrderRepositoyBd.findAll();
	
		List<ApprovalOrder> listApprovalOrder=new ArrayList<>();

		PurchaseOrderEntity purchaseOrderBd=new PurchaseOrderEntity(); //= new PurchaseOrderEntity();
		AppoverAmountEntity approverAmountBd=new AppoverAmountEntity();//= new AppoverAmountEntity();

		
			
	for(ApprovalOrderEntity approvalOrderBd: approvalOrderRepositoyBd.findAll()) {			

	listApprovalOrder.add(new ApprovalOrder(approvalOrderBd.getApprovalId(),
													approvalOrderBd.getApprovalDate(), 
													approvalOrderBd.getAppovalAmount(),
													new  PurchaseOrder(purchaseOrderBd.getPoHeaderId()),
													new ApproverAmount(approverAmountBd.getUserId() )
													)
			);
	
							}
	return listApprovalOrder; 						

	}

	@Override
	public ApprovalOrderEntity findByApprovalId(int approvalId) {
		// TODO Auto-generated method stub
		return approvalOrderRepositoyBd.findByApprovalId(approvalId);
	}

	@Override
	public ApprovalOrderEntity create(ApprovalOrderEntity approvalOrder) {
		// TODO Auto-generated method stub
		return approvalOrderRepositoyBd.save(approvalOrder);
	}

	@Override
	public ApprovalOrderEntity update(ApprovalOrderEntity approvalOrder) {
		// TODO Auto-generated method stub
		return approvalOrderRepositoyBd.save(approvalOrder);
	}

	
	

}
