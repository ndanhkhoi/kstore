package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.BillService;
import com.ndanhkhoi.service.ImportService;

@Controller
@RequestMapping("/admin-view-report")
public class AdminViewReportController {
	
	@Autowired
	ImportService importService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public String Default(){
		return "admin-view-report";
	}

	private static String maxDate(String date1, String date2){
		return date1.compareTo(date2) > 0 ? date1 : date2;
	}
	
	private static String minDate(String date1, String date2){
		return date1.compareTo(date2) < 0 ? date1 : date2;
	}
	
	@PostMapping
	public String viewReportByDay(@RequestParam("start-day") String startDay,
			@RequestParam("end-day") String endDay,
			ModelMap modelMap
			){
		String start = minDate(startDay, endDay);
		String end = maxDate(startDay, endDay);
		modelMap.addAttribute("fromDayToDay", "Từ ngày " + start + " đến ngày " + end);
		modelMap.addAttribute("imports", importService.findImportByPhoneFromDayToDay(start, end));
		modelMap.addAttribute("sales", billService.findSaleByPhoneFromDayToDay(start, end));
		modelMap.addAttribute("bills", billService.findFromDayToDay(start, end));
		modelMap.addAttribute("countStaff", accountService.countStaffAccountFromDayToDay(start, end));
		modelMap.addAttribute("countCustomer", accountService.countCustomerAccountFromDayToDay(start, end));
		return "admin-view-report";
	}
}
