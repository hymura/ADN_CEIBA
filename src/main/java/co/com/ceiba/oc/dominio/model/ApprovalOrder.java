package co.com.ceiba.oc.dominio.model;

import java.util.Date;

import static java.util.Objects.requireNonNull;


import java.time.DayOfWeek;
import java.time.LocalDate;

public class ApprovalOrder {
	
	private int approvalId;
	private Date approvalDate;
	private int appovalAmount;
	private PurchaseOrder purchaseOder;
	private ApproverAmount approverAmount; 
	private static final int MONTO_MINIMO=20000;
	private static final String ESTADO_APROBADO="APPROVED";
	
	
	
	public ApprovalOrder(int approvalId, Date approvalDate,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount) {

			this.approvalId = requireNonNull(approvalId);
			this.approvalDate =approvalDate;
			this.appovalAmount = requireNonNull(appovalAmount);
			this.purchaseOder = requireNonNull(purchaseOder);
			this.approverAmount = requireNonNull(approverAmount);		
	}
	
	
	public ApprovalOrder(int approvalId,int appovalAmount, PurchaseOrder purchaseOder,
			ApproverAmount approverAmount) {

			this.approvalId = requireNonNull(approvalId);			
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


	private boolean validaMontoAprobador(int totalOrden) {
		
		if (!(totalOrden>=this.approverAmount.getAppovalAmountInit() && totalOrden<=this.approverAmount.getAppovalAmountEnd())) {
			//throw new ExcepcionRule("NO cumple con el  rango de monto del  aprobador");
			 return false;
			}
		 return true;
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
        	if (validaMontoAprobador(this.purchaseOder.getTotalAmount())==true) {        	   
            	this.approvalDate=new Date();//Date(System.currentTimeMillis());            	    
            }else {
            	this.approvalDate=null;
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
	
	
	public void setStatusOrden(PurchaseOrder purchaseOder) {
		
		if (this.approvalDate!=null) {
			purchaseOder.setStatus(ESTADO_APROBADO);
		}
		this.purchaseOder = purchaseOder;
	}
	

	public ApproverAmount getApproverAmount() {
		return approverAmount;
	}


	public void setApproverAmount(ApproverAmount approverAmount) {
		this.approverAmount = approverAmount;
	}
	
	
	public LocalDate dateInstance () {
		return LocalDate.now();
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
