package com.micro.cold;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.model.ColdStorageData;
import com.micro.service.ColdStorageService;

@SpringBootTest
public class Storage_Test {
	
	@Autowired
	ColdStorageService storageService;
	
	@Test
	void test_ViewAllStorages() {
	List<ColdStorageData> storageList=storageService.viewAllStorages();
	assertNotNull(storageList);
	}
	
	
	@Test
	void test_GetAllstorageId() {
	List<ColdStorageData> storage=storageService.getAllstorageId();
	assertNotNull(storage);
	}
	
	
	@Test
	void test_getStorageById() {
	ColdStorageData storage=storageService.getStorageById(2);
	assertNotNull(storage);
	}
	
	@Test
	void test_removeColdStorageDataById() {
	String storage=storageService.removeColdStorageDataById(2);
	assertEquals("Storage Have a Rack", storage);
	}
	
	
	
	
	

}
