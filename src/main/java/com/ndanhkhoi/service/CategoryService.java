package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.CategoryDAO;
import com.ndanhkhoi.entity.Category;
import com.ndanhkhoi.imp.CategoryImp;

@Service
public class CategoryService implements CategoryImp{
	
	@Autowired CategoryDAO categoryDAO;

	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	public Category findById(int id) {
		return categoryDAO.findById(id);
	}

}
