package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.oc.AprobacionOcApplication;
import co.com.ceiba.oc.aplicacion.manejador.approver.CreateApproverHandler;
import co.com.ceiba.oc.aplicacion.manejador.approver.FindAllApproverHandler;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AprobacionOcApplication.class)

public class CreateApproverIntegrationTest {
	
	@MockBean
	private FindAllApproverHandler findAllApproverHandler;
	@MockBean
	private CreateApproverHandler createApproverHandler;
	
  @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
   
    
    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
   // @Ignore
    @Test   
    public void processAuditGoodRequest1() throws Exception {

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
	
	
	

}
