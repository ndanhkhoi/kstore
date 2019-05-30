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

import com.ndanhkhoi.entity.Import;
import com.ndanhkhoi.imp.ImportImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ImportDAO implements ImportImp{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void add(Import imPort) {
		getCurrentSession().save(imPort);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Import> findAll() {
		return getCurrentSession().createQuery("from IMPORT").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object[]> findImportByPhoneFromDayToDay(String start, String end) {
		String sql = "SELECT PRODUCT.NAME, SUM(IMPORT.NUMBER) TOTALNUMBER FROM IMPORT JOIN PRODUCT ON IMPORT.PRODUCTID = PRODUCT.ID WHERE IMPORTDATE>= :start AND IMPORTDATE<= :end GROUP BY PRODUCT.NAME  order by TOTALNUMBER desc;";
		Query query =  getCurrentSession().createNativeQuery(sql);
		query.setParameter("start", start);
		query.setParameter("end", end);
		return query.getResultList();
	}

}
