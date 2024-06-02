package com.micro.cold;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.service.AdminService;

@SpringBootTest
public class Admin_Test {

	@Autowired
	AdminService adminService; 
	
	
	@Test
	void test_validateAdminLogin() {
		String msg=adminService.validateLogin("admin@gmail.com","12345");
		assertNotNull("Success",msg);
	}
}
