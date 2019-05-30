package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.ProfileDAO;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.imp.ProfileImp;

@Service
public class ProfileService implements ProfileImp{
	
	@Autowired 
	ProfileDAO profileDAO;

	public void add(Profile profile) {
		profileDAO.add(profile);
	}

	public Profile findById(long id) {
		return profileDAO.findById(id);
	}

	public List<Profile> findAll() {
		return profileDAO.findAll();
	}

	public void delete(Profile profile) {
		profileDAO.delete(profile);
		
	}

	public void update(Profile profile) {
		profileDAO.update(profile);
		
	}

}
