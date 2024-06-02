package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.Admin;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepoImpl implements AdminRepo{

	
	@Autowired
	EntityManager manager;

	@Override
	public String validateLogin(String adminEmail, String adminPassword) {
		
		try {
			System.out.println(adminEmail);
			System.out.println(adminPassword);
			Query<Admin> query = (Query<Admin>) manager.createQuery("FROM Admin a WHERE a.adminEmail = :email AND a.adminPassword = :password");
			query.setParameter("email", adminEmail);
			query.setParameter("password", adminPassword);

			@SuppressWarnings("unchecked")
			List<Admin> adminList = query.getResultList();

			if (!adminList.isEmpty()) {
			   return "Success";
			} else { 
			    return " Email and password do not exist in the database";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


}
