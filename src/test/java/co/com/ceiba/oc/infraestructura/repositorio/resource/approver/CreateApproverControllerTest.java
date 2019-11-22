package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;

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

import co.com.ceiba.oc.aplicacion.manejador.approver.CreateApproverHandler;
import co.com.ceiba.oc.aplicacion.manejador.approver.FindAllApproverHandler;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateApproverController.class)
public class CreateApproverControllerTest {

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

	@Test
	public void generaterGoodRequest() throws Exception {
		// Arrange
		// Act
		ResultActions result = mvc.perform(get("/api/approver"));
		// Assert
		result.andExpect(status().is2xxSuccessful());
	}

}
