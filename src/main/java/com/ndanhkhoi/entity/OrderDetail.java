package com.ndanhkhoi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ORDERDETAIL")
public class OrderDetail {

	@Id
	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERID", nullable = false)
	private OrderInfo orderInfo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTID", nullable = false)
	private Product product;
	
	private int number;

	public OrderDetail() {
	}

	public OrderDetail(String code, OrderInfo orderInfo, Product product, int number) {
		this.code = code;
		this.orderInfo = orderInfo;
		this.product = product;
		this.number = number;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
