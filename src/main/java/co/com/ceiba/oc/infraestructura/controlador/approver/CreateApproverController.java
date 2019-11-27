package co.com.ceiba.oc.infraestructura.controlador.approver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approver.CreateApproverHandler;
import co.com.ceiba.oc.aplicacion.manejador.approver.FindAllApproverHandler;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/approver")
@Api(tags = "Approver")
public class CreateApproverController {
	private final CreateApproverHandler createApproverHandler;
	private final FindAllApproverHandler findAllApproverHandler;

	@Autowired
	public CreateApproverController(CreateApproverHandler createApproverHandler,
			FindAllApproverHandler findAllApproverHandler) {
		this.createApproverHandler = createApproverHandler;
		this.findAllApproverHandler = findAllApproverHandler;
	}

	@PostMapping(produces = { "application/json"})
	@ApiOperation(value = "Crear Aprobador", notes = "Servicio para crear un Aprobador")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobador creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<Void> createPurchaseOrder(@RequestBody ApproverAmount approver) {
		createApproverHandler.execute(approver);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping
	@ApiOperation(value = "Listar Aprobadores", notes = "Servicio para traer los aprobadores")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "aprobadores no encontrados"),
			@ApiResponse(code = 404, message = "OC no encontrados") })
	public ResponseEntity<List<ApproverAmount>> findAll() {

		return ResponseEntity.ok(this.findAllApproverHandler.execute());

	}

}
