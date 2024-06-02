package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.ColdStorageData;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ColdStorageImpl implements ColdStorageRepo {

	@Autowired
	EntityManager manager;
	
	
public String persist(ColdStorageData storageData) {
		
		try {
		manager.persist(storageData);
		return "SuccessFully Added";
	}catch(Exception e) {
		return "Storage Id Already Exist";
	}
	}

	public String update(ColdStorageData storageData) {
		try {
			manager.merge(storageData);
			return "SuccessFully Updated";
		}catch(Exception e) {
			return "Failed To Update";
		}
	}

	public String remove(int storageId) {
		try {
		Query<ColdStorageData> query = (Query<ColdStorageData>) manager.createQuery("delete from ColdStorageData cold where cold.storageId=:storageId");
		query.setParameter("storageId", storageId);
		query.executeUpdate();
		return "Success";
		}catch(Exception e) {
			return "Storage Have a Rack";
		}
	}

	@SuppressWarnings("unchecked")
	public List<ColdStorageData> viewAllTheStorage() {
		
		Query query=(Query) manager.createQuery("from ColdStorageData");
		return query.getResultList();

	}

	public ColdStorageData getStorageById(int storageId) {
		
		Query query = (Query) manager.createQuery("FROM ColdStorageData WHERE storageId = :storageId", ColdStorageData.class);
        query.setParameter("storageId", storageId);

		return  (ColdStorageData) query.getSingleResult();

	}

	public List<ColdStorageData> getAllstorageId() {
		Query<ColdStorageData> query=(Query<ColdStorageData>) manager.createQuery("select storageId from ColdStorageData");
		return  query.getResultList();	
		}

	
	
}
