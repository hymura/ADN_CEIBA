package co.com.ceiba.oc.dominio.model;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class ApprovalOrderTest {
	


	@Test
	public void testValidarFechaAprobacion() {
		 //Arrange
		
		
		 PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,new Date(System.currentTimeMillis()),3000,"PENDIENTE");
		 ApproverAmount approver =new ApproverAmount(1,"ALEX.GOMEZ",2000 ,5000);			 
		 ApprovalOrder  approvalOrder=new ApprovalOrder(1,30000,orderPurchase,approver);		 
		 approvalOrder.setApprovalDate();
		 
		// approvalOrder.setStatusOrden(orderPurchase);		 
		 
		 Assert.assertNotNull("ok", approvalOrder.getApprovalDate());		  
		
	}
	
	

}
