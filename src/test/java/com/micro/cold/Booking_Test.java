package com.micro.cold;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.micro.model.Booking;
import com.micro.service.BookingService;

@SpringBootTest
public class Booking_Test {

	
	@Autowired
	private BookingService bookingService;
	
	
	@Test
	void test_GetAllTheBookings() {
	List<Booking> message=bookingService.getAllTheBookings();
	assertNotNull(message);
	}
	
	@Test
	void test_GetBookingsByCusId() {
	List<Booking> list= bookingService.getBookingsByCusId(1);
	assertNotNull(list);
	}
	
}
