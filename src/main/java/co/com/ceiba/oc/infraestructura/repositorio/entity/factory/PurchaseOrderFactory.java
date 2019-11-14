package co.com.ceiba.oc.infraestructura.repositorio.entity.factory;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;

public final class PurchaseOrderFactory {
	
	private PurchaseOrderFactory() { }

    public static PurchaseOrder toModel(PurchaseOrderEntity entity) {
        return new PurchaseOrder(entity.getPoHeaderId(),entity.getOrderNumber(),entity.getCreationDate(),entity.getBuyerId(), entity.getApprovedDate(),entity.getTotalAmount(),entity.getStatus());
    }

    public static PurchaseOrderEntity toEntity(PurchaseOrder purchaseOrder) {
        return PurchaseOrderEntity.builder()
                .poHeaderId(purchaseOrder.getPoHeaderId())
                .orderNumber(purchaseOrder.getOrderNumber())
                .creationDate(purchaseOrder.getCreationDate())
                .buyerId(purchaseOrder.getBuyerId())
                .approvedDate(purchaseOrder.getApprovedDate())
                .totalAmount(purchaseOrder.getTotalAmount())                
                .build();
    }
	

}
