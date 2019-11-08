package co.com.ceiba.oc.vista;

import lombok.Data;

@Data
public class ApproverAmountVO {

	private int userId;	
	private String userName; 
	private Integer appovalAmountInit;
	private Integer appovalAmountEnd;
	private String status;

}
