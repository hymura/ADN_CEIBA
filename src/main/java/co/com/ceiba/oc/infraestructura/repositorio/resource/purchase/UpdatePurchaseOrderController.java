package co.com.ceiba.oc.infraestructura.repositorio.resource.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.purchase.FindByOrderHandler;
import co.com.ceiba.oc.aplicacion.manejador.purchase.UpdatePurchaseHandler;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/api/ActualizarCompra")
@Api(tags="PurchaseOrder")

public class UpdatePurchaseOrderController {
	
	private final UpdatePurchaseHandler updatePurchaseHandler;
	private final FindByOrderHandler findByOrderHandler; 
	
	 @Autowired
	 public UpdatePurchaseOrderController(UpdatePurchaseHandler updatePurchaseHandler,
				FindByOrderHandler findByOrderHandler) {			
			this.updatePurchaseHandler = updatePurchaseHandler;
			this.findByOrderHandler = findByOrderHandler;
		}
	 

	@PutMapping("/{orderNumber}")
	@ApiOperation(value = "Actualizar OC", notes = "Servicio para actualizar una OC")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC actualizado correctamente"),
			@ApiResponse(code = 404, message = "OC  no encontrada") })
	
	public ResponseEntity<PurchaseOrder> updateCliente(@PathVariable("orderNumber") String orderNumber,PurchaseOrder purchaseOrderVo ){
		
		
		PurchaseOrder purchaseOrder = this.findByOrderHandler.execute(orderNumber);
		if (purchaseOrderVo==null) {
			return new ResponseEntity<PurchaseOrder>(HttpStatus.NOT_FOUND);		
			
		}else {
			purchaseOrder.setPoHeaderId(purchaseOrderVo.getPoHeaderId());
			purchaseOrder.setOrderNumber(purchaseOrderVo.getOrderNumber());
			purchaseOrder.setCreationDate( purchaseOrderVo.getCreationDate());
			purchaseOrder.setBuyerId(purchaseOrderVo.getBuyerId());
			purchaseOrder.setApprovedDate(purchaseOrderVo.getApprovedDate());
			purchaseOrder.setStatus(purchaseOrderVo.getStatus());
			purchaseOrder.setTotalAmount(purchaseOrderVo.getTotalAmount());
		}
		return new ResponseEntity<>(this.updatePurchaseHandler.execute(purchaseOrderVo), HttpStatus.OK);
		
	}

	

	
}
