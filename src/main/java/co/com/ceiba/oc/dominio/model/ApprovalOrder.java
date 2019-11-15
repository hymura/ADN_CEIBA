package co.com.ceiba.oc.dominio.model;

import java.util.Date;

import static java.util.Objects.requireNonNull;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ApprovalOrder {
	
	private int approvalId;
	private Date approvalDate;
	private int appovalAmount;
	private PurchaseOrder purchaseOder;
	private ApproverAmount approverAmount; 
	private static final int MONTO_MINIMO=20000;
	//private StatusPurchase statusPurchase;
	
	
	public ApprovalOrder(int approvalId, Date approvalDate,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount) {

			this.approvalId = requireNonNull(approvalId);
			this.approvalDate = requireNonNull(approvalDate);
			this.appovalAmount = requireNonNull(appovalAmount);
			this.purchaseOder = requireNonNull(purchaseOder);
			this.approverAmount = requireNonNull(approverAmount);		
	}
	
	public ApprovalOrder() {
		super();
	}
	
	public int sumaDigitos(int n1, int n2) {
		return n1+n2;
	}


private void validaAprobador(ApproverAmount approverAmount2, PurchaseOrder purchaseOrder ) {
		
		if (!(this.purchaseOder.getTotalAmount()>=approverAmount2.getAppovalAmountInit() && this.purchaseOder.getTotalAmount()<=approverAmount2.getAppovalAmountEnd())) {
			throw new ExcepcionRule("NO cumple en el rango del aprobador");
		}
		
	}
	

		private void validaHorarioAprobacion(LocalDateTime date, PurchaseOrder order) {
			 if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			        throw new IllegalArgumentException("Solo se puede aprobar la orden :"+order.getOrderNumber());
			    }
			
		}


	private void validaMonto() {
		if (appovalAmount<MONTO_MINIMO) {
			throw new IllegalArgumentException("El monto minimo aprobar es :"+MONTO_MINIMO +"Orden"+this.purchaseOder.getOrderNumber());
		}
	}
		

	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	
	public Date getApprovalDate() {		
		Date FechaIni = new Date();
        new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return FechaIni;        	
	}
	
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	public int getAppovalAmount() {
		return appovalAmount;
	}	
	
	public void setAppovalAmount(int appovalAmount) {
		this.appovalAmount = appovalAmount;
	}

	public PurchaseOrder getPurchaseOder() {
		return purchaseOder;
	}

	public void setPurchaseOder(PurchaseOrder purchaseOder) {
		this.purchaseOder = purchaseOder;
	}


	public ApproverAmount getApproverAmount() {
		return approverAmount;
	}


	public void setApproverAmount(ApproverAmount approverAmount) {
		this.approverAmount = approverAmount;
	}
	

/*

	public StatusPurchase getStatusPurchase() {
		return statusPurchase;
	}

	public void setStatusPurchase(StatusPurchase statusPurchase) {
		this.statusPurchase = statusPurchase;
	}
	
	*/
	

}
