package com.ndanhkhoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.ProfileService;

@Controller
public class AdminManagerController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(path = "/admin-manager/{type}")
	@GetMapping
	public String Default(@PathVariable("type") String type, ModelMap modelMap){
		List<Account> listAccount = null;
		if (type.equalsIgnoreCase("staff") )
			listAccount = accountService.getStaffAccount();
		else if (type.equalsIgnoreCase("customer") )
			listAccount = accountService.getCustomerAccount();
		else return "redirect: ../404";
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("listAccount", listAccount);
		return "admin-manager-page";
	}
	
}
