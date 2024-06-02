package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	public String validateLogin(String adminEmail, String adminPassword){
		try {
			
		adminRepo.validateLogin(adminEmail, adminPassword);
		return "Success";
		}catch(Exception e) {
				return "Validation Error";
			}
			
		}

}
