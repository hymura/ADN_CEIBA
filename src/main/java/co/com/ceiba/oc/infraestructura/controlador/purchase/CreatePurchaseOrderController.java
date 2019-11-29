package co.com.ceiba.oc.infraestructura.controlador.purchase;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.oc.aplicacion.manejador.purchase.CreatePurchaseHandler;
import co.com.ceiba.oc.aplicacion.manejador.purchase.FindAllPurchaseOrderHandler;
import co.com.ceiba.oc.aplicacion.manejador.purchase.FindByOrderHandler;
import co.com.ceiba.oc.aplicacion.manejador.purchase.UpdatePurchaseHandler;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Orden-Compra")
@Api(tags = "PurchaseOrder")

public class CreatePurchaseOrderController {

	private final CreatePurchaseHandler createPurchaseHandler;
	private final UpdatePurchaseHandler updatePurchaseHandler;
	private final FindByOrderHandler findByOrderHandler; 
	private final FindAllPurchaseOrderHandler findAllPurchaseOrderHandler;

	@Autowired
	public CreatePurchaseOrderController(CreatePurchaseHandler createPurchaseHandler,
										UpdatePurchaseHandler updatePurchaseHandler, 
										FindByOrderHandler findByOrderHandler,
										FindAllPurchaseOrderHandler findAllPurchaseOrderHandler
										) {
		this.createPurchaseHandler = createPurchaseHandler;
		this.updatePurchaseHandler=updatePurchaseHandler;
		this.findByOrderHandler=findByOrderHandler;
		this.findAllPurchaseOrderHandler=findAllPurchaseOrderHandler;
	}

	@PostMapping
	@Transactional
	@ApiOperation(value = "Crear OC", notes = "Servicio para crear una OC")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalda") })
	public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrderVo) {

		createPurchaseHandler.execute(purchaseOrderVo);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PutMapping("/{orderNumber}")	
	@ApiOperation(value = "Actualizar OC", notes = "Servicio para actualizar una OC")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC actualizado correctamente"),
			@ApiResponse(code = 404, message = "OC  no encontrada") })
	
	public ResponseEntity<PurchaseOrder> updateCliente(@PathVariable("orderNumber") String orderNumber, PurchaseOrder purchaseOrder ){
						
		PurchaseOrder purchaseOrder1 = this.findByOrderHandler.execute(orderNumber);
		return (purchaseOrder1==null)? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(this.updatePurchaseHandler.execute(purchaseOrder), HttpStatus.OK);
				
	}
		
		@GetMapping
		@ApiOperation(value = "Listar idoC", notes = "Servicio para traer una Oc por Id")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "OC encontrados"),
				@ApiResponse(code = 404, message = "Orden de compra no encontrados") })
		public ResponseEntity<List<PurchaseOrder>> findAll() { // PurchaseOrder
			return ResponseEntity.ok(this.findAllPurchaseOrderHandler.execute());
		}
		
		
		
}
