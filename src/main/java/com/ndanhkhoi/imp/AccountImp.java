package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Account;

public interface AccountImp {
	
	public List<Account> findAll();
	public Account findByUsername(String username);
	public boolean existed(String username);
	public void add(Account account);
	public boolean authentication(String username, String password);
	public List<Account> getStaffAccount();
	public List<Account> getCustomerAccount();
	public Account getCurrentAccount();
	public void update(Account account);
	public int countStaffAccountFromDayToDay(String start, String end);
	public int countCustomerAccountFromDayToDay(String start, String end);

}
