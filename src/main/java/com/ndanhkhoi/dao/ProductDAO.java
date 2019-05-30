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

import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.imp.ProductImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDAO implements ProductImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> findAll() {
		return getCurrentSession().createQuery("from PRODUCT order by NAME").getResultList();
	}

	@Transactional
	public void addOrUpdate(Product product) {
		getCurrentSession().saveOrUpdate(product);
	}

	@Transactional
	public void delete(Product product) {
		getCurrentSession().delete(product);
	}

	@Transactional
	public Product findById(long id) {
		return getCurrentSession().get(Product.class, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<Product> findByName(String name) {
		List<Product> result = new ArrayList();
		List<Product> all = findAll();
		for (Product p:all){
			if (p.getName().toLowerCase().indexOf(name.toLowerCase()) != -1)
				result.add(p);
		}
		return result;
	}

}
