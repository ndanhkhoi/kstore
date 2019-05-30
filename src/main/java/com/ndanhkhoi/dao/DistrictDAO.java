package com.ndanhkhoi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.entity.District;
import com.ndanhkhoi.entity.Ward;
import com.ndanhkhoi.imp.DistrictImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DistrictDAO implements DistrictImp{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public District finrById(int id) {
		District district = getCurrentSession().get(District.class, id);
		return district;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<District> findAll() {
		String sql = "from DISTRICT ORDER BY name";
		return getCurrentSession().createQuery(sql).getResultList();
		}

	public List<Ward> getWards(District d) {
		return d.getWards();
	}

}
