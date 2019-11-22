package co.com.ceiba.oc.infraestructura.repositorio.resource.purchase;

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

import co.com.ceiba.oc.aplicacion.manejador.purchase.FindAllPurchaseOrderHandler;

@RunWith(SpringRunner.class)
@WebMvcTest(FindAllPurchaseOrderController.class)
//@SpringBootTest(classes = FindAllPurchaseOrderController.class)
public class FindAllPurchaseOrderControllerTest {

	 @MockBean
	 private FindAllPurchaseOrderHandler findAllPurchaseOrderHandler;  
	
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
	    	    
	        //Act
	    
	        ResultActions result = mvc.perform(get("/api/ConsultarCompra"));
	      //Assert
	      result.andExpect(status().is2xxSuccessful());
	    }
	    
}
