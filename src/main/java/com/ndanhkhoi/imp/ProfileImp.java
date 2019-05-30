package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Profile;

public interface ProfileImp {
	
	public List<Profile> findAll();
	public void add(Profile prodile);
	public Profile findById(long id);
	public void delete(Profile profile);	
	public void update(Profile profile);

}
