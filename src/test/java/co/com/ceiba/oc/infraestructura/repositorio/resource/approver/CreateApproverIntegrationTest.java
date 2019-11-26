package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

@Transactional
public class CreateApproverIntegrationTest {
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
    	
        ApproverAmount approverAmount=new ApproverAmount(6,"JUANk.GOMEZ",10000000,50000000);		
    	
		ResponseEntity<ApproverAmount> approverResponse = restTemplate.postForEntity(getRootUrl() + "/api/approver", approverAmount, ApproverAmount.class);
		assertNotNull(approverResponse.getStatusCode());            
       // assertNotNull(purchaseOrderResponse);
     
    }
	
	
	

}
