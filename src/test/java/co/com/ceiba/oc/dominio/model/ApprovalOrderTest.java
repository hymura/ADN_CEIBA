package co.com.ceiba.oc.dominio.model;

import static co.com.ceiba.oc.builderstest.ApprovalOrderBuilder.anApprovalOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ApprovalOrderTest {
	
	private PurchaseOrder orderPurchase;
	private ApproverAmount approver;
	ApprovalOrder approvalOrder;
	
	
	 @Before
	    public void setup() {
		 //Given
		  orderPurchase = new PurchaseOrder(1,"2505",1,3000,"REQ_APPROVAL");
		  approver = new ApproverAmount(1, "ALEX.GOMEZ", 2000, 5000);
		 
		
		 approvalOrder= anApprovalOrder().withApprovalId(1)
				 				     .withMotivo("PENDIENTE POR APROBAR")
				 				     .withAppovalAmount(3000)
				 				     .withApproverAmount(approver)
				 				     .wiPurchaseOrder(orderPurchase)
				 				     .build();
		 
		
	 }


	@Test
	public void testRegisterOrdertoApproval() {
			
		approvalOrder.setPurchaseOrder(orderPurchase);
		approvalOrder.setApproverAmount(approver);
		approvalOrder.setAppovalAmount(orderPurchase.getTotalAmount());

		Assert.assertNotNull(approvalOrder.getPurchaseOrder());
		Assert.assertNotNull(approvalOrder.getApproverAmount());
		Assert.assertNotNull(approvalOrder.getAppovalAmount());

	}

	@Test
	public void testValidarMontoiistrue() {
		
		
		assertTrue(approvalOrder.validaMontoAprobador(orderPurchase.getTotalAmount()));
		Assert.assertEquals(1, approvalOrder.getApprovalId());
		Assert.assertEquals(1, approvalOrder.getApprovalId());
		Assert.assertEquals(3000, approvalOrder.getAppovalAmount());
		Assert.assertEquals("PENDIENTE POR APROBAR", approvalOrder.getMotivo());
		Assert.assertEquals("ALEX.GOMEZ", approvalOrder.getApproverAmount().getUserName());

	}

	@Test
	public void testValidarMontoiisfalse() {
		approvalOrder.getPurchaseOrder().setTotalAmount(5);
		PurchaseOrder orderPurchase = new PurchaseOrder(1, "2507",  1, 5,"REQ_APPROVAL");				
		assertFalse(approvalOrder.validaMontoAprobador(orderPurchase.getTotalAmount()));
	}

	@Test
	public void testGenearteApproval() {
		//ApprovalOrder approvalOrder = new ApprovalOrder(1, 3000, orderPurchase, approver, null);
		approvalOrder.setApprovalDate();

		Assert.assertNotNull(approvalOrder.getApprovalDate());

	}

	@Test
	public void testRejectOrder() {
		//ApprovalOrder approvalOrder = new ApprovalOrder(1, 3000, orderPurchase, approver, null);
		approvalOrder.rejectPurchase();
		
		Assert.assertEquals("REJECT", orderPurchase.getStatus());
	}


	@Test
	public void testAppovalAmountisFail() {
		final int MONTO_MINIMO = 2000;
		try {			
			approvalOrder.getPurchaseOrder().setTotalAmount(5);
			approvalOrder.setAppovalAmount(20);
			 fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("El monto minimo aprobar es :" + MONTO_MINIMO + "Orden" + "2505", ex.getMessage());
		}

	}

	@Test
	public void testPurchaseWhenApprovedException() {

		try {
			PurchaseOrder orderPurchase1 = new PurchaseOrder(1, "2505",  1, 3000, "APPROVED");
			ApprovalOrder approvalOrder1 = new ApprovalOrder(1,  3000, orderPurchase1, approver, null);
			approvalOrder1.setApprovalDate();
			approvalOrder1.approvePurchase();
			// Assert.assertEquals(new Date(),approvalOrder.getApprovalDate());

			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("La orden de compra" + "2505" + " se encuentra Aprobada", ex.getMessage());
		}

	}

	
	@Test(expected = IllegalArgumentException.class)
	public void setApprovalDate_whenNow_thenGetFixedLocalDateTime() {

		LocalDate date = LocalDate.of(2019, 11, 17);
		approvalOrder.setAppovalAmount(20);
		

		approvalOrder.setApprovalDate();
	}

}
