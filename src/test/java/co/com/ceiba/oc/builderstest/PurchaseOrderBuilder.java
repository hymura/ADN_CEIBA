package co.com.ceiba.oc.builderstest;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;

public class PurchaseOrderBuilder {
	private int poHeaderId;
	private String orderNumber;
	private int buyerId;
	private int totalAmount;
	private String status;
	private static final String ESTADO_PENDIENTE = "REQ_APPROVAL";

	public PurchaseOrderBuilder() {

		this.poHeaderId = 1;
		this.orderNumber = "2505";
		this.buyerId = 1;
		this.totalAmount = 2000;
		this.status = ESTADO_PENDIENTE;
	}
	
	
	public PurchaseOrder build() {
		return new PurchaseOrder(poHeaderId, orderNumber,buyerId,totalAmount,status);
	}
	
	public PurchaseOrderBuilder withPoHeaderId(int poHeaderId) {
		this.poHeaderId = poHeaderId;
		return this;
	}
	
	public PurchaseOrderBuilder withOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}
		
	public PurchaseOrderBuilder withBuyerId(int  buyerId) {
		this.buyerId = buyerId;
		return this;
	}
	
	public PurchaseOrderBuilder withTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}
	
	public PurchaseOrderBuilder withStatus(String  status) {
		this.status = status;
		return this;
	}
	
	 public static PurchaseOrderBuilder aPurchaseOrder(){
	        return new PurchaseOrderBuilder();
	    }
}
