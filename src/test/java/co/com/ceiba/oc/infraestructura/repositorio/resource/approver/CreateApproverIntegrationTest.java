package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.oc.AprobacionOcApplication;
import co.com.ceiba.oc.aplicacion.manejador.approver.CreateApproverHandler;
import co.com.ceiba.oc.aplicacion.manejador.approver.FindAllApproverHandler;
import co.com.ceiba.oc.aplicacion.manejador.purchase.FindAllPurchaseOrderHandler;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;
import co.com.ceiba.oc.infraestructura.controlador.purchase.CreatePurchaseOrderController;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AprobacionOcApplication.class)
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource("/test-application.properties")
@Transactional
public class CreateApproverIntegrationTest {
	
	@MockBean
	private FindAllApproverHandler findAllApproverHandler;
	@MockBean
	private CreateApproverHandler createApproverHandler;
	@MockBean
	private PurchaseOrderRepository purchaseOrderRepository;
	
  @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
       
    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
   // @Ignore
    @Test   
    public void testProcessCreateApprover() throws Exception {
        //Arrange    	               
        String jsonParameters = "{\r\n" + 
        		"  \"appovalAmountEnd\": 50000000,\r\n" + 
        		"  \"appovalAmountInit\": 10000000,\r\n" + 
        		"  \"status\": \"ACTIVO\",\r\n" + 
        		"  \"userName\": \"JUANk.GOMEZ\"\r\n" + 
        		"}";
        //Act Assert
        mvc.perform(post("/api/approver")
        		.contentType(MediaType.APPLICATION_JSON)
        		//.contentType(MediaType.APPLICATION_JSON)
                .content(jsonParameters))
                .andExpect(status().isCreated());
    }
        
    @Test   
    public void testProcessCreatePurchaseOrder()  {
        //Arrange    	               
    	try {
        String jsonParameters = "{\r\n" + 
        		"  \"approvedDate\": \"\",\r\n" + 
        		"  \"buyerId\": 1,\r\n" + 
        		"  \"creationDate\": \"2019-11-14T13:38:43.097Z\",\r\n" + 
        		"  \"orderNumber\": \"4\",\r\n" + 
        		"  \"status\": \"REQ_APPROVAL\",\r\n" + 
        		"  \"totalAmount\": 1500\r\n" + 
        		"}";
        //Act Assert
        mvc.perform(post("/api/Orden-Compra")
        		.contentType(MediaType.APPLICATION_JSON)
        		//.contentType(MediaType.APPLICATION_JSON)
                .content(jsonParameters))
                .andExpect(status().isCreated());
    }catch(Exception e) {
    	System.out.println("Error"+e.getMessage());
    }
    }
    
    @Test   
    public void testSendPurchaseToApproval() throws Exception {
        //Arrange    	               
        String jsonParameters = "{\r\n" + 
        		"    \"approvedDate\": \"\",\r\n" + 
        		"    \"buyerId\": 1,\r\n" + 
        		"    \"creationDate\": \"2019-11-07\",\r\n" + 
        		"    \"orderNumber\": \"2\",\r\n" + 
        		"    \"poHeaderId\": 2,\r\n" + 
        		"    \"status\": \"REQ_APPROVAL\",\r\n" + 
        		"    \"totalAmount\": 300000\r\n" + 
        		"  }";
        //Act Assert
        mvc.perform(post("/api/enviar-orden")
        		.contentType(MediaType.APPLICATION_JSON)
        		//.contentType(MediaType.APPLICATION_JSON)
                .content(jsonParameters))
                .andExpect(status().isOk());
    }
    
    @Test   
    public void testExecuteApproval() throws Exception {
        //Arrange    	               
        String jsonParameters = "{\r\n" + 
        		"    \"approvalId\": 1,\r\n" + 
        		"    \"approvalDate\": \"2019-11-21T16:56:53.526+0000\",\r\n" + 
        		"    \"appovalAmount\": 300000,\r\n" + 
        		"    \"motivo\": \"1\",\r\n" + 
        		"    \"approverAmount\": {\r\n" + 
        		"        \"userId\": 1,\r\n" + 
        		"        \"userName\": \"ALEX.GOMEZ\",\r\n" + 
        		"        \"appovalAmountInit\": 2000,\r\n" + 
        		"        \"appovalAmountEnd\": 50000000,\r\n" + 
        		"        \"status\": \"ACTIVO\"\r\n" + 
        		"    },\r\n" + 
        		"    \"purchaseOder\": {\r\n" + 
        		"        \"poHeaderId\": 1,\r\n" + 
        		"        \"orderNumber\": \"1\",\r\n" + 
        		"        \"creationDate\": \"2019-11-07\",\r\n" + 
        		"        \"buyerId\": 1,\r\n" + 
        		"        \"approvedDate\": null,\r\n" + 
        		"        \"totalAmount\": 300000,\r\n" + 
        		"        \"status\": \"REQ_APPROVAL\"\r\n" + 
        		"    }\r\n" + 
        		"}";
        //Act Assert
                
        mvc.perform(put("/api/aprobar/1/APROBAR")
        		.contentType(MediaType.APPLICATION_JSON)
        		//.contentType(MediaType.APPLICATION_JSON)
                .content(jsonParameters))
        		.andExpect(status().isOk());
        
       
    }  
    
    
    @Test
    public void testGetAllPurchaseSuccess() throws Exception {           
       
        when(this.purchaseOrderRepository.findAll()).thenReturn(Arrays.asList(new PurchaseOrder(1,"1",new Date(),1,300000,"REQ_APPROVAL"),
        		new PurchaseOrder(2,"2",new Date(),1,30000,"REQ_APPROVAL")));

        mvc.perform(get("/api/Orden-Compra"))                
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].poHeaderId", is(1)))
                .andExpect(jsonPath("$[0].orderNumber", is("1")))
                .andExpect(jsonPath("$[1].poHeaderId", is(2)))
                .andExpect(jsonPath("$[1].orderNumber", is("2")))
                .andExpect(status().is2xxSuccessful());

       
    }
    
    
    @Test
    public void testGetAllApproverSuccess() throws Exception {                         
        mvc.perform(get("/api/approver"))                
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is2xxSuccessful());              

       
    }
    
}
