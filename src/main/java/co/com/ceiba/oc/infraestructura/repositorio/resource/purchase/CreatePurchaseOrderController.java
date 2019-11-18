package co.com.ceiba.oc.infraestructura.repositorio.resource.purchase;


//SERVICIO PARA OC


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.oc.aplicacion.manejador.purchase.CreatePurchaseHandler;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/CrearCompra")
@Api(tags="PurchaseOrder")

public class CreatePurchaseOrderController {
	
	
	private final CreatePurchaseHandler createPurchaseHandler;
	 @Autowired
	public CreatePurchaseOrderController(CreatePurchaseHandler createPurchaseHandler) {	
		this.createPurchaseHandler = createPurchaseHandler;
	}
	
	
	 @PostMapping
	 @Transactional
		@ApiOperation(value = "Crear OC", notes = "Servicio para crear una OC")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "OC creado correctamente"),
				@ApiResponse(code = 400, message = "Solicitud Invalda") })
		public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrderVo) {
			
			//PurchaseOrderEntity  purchaseOrder =new PurchaseOrderEntity();			
			createPurchaseHandler.execute(purchaseOrderVo);								
			return new ResponseEntity<>(HttpStatus.CREATED);
			
		}



}
