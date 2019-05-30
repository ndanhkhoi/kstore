package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.ImportDAO;
import com.ndanhkhoi.entity.Import;
import com.ndanhkhoi.imp.ImportImp;

@Service
public class ImportService implements ImportImp{
	
	@Autowired 
	ImportDAO importDAO;

	public void add(Import imPort) {
		importDAO.add(imPort);
	}

	public List<Import> findAll() {
		return importDAO.findAll();
	}

	public List<Object[]> findImportByPhoneFromDayToDay(String start, String end) {
		return importDAO.findImportByPhoneFromDayToDay(start, end);
	}

}
