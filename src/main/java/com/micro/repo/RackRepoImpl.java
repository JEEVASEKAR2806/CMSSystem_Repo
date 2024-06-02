package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.RackInfo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RackRepoImpl implements RackRepo{

	@Autowired
    private EntityManager manager;

	public String persist(RackInfo rack) {
        try {
            manager.persist(rack);
            return "Rack Details Added";
        } catch (Exception e) {
          
        	 return "RackId Already Exist";
           
        }
    }

	public List<RackInfo> getAllRackId() {
		
	Query<RackInfo> query=(Query<RackInfo>) manager.createQuery("select rackId from RackInfo");
	return  query.getResultList();	
	}

	@SuppressWarnings("unchecked")
	public List<RackInfo> getRacks() {
		
		@SuppressWarnings("rawtypes")
		Query query=(Query<RackInfo>) manager.createQuery("from RackInfo");
		return  query.getResultList();
		
	}

	public RackInfo getRackByRId(int rackId) {
		
	Query<RackInfo> query=(Query<RackInfo>) manager.createQuery("from RackInfo rf where rackId=:rackId ");
	query.setParameter("rackId", rackId);
	return query.getSingleResult();
	}
	
	public List<Integer> getAllRacksBystorageId(int storageId) {
		    Query<Integer> query = (Query<Integer>) manager.createQuery("select r.rackId from RackInfo as r where r.storageData.storageId=:storageId");
		    query.setParameter("storageId", storageId);
		    return query.getResultList();
	}

	public List<RackInfo> getRackByColdStoreId(int storageId) {
		Query<RackInfo> query=(Query<RackInfo>) manager.createQuery("from RackInfo as r where r.storageData.storageId=:storageId");
		query.setParameter("storageId", storageId);
		return query.getResultList();
	}

	public String updateRackAvailability(int rackId, int setValue) {
		
		System.out.println("rackId"+rackId);
		System.out.println("setValue"+setValue);
		
		int x=setValue;
		
		Query<RackInfo> query=(Query<RackInfo>) manager.
				createQuery("update RackInfo ra set ra.rackAvailability=rackAvailability- :x where ra.rackId=:rackId");
		query.setParameter("x", x);
		query.setParameter("rackId", rackId);
		query.executeUpdate();
		return "Updated";
	}

	@Override
	public String removeRack(int rackId) {
		
		System.out.println(rackId);
		try {
		Query<RackInfo> query = (Query<RackInfo>) manager.createQuery("from RackInfo r where r.rackId=:rackId");
		query.setParameter("rackId", rackId);
		RackInfo rackInfo = query.getSingleResult();
		manager.remove(rackInfo);
	     return "Removed";
		}catch(Exception e) {
			return "Customer Have a Product";
		}
	
	}

	@Override
	public String getRackQuantity(int rackId) {
	Query<RackInfo> query = (Query<RackInfo>) manager.createQuery("from RackInfo r where r.rackId=:rackId");
	query.setParameter("rackId", rackId);
		return null;
	}

	@Override
	public String updateRackAfterRemoving(int rackId, int rackAvailability, int x) {
		System.out.println("rackId"+rackId);
		System.out.println("availability"+rackAvailability);
		System.out.println("count"+x);

		
		Query<RackInfo> query=(Query<RackInfo>) manager.
				createQuery("update RackInfo ra set ra.rackAvailability=ra.rackAvailability+:x where ra.rackId=:rackId");
		query.setParameter("x", x);
		query.setParameter("rackId", rackId);
		query.executeUpdate();
		return "Updated";
	}

	
	
	
	
		
}
