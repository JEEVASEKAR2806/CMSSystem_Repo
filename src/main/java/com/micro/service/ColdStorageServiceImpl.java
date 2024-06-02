package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.ColdStorageData;
import com.micro.repo.ColdStorageRepo;

@Service
public class ColdStorageServiceImpl implements ColdStorageService {


	@Autowired
	private ColdStorageRepo storageRepo;
	
	public String insertColdStorageData(ColdStorageData storageData) {
		try {
			return storageRepo.persist(storageData);
		
		}catch(Exception e) {
			e.printStackTrace();
			return "Id Already Exist";
		}
	}

	public String updateColdStorageData(ColdStorageData storageData) {
		
		try {
			 storageRepo.update(storageData);
			 return "Storage Data Updated";
		
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed To Update";
		}
	}

	public String removeColdStorageDataById(int storageId) {
		try {
			 storageRepo.remove(storageId);
		return"Success";
		}catch(Exception e) {
			e.printStackTrace();
			return "Storage Have a Rack";
		}
	}

	public List<ColdStorageData> viewAllStorages() {
		try {
			 return storageRepo.viewAllTheStorage();
			
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ColdStorageData getStorageById( int storageId ) {
		try {
			return storageRepo.getStorageById(storageId);
			
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ColdStorageData> getAllstorageId() {
		
		return storageRepo.getAllstorageId();
	}

	

}
