package co.com.ceiba.oc.dominio.model;

import static org.junit.Assert.*;

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
		  Assert.assertEquals("ACTIVO", approver.getStatus());
		  Assert.assertTrue(approver.getAppovalAmountInit()>0);
		  Assert.assertTrue(approver.getAppovalAmountEnd()>approver.getAppovalAmountInit());
	
		
	}

}
