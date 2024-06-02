package com.micro.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class RackInfo {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rackId;
	private int rackCapacity;
	private int rackAvailability;
	private int rackPricePerDay;
	private String productName;


	@ManyToOne(targetEntity = ColdStorageData.class, cascade = CascadeType.DETACH) 
	@JoinColumn(name="storageId",nullable = false) 
	private ColdStorageData storageData;



	public RackInfo() {
		super();
	}



	public RackInfo(int rackId, int rackCapacity, int rackAvailability, int rackPricePerDay, String productName,
			ColdStorageData storageData) {
		super();
		this.rackId = rackId;
		this.rackCapacity = rackCapacity;
		this.rackAvailability = rackAvailability;
		this.rackPricePerDay = rackPricePerDay;
		this.productName = productName;
		this.storageData = storageData;
	}



	public int getRackId() {
		return rackId;
	}



	public void setRackId(int rackId) {
		this.rackId = rackId;
	}



	public int getRackCapacity() {
		return rackCapacity;
	}



	public void setRackCapacity(int rackCapacity) {
		this.rackCapacity = rackCapacity;
	}



	public int getRackAvailability() {
		return rackAvailability;
	}



	public void setRackAvailability(int rackAvailability) {
		this.rackAvailability = rackAvailability;
	}



	public int getRackPricePerDay() {
		return rackPricePerDay;
	}



	public void setRackPricePerDay(int rackPricePerDay) {
		this.rackPricePerDay = rackPricePerDay;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public ColdStorageData getStorageData() {
		return storageData;
	}



	public void setStorageData(ColdStorageData storageData) {
		this.storageData = storageData;
	}


     
	

	
   
	
	
}
