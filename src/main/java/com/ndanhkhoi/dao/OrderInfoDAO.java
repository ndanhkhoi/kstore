package com.ndanhkhoi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ndanhkhoi.entity.OrderInfo;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.imp.OrderInfoImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderInfoDAO implements OrderInfoImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void add(OrderInfo orderInfo) {
		getCurrentSession().save(orderInfo);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<OrderInfo> findAll() {
		return getCurrentSession().createQuery("from ORDERINFO").getResultList();
	}

	@Transactional
	public void delete(OrderInfo orderInfo) {
		getCurrentSession().delete(orderInfo);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<OrderInfo> findUnpaidByCustomer(Profile profile) {
		return getCurrentSession().createQuery("from ORDERINFO where PAID = 0 AND CUSTOMERID = " + profile.getId() ).getResultList();
	}

	@Transactional
	public OrderInfo findByCustomerAndOrderId(Profile profile, long orderId) {
		return (OrderInfo) getCurrentSession().createQuery("from ORDERINFO where ID = " + orderId + " AND CUSTOMERID = " + profile.getId() ).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<OrderInfo> findUnpaid() {
		return getCurrentSession().createQuery("from ORDERINFO where PAID = 0").getResultList();
	}

	@Transactional
	public OrderInfo findById(long orderId) {
		return (OrderInfo) getCurrentSession().get(OrderInfo.class, orderId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<OrderInfo> findByDate(String date) {
		List<OrderInfo> all = findUnpaid();
		List<OrderInfo> temp = new ArrayList();
		for (OrderInfo o : all)
			if (o.getOrderDay().equalsIgnoreCase(date)) temp.add(o);
		return temp;
	}
	
	@Transactional
	public void update(OrderInfo orderInfo) {
		getCurrentSession().update(orderInfo);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<OrderInfo> findPaidByCustomer(Profile profile) {
		return getCurrentSession().createQuery("from ORDERINFO where PAID <> 0 AND CUSTOMERID = " + profile.getId() ).getResultList();
	}

}
