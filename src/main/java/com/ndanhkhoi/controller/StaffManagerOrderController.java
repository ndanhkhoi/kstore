package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.OrderInfoService;

@Controller
@RequestMapping("/staff-manager-order")
public class StaffManagerOrderController {
	
	@Autowired
	OrderInfoService orderInfoService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public String managerOrder(ModelMap modelMap){
		modelMap.addAttribute("unpaidOrders", orderInfoService.findUnpaid());
		return "staff-manager-order";
	}

}
