package co.com.ceiba.oc.vista;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class ApprovalOrderVO {
	
	private int approvalId;
	@Temporal(TemporalType.DATE)
	private Date approvalDate;
	private double appovalAmount;
	private int userId;
	private PurchaseOrderVO purchaseOrder;
	
	
	
	

	
	
}
