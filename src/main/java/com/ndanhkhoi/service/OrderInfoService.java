package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.OrderInfoDAO;
import com.ndanhkhoi.entity.OrderInfo;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.imp.OrderInfoImp;

@Service
public class OrderInfoService implements OrderInfoImp{

	@Autowired OrderInfoDAO orderInfoDAO;

	public void add(OrderInfo orderInfo) {
		orderInfoDAO.add(orderInfo);
	}

	public List<OrderInfo> findAll() {
		return orderInfoDAO.findAll();
	}

	public void delete(OrderInfo orderInfo) {
		orderInfoDAO.delete(orderInfo);
	}

	public List<OrderInfo> findUnpaidByCustomer(Profile profile) {
		return orderInfoDAO.findUnpaidByCustomer(profile);
	}

	public OrderInfo findByCustomerAndOrderId(Profile profile, long orderId) {
		return orderInfoDAO.findByCustomerAndOrderId(profile, orderId);
	}

	public List<OrderInfo> findUnpaid() {
		return orderInfoDAO.findUnpaid();
	}

	public OrderInfo findById(long orderId) {
		return orderInfoDAO.findById(orderId);
	}

	public List<OrderInfo> findByDate(String date) {
		return orderInfoDAO.findByDate(date);
	}

	public void update(OrderInfo orderInfo) {
		orderInfoDAO.update(orderInfo);
	}

	public List<OrderInfo> findPaidByCustomer(Profile profile) {
		return orderInfoDAO.findPaidByCustomer(profile);
	}
	
}
