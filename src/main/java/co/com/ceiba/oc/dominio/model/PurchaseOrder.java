package co.com.ceiba.oc.dominio.model;

import java.util.Date;

public class PurchaseOrder {

	private int poHeaderId;
	private String orderNumber;
	private Date creationDate;
	private int buyerId;
	private Date approvedDate;
	private int totalAmount;
	private String status;
	private static final String ESTADO_PENDIENTE = "REQ_APPROVAL";
	private static final String ESTADO_APROBADO = "APPROVED";
	private static final String ESTADO_RECAHAZADO = "REJECT";

	public PurchaseOrder() {
	}

	public PurchaseOrder(int poHeaderId, String orderNumber, Date creationDate, int buyerId, int totalAmount,
			String status) {

		this.poHeaderId = poHeaderId;
		this.orderNumber = orderNumber;
		this.creationDate = creationDate;
		this.buyerId = buyerId;
		this.totalAmount = totalAmount;
		this.status = status;

	}

	public PurchaseOrder(int poHeaderId, String orderNumber, Date creationDate, int buyerId, int totalAmount) {

		this.poHeaderId = poHeaderId;
		this.orderNumber = orderNumber;
		this.creationDate = creationDate;
		this.buyerId = buyerId;
		this.totalAmount = totalAmount;
		this.status = ESTADO_PENDIENTE;

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

		if (orderNumber.matches("[Z0-9]+")) {
			this.orderNumber = orderNumber;
		} else {
			throw new IllegalArgumentException("No cumple con valores de 0 a 9" + orderNumber);
		}

	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate() {
		this.creationDate = new Date();
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

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {

		if (totalAmount > 0) {
			this.totalAmount = totalAmount;
		} else {
			throw new IllegalArgumentException("El Monto de la orden debe ser mayor a cero");
		}

	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void approve() {
		this.status = ESTADO_APROBADO;
		this.approvedDate = new Date();
	}

	public void reject() {
		this.status = ESTADO_RECAHAZADO;
		this.approvedDate = null;

	}
}
