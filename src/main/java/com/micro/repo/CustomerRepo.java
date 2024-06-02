package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.Customer;
import com.micro.model.RackInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import jakarta.websocket.Session;


public interface CustomerRepo {

	
	public String addCust(Customer customer); 
	
	public boolean existsByuserEmail(String customerEmail); 
	
	
	
	public Customer validateLogin(String customerEmail, String customerPassword); 

	public Customer findBycustomerEmail(String customerEmail);


	public List<Customer> getAllCustomerId();
	
		public List<RackInfo> getRacks();
}
