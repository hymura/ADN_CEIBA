package co.com.ceiba.oc.infraestructura.repositorio.entity.factory;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;


public class ApprovalOrderFactory {

	private ApprovalOrderFactory() {}
	
	public static ApprovalOrder toModel(ApprovalOrderEntity entity) {
		PurchaseOrder purchaseOrder = PurchaseOrderFactory.toModel(entity.getPurchaseOrderEntity());
		ApproverAmount approverAmount = ApproverFactory.toModel(entity.getAppoverAmountEntity());		
		return new ApprovalOrder (entity.getApprovalId(),entity.getApprovalDate(),entity.getAppovalAmount(),purchaseOrder,approverAmount,entity.getMotivo());
		
	}
	
	
    public static ApprovalOrderEntity toEntity(ApprovalOrder approvalOrder) {
        return ApprovalOrderEntity.builder()
                .approvalId(approvalOrder.getApprovalId())
                .approvalDate(approvalOrder.getApprovalDate())
                .appovalAmount(approvalOrder.getAppovalAmount())
                .purchaseOrderEntity(PurchaseOrderFactory.toEntity(approvalOrder.getPurchaseOrder()))
                .appoverAmountEntity(ApproverFactory.toEntity(approvalOrder.getApproverAmount()))
                .motivo(approvalOrder.getMotivo())
                .build();
    }
	
 
		

}