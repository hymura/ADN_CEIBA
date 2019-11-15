package co.com.ceiba.oc.infraestructura.repositorio.resource.approval;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approval.FindAllApprovalHandler;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/aprobacion")
@Api(tags = "aprobacion")

public class FindaAllRegisterApprovalController {

	private FindAllApprovalHandler findAllApprovalHandler;

	public FindaAllRegisterApprovalController(FindAllApprovalHandler findAllApprovalHandler) {	
		this.findAllApprovalHandler = findAllApprovalHandler;
	}
		
	@GetMapping
	@ApiOperation(value = "Listar Registro Aprobacion", notes = "Servicio para traer el Registro de aprobacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Regitro aprobacion encontrados"),
			@ApiResponse(code = 404, message = "Regitro aprobacion no encontrados") })
public  ResponseEntity<List<ApprovalOrder>>  findAll(){
		
		return ResponseEntity.ok(this.findAllApprovalHandler.execute());
				
	}

	
	

}
