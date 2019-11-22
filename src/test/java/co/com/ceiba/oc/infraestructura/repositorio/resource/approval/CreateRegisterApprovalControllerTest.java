package co.com.ceiba.oc.infraestructura.repositorio.resource.approval;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.oc.aplicacion.manejador.approval.CreateApprovalHandler;
import co.com.ceiba.oc.aplicacion.manejador.approval.FindAllApprovalHandler;


@RunWith(SpringRunner.class)
@WebMvcTest(CreateRegisterApprovalController.class)
public class CreateRegisterApprovalControllerTest {

	  @MockBean
	    private FindAllApprovalHandler findAllApprovalHandler;
	  @MockBean  
	   private  CreateApprovalHandler createApprovalHandler;

	    
	    @Autowired
	    private WebApplicationContext wac;

	    private MockMvc mvc;

	    @Before
	    public void setup() {
	        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	    
	    @Test
	    public void generaterGoodRequest() throws Exception {
	        //Arrange
	        //String responseExpected = "[{\"poHeaderId\":4,\"orderNumber\":\"2485\",\"creationDate\":\"2019-11-14\",\"buyerId\":1,\"approvedDate\":\"2019-11-14\",\"totalAmount\":1500,\"status\":null},{\"poHeaderId\":5,\"orderNumber\":\"7\",\"creationDate\":\"2019-11-06\",\"buyerId\":1,\"approvedDate\":null,\"totalAmount\":2000000,\"status\":\"p\"},{\"poHeaderId\":1,\"orderNumber\":\"1\",\"creationDate\":\"2019-11-07\",\"buyerId\":1,\"approvedDate\":null,\"totalAmount\":200000,\"status\":\"p\"},{\"poHeaderId\":2,\"orderNumber\":\"2\",\"creationDate\":\"2019-11-07\",\"buyerId\":1,\"approvedDate\":null,\"totalAmount\":300000,\"status\":\"p\"},{\"poHeaderId\":3,\"orderNumber\":\"3\",\"creationDate\":\"2019-11-07\",\"buyerId\":1,\"approvedDate\":null,\"totalAmount\":500000,\"status\":\"p\"}]";
	    
	        //Act
	        //Assert
	     /*   mvc.perform(get("/api/ConsultarCompra"))	                
	                .andExpect(status().isOk()); */
	        
	        ResultActions result = mvc.perform(get("/api/aprobacion"));
	      //Assert
	      result.andExpect(status().is2xxSuccessful());
	    }

}
