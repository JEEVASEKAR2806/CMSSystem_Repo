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
public class Booking {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private String fromDate;
	
	private String toDate;
	
	private int totalPrice;
	
	private String bookingStatus;
	
	private int rackCounts;
	
	private String product;
	
	

	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.DETACH) 
	@JoinColumn(name="customerId",nullable = false) 
	private Customer customer;
	
	@ManyToOne(targetEntity = ColdStorageData.class, cascade = CascadeType.DETACH) 
	@JoinColumn(name="storageId",nullable = false) 
	private ColdStorageData storageData;
	
	@ManyToOne(targetEntity = RackInfo.class, cascade = CascadeType.DETACH) 
	@JoinColumn(name="rackId",nullable = false) 
	private RackInfo rackInfo;

	@ManyToOne(targetEntity = Admin.class, cascade = CascadeType.DETACH) 
	@JoinColumn(name="adminId",nullable = false) 
	private Admin admin;

	
	
	public Booking() {
		super();
		
	}



	public Booking(int bookingId, String fromDate, String toDate, int totalPrice, String bookingStatus, int rackCounts,
			String product, Customer customer, ColdStorageData storageData, RackInfo rackInfo, Admin admin) {
		super();
		this.bookingId = bookingId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalPrice = totalPrice;
		this.bookingStatus = bookingStatus;
		this.rackCounts = rackCounts;
		this.product = product;
		this.customer = customer;
		this.storageData = storageData;
		this.rackInfo = rackInfo;
		this.admin = admin;
	}



	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public String getFromDate() {
		return fromDate;
	}



	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}



	public String getToDate() {
		return toDate;
	}



	public void setToDate(String toDate) {
		this.toDate = toDate;
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}



	public String getBookingStatus() {
		return bookingStatus;
	}



	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}



	public int getRackCounts() {
		return rackCounts;
	}



	public void setRackCounts(int rackCounts) {
		this.rackCounts = rackCounts;
	}



	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public ColdStorageData getStorageData() {
		return storageData;
	}



	public void setStorageData(ColdStorageData storageData) {
		this.storageData = storageData;
	}



	public RackInfo getRackInfo() {
		return rackInfo;
	}



	public void setRackInfo(RackInfo rackInfo) {
		this.rackInfo = rackInfo;
	}



	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	


	

	

	
}
