package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import com.micro.model.Customer;
import com.micro.model.RackInfo;
import com.micro.repo.CustomerRepo;


public interface CustomerService {
	
	
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer); 

	public String validateLogin(String customerEmail, String customerPassword);

	public Customer findBycustomerEmail(String customerEmail);
	public List<Customer> getAllCustomerId();
}
