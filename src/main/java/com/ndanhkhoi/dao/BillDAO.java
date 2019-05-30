package com.ndanhkhoi.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ndanhkhoi.entity.Bill;
import com.ndanhkhoi.imp.BillImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BillDAO implements BillImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void add(Bill bill) {
		getCurrentSession().save(bill);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Bill> findAll() {
		return getCurrentSession().createQuery("from BILL").getResultList();
	}

	@Transactional
	public Bill findById(long id) {
		return getCurrentSession().get(Bill.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object[]> findSaleByPhoneFromDayToDay(String start, String end) {
		String sql = "SELECT PRODUCT.NAME, SUM(ORDERDETAIL.NUMBER) TOTALNUMBER FROM BILL JOIN ORDERINFO ON BILL.ORDERID = ORDERINFO.ID JOIN ORDERDETAIL ON ORDERDETAIL.ORDERID = ORDERINFO.ID JOIN PRODUCT ON PRODUCT.ID = ORDERDETAIL.PRODUCTID WHERE PAYMENTDAY>=:start AND PAYMENTDAY<= :end GROUP BY PRODUCT.NAME order by TOTALNUMBER desc;";
		Query query =  getCurrentSession().createNativeQuery(sql);
		query.setParameter("start", start);
		query.setParameter("end", end);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Bill> findFromDayToDay(String start, String end) {
		return getCurrentSession().createQuery("from BILL where PAYMENTDAY>='" + start + "' and PAYMENTDAY <='" + end + "'").getResultList();
	}

}
