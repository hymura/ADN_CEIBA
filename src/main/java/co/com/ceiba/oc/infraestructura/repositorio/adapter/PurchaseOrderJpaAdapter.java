package co.com.ceiba.oc.infraestructura.repositorio.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;
import co.com.ceiba.oc.infraestructura.repositorio.PurchaseOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;

@Repository
public class PurchaseOrderJpaAdapter implements PurchaseOrderRepository {
	
	@Autowired
	private PurchaseOrderRepositoryBd purchaseOrderRepositoryBd;

	@Override
	public PurchaseOrderEntity findByOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		return purchaseOrderRepositoryBd.findByOrderNumber(orderNumber);
	}

	
	
	@Override
	public PurchaseOrderEntity findByIdOc(int PoheaderId) {
		// TODO Auto-generated method stub
		return purchaseOrderRepositoryBd.findByIdOc(PoheaderId);
	}



	@Override
	public List<PurchaseOrder> findAll() {
		// TODO Auto-generated method stub
		List<PurchaseOrder> listPurchaseOrder=new ArrayList<>();
		for(PurchaseOrderEntity purchaseOrderBd: purchaseOrderRepositoryBd.findAll()) {
			listPurchaseOrder.add(new PurchaseOrder(purchaseOrderBd.getPoHeaderId(),purchaseOrderBd.getOrderNumber(),purchaseOrderBd.getCreationDate(),purchaseOrderBd.getBuyerId(),purchaseOrderBd.getApprovedDate(),purchaseOrderBd.getTotalAmount(),purchaseOrderBd.getStatus() ));			
		}
		return listPurchaseOrder;
	}

	@Override
	public PurchaseOrderEntity save(PurchaseOrderEntity purchaseOrder) {
		// TODO Auto-generated method stub
		return purchaseOrderRepositoryBd.save(purchaseOrder);
	}

	@Override
	public void delete(PurchaseOrderEntity purchaseOrder) {
		// TODO Auto-generated method stub
		purchaseOrderRepositoryBd.delete(purchaseOrder);
	}

	@Override
	public PurchaseOrderEntity update(PurchaseOrderEntity purchaseOrder) {
		// TODO Auto-generated method stub
		return purchaseOrderRepositoryBd.save(purchaseOrder);
	}
	

}
