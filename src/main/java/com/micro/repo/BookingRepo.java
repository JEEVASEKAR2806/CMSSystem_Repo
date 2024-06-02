package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.Booking;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


public interface BookingRepo {

	
	public String addBooking(Booking booking);

	public List<Booking> getAllTheBookings();

	public String updateBookingById(Booking bookingId);

	
		public List<Booking> getBookingsByCusId(int customerId);


		public String dropBookings(int bookingId);
		public String up(int bookingId);
		
		
		
		
		
		
		
}
