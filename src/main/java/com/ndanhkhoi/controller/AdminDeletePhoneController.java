package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.ProductService;

@Controller
public class AdminDeletePhoneController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	ProductService productService;
	
	@Autowired
	LogService logService;
	
	@RequestMapping("/admin-delete-phone/{id}")
	public String confirm(@PathVariable("id") long id,
			ModelMap modelMap){
		modelMap.addAttribute("id", id);
		return "admin-delete-phone-confirm";
	}
	
	@PostMapping
	@RequestMapping("/admin-delete-phone")
	@ResponseBody
	public String delete(@RequestParam("id") long id, 
			@RequestParam("password") String password
			){
		String username =  SecurityContextHolder.getContext().getAuthentication().getName();
		String hashpass = accountService.findByUsername(username).getPassword();
		if (BCrypt.checkpw(password, hashpass)){
			productService.delete(productService.findById(id));
			Log log =  new Log(accountService.getCurrentAccount(), "Xóa điện thoại ID " + id);
			logService.add(log);
			return "ok";
		}
		return "error";
	}

}
