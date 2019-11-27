package co.com.ceiba.oc.dominio.servicio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.oc.dominio.model.ApproverAmount;
import co.com.ceiba.oc.dominio.repositorio.ApproverAmountRepository;
import co.com.ceiba.oc.dominio.servicio.AppoverAmountServices;

public class AppoverAmountServicesTest {

	@Mock
	private ApproverAmountRepository approverAmountRepository;
	private AppoverAmountServices appoverAmountServices;

	@Before
	public void inicializarPrueba() {
		MockitoAnnotations.initMocks(this);
		appoverAmountServices = new AppoverAmountServices(approverAmountRepository);
	}

	@Test
	public void test() {

		// Arrange
		ApproverAmount approver = new ApproverAmount();
		approver.setUserId(1);

		ApproverAmount approver2 = new ApproverAmount();
		approver2.setUserId(2);

		Mockito.when(approverAmountRepository.save(Mockito.any(ApproverAmount.class))).thenReturn(approver2);

		// act

		ApproverAmount approverAmountResponse = appoverAmountServices.create(approver);

		// Assert
		assertEquals(2, approverAmountResponse.getUserId());

	}

	@Test
	public void testUpdateApprover() {

		// Arrange
		ApproverAmount approver = new ApproverAmount();
		approver.setUserId(1);

		ApproverAmount approver2 = new ApproverAmount();
		approver2.setUserId(3);
		Mockito.when(approverAmountRepository.save(Mockito.any(ApproverAmount.class))).thenReturn(approver2);
	
		// act
		ApproverAmount approverAmountResponse = appoverAmountServices.update(approver);
		// Assert
		assertEquals(3, approverAmountResponse.getUserId());

	}
	
	
	@Test
	public void TestDeleteApprove() {
		// Arrange
		ApproverAmount approverAmount = new ApproverAmount(1,"Alex.gomez",5000,10000);									
		appoverAmountServices.delete(approverAmount);
		// Assert

		Mockito.verify(approverAmountRepository).delete(Mockito.any(ApproverAmount.class));
		// Assert.assertEquals(null, orderPurchase);

	}

	@Test
	public void TestFindByOrderNumber() {
		// Arrange
		ApproverAmount approverAmount = new ApproverAmount(1,"Alex.gomez",5000,10000);		
		Mockito.when(approverAmountRepository.findByApprover(Mockito.anyInt())).thenReturn(approverAmount);
		ApproverAmount approverAmountResponse = appoverAmountServices.findByApprover(1);

		// Assert
		assertEquals(1, approverAmountResponse.getUserId());

	}
	
	@Test
	public void testFindByAmountApprover() {
		int totalAmount=6000;
		String status="ACTIVO";
		ApproverAmount approverAmount = new ApproverAmount(1,"Alex.gomez",5000,10000);	
		Mockito.when(approverAmountRepository.findByAmountApprover(Mockito.anyInt(),Mockito.anyString())).thenReturn(approverAmount);
		ApproverAmount approverAmountResponse = appoverAmountServices.findByAmountApprover(totalAmount,status);
		assertEquals(1, approverAmountResponse.getUserId());
		
	}

	@Test
	public void findAll() {

		List<ApproverAmount> approverAmountList = new ArrayList<>();
		approverAmountList.add(new ApproverAmount(1,"Alex.gomez",5000,10000));
		approverAmountList.add(new ApproverAmount(2,"Juanki.gomez",10001,20000));

		Mockito.when(approverAmountRepository.findAll()).thenReturn(approverAmountList);
		List<ApproverAmount> approverAmountList1 = appoverAmountServices.findAll();

		assertThat(approverAmountList1, is(approverAmountList));

	}
	

}
