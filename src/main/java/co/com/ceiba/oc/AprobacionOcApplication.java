package co.com.ceiba.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan ({"'co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices","'co.com.ceiba.oc.dominio.servicio.AppoverAmountServices","'co.com.ceiba.oc.dominio.servicio.PurchaseOrderService"})
public class AprobacionOcApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprobacionOcApplication.class, args);
	}

}
