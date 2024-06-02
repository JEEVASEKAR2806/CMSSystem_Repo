package com.micro.service;

import java.util.List;

import com.micro.model.Booking;



public interface BookingService {
	

	public String insertBooking(Booking booking);
	public List<Booking> getAllTheBookings() ;
	public String updateBookingById(Booking booking);

	public List<Booking> getBookingsByCusId(int customerId);
	public String dropBookingsByCusIds(int bookingId);
	public String updateB(int bookingId) ;

}
