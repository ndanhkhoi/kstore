package com.ndanhkhoi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.imp.ProfileImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProfileDAO implements ProfileImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void add(Profile profile) {
		getCurrentSession().save(profile);
	}

	@Transactional
	public Profile findById(long id) {
		Profile profile = (Profile) getCurrentSession().get(Profile.class, id);
		return profile;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Profile> findAll() {
		return getCurrentSession().createQuery("from PROFILE").getResultList();
	}

	@Transactional
	public void delete(Profile profile) {
		getCurrentSession().delete(profile);
	}

	@Transactional
	public void update(Profile profile) {
		getCurrentSession().update(profile);
	}

}
