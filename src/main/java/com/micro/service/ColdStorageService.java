package com.micro.service;

import java.util.List;

import com.micro.model.ColdStorageData;



public interface ColdStorageService {

	public String insertColdStorageData(ColdStorageData storageData);

	public String updateColdStorageData(ColdStorageData storageData);

	public String removeColdStorageDataById(int storageId);

	public List<ColdStorageData> viewAllStorages();

	public ColdStorageData getStorageById( int storageId );

	public List<ColdStorageData> getAllstorageId() ;
	

}
