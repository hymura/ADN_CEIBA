package co.com.ceiba.oc.infraestructura.repositorio.entity.factory;



import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;

public class ApprovalOrderUpateFactory {
	
	private ApprovalOrderUpateFactory(){
		
	}
	
	public static ApprovalOrder toModel(ApprovalOrderEntity entity) {
		PurchaseOrder purchaseOrder = PurchaseOrderFactory.toModel(entity.getPurchaseOrderEntity());
		return new ApprovalOrder (entity.getApprovalId(),purchaseOrder, entity.getApprovalDate(),entity.getMotivo());
		
				
	}
	
	
    public static ApprovalOrderEntity toEntity(ApprovalOrder approvalOrder) {
        return ApprovalOrderEntity.builder()
                .approvalId(approvalOrder.getApprovalId())
                .approvalDate(approvalOrder.getApprovalDate())           
                .purchaseOrderEntity(PurchaseOrderFactory.toEntity(approvalOrder.getPurchaseOder()))
                .appoverAmountEntity(ApproverFactory.toEntity(approvalOrder.getApproverAmount()))
                .build();
    }

	
	

}
