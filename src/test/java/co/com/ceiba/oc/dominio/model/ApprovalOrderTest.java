package co.com.ceiba.oc.dominio.model;

import static java.util.Objects.requireNonNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class ApprovalOrderTest {
	


	@Test
	public void testValidarFechaAprobacion() {
		 //Arrange
	
		
		 PurchaseOrder orderPurchase = new PurchaseOrder(1,"2505",new Date(System.currentTimeMillis()),1,3000,"REQ_APPROVAL");
		 ApproverAmount approver =new ApproverAmount(1,"ALEX.GOMEZ",2000 ,5000);			 
		 ApprovalOrder  approvalOrder=new ApprovalOrder(1,new Date(),30000,orderPurchase,approver,"Aprobado");		 
		 //approvalOrder.setApprovalDate();
		 
		// approvalOrder.setStatusOrden(orderPurchase);		 
		 
		 Assert.assertNotNull( approvalOrder.getApprovalDate());		  
		
	}
	
	

}
