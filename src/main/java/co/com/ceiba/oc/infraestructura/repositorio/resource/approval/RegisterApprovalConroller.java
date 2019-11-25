package co.com.ceiba.oc.infraestructura.repositorio.resource.approval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approval.GenerateApprovalOrRejection;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/aprobar-rechazar")
@Api(tags = "aprobacion")
public class RegisterApprovalConroller {
	
	private final GenerateApprovalOrRejection generateApprovalOrRejection;
	
	@Autowired
	public RegisterApprovalConroller(GenerateApprovalOrRejection generateApprovalOrRejection
			) {
		this.generateApprovalOrRejection = generateApprovalOrRejection;
		
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Aprobacion OC", notes = "Servicio para aprobar o rechazar orden compra")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Ejecutada correctamente"),
			@ApiResponse(code = 404, message = "No hay ninguna aprobacion pendiente") })
	public ResponseEntity<List<ApprovalOrder>> updateApproval(@RequestBody List<ApprovalOrder> approval, String action) {		
				
		return new ResponseEntity<>(this.generateApprovalOrRejection.executeApproval(approval,action), HttpStatus.OK);
	}

}
