package co.com.ceiba.oc.dominio.servicio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	private PurchaseOrderRepository purchaseOrderRepository;
	private PurchaseOrderService purchaseOrderService;

	@Before
	public void inicializarPrueba() {
		MockitoAnnotations.initMocks(this);
		purchaseOrderService = new PurchaseOrderService(purchaseOrderRepository);
	}

	@Test
	public void testCreatePurchaseOrder() {
		// Arrange
		PurchaseOrder purchaseOrder = new PurchaseOrder(1);
		purchaseOrder.setPoHeaderId(1);
		PurchaseOrder purchaseOrder1 = new PurchaseOrder(2);
		purchaseOrder1.setPoHeaderId(2);

		Mockito.when(purchaseOrderRepository.save(Mockito.any(PurchaseOrder.class))).thenReturn(purchaseOrder1);
		PurchaseOrder purchaseOrdertResponse = purchaseOrderService.create(purchaseOrder);

		// Assert
		assertEquals(2, purchaseOrdertResponse.getPoHeaderId());

	}

	@Test

	public void TestUpdatePuraseorder() {
		// Arrange
		PurchaseOrder purchaseOrder = new PurchaseOrder(1);
		purchaseOrder.setPoHeaderId(1);
		PurchaseOrder purchaseOrder1 = new PurchaseOrder(2);
		purchaseOrder1.setPoHeaderId(2);

		Mockito.when(purchaseOrderRepository.save(Mockito.any(PurchaseOrder.class))).thenReturn(purchaseOrder1);
		PurchaseOrder purchaseOrdertResponse = purchaseOrderService.update(purchaseOrder);

		// Assert
		assertEquals(2, purchaseOrdertResponse.getPoHeaderId());

	}

	@Test
	public void TestDeletePuraseorder() {
		// Arrange
		PurchaseOrder orderPurchase = new PurchaseOrder(1, "2505", 1, 2000, "REQ_APPROVAL");

		purchaseOrderService.delete(orderPurchase);

		// Assert

		Mockito.verify(purchaseOrderRepository).delete(Mockito.any(PurchaseOrder.class));
		// Assert.assertEquals(null, orderPurchase);

	}

	@Test
	public void TestFindByOrderNumber() {
		// Arrange
		PurchaseOrder orderPurchase = new PurchaseOrder(1, "2505",  1, 2000, "REQ_APPROVAL");
		Mockito.when(purchaseOrderRepository.findByOrderNumber(Mockito.anyString())).thenReturn(orderPurchase);
		PurchaseOrder purchaseOrdertResponse = purchaseOrderService.findByOrderNumber("2505");

		// Assert
		assertEquals(1, purchaseOrdertResponse.getPoHeaderId());

	}

	@Test
	public void findAll() {

		List<PurchaseOrder> orderPurchaseList = new ArrayList<>();
		orderPurchaseList.add(new PurchaseOrder(1, "2505",  1, 2000, "REQ_APPROVAL"));
		orderPurchaseList.add(new PurchaseOrder(2, "2506",  1, 2000, "REQ_APPROVAL"));

		Mockito.when(purchaseOrderRepository.findAll()).thenReturn(orderPurchaseList);
		List<PurchaseOrder> orderPurchaseList1 = purchaseOrderService.findAll();

		assertThat(orderPurchaseList1, is(orderPurchaseList));

	}

}
