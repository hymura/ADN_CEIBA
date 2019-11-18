package co.com.ceiba.oc.dominio.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class PurchaseOrderTest {


	@Test
	public void validaMontoAprobacion () {
		
		
	}
		
	  @Test
	    public void getterAndSetter() {
		 
		  PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,2000,"REQ_APPROVAL");			       
	     
		 // orderPurchase.setStatus("REQ_APPROVAL");
		  
		  Assert.assertEquals("2505", orderPurchase.getOrderNumber());
		  Assert.assertEquals(1, orderPurchase.getPoHeaderId());
		  Assert.assertEquals("REQ_APPROVAL", orderPurchase.getStatus());
		  
	    }
	  
	  @Test
	    public void TestOrdenNumberWheOnlyNumber() {
		  PurchaseOrder orderPurchase = new PurchaseOrder();  
		  orderPurchase.setOrderNumber("2505");		  		  
		  Assert.assertTrue("Ok",orderPurchase.getOrderNumber().matches("[Z0-9]+") );
	    }
	  

		@Test
		
		public void testIngresarOrdenCompra() {
			
			   //Arrange
			 PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,2000,"REQ_APPROVAL");
			 PurchaseOrder orderPurchase1 = new PurchaseOrder(2,"2506",new Date(System.currentTimeMillis()),1,2000,"REQ_APPROVAL");
			 PurchaseOrder orderPurchase3 = new PurchaseOrder(3,"2507",new Date(System.currentTimeMillis()),1,2000,"REQ_APPROVAL");
			 PurchaseOrder orderPurchase4 = new PurchaseOrder(4,"2508",new Date(System.currentTimeMillis()),1,2000,"REQ_APPROVAL");
	        //ACT
	       
	        System.out.println("Orden "+orderPurchase.getOrderNumber() );

	       //Assert
	       Assert.assertEquals("2505", orderPurchase.getOrderNumber());
	       Assert.assertEquals(2, orderPurchase1.getPoHeaderId());
	       Assert.assertEquals(2000, orderPurchase3.getTotalAmount());
	       Assert.assertEquals(1, orderPurchase4.getBuyerId());
			
		}
		
	
}
