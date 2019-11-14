package co.com.ceiba.oc.dominio.repositorio;


import java.util.List;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;

public interface ApprovalOrderRepositoy {
	public List<ApprovalOrder>  findAll();
//	public List<ApprovalOrderEntity>  findAll();
	public ApprovalOrder findByApprovalId(int approvalId);	
	public ApprovalOrder save (ApprovalOrder approvalOrder);
	public ApprovalOrder create(ApprovalOrder approvalOrder);
	public ApprovalOrder update(ApprovalOrder approvalOrder);

}
