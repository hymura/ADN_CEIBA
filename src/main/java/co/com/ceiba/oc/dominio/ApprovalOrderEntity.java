package co.com.ceiba.oc.dominio;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
* Clase para definir los servicios de las ordenes pendiente por aprobar
* 
* @author hymura
*
*/
@Data
@Entity
@Table(name = "PO_APPROVAL_ORDER")

public class ApprovalOrderEntity {
	
	@Id
	private int approvalId;
	private Date approvalDate;
	private Integer appovalAmount;
	
	@ManyToOne
	  @JoinColumn(name="PO_HEADER_ID")	  
	private PurchaseOrderEntity purchaseOrderEntity;
	
	@ManyToOne
	  @JoinColumn(name="USER_ID")	  
	private AppoverAmountEntity appoverAmountEntity;

	

	public ApprovalOrderEntity() {
		
			}

	


}
