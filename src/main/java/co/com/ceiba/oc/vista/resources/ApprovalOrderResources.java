package co.com.ceiba.oc.vista.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.dominio.AppoverAmountEntity;
import co.com.ceiba.oc.dominio.ApprovalOrderEntity;
import co.com.ceiba.oc.dominio.PurchaseOrderEntity;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;
import co.com.ceiba.oc.vista.ApprovalOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/api/aprobacion")
@Api(tags = "aprobacion")
public class ApprovalOrderResources {
	
	

	private final ApprovalOrderServices approvalOrderServices;
	private final PurchaseOrderService purchaseOrderService;
	private final AppoverAmountServices approverAmountServices;
	private static  String  ACTIVO="Activo";
	

	public ApprovalOrderResources(ApprovalOrderServices approvalOrderServices,
			PurchaseOrderService purchaseOrderService, AppoverAmountServices approverAmountServices) {
	
		this.approvalOrderServices = approvalOrderServices;
		this.purchaseOrderService = purchaseOrderService;
		this.approverAmountServices = approverAmountServices;
	}



	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inv�lida") })
	
	public ResponseEntity<ApprovalOrderEntity> createApprovalOrderPending(@RequestBody ApprovalOrderVO approvalOrderVO) {
		
    //valida excepciones  numero de OC y aprobador		
		PurchaseOrderEntity purchaseOrder = purchaseOrderService.findByOrderNumber(approvalOrderVO.getPurchaseOrder().getOrderNumber());		
		AppoverAmountEntity appoverAmount=approverAmountServices.findByAmountApprover(approvalOrderVO.getPurchaseOrder().getTotalAmount(),ACTIVO);
					
				
		ApprovalOrderEntity approvalOrder = new ApprovalOrderEntity();
		approvalOrder.setPurchaseOrderEntity(purchaseOrder);
		approvalOrder.setAppoverAmountEntity(appoverAmount);
				
		approvalOrder.setApprovalId(approvalOrderVO.getApprovalId());
		approvalOrder.setAppovalAmount(approvalOrderVO.getAppovalAmount());
		approvalOrder.setApprovalDate(approvalOrderVO.getApprovalDate());
		
		return new ResponseEntity<>(this.approvalOrderServices.create(approvalOrder), HttpStatus.CREATED);
	}
		
	
	@PutMapping("/{approvalId}")
	@ApiOperation(value = "Proceso Aprobacion", notes = "Servicio para aprobar una Orden de Compra")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Proceso actualizado correctamente"),
			@ApiResponse(code = 404, message = "Orden Pendiente no encontrada") })
	public ResponseEntity<ApprovalOrderEntity> updatePendingPurchase(@PathVariable("approvalId") int approvalId,	ApprovalOrderVO approvalOrderVO) {

		ApprovalOrderEntity approvalOrder =this.approvalOrderServices.findByApprovalId(approvalId);
				
		if (approvalOrder == null) {
			return new ResponseEntity<ApprovalOrderEntity>(HttpStatus.NOT_FOUND);
		} else {				
			
			approvalOrder.setApprovalDate(approvalOrderVO.getApprovalDate());
		}
		return new ResponseEntity<>(this.approvalOrderServices.update(approvalOrder), HttpStatus.OK);
	}
	

	
}
