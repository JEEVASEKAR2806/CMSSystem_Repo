package com.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.Booking;
import com.micro.service.BookingService;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/addBooking")
	public String addRackInfo(@RequestBody Booking booking) {
	
		return bookingService.insertBooking(booking);
	}
	
	@GetMapping("/getAllTheBookings")
	public List<Booking> getAllTheBookings(){
		
		return bookingService.getAllTheBookings();
	}
	
	@PutMapping("/updateBooking")
	public String updateBooking(@RequestBody Booking booking){
		 
		return bookingService.updateBookingById(booking);
	}
	
	@GetMapping("/getBookingsByCusId/{customerId}")
	public List<Booking> getBookingsByCusId(@PathVariable int customerId){
		 
		return bookingService.getBookingsByCusId(customerId);
	}
	
	@DeleteMapping("/dropBookings/{bookingId}")
	public String dropBookingsByCus(@PathVariable int bookingId){
		 
		return bookingService.dropBookingsByCusIds(bookingId);

	}
	
	@PutMapping("/updateBooking/{bookingId}")
	public String updateB(@PathVariable int bookingId){
		 
		return bookingService.updateB(bookingId);
	}
	
	
}
