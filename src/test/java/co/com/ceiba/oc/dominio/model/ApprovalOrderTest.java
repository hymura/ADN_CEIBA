package co.com.ceiba.oc.dominio.model;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;



public class ApprovalOrderTest {
	

	@Test
	public void testValidarRegistros() {
		 //Arrange
	
		
		 PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		 ApproverAmount approver =new ApproverAmount(1,"ALEX.GOMEZ",2000 ,5000);			 
		 ApprovalOrder  approvalOrder=new ApprovalOrder(1,new Date(),30000,orderPurchase,approver,"Aprobado");		 
		 //approvalOrder.setApprovalDate();
		 
		// approvalOrder.setStatusOrden(orderPurchase);		 
		 
		 Assert.assertNotNull( approvalOrder.getApprovalDate());
		 
		
	}
	
	@Test
	public void testValidarMontoiistrue(){
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,3000,orderPurchase,approver,"PENDIENTE POR APROBAR");
		
	
		assertTrue(approvalOrder.validaMontoAprobador(orderPurchase.getTotalAmount()));
		Assert.assertEquals(1, approvalOrder.getApprovalId());
		Assert.assertEquals(1, approvalOrder.getApprovalId());
		Assert.assertEquals(3000, approvalOrder.getAppovalAmount());
		Assert.assertEquals("PENDIENTE POR APROBAR", approvalOrder.getMotivo());
		Assert.assertEquals("Alex.gomez", approvalOrder.getApproverAmount().getUserName());
	
	}
	
	
	@Test
	public void testValidarMontoiisfalse(){
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,5,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,5,orderPurchase,approver,null);

		assertFalse(approvalOrder.validaMontoAprobador(orderPurchase.getTotalAmount()));
	
	}
	
	
	@Test
	public void testGenearteApproval(){
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,3000,orderPurchase,approver,null);
		 approvalOrder.setApprovalDate();
	
		 Assert.assertNotNull(approvalOrder.getApprovalDate());
	
	}
	
	
	@Test
	public void testRejectOrder(){
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,3000,orderPurchase,approver,null);
		approvalOrder.rejectPurchase("Rechazadoo");
	
		Assert.assertEquals("REJECT", orderPurchase.getStatus());
	
	}
	
	@Test
	public void test(){
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,3000,orderPurchase,approver,null);
		approvalOrder.rejectPurchase("Rechazadoo");
	
		Assert.assertEquals("REJECT", orderPurchase.getStatus());
	
	}
	
	
	@Test
    public void testAppovalAmountisFail() {
		 final int MONTO_MINIMO = 20000;
		 try {
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,5,orderPurchase,approver,null);		 
		approvalOrder.setAppovalAmount(20);
	    fail();
	        } catch (IllegalArgumentException ex) {
	            assertEquals("El monto minimo aprobar es :" + MONTO_MINIMO + "Orden" +"2505", ex.getMessage());
	        }
		
    }

	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test(expected = IllegalArgumentException.class)
	public void TestsetApprovalDateisFail(){
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,20,"REQ_APPROVAL");
		ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		ApprovalOrder approvalOrder = new ApprovalOrder(1,null,20,orderPurchase,approver,null);			
		approvalOrder.setApprovalDate();
	}
	
	

	
	 @Test(expected = IllegalArgumentException.class)
	 public void setApprovalDate_whenNow_thenGetFixedLocalDateTime() {
		 
		 LocalDate date = LocalDate.of(2019,11,17);
	    // PowerMockito.mockStatic(LocalDate.class);

		 //   Mockito.when(LocalDate.now()).thenReturn(date);
		    PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,20,"REQ_APPROVAL");
	     ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
		 ApprovalOrder approvalOrder = new ApprovalOrder(1,null,5,orderPurchase,approver,null);
	     
		 approvalOrder.setApprovalDate();
		
		 
	   
	 }
	
}
