package com.ndanhkhoi.entity;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "ORDERINFO")
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMERID", nullable = false)
	private Profile profile;

	private String orderDay;
	private long totalPrice;
	private short paid;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderInfo")
	private List<OrderDetail> orderDetails;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "orderInfo")
	private Bill bill;

	public OrderInfo() {
	}

	public OrderInfo(Profile profile) {
		this.profile = profile;
	}

	public OrderInfo(Profile profile, long totalPrice) {
		this.profile = profile;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		this.orderDay = dtf.format(localDate).toString();
		this.totalPrice = totalPrice;
		this.paid = 0;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public String getTotalPriceString() {
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getCurrencyInstance(localeVN);
		return vn.format(totalPrice);
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public short getPaid() {
		return paid;
	}

	public void setPaid(short paid) {
		this.paid = paid;
	}

}
