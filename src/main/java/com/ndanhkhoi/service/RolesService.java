package com.ndanhkhoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.RolesDAO;
import com.ndanhkhoi.entity.Roles;
import com.ndanhkhoi.imp.RolesImp;

@Service
public class RolesService implements RolesImp{
	
	@Autowired
	RolesDAO rolesDAO;

	public Roles findById(int id) {
		return rolesDAO.findById(id);
	}
	

}
