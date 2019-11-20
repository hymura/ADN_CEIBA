package co.com.ceiba.oc.infraestructura.repositorio.resource.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approval.CreateApprovalHandler;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Configuration
@RestController
@RequestMapping("/api/aprobacion")
@Api(tags = "aprobacion")
public class CreateRegisterApprovalController {

	private final CreateApprovalHandler createApprovalHandler;

	@Autowired
	public CreateRegisterApprovalController(CreateApprovalHandler createApprovalHandler) {
		this.createApprovalHandler = createApprovalHandler;
	}

	@PostMapping
	@ApiOperation(value = "Crear registro aprobacion", notes = "Servicio para crear registro aprobacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "registro de aprobacion creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<ApprovalOrder> createPurchaseOrder(@RequestBody ApprovalOrder approvalOrder) {

		createApprovalHandler.execute(approvalOrder);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
