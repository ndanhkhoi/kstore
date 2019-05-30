package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.OrderInfo;
import com.ndanhkhoi.entity.Profile;

public interface OrderInfoImp {
	
	public void add(OrderInfo orderInfo);
	public void update(OrderInfo orderInfo);
	public List<OrderInfo>  findAll();
	public List<OrderInfo>  findUnpaid();
	public void delete(OrderInfo orderInfo);
	public List<OrderInfo>  findUnpaidByCustomer(Profile profile);
	public List<OrderInfo>  findPaidByCustomer(Profile profile);
	public OrderInfo findByCustomerAndOrderId(Profile profile, long orderId);
	public OrderInfo findById(long orderId);
	public List<OrderInfo>  findByDate(String date);
}
