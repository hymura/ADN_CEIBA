package co.com.ceiba.oc.aplicacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepositoy;
import co.com.ceiba.oc.dominio.repositorio.ApproverAmountRepository;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;


@Configuration
public class BeanConfig {
	
	@Bean
	public PurchaseOrderService getPurchaseServices(PurchaseOrderRepository purchaseOrderRepository) {
		return new PurchaseOrderService(purchaseOrderRepository);
		
	}
	@Bean
	public AppoverAmountServices getApproverService(ApproverAmountRepository approverAmountRepository ) {
		return new AppoverAmountServices(approverAmountRepository);
		
	}
	
	@Bean
	public ApprovalOrderServices  getApprovalOrderService(ApprovalOrderRepositoy approvalOrderServices ) {
		return new ApprovalOrderServices(approvalOrderServices);
		
	}
}
