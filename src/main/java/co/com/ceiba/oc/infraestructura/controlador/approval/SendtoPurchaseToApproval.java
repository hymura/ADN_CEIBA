package co.com.ceiba.oc.infraestructura.controlador.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approval.SendPurchaseOrderToApprovalHandler;
import co.com.ceiba.oc.aplicacion.manejador.approver.FindByAmountApproverHandler;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@RestController
@RequestMapping("/api/enviar-orden")
@Api(tags = "enviar orden")
public class SendtoPurchaseToApproval {
	private final SendPurchaseOrderToApprovalHandler sendPurchaseOrderToApprovalHandler;
	private final FindByAmountApproverHandler findByAmountApproverHandler;
	
	@Autowired
	public SendtoPurchaseToApproval(SendPurchaseOrderToApprovalHandler sendPurchaseOrderToApprovalHandler,
			FindByAmountApproverHandler findByAmountApproverHandler) {
		this.sendPurchaseOrderToApprovalHandler = sendPurchaseOrderToApprovalHandler;
		this.findByAmountApproverHandler = findByAmountApproverHandler;
	}
	
	@PostMapping
	@ApiOperation(value = "Orden para aprobacion", notes = "Servicio registrar orden pendiente para aprobacion")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Proceso generado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	
	public ResponseEntity<ApprovalOrder> sendPurchaseorder(@RequestBody PurchaseOrder purchaseOrder) {
		
		ApproverAmount approverAmount= this.findByAmountApproverHandler.execute(purchaseOrder.getTotalAmount());
			
		if (approverAmount == null) {			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

		return new ResponseEntity<>(this.sendPurchaseOrderToApprovalHandler.execute(purchaseOrder, approverAmount), HttpStatus.OK);

	}

	

}
