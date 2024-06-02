package com.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.RackInfo;
import com.micro.service.RackService;


@RestController
@CrossOrigin("http://localhost:3000")
public class RackController {

	@Autowired
	private RackService rackService;
	
	
	@PostMapping("/addRackInfo")
	public String addRackInfo(@RequestBody RackInfo rackInfo) {
		
		 return rackService.insertRack(rackInfo);
	}
	
	@GetMapping("/getAllRackId")
	public List<RackInfo> getRackId() {
		
		  return rackService.getRackId();
	}
	
	@GetMapping("/getAllRacks")
	public List<RackInfo> getRacks() {
		
		  return rackService.getRacks();
	}
	
	@GetMapping("/getRackByRackId/{rackId}")
	public RackInfo getRackByRackId(@PathVariable int rackId ) {
		
		RackInfo rack= rackService.getRackByRackId(rackId);
		
		
		return rack;
	}
	
	
	@GetMapping("/getAllRacksBystorageId/{storageId}")
	public List<Integer> getAllRacksBystorageId(@PathVariable int storageId ) {
		return rackService.getAllRacksBystorageId(storageId);
	}
	
	
	
	@GetMapping("/getRackByColdStoreId/{storageId}")
	public List<RackInfo> getRackByColdStoreId(@PathVariable int storageId ) {
		return rackService.getRackByColdStoreId(storageId);
	}
	
	@PutMapping("/updateRackAvailability/{rackId}/{availability}")
	public String updateRackAvailability(@PathVariable int rackId,@PathVariable int availability) {
		
		return rackService.updateRackAvailability(rackId,availability);
	}
	
	@PutMapping("/updateRackAfterRemoving/{rackId}/{rackAvailability}/{rackCapacity}")
	public String updateRackAfterRemoving(@PathVariable int rackId,@PathVariable int rackAvailability,@PathVariable int rackCapacity ) {
		
		return rackService.updateRackAfterRemoving(rackId,rackAvailability,rackCapacity);
	}
		
	@DeleteMapping("/removeRack/{rackId}")
	public String removeRack(@PathVariable int rackId) {
		try {
		String s= rackService.removeRack(rackId);
		 return s;
		}
		catch(Exception e) {
			return "Customer Have a Product";
		}
	}
	
	@GetMapping("/getRackQuamtity/{rackId}")
	public String getRackQuamtity(@PathVariable int rackId) {
		
		return rackService.getRackQuamtity(rackId);
	}
	
	
	
}