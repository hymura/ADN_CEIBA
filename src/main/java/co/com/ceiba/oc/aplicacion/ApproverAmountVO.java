package co.com.ceiba.oc.aplicacion;

import lombok.Data;

@Data
public class ApproverAmountVO {

	private int userId;	
	private String userName; 
	private Integer appovalAmountInit;
	private Integer appovalAmountEnd;
	private String status;

}
