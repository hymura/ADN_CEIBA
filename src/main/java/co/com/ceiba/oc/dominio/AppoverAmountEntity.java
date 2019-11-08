package co.com.ceiba.oc.dominio;




import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PO_APPOVER_AMOUNT")

public class AppoverAmountEntity {
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	@Column(name = "user_name")
	private String userName; 
	@Column(name = "appoval_amount_init")
	private Integer appovalAmountInit;
	@Column(name = "appoval_amount_end")
	private Integer appovalAmountEnd;
	@Column(name = "status")
	private String status;
 
	@OneToMany(fetch=FetchType.LAZY)
	 @JoinColumn(name="USER_ID")
	private Set<ApprovalOrderEntity> approvalOrderEntity;

		
	

}
