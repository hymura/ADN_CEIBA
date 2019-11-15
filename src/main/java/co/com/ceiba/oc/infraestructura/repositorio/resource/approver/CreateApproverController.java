package co.com.ceiba.oc.infraestructura.repositorio.resource.approver;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approver.CreateApproverHandler;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/approver")
@Api(tags="Approver")
public class CreateApproverController {
	private final CreateApproverHandler createApproverHandler;

 @Autowired
	public CreateApproverController(CreateApproverHandler createApproverHandler) {
			this.createApproverHandler = createApproverHandler;
	}
	
	
	 @PostMapping
	 @Transactional
	 @ApiOperation(value = "Crear Aprobador", notes = "Servicio para crear un Aprobador")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobador creado correctamente"),
				@ApiResponse(code = 400, message = "Solicitud Invalida") })
		public ResponseEntity<ApproverAmount> createPurchaseOrder(@RequestBody ApproverAmount approver) {
			
			//PurchaseOrderEntity  purchaseOrder =new PurchaseOrderEntity();			
		 	createApproverHandler.execute(approver);								
			return new ResponseEntity<>(HttpStatus.CREATED);
			
		}

	
	

}
