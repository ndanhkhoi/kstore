package com.ndanhkhoi.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.imp.AccountImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountDAO implements AccountImp{

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public boolean existed(String username) {
		return (findByUsername(username) != null);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Account> findAll() {
		return getCurrentSession().createQuery("from ACCOUNT").getResultList();
	}

	@Transactional
	public Account findByUsername(String username) {
		Account accuont = (Account) getCurrentSession().get(Account.class, username);
		return accuont;
	}
	
	@Transactional
	public void add(Account account) {
		getCurrentSession().save(account);
	}
	
	@Transactional
	public boolean authentication(String username, String password) {
		try{
			Account account = findByUsername(username);
			return BCrypt.checkpw(password, account.getPassword());
		}
		catch (NullPointerException ex)		//Không tìm thấy tài khoản
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Account> getStaffAccount() {
		List<Account> list = getCurrentSession().createQuery("from ACCOUNT where ROLEID = 2").getResultList();
		Collections.sort(list, new Comparator<Account>() {
			public int compare(Account o1, Account o2) {
				return (int) ( o1.getProfile().getId() - o2.getProfile().getId() );
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Account> getCustomerAccount() {
		List<Account> list = getCurrentSession().createQuery("from ACCOUNT where ROLEID = 3").getResultList();
		Collections.sort(list, new Comparator<Account>() {
			public int compare(Account o1, Account o2) {
				return (int) ( o1.getProfile().getId() - o2.getProfile().getId() );
			}
		});
		return list;
	}
	
	@Transactional
	public Account getCurrentAccount(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Account account = findByUsername(username);
		return account;
	}

	@Transactional
	public void update(Account account) {
		getCurrentSession().update(account);
	}

	@Transactional
	public int countStaffAccountFromDayToDay(String start, String end) {
		List<Account> list = getStaffAccount();
		int count = 0;
		for (Account account : list)
		{
			String date = account.getProfile().getJoindate();
			if (date.compareTo(start) >= 0 && date.compareTo(end) <=0) count++;
		}
		return count;
	}

	@Transactional
	public int countCustomerAccountFromDayToDay(String start, String end) {
		List<Account> list = getCustomerAccount();
		int count = 0;
		for (Account account : list)
		{
			String date = account.getProfile().getJoindate();
			if (date.compareTo(start) >= 0 && date.compareTo(end) <=0) count++;
		}
		return count;
	}

}
