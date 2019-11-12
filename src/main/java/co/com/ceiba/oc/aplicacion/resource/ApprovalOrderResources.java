package co.com.ceiba.oc.aplicacion.resource;

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

import co.com.ceiba.oc.aplicacion.ApprovalOrderVO;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;
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
	private static  String  ACTIVE="ACTIVE";

	

	public ApprovalOrderResources(ApprovalOrderServices approvalOrderServices,
			PurchaseOrderService purchaseOrderService, AppoverAmountServices approverAmountServices) {
	
		this.approvalOrderServices = approvalOrderServices;
		this.purchaseOrderService = purchaseOrderService;
		this.approverAmountServices = approverAmountServices;
	}



	@PostMapping
	@ApiOperation(value = "Proceso Aprobacion", notes = "Servicio para bandeja de aprobacion ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	
	public ResponseEntity<ApprovalOrderEntity> createApprovalOrderPending(@RequestBody ApprovalOrderVO approvalOrderVO) {
		
    //valida excepciones  numero de OC y aprobador		
		//PurchaseOrderEntity purchaseOrder = purchaseOrderService.findByOrderNumber(approvalOrderVO.getPurchaseOrder().getOrderNumber());
		PurchaseOrderEntity purchaseOrder = purchaseOrderService.findByIdOc(approvalOrderVO.getPurchaseOrder().getPoHeaderId());
		AppoverAmountEntity appoverAmount=approverAmountServices.findByAmountApprover(approvalOrderVO.getPurchaseOrder().getTotalAmount(),ACTIVE);
					
				
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
	
	
	@GetMapping
	@ApiOperation(value = "Listar Ordenes", notes = "Servicio para listar Ordenes pendiente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Ordenes encontrados"),
			@ApiResponse(code = 404, message = "Ordenes no encontrados") })
	public ResponseEntity<List<ApprovalOrderEntity>> findAll() {
		return ResponseEntity.ok(this.approvalOrderServices.findAll());
	}
	

	
	
}
