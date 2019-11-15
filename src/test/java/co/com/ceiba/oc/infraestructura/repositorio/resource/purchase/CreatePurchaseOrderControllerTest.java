package co.com.ceiba.oc.infraestructura.repositorio.resource.purchase;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import java.util.Date;
import org.junit.Test;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;
import static org.mockito.ArgumentMatchers.any;



import lombok.var;

public class CreatePurchaseOrderControllerTest {

	@Test
    void create_when_not_exists() {
        // arrange
        PurchaseOrder purchaseOrder = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),2000,"PENDIENTE");
        PurchaseOrderRepository persistence = mock(PurchaseOrderRepository.class);
        doAnswer(invocation -> {
            // assert
            var purchaseArg = (PurchaseOrder) invocation.getArgument(0);
            assertNotNull(purchaseArg);
            assertNull(purchaseArg.getOrderNumber());
            return null;
        }).when(persistence).save(purchaseOrder);
        PurchaseOrderService service = new PurchaseOrderService(persistence);

        // act - assert
      //  assertAll​(() -> service.execute(purchaseOrder));
        
    }

}
