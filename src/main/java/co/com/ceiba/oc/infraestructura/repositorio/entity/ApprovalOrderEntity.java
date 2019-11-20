package co.com.ceiba.oc.infraestructura.repositorio.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para definir los servicios de las ordenes pendiente por aprobar
 * 
 * @author hymura
 *
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PO_APPROVAL_ORDER")

public class ApprovalOrderEntity {

	@Id
	private int approvalId;
	private Date approvalDate;
	private int appovalAmount;
	private String motivo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PO_HEADER_ID", updatable = true)
	private PurchaseOrderEntity purchaseOrderEntity;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private AppoverAmountEntity appoverAmountEntity;

}
