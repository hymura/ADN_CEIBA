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
		 
		  PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),2000,"PENDIENTE");			       
	     
		  orderPurchase.setStatus("REQ_APPROVAL");
		  
		  Assert.assertEquals("2505", orderPurchase.getOrderNumber());
		  Assert.assertEquals(1, orderPurchase.getPoHeaderId());
		  Assert.assertEquals("REQ_APPROVAL", orderPurchase.getStatus());
		  
	    }


}
