package com.ndanhkhoi.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ndanhkhoi.entity.OrderDetail;
import com.ndanhkhoi.imp.OrderDetailImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderDetailDAO implements OrderDetailImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void add(OrderDetail orderDetail) {
		getCurrentSession().save(orderDetail);
	}
	


}
