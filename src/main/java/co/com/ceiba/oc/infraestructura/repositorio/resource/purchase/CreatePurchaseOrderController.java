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


	
	/*
	public PurchaseOrderResource(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear OC", notes = "Servicio para crear una OC")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<PurchaseOrderEntity> createPurchaseOrder(@RequestBody PurchaseOrderVO purchaseOrderVo) {
		
		PurchaseOrderEntity  purchaseOrder =new PurchaseOrderEntity();
		
		purchaseOrder.setPoHeaderId(purchaseOrderVo.getPoHeaderId());
		purchaseOrder.setOrderNumber(purchaseOrderVo.getOrderNumber());
		purchaseOrder.setCreationDate( purchaseOrderVo.getCreationDate());
		purchaseOrder.setBuyerId(purchaseOrderVo.getBuyerId());
		purchaseOrder.setApprovedDate(purchaseOrderVo.getApprovedDate());
		purchaseOrder.setTotalAmount(purchaseOrderVo.getTotalAmount());
		purchaseOrder.setStatus(purchaseOrderVo.getStatus());
		
		return new ResponseEntity<>(this.purchaseOrderService.create(purchaseOrder),HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{orderNumber}")
	@ApiOperation(value = "Actualizar OC", notes = "Servicio para actualizar una OC")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC actualizado correctamente"),
			@ApiResponse(code = 404, message = "OC  no encontrada") })
	
	public ResponseEntity<PurchaseOrderEntity> updateCliente(@PathVariable("orderNumber") String orderNumber,PurchaseOrderVO purchaseOrderVo ){
		
		
		PurchaseOrderEntity purchaseOrder = this.purchaseOrderService.findByOrderNumber(orderNumber);
		if (purchaseOrderVo==null) {
			return new ResponseEntity<PurchaseOrderEntity>(HttpStatus.NOT_FOUND);		
			
		}else {
			purchaseOrder.setPoHeaderId(purchaseOrderVo.getPoHeaderId());
			purchaseOrder.setOrderNumber(purchaseOrderVo.getOrderNumber());
			purchaseOrder.setCreationDate( purchaseOrderVo.getCreationDate());
			purchaseOrder.setBuyerId(purchaseOrderVo.getBuyerId());
			purchaseOrder.setApprovedDate(purchaseOrderVo.getApprovedDate());
			purchaseOrder.setStatus(purchaseOrderVo.getStatus());
			purchaseOrder.setTotalAmount(purchaseOrderVo.getTotalAmount());
		}
		return new ResponseEntity<>(this.purchaseOrderService.update(purchaseOrder), HttpStatus.OK);
		
	}
	
	
	@GetMapping
	@ApiOperation(value = "Listar idoC", notes = "Servicio para traer una Oc por Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC encontrados"),
			@ApiResponse(code = 404, message = "OC no encontrados") })
	
	public ResponseEntity<List<PurchaseOrder>> findAll(){ // PurchaseOrder
		
		return ResponseEntity.ok(this.purchaseOrderService.findAll());
		
	}
*/	
	
	

	
	

}
