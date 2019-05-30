package com.ndanhkhoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.OrderDetailDAO;
import com.ndanhkhoi.entity.OrderDetail;
import com.ndanhkhoi.imp.OrderDetailImp;

@Service
public class OrderDetailService implements OrderDetailImp{
	
	@Autowired OrderDetailDAO orderDetailDAO;

	public void add(OrderDetail orderDetail) {
		orderDetailDAO.add(orderDetail);
	}

}
