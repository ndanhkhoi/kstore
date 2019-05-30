package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.ProvinceDAO;
import com.ndanhkhoi.entity.District;
import com.ndanhkhoi.entity.Province;
import com.ndanhkhoi.imp.ProvinceImp;

@Service
public class ProvinceService implements ProvinceImp{
	
	@Autowired
	ProvinceDAO provinceDAO;

	public Province finrById(int id) {
		return provinceDAO.finrById(id);
	}

	public List<District> getDistricts(Province p) {
		return provinceDAO.getDistricts(p);
	}

	public List<Province> findAll() {
		return provinceDAO.findAll();
	}

}
