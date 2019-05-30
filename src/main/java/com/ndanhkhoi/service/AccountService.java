package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.AccountDAO;
import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.imp.AccountImp;

@Service
public class AccountService implements AccountImp{

	@Autowired
	AccountDAO accountDAO;

	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	public Account findByUsername(String username) {
		return accountDAO.findByUsername(username);
	}

	public boolean existed(String username) {
		return accountDAO.existed(username);
	}

	public void add(Account account) {
		accountDAO.add(account);
	}

	public boolean authentication(String username, String password) {
		return accountDAO.authentication(username, password);
	}

	public List<Account>  getStaffAccount() {
		return accountDAO.getStaffAccount();
	}

	public List<Account> getCustomerAccount() {
		return accountDAO.getCustomerAccount();
	}

	public Account getCurrentAccount() {
		return accountDAO.getCurrentAccount();
	}

	public void update(Account account) {
		accountDAO.update(account);
		
	}

	public int countStaffAccountFromDayToDay(String start, String end) {
		return accountDAO.countStaffAccountFromDayToDay(start, end);
	}

	public int countCustomerAccountFromDayToDay(String start, String end) {
		return accountDAO.countCustomerAccountFromDayToDay(start, end);
	}

	
}
