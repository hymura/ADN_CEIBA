package co.com.ceiba.oc.infraestructura.controlador.approval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approval.CreateApprovalHandler;
import co.com.ceiba.oc.aplicacion.manejador.approval.FindAllApprovalHandler;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/aprobacion")
@Api(tags = "aprobacion")
public class CreateRegisterApprovalController {

	private final CreateApprovalHandler createApprovalHandler;
	private final FindAllApprovalHandler findAllApprovalHandler;

	@Autowired
	public CreateRegisterApprovalController(CreateApprovalHandler createApprovalHandler,FindAllApprovalHandler findAllApprovalHandler) {
		this.createApprovalHandler = createApprovalHandler;
		this.findAllApprovalHandler=findAllApprovalHandler;
	}

	@PostMapping
	@ApiOperation(value = "Crear registro aprobacion", notes = "Servicio para crear registro aprobacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "registro de aprobacion creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<ApprovalOrder> createPurchaseOrder(@RequestBody ApprovalOrder approvalOrder) {
		createApprovalHandler.execute(approvalOrder);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Registro Aprobacion", notes = "Servicio para traer el Registro de aprobacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Regitro aprobacion encontrados"),
			@ApiResponse(code = 404, message = "Regitro aprobacion no encontrados") })
public  ResponseEntity<List<ApprovalOrder>>  findAll(){		
		return ResponseEntity.ok(this.findAllApprovalHandler.execute());				
	}

}
