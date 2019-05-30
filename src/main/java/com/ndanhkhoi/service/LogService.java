package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.LogDAO;
import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.imp.LogImp;

@Service
public class LogService implements LogImp{
	
	@Autowired
	LogDAO logDAO;

	public void add(Log log) {
		logDAO.add(log);
		
	}

	public List<Log> findAll() {
		return logDAO.findAll();
	}

	public List<Log> findByAccount(Account account) {
		return logDAO.findByAccount(account);
	}

	public List<Log> findFromDayToDay(String start, String end) {
		return logDAO.findFromDayToDay(start, end);
	}

}
