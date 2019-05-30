package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.District;
import com.ndanhkhoi.entity.Province;

public interface ProvinceImp {
	
	public Province finrById(int id);
	public List<Province> findAll();
	public List<District> getDistricts(Province p);

}
