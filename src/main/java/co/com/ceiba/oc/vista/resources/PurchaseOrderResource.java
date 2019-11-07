package co.com.ceiba.oc.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.dominio.PurchaseOrderEntity;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;
import co.com.ceiba.oc.vista.PurchaseOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/PurchaseOrder")
@Api(tags="PurchaseOrder")

public class PurchaseOrderResource {
	
	private final PurchaseOrderService purchaseOrderService;

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
			purchaseOrder.setTotalAmount(purchaseOrderVo.getTotalAmount());
		}
		return new ResponseEntity<>(this.purchaseOrderService.update(purchaseOrder), HttpStatus.OK);
		
	}
	
	
	@GetMapping
	@ApiOperation(value = "Listar OC", notes = "Servicio para listar todas las OC")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC encontrados"),
			@ApiResponse(code = 404, message = "OC no encontrados") })
	
	public ResponseEntity<List<PurchaseOrderEntity>> findAll(){
		
		return ResponseEntity.ok(this.purchaseOrderService.findAll());
		
	}
	

}
