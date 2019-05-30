package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.entity.Log;

public interface LogImp {
	
	public void add(Log log);
	public List<Log> findAll();
	public List<Log> findByAccount(Account account);
	public List<Log> findFromDayToDay(String start, String end);

}
