package com.ndanhkhoi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.entity.Category;
import com.ndanhkhoi.imp.CategoryImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryDAO implements CategoryImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> findAll() {
		return getCurrentSession().createQuery("from CATEGORY").getResultList();
	}
	
	@Transactional
	public Category findById(int id) {
		Category category = (Category) getCurrentSession().get(Category.class, id);
		return category;
	}


}
