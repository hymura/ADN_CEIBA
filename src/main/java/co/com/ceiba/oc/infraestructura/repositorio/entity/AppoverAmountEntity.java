package co.com.ceiba.oc.infraestructura.repositorio.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PO_APPOVER_AMOUNT")

public class AppoverAmountEntity {
	

	@Id
	@Column(name="USER_ID")
	private int userId;
	@Column(name = "user_name")
	private String userName; 
	@Column(name = "appoval_amount_init")
	private int appovalAmountInit;
	@Column(name = "appoval_amount_end")
	private int appovalAmountEnd;
	@Column(name = "status")
	private String status;
 
	@OneToMany(fetch=FetchType.LAZY)
	 @JoinColumn(name="USER_ID")
	private Set<ApprovalOrderEntity> approvalOrderEntity;

	
	

}
