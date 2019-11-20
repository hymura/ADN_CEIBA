package co.com.ceiba.oc.aplicacion.servicio;

import static org.junit.Assert.*;

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
	private AppoverAmountServices appoverAmount;
	
	@Before
	public void inicializarPrueba() {
		MockitoAnnotations.initMocks(this);
		appoverAmount=new AppoverAmountServices(approverAmountRepository);		
	}
	
	@Test
	public void test() {
		
	//Arrange
		ApproverAmount approver=new ApproverAmount( );
		approver.setUserId(1);
		
		ApproverAmount approver2=new ApproverAmount( );
		approver2.setUserId(2);
		
		
		Mockito.when(approverAmountRepository.save(Mockito.any(ApproverAmount.class))).thenReturn(approver2);
		
	//act
		
		ApproverAmount approverAmountResponse=appoverAmount.create(approver);
		
	//Assert
		assertEquals(2,approverAmountResponse.getUserId());

	}

	@Test
	public void testUpdateApprover() {
		
	//Arrange
		ApproverAmount approver=new ApproverAmount( );
		approver.setUserId(1);
		
		ApproverAmount approver2=new ApproverAmount( );
		approver2.setUserId(3);
		
		
		Mockito.when(approverAmountRepository.save(Mockito.any(ApproverAmount.class))).thenReturn(approver2);
		
	//act
		
		ApproverAmount approverAmountResponse=appoverAmount.update(approver);
		
	//Assert
		assertEquals(3,approverAmountResponse.getUserId());

	}


	

}
