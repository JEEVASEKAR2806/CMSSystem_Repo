package com.micro.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {

	@Id
	private int adminId;
	
	private String adminName;	
	
	private String userName;
	
	private String adminPassword;
	
	private String adminEmail;

		
	
	public Admin() { 
		super();
		
	}

	public Admin(int adminId, String adminName, String userName, String adminPassword, String adminEmail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.userName = userName;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEamil() {
		return adminEmail;
	}

	public void setAdminEamil(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	
	
	
	
}
