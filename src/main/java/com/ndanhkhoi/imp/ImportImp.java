package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Import;

public interface ImportImp {
	
	public void add(Import imPort);
	public List<Import> findAll();
	public List<Object[]> findImportByPhoneFromDayToDay(String start, String end);
}
