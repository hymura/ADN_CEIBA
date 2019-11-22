package co.com.ceiba.oc.dominio.model;

import java.util.Date;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ApprovalOrder {

	private int approvalId;
	private Date approvalDate;
	private int appovalAmount;
	private String motivo;
	private PurchaseOrder purchaseOrder;
	private ApproverAmount approverAmount;
	private static final int MONTO_MINIMO = 20000;
	
	public ApprovalOrder(int approvalId, Date approvalDate, int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount, String motivo) {
		this.approvalId = requireNonNull(approvalId);
		this.approvalDate = approvalDate;
		this.appovalAmount = requireNonNull(appovalAmount);
		this.purchaseOrder = requireNonNull(purchaseOder);
		this.approverAmount = requireNonNull(approverAmount);
		this.motivo = motivo;
	}


	
	public ApprovalOrder(int approvalId) {
		
		this.approvalId=approvalId;
		// TODO Auto-generated constructor stub
	}

	public boolean validaMontoAprobador(int totalOrden) {

		if ((totalOrden >= this.approverAmount.getAppovalAmountInit() && totalOrden <= this.approverAmount.getAppovalAmountEnd())) {
			return true;
		}
		return false;
	}

	public void approvePurchase() {
		
		if (this.approvalDate==null) {
			setApprovalDate();		
			//this.getPurchaseOder().setApprovedDate(new Date());
			this.purchaseOrder.approve();
		}else {
			throw new IllegalArgumentException("La orden de compra"+this.purchaseOrder.getOrderNumber()+" se encuentra Aprobada");
		}
	}

	public void rejectPurchase() {
		//this.approvalDate = null;
		setMotivo("rechazado");
		
		//this.getPurchaseOder().setStatus(ESTADO_RECHAZDO);
		this.purchaseOrder.reject();
		
	}

	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate() {

		LocalDate dia = LocalDate.now();

		if (dia.getDayOfWeek() == DayOfWeek.SATURDAY || dia.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new IllegalArgumentException("Fecha no habil para aprobacion :");
		}
		if (!validaMontoAprobador(this.purchaseOrder.getTotalAmount())) {
			throw new IllegalArgumentException("El monto de la Orden no cumple las reglas");
		}
		this.approvalDate = new Date();
	}

	public int getAppovalAmount() {
		return appovalAmount;
	}

	public void setAppovalAmount(int appovalAmount) {

		if (appovalAmount < MONTO_MINIMO) {
			throw new IllegalArgumentException(
					"El monto minimo aprobar es :" + MONTO_MINIMO + "Orden" + this.purchaseOrder.getOrderNumber());
		}
		this.appovalAmount = appovalAmount;
	}

	public PurchaseOrder getPurchaseOder() {
		return purchaseOrder;
	}

		
	public ApproverAmount getApproverAmount() {
		return approverAmount;
	}


	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
