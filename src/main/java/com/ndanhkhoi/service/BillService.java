package com.ndanhkhoi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndanhkhoi.dao.BillDAO;
import com.ndanhkhoi.entity.Bill;
import com.ndanhkhoi.imp.BillImp;

@Service
public class BillService implements BillImp{
	
	@Autowired
	BillDAO billDAO;

	public void add(Bill bill) {
		billDAO.add(bill);
	}

	public List<Bill> findAll() {
		return billDAO.findAll();
	}

	public Bill findById(long id) {
		return billDAO.findById(id);
	}

	public List<Object[]> findSaleByPhoneFromDayToDay(String start, String end) {
		return billDAO.findSaleByPhoneFromDayToDay(start, end);
	}

	public List<Bill> findFromDayToDay(String start, String end) {
		return billDAO.findFromDayToDay(start, end);
	}

}
