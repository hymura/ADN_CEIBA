package co.com.ceiba.oc.dominio.model;
import static co.com.ceiba.oc.builderstest.ApproverAmountBuilder.anApproverAmount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApproverAmountTest {
	
	ApproverAmount approver;
	
	 @Before
	    public void setup() {
		
		 //Given
		 approver = anApproverAmount().
	        					      withUserId(1).
	        					      withUerName("ALEX.GOMEZ").
	        					      withAppovalAmountInit(2000).
	        					      withappovalAmountEnd(50000).
	        					      build();
	        					
	 }

	@Test
	public void testIngresarAprobadores() {
		
		int userId = 1;
		String userName ="ALEX.GOMEZ";
		int appovalAmountInit = 2000;
		int appovalAmountEnd = 50000;
	
		 
		Assert.assertEquals(userId, approver.getUserId());
		  Assert.assertEquals(userName, approver.getUserName());
		  Assert.assertEquals(appovalAmountInit, approver.getAppovalAmountInit());
		  Assert.assertEquals(appovalAmountEnd, approver.getAppovalAmountEnd());
	}
	
	@Test		
	public void TestValidaMontoInicialMayoraCero() {
		
		//Arrange
		int appovalAmountInit = 20000;
		ApproverAmount approver1 =new ApproverAmount();		
		//act
		approver1.setAppovalAmountInit(appovalAmountInit);		
		//Assert
		 Assert.assertTrue(approver1.getAppovalAmountInit()>0);
	}
	
	
	@Test		
	public void TestValidaMontoFinalMayorInicial() {
		
		//Arrange
		int appovalAmountInit = 20000;
		int appovalAmountEnd = 50000;
		ApproverAmount approver1 =new ApproverAmount();
		
		//act
		approver1.setAppovalAmountInit(appovalAmountInit);
		approver1.setAppovalAmountEnd(appovalAmountEnd);
		
		//Assert		
		 Assert.assertTrue(approver1.getAppovalAmountEnd()>approver1.getAppovalAmountInit());		
	}
	
	public ExpectedException exception = ExpectedException.none();
	@Test(expected = IllegalArgumentException.class)
	public void ValidaMontoFinalsifalla() {
												
				approver.setAppovalAmountEnd(2000);
				
	}
			
	@Test(expected = IllegalArgumentException.class)
	public void ValidaMontoInicialsifalla() {
													
				approver.setAppovalAmountInit(0);
				
	}	

@Test		
public void TestValidaEstadoAprobador() {
	String status="ACTIVO";
	//act		
	//Assert
	 Assert.assertEquals(status,approver.getStatus());	
	
}

@Test		
public void TestValidaEstadoiInactivoAprobador() {
	
	String status="INACTIVO";
	//act	
	approver.setStatus(status);
	
	//Assert
	 Assert.assertEquals("INACTIVO",approver.getStatus());	
	
}


}
