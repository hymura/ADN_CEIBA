package co.com.ceiba.oc.aplicacion.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.ApproverAmountVO;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;
import co.com.ceiba.oc.infraestructura.repositorio.entity.AppoverAmountEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/approver")
@Api(tags="Approver")
public class ApproverAmountResource {
	
	private final AppoverAmountServices approverAmountServices;


	public ApproverAmountResource(AppoverAmountServices approverAmountServices) {
		this.approverAmountServices = approverAmountServices;
	}
	
	
	@PostMapping
	@ApiOperation(value = "Crear Aprobador", notes = "Servicio para crear un Aprobador")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobador creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	
	public ResponseEntity<AppoverAmountEntity> createApprover(@RequestBody ApproverAmountVO approverAmountVO ) {
		
		AppoverAmountEntity  appoverAmount =new AppoverAmountEntity();
		
		appoverAmount.setUserId(approverAmountVO.getUserId());		
		appoverAmount.setUserName(approverAmountVO.getUserName());
		appoverAmount.setAppovalAmountInit(approverAmountVO.getAppovalAmountInit());
		appoverAmount.setAppovalAmountEnd(approverAmountVO.getAppovalAmountEnd());
		appoverAmount.setStatus(approverAmountVO.getStatus());
				
		return new ResponseEntity<>(this.approverAmountServices.create(appoverAmount),HttpStatus.CREATED);		
	}
			
	
	@PutMapping("/{userId}")
	@ApiOperation(value = "Actualizar Aprobador", notes = "Servicio para actualizar un Aprobador")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobador actualizado correctamente"),
			@ApiResponse(code = 404, message = "Aprobador no encontrado") })
	public ResponseEntity<AppoverAmountEntity> updateApprover(@PathVariable("userId") int userId,
			ApproverAmountVO approverAmountVo) {

		AppoverAmountEntity approverAmount = this.approverAmountServices.findByApprover(userId);
	
		
		if (approverAmount==null) {
			return new ResponseEntity<AppoverAmountEntity>(HttpStatus.NOT_FOUND);					
		}else {
			approverAmount.setUserId(approverAmountVo.getUserId());
			approverAmount.setUserName(approverAmountVo.getUserName());
			approverAmount.setAppovalAmountInit(approverAmountVo.getAppovalAmountInit());
			approverAmount.setAppovalAmountEnd(approverAmountVo.getAppovalAmountEnd());
			approverAmount.setStatus(approverAmountVo.getStatus());
		
		}
		return new ResponseEntity<>(this.approverAmountServices.update(approverAmount), HttpStatus.OK);
		
		}
	
	
	@DeleteMapping("/{idaprobador}")
	@ApiOperation(value = "Eliminar Aprobador", notes = "Servicio para eliminar un aprobador")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobador eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void removeAApprover(@PathVariable("UserId") int UserId) {
		AppoverAmountEntity approverAmount = this.approverAmountServices.findByApprover(UserId);
		if (approverAmount != null) {
			this.approverAmountServices.delete(approverAmount);
		}
	}
	
	
	@GetMapping
	@ApiOperation(value = "Listar Aprobadores", notes = "Servicio para listar todas los aprobadores")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aprobadores encontrados"),
			@ApiResponse(code = 404, message = "Aprobadores no encontrados") })
	
	public ResponseEntity<List<ApproverAmount>> findAll(){		
		return ResponseEntity.ok(this.approverAmountServices.findAll());
		
	}
	

}
