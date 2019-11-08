package co.com.ceiba.oc.vista;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class PurchaseOrderVO {
	
	
	private int poHeaderId;	
	private String orderNumber;
	@Temporal(TemporalType.DATE)
	private  Date creationDate;	
	private int buyerId;
	@Temporal(TemporalType.DATE)
	private Date approvedDate;	
	private Integer totalAmount;
	private String Status;
	
	
	public Integer getTotalAmount() {
		// TODO Auto-generated method stub
		return totalAmount;
	}


	public Date getApprovedDate() {
		// TODO Auto-generated method stub
		return approvedDate;
	}

}
