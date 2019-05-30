package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.ProductDAO;
import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.imp.ProductImp;

@Service
public class ProductService implements ProductImp{
	
	@Autowired
	ProductDAO productDao;

	public List<Product> findAll() {
		return productDao.findAll();
	}

	public void addOrUpdate(Product product) {
		productDao.addOrUpdate(product);
		
	}

	public void delete(Product product) {
		productDao.delete(product);
	}

	public Product findById(long id) {
		return productDao.findById(id);
	}

	public List<Product> findByName(String name) {
		return productDao.findByName(name);
	}

}
