package com.ndanhkhoi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "BILL")
public class Bill{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERID", nullable = false)
	private OrderInfo orderInfo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COLLECTORID", nullable = false)
	private Profile profile;

	private String paymentDay;

	public Bill() {
	}

	public Bill(OrderInfo orderInfo, Profile profile) {
		this.orderInfo = orderInfo;
		this.profile = profile;
	}

	public Bill(OrderInfo orderInfo, Profile profile, String paymentDay) {
		this.orderInfo = orderInfo;
		this.profile = profile;
		this.paymentDay = paymentDay;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getpaymentDay() {
		return this.paymentDay;
	}

	public void setpaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}

}
