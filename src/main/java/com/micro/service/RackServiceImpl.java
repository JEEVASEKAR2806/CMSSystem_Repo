package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.ColdStorageData;
import com.micro.model.RackInfo;
import com.micro.repo.RackRepo;

@Service
public class RackServiceImpl  implements RackService{

	@Autowired
	private RackRepo rackRepo;

	public String insertRack(RackInfo rackInfo) {
		
		ColdStorageData o=rackInfo.getStorageData();
		System.out.println(o.getStorageId());
		
		 return rackRepo.persist(rackInfo);
	}

	public List<RackInfo> getRackId() {
		
		return rackRepo.getAllRackId();
		
	}

	public List<RackInfo> getRacks() {
	
		return rackRepo.getRacks();
	}

	public RackInfo getRackByRackId(int rackId) {
		
		return rackRepo.getRackByRId(rackId);
	}

	public List<Integer> getAllRacksBystorageId(int storageId) {
		
		return rackRepo.getAllRacksBystorageId(storageId);
	}

	public List<RackInfo> getRackByColdStoreId(int storageId) {
		
		return rackRepo.getRackByColdStoreId(storageId);
	}

	public String updateRackAvailability(int rackId, int availability) {
		
		return rackRepo.updateRackAvailability(rackId,availability);
	}

	@Override
	public String removeRack(int rackId) {
		try {
		 rackRepo.removeRack(rackId);
		return "Removed";
		}catch(Exception e) {
			return "Customer Have a Product";
		}
	}

	@Override
	public String getRackQuamtity(int rackId) {
		
		return rackRepo.getRackQuantity(rackId);
	}

	@Override
	public String updateRackAfterRemoving(int rackId, int rackAvailability, int rackCapacity) {
		
		return rackRepo.updateRackAfterRemoving(rackId,rackAvailability,rackCapacity);
	}

}
