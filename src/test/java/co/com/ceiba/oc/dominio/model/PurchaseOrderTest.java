package co.com.ceiba.oc.dominio.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PurchaseOrderTest {
	
	private PurchaseOrder orderPurchase;
	
	 @Before
	    public void setup() {
		  orderPurchase = new PurchaseOrder(1,"2505",1,2000,"REQ_APPROVAL");		 
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
	public void TestTotalAmountFail() {
				 					
		orderPurchase.setTotalAmount(0);	
		//Assert.assertTrue(orderPurchase.getTotalAmount()>0);
	}
		  
	  @Test
	    public void TestOrdenNumberWheOnlyNumber() {		   
		  orderPurchase.setOrderNumber("2505");		  		  
		  Assert.assertTrue("Ok",orderPurchase.getOrderNumber().matches("[Z0-9]+") );
	    }
	  
	 @Test
	 public void TestApproveOrder(){
		//Arrange		 
		PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",1,2000,"REQ_APPROVAL");		
		//Arrange
		 orderPurchase.approve();		
		 Assert.assertEquals("APPROVED", orderPurchase.getStatus());
		 Assert.assertEquals(new Date(), orderPurchase.getApprovedDate());				
		
	}
	  
	 @Test
	 public void TestReject(){		
		//Arrange
		 orderPurchase.reject();		
		 Assert.assertEquals("REJECT", orderPurchase.getStatus());			
	}	
	
	 @Test 
	 public void TestSetsPurchaseOrder(){
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
	 
	 
	
	 
}
