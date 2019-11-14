package co.com.ceiba.oc.infraestructura.repositorio.adapter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.oc.dominio.model.PurchaseOrder;
import co.com.ceiba.oc.dominio.repositorio.PurchaseOrderRepository;
import co.com.ceiba.oc.infraestructura.repositorio.PurchaseOrderRepositoryBd;
import co.com.ceiba.oc.infraestructura.repositorio.entity.PurchaseOrderEntity;
import co.com.ceiba.oc.infraestructura.repositorio.entity.factory.PurchaseOrderFactory;


@Repository
public class PurchaseOrderJpaAdapter implements PurchaseOrderRepository {
	
	
	private PurchaseOrderRepositoryBd purchaseOrderRepositoryBd;
	
	
	@Autowired
	public PurchaseOrderJpaAdapter(PurchaseOrderRepositoryBd purchaseOrderRepositoryBd) {

		this.purchaseOrderRepositoryBd = purchaseOrderRepositoryBd;
	}

	@Override
	public PurchaseOrder findByOrderNumber(String orderNumber) {
		 return null;
	                
	}

	@Override
	public PurchaseOrder findByIdOc(int PoheaderId) {
		// TODO Auto-generated method stub
		return null;
		//return purchaseOrderRepositoryBd.findByIdOc(PoheaderId).;
				
	}

	@Override
	public List<PurchaseOrder> findAll() {
		// TODO Auto-generated method stub		
		return purchaseOrderRepositoryBd.findAll().stream().map(PurchaseOrderFactory::toModel)
                .collect(Collectors.toList());
		
	}

	@Override
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		   PurchaseOrderEntity entity = PurchaseOrderFactory.toEntity(purchaseOrder);
	       return PurchaseOrderFactory.toModel(purchaseOrderRepositoryBd.save(entity));
	
	}

	@Override
	public void delete(PurchaseOrder purchaseOrder) {
		
		PurchaseOrderEntity entity = PurchaseOrderFactory.toEntity(purchaseOrder);
		purchaseOrderRepositoryBd.delete(entity);
		
	}

	@Override
	public PurchaseOrder update(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		 PurchaseOrderEntity entity = PurchaseOrderFactory.toEntity(purchaseOrder);
	       return PurchaseOrderFactory.toModel(purchaseOrderRepositoryBd.save(entity));
	}

	
	

}
