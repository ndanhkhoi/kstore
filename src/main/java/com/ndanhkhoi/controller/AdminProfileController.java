package com.ndanhkhoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndanhkhoi.entity.Province;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.ProvinceService;

@Controller
public class AdminProfileController {
	
	@Autowired 
	AccountService accountService;
	@Autowired
	ProvinceService provinceService;
	
	@RequestMapping("/admin-profile")
	public String adminProfile(ModelMap modelMap){
		modelMap.addAttribute("type", "admin");
		modelMap.addAttribute("account", accountService.getCurrentAccount());
		modelMap.addAttribute("role", accountService.getCurrentAccount().getRoles().getId());
		List<Province> provinceList = provinceService.findAll();
		modelMap.addAttribute("provinceList" ,provinceList);
		return "admin-view-detail";	
	}

}
