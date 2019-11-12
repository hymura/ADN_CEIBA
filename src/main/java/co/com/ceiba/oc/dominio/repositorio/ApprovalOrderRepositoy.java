package co.com.ceiba.oc.dominio.repositorio;


import java.util.List;

import co.com.ceiba.oc.dominio.model.ApprovalOrder;
import co.com.ceiba.oc.infraestructura.repositorio.entity.ApprovalOrderEntity;

public interface ApprovalOrderRepositoy {
	public List<ApprovalOrder>  findAll();
	public ApprovalOrderEntity findByApprovalId(int approvalId);	
	public ApprovalOrderEntity create(ApprovalOrderEntity approvalOrder);
	public ApprovalOrderEntity update(ApprovalOrderEntity approvalOrder);

}
