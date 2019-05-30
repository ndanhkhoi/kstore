package com.ndanhkhoi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.imp.LogImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LogDAO implements LogImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void add(Log log) {
		getCurrentSession().save(log);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Log> findAll() {
		return getCurrentSession().createQuery("from LOG order by TIME desc").getResultList();
	}
	
	@Transactional
	public List<Log> findByAccount(Account account) {
		return account.getLogs();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Log> findFromDayToDay(String start, String end) {
		String sql = "from LOG where time >= '" + start + "' AND time <= '" + end + "' order by TIME desc";
		return getCurrentSession().createQuery(sql).getResultList();
	}

}
