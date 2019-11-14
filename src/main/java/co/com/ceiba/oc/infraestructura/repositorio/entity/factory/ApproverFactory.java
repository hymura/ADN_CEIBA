package co.com.ceiba.oc.infraestructura.repositorio.entity.factory;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;

public final class ApproverFactory {

    private ApproverFactory() { }
    public static ApproverAmount toModel(AppoverAmountEntity entity) {
        return new ApproverAmount(entity.getUserId(),entity.getUserName(), entity.getAppovalAmountInit(), entity.getAppovalAmountEnd(),entity.getStatus() );
    }

    public static AppoverAmountEntity toEntity(ApproverAmount approverAmount) {
        return AppoverAmountEntity.builder()
                .userId(approverAmount.getUserId())
                		.userName(approverAmount.getUserName())
                		.appovalAmountInit(approverAmount.getAppovalAmountInit())
                		.appovalAmountEnd(approverAmount.getAppovalAmountEnd())
                		.status(approverAmount.getStatus())
                		.build();
    }

}
