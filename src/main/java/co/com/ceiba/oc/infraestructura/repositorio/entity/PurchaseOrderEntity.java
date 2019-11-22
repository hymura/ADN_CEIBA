package co.com.ceiba.oc.infraestructura.repositorio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

/**
 * Clase que representa la tabla purchase
 * @author hymura
 *
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PO_HEADER")
public class PurchaseOrderEntity {

	@Id	
	@Column(name="PO_HEADER_ID")
	private int poHeaderId;
	private String orderNumber;
	@Temporal(TemporalType.DATE)
	private  Date creationDate;
	private int buyerId;
	@Temporal(TemporalType.DATE)
	private Date approvedDate;
	private int totalAmount;
	private String status;
	

	@OneToMany(fetch=FetchType.LAZY)
	 @JoinColumn(name="PO_HEADER_ID")
	private Set<ApprovalOrderEntity> approvalOrderEntity;
}
