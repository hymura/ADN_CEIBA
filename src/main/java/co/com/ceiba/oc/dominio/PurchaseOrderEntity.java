package co.com.ceiba.oc.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




import lombok.Data;
import java.util.Date;
import java.util.Set;

/**
 * Clase que representa la tabla purchase
 * @author martosfre
 *
 */

@Data
@Entity
@Table(name = "po_header")
public class PurchaseOrderEntity {

	@Id	
	@Column(name="PO_HEADER_ID")
	private int poHeaderId;
	private String orderNumber;
	@Temporal(TemporalType.DATE)
	private  Date creationDate;
	private int buyerId;
	private Date approvedDate;
	private double totalAmount;
	
	@OneToMany(fetch=FetchType.LAZY)
	 @JoinColumn(name="PO_HEADER_ID")
	private Set<ApprovalOrderEntity> approvalOrderEntity;
	

	
public PurchaseOrderEntity() {
		
	}



}
