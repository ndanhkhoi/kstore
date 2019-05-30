package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Category;

public interface CategoryImp {
	
	public List<Category> findAll();
	public Category findById(int id);

}
