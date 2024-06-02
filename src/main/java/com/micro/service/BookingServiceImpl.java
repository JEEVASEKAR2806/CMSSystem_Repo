package com.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.Booking;
import com.micro.repo.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepo bookingRepo;
	
	public String insertBooking(Booking booking) {
		
		return bookingRepo.addBooking(booking);
	}

	public List<Booking> getAllTheBookings() {
		
		return bookingRepo.getAllTheBookings();
	}

	public String updateBookingById(Booking booking) {
		
		return bookingRepo.updateBookingById(booking);
	}

	public List<Booking> getBookingsByCusId(int customerId) {
		
		return bookingRepo.getBookingsByCusId(customerId);

	}

	public String dropBookingsByCusIds(int bookingId) {
		
		return bookingRepo.dropBookings(bookingId);
	}

	public String updateB(int bookingId) {
		
		return bookingRepo.up(bookingId);
	}
}
