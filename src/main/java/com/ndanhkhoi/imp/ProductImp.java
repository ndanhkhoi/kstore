package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Product;

public interface ProductImp {
	
	public List<Product> findAll();
	public void addOrUpdate(Product product);
	public void delete(Product product);
	public Product findById(long id);
	public List<Product> findByName(String name);

}
