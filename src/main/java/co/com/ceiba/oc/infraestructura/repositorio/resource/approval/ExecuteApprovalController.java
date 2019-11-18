package co.com.ceiba.oc.infraestructura.repositorio.resource.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.approval.FindByIdApprovalHandler;
import co.com.ceiba.oc.aplicacion.manejador.approval.UpdateApprovalHandler;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/aprobar")
@Api(tags="ApprovalOrder")
public class ExecuteApprovalController {
	
		private final UpdateApprovalHandler updateApprovalHandler;
		private final FindByIdApprovalHandler findByIdApprovalHandler; 
		
		 @Autowired
		 public ExecuteApprovalController(UpdateApprovalHandler updateApprovalHandler,FindByIdApprovalHandler findByIdApprovalHandler) {			
				this.updateApprovalHandler = updateApprovalHandler;
				this.findByIdApprovalHandler = findByIdApprovalHandler;
			}
		 
		@Transactional
		@PutMapping("/{approvalId}")	
		@ApiOperation(value = "Actualizar OC", notes = "Servicio para aprobar orden compra")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobacion ejecutada correctamente"),
				@ApiResponse(code = 404, message = "No hay ninguna aprobacion pendiente") })
		
		public ResponseEntity<ApprovalOrder> updateApproval(@PathVariable("approvalId") int  approvalId, ApprovalOrder approvalOrder ){
						
			ApprovalOrder approvalOrder1 = this.findByIdApprovalHandler.execute(approvalId);
			if (approvalOrder1==null) {
				return new ResponseEntity<ApprovalOrder>(HttpStatus.NOT_FOUND);		
				
			}else {
				return new ResponseEntity<>(this.updateApprovalHandler.execute(approvalOrder), HttpStatus.OK);
					
			}
			
			
		}

		
}
	


