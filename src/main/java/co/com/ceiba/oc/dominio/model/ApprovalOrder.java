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
	private PurchaseOrder purchaseOder;
	private ApproverAmount approverAmount; 
	private static final int MONTO_MINIMO=20000;
	private static final String ESTADO_APROBADO="APPROVED";
	private static final String ESTADO_RECHAZDO="REJECT";
	
	
	
	public ApprovalOrder(int approvalId, Date approvalDate,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount, String motivo) {
			this.approvalId = requireNonNull(approvalId);
			this.approvalDate =approvalDate;
			this.appovalAmount = requireNonNull(appovalAmount);
			this.purchaseOder = requireNonNull(purchaseOder);
			this.approverAmount = requireNonNull(approverAmount);	
		    this.motivo=motivo;
	}
	
	public ApprovalOrder(int approvalId,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount) {

			this.approvalId = requireNonNull(approvalId);			
			this.appovalAmount = requireNonNull(appovalAmount);
			this.purchaseOder = requireNonNull(purchaseOder);
			this.approverAmount = requireNonNull(approverAmount);		
	}
	

	public ApprovalOrder(int approvalId, PurchaseOrder purchaseOder,ApproverAmount approverAmount, Date approvalDate) {
		this.approvalId = approvalId;
		this.purchaseOder = purchaseOder;
		this.approvalDate = approvalDate;
	}



	public ApprovalOrder() {
		super();
	}
	

	private boolean validaMontoAprobador(int totalOrden) {
		
		if ((totalOrden>=this.approverAmount.getAppovalAmountInit() && totalOrden<=this.approverAmount.getAppovalAmountEnd())) {
			 return true;			 
			}
		return false;
	}
	
	
public void executeApprovalPurchase() {
	
		setApprovalDate();
			if (this.approvalDate!=null ) {
				setStatusOrden(this.purchaseOder,ESTADO_APROBADO );
				}
}

public void executeRejectPurchase(String motivo) {	
	this.approvalDate=null;
	setStatusOrden(this.purchaseOder,ESTADO_RECHAZDO );	
	setMotivo(motivo);	
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
		
		LocalDate dia= LocalDate.now();		
	
	    if (dia.getDayOfWeek() == DayOfWeek.SATURDAY || dia.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("Fecha no habil para aprobacion :");
        }else {
        	if (validaMontoAprobador(this.purchaseOder.getTotalAmount())) {        	   
            	this.approvalDate=new Date();             	            
            }
        }
	     
	}	
		
	public int getAppovalAmount() {
		return appovalAmount;
	}	
	
	public void setAppovalAmount(int appovalAmount) {
		
		if (appovalAmount<MONTO_MINIMO) {
			throw new IllegalArgumentException("El monto minimo aprobar es :"+MONTO_MINIMO +"Orden"+this.purchaseOder.getOrderNumber());
		}
		this.appovalAmount = appovalAmount;
	}
	
	public PurchaseOrder getPurchaseOder() {
		return purchaseOder;
	}

	public void setPurchaseOder(PurchaseOrder purchaseOder) {
		this.purchaseOder = purchaseOder;
	}
		
	public void setStatusOrden(PurchaseOrder purchaseOder, String statusPurchase) {				
			purchaseOder.setStatus(statusPurchase);
	}
			
	public ApproverAmount getApproverAmount() {
		return approverAmount;
	}

	public void setApproverAmount(ApproverAmount approverAmount) {
		this.approverAmount = approverAmount;
	}
		
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
