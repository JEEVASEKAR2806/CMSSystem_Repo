package com.micro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table
public class ColdStorageData {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storageId;
	
	private String storageName;
	
	private String storageLocation;
	
	private String storageAddress;
	
	
	
	 
	public ColdStorageData() {
		super();
		
	}

	public ColdStorageData(int storageId, String storageName, String storageLocation, String storageAddress) {
		super();
		this.storageId = storageId;
		this.storageName = storageName;
		this.storageLocation = storageLocation;
		this.storageAddress = storageAddress;
	}

	public int getStorageId() {
		return storageId;
	}

	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public String getStorageAddress() {
		return storageAddress;
	}

	public void setStorageAddress(String storageAddress) {
		this.storageAddress = storageAddress;
	}

	
	
}
