package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.ColdStorageData;
import com.micro.model.RackInfo;

import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ColdStorageRepo {

	
	public String persist(ColdStorageData storageData);

	public String update(ColdStorageData storageData);

	public String remove(int storageId);
	
	
	public List<ColdStorageData> viewAllTheStorage();

	public ColdStorageData getStorageById(int storageId);

	public List<ColdStorageData> getAllstorageId();
	
	
	

	
}
