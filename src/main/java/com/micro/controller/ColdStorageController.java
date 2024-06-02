package com.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.ColdStorageData;
import com.micro.model.RackInfo;
import com.micro.service.ColdStorageService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ColdStorageController {

	
	@Autowired
	private ColdStorageService storageService;
	
	
	@PostMapping("/addColdStorageData")
	public String insertColdStorageData(@RequestBody ColdStorageData storageData ){

		try {
			return storageService.insertColdStorageData(storageData);

		}catch(Exception e) {
			
			return "Id Already Exist";
		}
	}
	
	@PutMapping("/updateColdStorageData")
	public String updateColdStorageData(@RequestBody ColdStorageData storageData ){

		try {
			return storageService.updateColdStorageData(storageData);

		}catch(Exception e) {
			e.printStackTrace();
			return "Id Already Exist";
		}
	}
	
	
	@DeleteMapping("/removeColdStorageData/{storageId}")
	public String removeColdStorageDataById(@PathVariable int storageId ){

		try {
			String s= storageService.removeColdStorageDataById(storageId);
			 System.out.println(s);
			 return s;
			 }catch(Exception e) {
			
			return "Storage Have a Rack";
		}
	}
	
	
	@GetMapping("/viewAllStorages")
	public List<ColdStorageData> viewAllStorages(){

		try {
			return storageService.viewAllStorages();

		}catch(Exception e) {
			e.printStackTrace();
			return null ;
		}
	}
	
	
	@GetMapping("/getStorageById/{storageId}")
	public ColdStorageData getStorageById(@PathVariable int storageId ){

		try {
			return storageService.getStorageById(storageId);

		}catch(Exception e) {
			e.printStackTrace();
			return null ;
		}
	}
	
	@GetMapping("/getAllstorageId")
	public List<ColdStorageData> getAllstorageId() {
		
		  return storageService.getAllstorageId();
	}
	
	
	
	
	
}
