package com.ndanhkhoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.entity.Roles;
import com.ndanhkhoi.imp.RolesImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RolesDAO implements RolesImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Roles findById(int id) {
		Roles roles = (Roles) getCurrentSession().get(Roles.class, id);
		return roles;
	}
	


}
