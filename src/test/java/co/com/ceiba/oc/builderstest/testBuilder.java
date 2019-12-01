package co.com.ceiba.oc.builderstest;
import static co.com.ceiba.oc.builderstest.ApproverAmountBuilder.anApproverAmount;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.oc.dominio.model.ApproverAmount;

public class testBuilder {

	 @Test
	    public void it_should_transfer_between_two_accounts(){
		 
		
	        //Given
	        ApproverAmount approver = anApproverAmount().
	        					      withUserId(1).
	        					      withUerName("ALEX.GOMEZ").
	        					      withAppovalAmountInit(2000).
	        					      withappovalAmountEnd(50000).
	        					      build();
	        
	        Assert.assertEquals(1,approver.getUserId());	
	                
	          
	 }



}
