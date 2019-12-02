package co.com.ceiba.oc.dominio.model;

import static co.com.ceiba.oc.builderstest.PurchaseOrderBuilder.aPurchaseOrder;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PurchaseOrderTest {
	
	private PurchaseOrder orderPurchase;
	
	 @Before
	    public void setup() {
		 
		  orderPurchase = aPurchaseOrder().withPoHeaderId(1)
			      .withOrderNumber("2505")
			      .withBuyerId(1)
			      .withStatus("REQ_APPROVAL")
			      .withTotalAmount(2000)			  
			      .build();		 
	 }
	 
	
	@Test		
	public void testIngresarOrdenCompra() {
		
		   //Arrange
		 		
        //ACT
       
        //Assert
       Assert.assertEquals("2505", orderPurchase.getOrderNumber());
       Assert.assertEquals(1, orderPurchase.getPoHeaderId());
       Assert.assertEquals(2000, orderPurchase.getTotalAmount());
       Assert.assertEquals(1, orderPurchase.getBuyerId());
       Assert.assertEquals("REQ_APPROVAL", orderPurchase.getStatus());
       Assert.assertNotNull(orderPurchase.getCreationDate());

	}

	public ExpectedException exception = ExpectedException.none();
	
	@Test(expected = IllegalArgumentException.class)
	public void TestOrderNumberiffail () {
		//Arrange		 				
		 orderPurchase.setOrderNumber("ALX2505");			
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalAmountFail() {
				 					
		orderPurchase.setTotalAmount(0);	
		//Assert.assertTrue(orderPurchase.getTotalAmount()>0);
	}
		  
	  @Test
	    public void testOrdenNumberWheOnlyNumber() {		   
		  orderPurchase.setOrderNumber("2505");		  		  
		  Assert.assertTrue("Ok",orderPurchase.getOrderNumber().matches("[Z0-9]+") );
	    }
	  
	 @Test
	 public void testApproveOrder(){
		//Arrange		 
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",1,2000,"REQ_APPROVAL");		
		//Arrange
		 orderPurchase.approve();		
		 Assert.assertEquals("APPROVED", orderPurchase.getStatus());
		 Assert.assertEquals(new Date(), orderPurchase.getApprovedDate());				
		
	}
	  
	 @Test
	 public void testReject(){		
		//Arrange
		 orderPurchase.reject();		
		 Assert.assertEquals("REJECT", orderPurchase.getStatus());			
	}	
	
	 @Test 
	 public void testSetsPurchaseOrder(){
		 PurchaseOrder orderPurchase= new PurchaseOrder(1);
		 orderPurchase.setBuyerId(1);
		 orderPurchase.setTotalAmount(2000);
		 orderPurchase.setOrderNumber("2001");
		 orderPurchase.setCreationDate();
		 orderPurchase.setStatus("REQ_APPROVAL");
		 
		 Assert.assertEquals("2001", orderPurchase.getOrderNumber());
		 Assert.assertEquals(new Date(), orderPurchase.getCreationDate());
		 Assert.assertEquals(2000, orderPurchase.getTotalAmount());
		 Assert.assertEquals(1, orderPurchase.getBuyerId());
		 Assert.assertEquals("REQ_APPROVAL", orderPurchase.getStatus());
		 
	 }

	 @Test	 
	 public void testConstructorPurchaseOrder() {
		 
		 PurchaseOrder orderPurchase= new PurchaseOrder(1, "2507",1,30000);
		 Assert.assertEquals("REQ_APPROVAL", orderPurchase.getStatus());
	 }
	 
}
