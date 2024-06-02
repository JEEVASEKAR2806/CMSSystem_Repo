package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.ColdStorageData;
import com.micro.model.RackInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.TransactionRolledbackException;
import jakarta.transaction.Transactional;


public interface RackRepo {


	public String persist(RackInfo rack);

	public List<RackInfo> getAllRackId();

	
	public List<RackInfo> getRacks();

	public RackInfo getRackByRId(int rackId);
	
	public List<Integer> getAllRacksBystorageId(int storageId);

	public List<RackInfo> getRackByColdStoreId(int storageId);

	public String updateRackAvailability(int rackId, int setValue);

	public String removeRack(int rackId);

	public String getRackQuantity(int rackId);

	public String updateRackAfterRemoving(int rackId, int rackAvailability, int rackCapacity);
	
}
	
	
	
	
	
	
	
