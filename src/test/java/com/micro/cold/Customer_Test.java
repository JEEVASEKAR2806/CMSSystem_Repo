package com.micro.cold;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.model.Customer;
import com.micro.service.CustomerService;

@SpringBootTest
public class Customer_Test {

	@Autowired
	CustomerService customerService; 
	
	@Test
	void test_registerCustomer() {
		String msg=customerService.validateLogin("jeevangp@gmail.com","12345");
		assertEquals("Success",msg);
	}
	
	@Test
	void test_findBycustomerEmail() {
		Customer customer=customerService.findBycustomerEmail("jeevangp@gmail.com");
		assertNotNull(customer);
	}
	
	@Test
	void test_getAllCustomerId() {
		List<Customer> customer=customerService.getAllCustomerId();
		assertNotNull(customer);
	}
	
	
	
	
}
