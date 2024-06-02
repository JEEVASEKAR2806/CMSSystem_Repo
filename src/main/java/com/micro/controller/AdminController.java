package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.AdminService;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {

	@Autowired
	private AdminService adminService;

	
	@GetMapping("/validateAdminlogin/{adminEmail}/{adminPassword}") // Passing multiple arguments with url
	public String validateAdminLogin(@PathVariable("adminEmail") String adminEmail,@PathVariable("adminPassword") String adminPassword)
	{
//		System.out.println(adminEmail);
//		System.out.println(adminPassword);
		return adminService.validateLogin(adminEmail, adminPassword);
	}
}
