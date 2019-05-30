package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndanhkhoi.service.LogService;

@Controller
@RequestMapping("/admin-view-log")
public class AdminViewLogController {
	
	@Autowired
	LogService logService;
	
	@GetMapping
	public String Default(ModelMap modelMap){
		modelMap.addAttribute("fromDayToDay", "Chọn khoảng thời gian xem nhật ký");
		modelMap.addAttribute("logs", logService.findAll());
		return "admin-view-log";
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
		modelMap.addAttribute("logs", logService.findFromDayToDay(start, end));
		return "admin-view-log";
	}

}
