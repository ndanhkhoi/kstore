package com.ndanhkhoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.entity.Ward;
import com.ndanhkhoi.imp.WardImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WardDAO implements WardImp{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Ward findById(int id) {
		Ward ward = (Ward) getCurrentSession().get(Ward.class, id);
		return ward;
	}
	
	
	
}
