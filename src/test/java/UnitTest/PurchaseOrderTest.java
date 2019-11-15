package UnitTest;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;


public class PurchaseOrderTest {
	
	
	
	@Test
	
	public void testIngresarOrdenCompra() {
		
		   //Arrange
		 PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),2000,"PENDIENTE");
		 PurchaseOrder orderPurchase1 = new PurchaseOrder(2,"2506",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),2000,"PENDIENTE");
		 PurchaseOrder orderPurchase3 = new PurchaseOrder(3,"2507",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),2000,"PENDIENTE");
		 PurchaseOrder orderPurchase4 = new PurchaseOrder(4,"2508",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),2000,"PENDIENTE");

        //ACT
       

        System.out.println("Orden "+orderPurchase.getOrderNumber() );

       //Assert
       Assert.assertEquals("2505", orderPurchase.getOrderNumber());
       Assert.assertEquals(2, orderPurchase1.getPoHeaderId());
       Assert.assertEquals(2000, orderPurchase3.getTotalAmount());
       Assert.assertEquals(1, orderPurchase4.getBuyerId());
		
	}
	

}
