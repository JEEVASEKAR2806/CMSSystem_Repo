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

@Repository
@Transactional
public class CustomerImpl implements CustomerRepo {

	@Autowired
	EntityManager manager;
	
	
	public String addCust(Customer customer) {
		try {	
			System.out.println(customer);
	    manager.persist(customer);	    
	    return "Storage Details Removed";
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return "Failed to Insert";	
		}
		} 

	
	public boolean existsByuserEmail(String customerEmail) {
		 Query query = (Query) manager.createQuery("SELECT COUNT(c) FROM Customer c WHERE c.customerEmail = :customerEmail");
	     query.setParameter("customerEmail", customerEmail);
	     long count = (long) query.getSingleResult();
	     return count > 0;
	}
	
	
	
	public Customer validateLogin(String customerEmail, String customerPassword) {
		
		try {
			System.out.println(customerEmail);
			System.out.println(customerPassword);
		Query<Customer> qry2=(Query<Customer>) manager.createQuery("from Customer mail where mail.customerEmail =:customerEmail");
		qry2.setParameter("customerEmail",customerEmail);
			
		return (Customer) qry2.getSingleResult();

//		if(customers.isEmpty()) {
//			return "LoginFailed";
//		}else {
//			return "Login Success";
//		}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public Customer findBycustomerEmail(String customerEmail) {
//	    Session session = sessionFactory.getCurrentSession();
	    Query<Customer> query = (Query<Customer>) manager.createQuery("FROM Customer WHERE customerEmail = :customerEmail", Customer.class);
	    query.setParameter("customerEmail", customerEmail);
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}


	public List<Customer> getAllCustomerId() {
		Query<Customer> query=(Query<Customer>) manager.createQuery("select customerId from Customer");
		return  query.getResultList();	
		}

		@SuppressWarnings("unchecked")
		public List<RackInfo> getRacks() {
			
			@SuppressWarnings("rawtypes")
			Query query=(Query<RackInfo>) manager.createQuery("from RackInfo");
			return  query.getResultList();
			
	
		
	}
}
