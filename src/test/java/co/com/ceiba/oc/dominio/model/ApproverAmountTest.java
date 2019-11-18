package co.com.ceiba.oc.dominio.model;



import org.junit.Assert;
import org.junit.Test;

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
