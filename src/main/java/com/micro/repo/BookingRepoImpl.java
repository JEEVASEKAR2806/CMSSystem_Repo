package com.micro.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.model.Booking;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookingRepoImpl implements BookingRepo {

	@Autowired
	EntityManager manager;
	
	public String addBooking(Booking booking) {
		manager.persist(booking);
		return "Success";
	} 

	public List<Booking> getAllTheBookings() {
		Query<Booking> query=(Query<Booking>) manager.createQuery("from Booking");
		return (List<Booking>) query.getResultList();
	}

	public String updateBookingById(Booking bookingId) {
		try {
			manager.merge(bookingId);
		   return "Updated";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed To Update";
		}
		
	}
	

	
		public List<Booking> getBookingsByCusId(int customerId) {
			Query<Booking> qr = (Query<Booking>) manager
					.createQuery("from Booking as b where b.customer.customerId=:customerId");
			qr.setParameter("customerId", customerId);
			return qr.getResultList();
	 
		}



		public String dropBookings(int bookingId) {
			try {
				
				Query<Booking> query=(Query<Booking>) manager.createQuery("delete from Booking b where b.bookingId=:bookingId");
				query.setParameter("bookingId", bookingId);	
				query.executeUpdate();
				return "Please check the correct date and let us Wait For Upcoming Bookings";
			}catch(Exception e) {
				return "Failure";
			}
			
		}

		public String up(int bookingId) {
			String s="Approved";
			try {
				Query<Booking> query=(Query<Booking>) manager
						.createQuery("update Booking m set m.bookingStatus =:bookingStatus  where m.bookingId =:bookingId");
				query.setParameter("bookingId", bookingId);
				query.setParameter("bookingStatus", s);
				query.executeUpdate();
//				if(s1!=null) {
//					return "Success";
//				}else {
					return "Success";
//				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return "error";
			}
			
		}

		
		
		
}
