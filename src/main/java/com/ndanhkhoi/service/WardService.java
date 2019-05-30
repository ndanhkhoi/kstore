package com.ndanhkhoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.WardDAO;
import com.ndanhkhoi.entity.Ward;
import com.ndanhkhoi.imp.WardImp;

@Service
public class WardService implements WardImp{
	
	@Autowired
	WardDAO wardDAO;

	public Ward findById(int id) {
		return wardDAO.findById(id);
	}

}
