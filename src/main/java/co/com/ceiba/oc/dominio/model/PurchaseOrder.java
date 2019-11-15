package co.com.ceiba.oc.dominio.model;

import java.time.LocalDate;
import java.util.Date;


public class PurchaseOrder {
	
	private int poHeaderId;
	private String orderNumber;
	private  Date creationDate;
	private int buyerId;
	private Date approvedDate;
	private int totalAmount;
	private String status;
	//private ApproverAmount approverAmount;
	private static final String ESTADO_AROBADO="APROBADO";
	private static final String ESTADO_PENDIENTE="PENDIENTE";
	
	
	
	public PurchaseOrder(int poHeaderId, String orderNumber, Date creationDate, int buyerId, Date approvedDate,
			int totalAmount, String status) {
	
		this.poHeaderId = poHeaderId;
		this.orderNumber = orderNumber;
		this.creationDate = creationDate;
		this.buyerId = buyerId;
		this.approvedDate = approvedDate;
		this.totalAmount = totalAmount;
		this.status=status;
		 
	}
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(int poHeaderId, String orderNumber, Date creationDate, int buyerId, Date approvedDate,
			int totalAmount) {
	
		this(poHeaderId, orderNumber, creationDate, buyerId, approvedDate,totalAmount,ESTADO_PENDIENTE );
	}
	
	public PurchaseOrder(int poHeaderId) {	
		this.poHeaderId = poHeaderId;
	}
	
/*	
	public void ApprovedProcess(ApproverAmount approverAmount ){
		validaAprobador(approverAmount);
		this.approverAmount=approverAmount;
		this.approvedDate=new Date();
		this.status=ESTADO_AROBADO;
			
	}
*/	




	public int getPoHeaderId() {
		return poHeaderId;
	}
	public void setPoHeaderId(int poHeaderId) {
		this.poHeaderId = poHeaderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
				
			this.totalAmount = totalAmount;
		
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		 this.status=status;
	}
	
	
	

}
