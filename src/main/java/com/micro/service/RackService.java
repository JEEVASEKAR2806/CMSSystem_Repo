package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.ColdStorageData;
import com.micro.model.RackInfo;
import com.micro.repo.RackRepo;


public interface RackService {
	
	public String insertRack(RackInfo rackInfo);
	
	public List<RackInfo> getRackId();
	
	public List<RackInfo> getRacks();
	
	public RackInfo getRackByRackId(int rackId);

	public List<Integer> getAllRacksBystorageId(int storageId);
	
	public List<RackInfo> getRackByColdStoreId(int storageId) ;

	public String updateRackAvailability(int rackId, int availability);
	public String removeRack(int rackId);
	public String getRackQuamtity(int rackId);
	public String updateRackAfterRemoving(int rackId, int rackAvailability, int rackCapacity);
	
}
