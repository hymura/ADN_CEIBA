package co.com.ceiba.oc.dominio.model;

import java.util.Date;


public class PurchaseOrder {
	
	private int poHeaderId;
	private String orderNumber;
	private  Date creationDate;
	private int buyerId;
	private Date approvedDate;
	private int totalAmount;
	private String status;
	
	
	public PurchaseOrder(int poHeaderId, String orderNumber, Date creationDate, int buyerId, Date approvedDate,
			int totalAmount, String status) {
	
		this.poHeaderId = poHeaderId;
		this.orderNumber = orderNumber;
		this.creationDate = creationDate;
		this.buyerId = buyerId;
		this.approvedDate = approvedDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
			
	
	public PurchaseOrder(int poHeaderId) {	
		this.poHeaderId = poHeaderId;
	}


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
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		 this.status=status;
	}
	
	
	

}
