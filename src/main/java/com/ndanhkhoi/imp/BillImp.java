package com.ndanhkhoi.imp;

import java.util.List;

import com.ndanhkhoi.entity.Bill;

public interface BillImp {
	
	public void add(Bill bill);
	public List<Bill> findAll();
	public Bill findById(long id);
	public List<Object[]> findSaleByPhoneFromDayToDay(String start, String end);
	public List<Bill> findFromDayToDay(String start, String end);
	
}
