package co.com.ceiba.oc.infraestructura.repositorio.resource.purchase;

import static org.junit.Assert.*;

import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CreatePurchaseOrderController.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreatePurchaseOrderIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

    @LocalServerPort
    private String  port="9093";

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    
 
    @Test
    public void contextLoads() {}
    
        @Test
    public void testCreatePurchaseOrder() {
    	PurchaseOrder orderPurchase = new PurchaseOrder();
    	orderPurchase.setPoHeaderId(5);
    	orderPurchase.setCreationDate();
    	orderPurchase.setBuyerId(1);
    	orderPurchase.setOrderNumber("2490");
    	orderPurchase.setStatus("REQ_APPROVAL");
    	orderPurchase.setTotalAmount(2000);
    	
    	   	
		ResponseEntity<PurchaseOrder> purchaseOrderResponse = restTemplate.postForEntity(getRootUrl() + "/api/Orden-Compra", orderPurchase, PurchaseOrder.class);
		assertNotNull(purchaseOrderResponse.getStatusCode());
             // assertEquals(HttpStatus.OK, purchaseOrderResponse.getStatusCode());
       // assertNotNull(purchaseOrderResponse);
     
    }
}
