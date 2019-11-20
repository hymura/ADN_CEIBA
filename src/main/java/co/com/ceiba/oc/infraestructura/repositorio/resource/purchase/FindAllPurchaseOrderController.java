package co.com.ceiba.oc.infraestructura.repositorio.resource.purchase;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.oc.aplicacion.manejador.purchase.FindAllPurchaseOrderHandler;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/ConsultarCompra")
@Api(tags = "PurchaseOrder")

public class FindAllPurchaseOrderController {

	private final FindAllPurchaseOrderHandler findAllPurchaseOrderHandler;

	public FindAllPurchaseOrderController(FindAllPurchaseOrderHandler findAllPurchaseOrderHandler) {
		this.findAllPurchaseOrderHandler = findAllPurchaseOrderHandler;
	}

	@GetMapping
	@ApiOperation(value = "Listar idoC", notes = "Servicio para traer una Oc por Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OC encontrados"),
			@ApiResponse(code = 404, message = "Orden de compra no encontrados") })
	public ResponseEntity<List<PurchaseOrder>> findAll() { // PurchaseOrder
		return ResponseEntity.ok(this.findAllPurchaseOrderHandler.execute());

	}
}
