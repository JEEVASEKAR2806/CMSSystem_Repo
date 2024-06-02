package com.micro.cold;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.model.RackInfo;
import com.micro.service.RackService;

@SpringBootTest
public class Rack_Test {

	@Autowired
	RackService rackService;
	
	
	@Test
	void test_GetRackId() {
		List<RackInfo> racks=rackService.getRackId();
		assertNotNull(racks);
	}
	
	
	@Test
	void test_GetRackByRackId() {
		RackInfo racks=rackService.getRackByRackId(2);
		assertNotNull(racks);
	}
	
	
	
	@Test
	void test_GetAllRacksBystorageId() {
		List<Integer> racks=rackService.getAllRacksBystorageId(2);
		assertNotNull(racks);
	}
	
	
	
	@Test
	void test_GetRacks() {
		List<RackInfo> racks=rackService.getRacks();
		assertNotNull(racks);
	}
	
	
	
	@Test
	void test_GetRackByColdStoreId() {
		List<RackInfo> racks=rackService.getRackByColdStoreId(2);
		assertNotNull(racks);
	}
}










