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
import com.ndanhkhoi.entity.Province;
import com.ndanhkhoi.imp.ProvinceImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProvinceDAO implements ProvinceImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Province finrById(int id) {
		Province province = (Province) getCurrentSession().get(Province.class, id);
		return province;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Province> findAll() {
		String sql = "from PROVINCE ORDER BY name";
		return getCurrentSession().createQuery(sql).getResultList();
	}

	public List<District> getDistricts(Province p) {
		return p.getDistricts();
	}


}
