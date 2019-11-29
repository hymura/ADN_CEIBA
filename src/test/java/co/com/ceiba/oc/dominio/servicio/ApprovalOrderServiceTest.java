package co.com.ceiba.oc.dominio.servicio;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.ApprovalOrderRepositoy;
import co.com.ceiba.oc.dominio.servicio.ApprovalOrderServices;

public class ApprovalOrderServiceTest {
	
	
	@Mock
	private  ApprovalOrderRepositoy approvalOrderRepositoy;
	private  ApprovalOrderServices approvalOrderServices;
	
	@Before
	public void inicializarPrueba() {
		MockitoAnnotations.initMocks(this);
		approvalOrderServices=new ApprovalOrderServices(approvalOrderRepositoy);		
	}

	@Test
	public void testCreateApprovalOrderService() {
		//Arrange
		ApprovalOrder approvalOrder=new ApprovalOrder(1);
		approvalOrder.setApprovalId(1);
		
		ApprovalOrder approvalOrder1=new ApprovalOrder(2);
		approvalOrder1.setApprovalId(2);
				
		Mockito.when(approvalOrderRepositoy.save(Mockito.any(ApprovalOrder.class))).thenReturn(approvalOrder1);		
		ApprovalOrder approvalOrdertResponse=approvalOrderServices.create(approvalOrder);
		
		//Assert
			assertEquals(2,approvalOrdertResponse.getApprovalId());
		
	}
	
	
	@Test
	public void testUpdateApprovalOrderService() {
		//Arrange
		ApprovalOrder approvalOrder=new ApprovalOrder(1);
		approvalOrder.setApprovalId(1);
		
		ApprovalOrder approvalOrder1=new ApprovalOrder(2);
		approvalOrder1.setApprovalId(2);
				
		Mockito.when(approvalOrderRepositoy.save(Mockito.any(ApprovalOrder.class))).thenReturn(approvalOrder1);		
		ApprovalOrder approvalOrdertResponse=approvalOrderServices.update(approvalOrder);
		
		//Assert
			assertEquals(2,approvalOrdertResponse.getApprovalId());
		
	}

	@Test
	public void testFindByApprovalId(){
		
		// Arrange
				PurchaseOrder orderPurchase = new PurchaseOrder(1, "2505",  1, 3000, "APPROVED");
				ApproverAmount approver = new ApproverAmount(1, "Alex.gomez", 2000, 5000);
				ApprovalOrder approvalOrder = new ApprovalOrder(1,  3000, orderPurchase, approver, null);
				
						
				Mockito.when(approvalOrderRepositoy.findByApprovalId(Mockito.anyInt())).thenReturn(approvalOrder);
				ApprovalOrder approvalOrdeResponse = approvalOrderServices.findByApprovalId(1);

				// Assert
				assertEquals(1, approvalOrdeResponse.getApprovalId());
		
	} 

}
