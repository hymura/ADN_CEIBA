package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.oc.AprobacionOcApplication;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AprobacionOcApplication.class)
@Transactional
public class CreateApproverIntegrationTest {
	

	@Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    
    
    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
  
    @Test
    public void processAuditGoodRequest1() throws Exception {
    	
    	  
        //Arrange
    	               
        String jsonParameters = "{\r\n" + 
        		"  \"appovalAmountEnd\": 5000000,\r\n" + 
        		"  \"appovalAmountInit\": 1000000,\r\n" + 
        		"  \"status\": \"ACTIVO\",\r\n" + 
        		"  \"userName\": \"JUANk.GOMEZ\"\r\n" + 
        		"}";
        //Act Assert
        mvc.perform(post("/api/approver")
                .content(jsonParameters)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
	
	
	

}
