package co.com.ceiba.oc.dominio.model;



import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApproverAmountTest {

	@Test
	public void testIngresarAprobadores() {
		
		int userId = 1;
		String userName ="ALEX.GOMEZ";
		int appovalAmountInit = 20000;
		int appovalAmountEnd = 50000;
		
		
		ApproverAmount approver =new ApproverAmount();
		approver.setUserId(userId);
		approver.setUserName(userName);
		approver.setAppovalAmountInit(appovalAmountInit);
		approver.setAppovalAmountEnd(appovalAmountEnd);

		  Assert.assertEquals(1, approver.getUserId());
		  Assert.assertEquals("ALEX.GOMEZ", approver.getUserName());
		  Assert.assertEquals(20000, approver.getAppovalAmountInit());
		  Assert.assertEquals(50000, approver.getAppovalAmountEnd());
	}
	
	@Test		
	public void TestValidaMontoInicialMayoraCero() {
		
		//Arrange
		int appovalAmountInit = 20000;
		ApproverAmount approver =new ApproverAmount();		
		//act
		approver.setAppovalAmountInit(appovalAmountInit);		
		//Assert
		 Assert.assertTrue(approver.getAppovalAmountInit()>0);
	}
	
	
	@Test		
	public void TestValidaMontoFinalMayorInicial() {
		
		//Arrange
		int appovalAmountInit = 20000;
		int appovalAmountEnd = 50000;
		ApproverAmount approver =new ApproverAmount();
		
		//act
		approver.setAppovalAmountInit(appovalAmountInit);
		approver.setAppovalAmountEnd(appovalAmountEnd);
		
		//Assert		
		 Assert.assertTrue(approver.getAppovalAmountEnd()>approver.getAppovalAmountInit());		
	}
	
	public ExpectedException exception = ExpectedException.none();
	@Test(expected = IllegalArgumentException.class)
	public void ValidaMontoFinalsifalla() {
				
				ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",5000,10000);							
				approver.setAppovalAmountEnd(2000);
				
	}
			
	@Test(expected = IllegalArgumentException.class)
	public void ValidaMontoInicialsifalla() {
				
				ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,10000);							
				approver.setAppovalAmountInit(0);
				
	}	

@Test		
public void TestValidaEstadoAprobador() {
	
	//Arrange
	ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000);	
	//act		
	//Assert
	 Assert.assertEquals("ACTIVO",approver.getStatus());	
	
}

@Test		
public void TestValidaEstadoiInactivoAprobador() {
	
	//Arrange
	ApproverAmount approver =new ApproverAmount(1,"Alex.gomez",2000,5000,"ACTIVO");	
	//act	
	approver.setStatus("INACTIVO");
	
	//Assert
	 Assert.assertEquals("INACTIVO",approver.getStatus());	
	
}


}
