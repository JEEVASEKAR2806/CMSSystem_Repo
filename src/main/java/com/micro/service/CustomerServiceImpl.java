package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.model.Customer;
import com.micro.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;

	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {			

		try {	
			String customerEmail=customer.getCustomerEmail();
			
			BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
			String encryppwd=bCrypt.encode(customer.getCustomerPassword());
			customer.setCustomerPassword(encryppwd);	
			
			boolean validate = customerRepo.existsByuserEmail(customerEmail);
			System.out.println(validate);
			if (validate) {
				return ResponseEntity.badRequest().body("User Already Present");
			} 
			else {

				customerRepo.addCust(customer);
				return ResponseEntity.ok("Registration Successfull");
			}
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Provide Valid Email/Password");
			
		}	
		
	}


	
	public String validateLogin(String customerEmail, String customerPassword) {

		try {
		Customer existingCustomer=customerRepo.validateLogin(customerEmail, customerPassword);
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		boolean isPasswordMatch = bCrypt.matches(customerPassword, existingCustomer.getCustomerPassword());
		if(isPasswordMatch) {
			return "Success";
		}else {
			return "PassError";
		}
		}catch(Exception e) {
			return "Validation Error";
		}
		
	}

	public Customer findBycustomerEmail(String customerEmail) {
		return customerRepo.findBycustomerEmail(customerEmail);
		 
	}

	public List<Customer> getAllCustomerId() {
		
		return customerRepo.getAllCustomerId();
	}
}
