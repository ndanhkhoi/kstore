package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.District;
import com.ndanhkhoi.entity.Ward;

public interface DistrictImp {
	
	public District finrById(int id);
	public List<District> findAll();
	public List<Ward> getWards(District d);

}
