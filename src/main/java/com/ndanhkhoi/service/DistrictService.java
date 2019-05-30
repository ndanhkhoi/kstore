package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.DistrictDAO;
import com.ndanhkhoi.entity.District;
import com.ndanhkhoi.entity.Ward;
import com.ndanhkhoi.imp.DistrictImp;

@Service
public class DistrictService implements DistrictImp{
	
	@Autowired
	DistrictDAO districtDao;

	public District finrById(int id) {
		return districtDao.finrById(id);
	}

	public List<District> findAll() {
		return districtDao.findAll();
	}

	public List<Ward> getWards(District d) {
		return districtDao.getWards(d);
	}

}
