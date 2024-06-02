package com.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.Customer;
import com.micro.model.RackInfo;
import com.micro.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;




	@PostMapping("/registerCustomer")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer ){

		System.out.println(customer);
		try {
			return customerService.registerCustomer(customer);

		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("ERROR");
		}
		
		//return ResponseEntity.badRequest().body("ERROR");
	}
	 
	

	@GetMapping("/findBycustomerEmail/{customerEmail}")
	public Customer findBycustomerEmail(@PathVariable("customerEmail") String customerEmail) {
		
		System.out.println(customerEmail);
		return customerService.findBycustomerEmail(customerEmail);
		
	}
	
	
	
	@GetMapping("/validatelogin/{customerEmail}/{customerPassword}") // Passing multiple arguments with url
	public String validateLogin(@PathVariable("customerEmail") String customerEmail,@PathVariable("customerPassword") String customerPassword)
	{

		return customerService.validateLogin(customerEmail, customerPassword);
	}
	
	@GetMapping("/getAllCustomerId")
	public List<Customer> getAllCustomerId() {
		
		  return customerService.getAllCustomerId();
	} 
	
	


}
