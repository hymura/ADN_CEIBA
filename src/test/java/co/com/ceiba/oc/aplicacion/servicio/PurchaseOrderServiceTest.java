package co.com.ceiba.oc.aplicacion.servicio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;
import co.com.ceiba.oc.dominio.servicio.PurchaseOrderService;

public class PurchaseOrderServiceTest {
	
	@Mock
	private  PurchaseOrderRepository purchaseOrderRepository ;
	private  PurchaseOrderService purchaseOrderService;
	
	@Before
	public void inicializarPrueba() {
		MockitoAnnotations.initMocks(this);
		purchaseOrderService=new PurchaseOrderService(purchaseOrderRepository);		
	}

	@Test
	public void testCreatePurchaseOrder() {
		//Arrange
		PurchaseOrder purchaseOrder=new PurchaseOrder(1);
		purchaseOrder.setPoHeaderId(1);
		PurchaseOrder purchaseOrder1=new PurchaseOrder(2);
		purchaseOrder1.setPoHeaderId(2);
				
		Mockito.when(purchaseOrderRepository.save(Mockito.any(PurchaseOrder.class))).thenReturn(purchaseOrder1);		
		PurchaseOrder purchaseOrdertResponse=purchaseOrderService.create(purchaseOrder);
		
		//Assert
			assertEquals(2,purchaseOrdertResponse.getPoHeaderId());
		
	}
	
	
	@Test
	
	public void TestUpdatePuraseorder() {
		//Arrange
				PurchaseOrder purchaseOrder=new PurchaseOrder(1);
				purchaseOrder.setPoHeaderId(1);
				PurchaseOrder purchaseOrder1=new PurchaseOrder(2);
				purchaseOrder1.setPoHeaderId(2);
						
				Mockito.when(purchaseOrderRepository.save(Mockito.any(PurchaseOrder.class))).thenReturn(purchaseOrder1);		
				PurchaseOrder purchaseOrdertResponse=purchaseOrderService.update(purchaseOrder);
				
				//Assert
					assertEquals(2,purchaseOrdertResponse.getPoHeaderId());
			
		
	}

}
