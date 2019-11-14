package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approver.FindAllApproverHandler;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/api/approver")
@Api(tags="Approver")
public class FindAllApproverController {
	
	private FindAllApproverHandler findAllApproverHandler;
	
	@Autowired
	public FindAllApproverController(FindAllApproverHandler findAllApproverHandler) {
		super();
		this.findAllApproverHandler = findAllApproverHandler;
	}
		

	@GetMapping
	@ApiOperation(value = "Listar Aprobadores", notes = "Servicio para traer los aprobadores")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "aprobadores no encontrados"),
			@ApiResponse(code = 404, message = "OC no encontrados") })
public  ResponseEntity<List<ApproverAmount>>  findAll(){
		
		return ResponseEntity.ok(this.findAllApproverHandler.execute());
				
	}


	
	

}
