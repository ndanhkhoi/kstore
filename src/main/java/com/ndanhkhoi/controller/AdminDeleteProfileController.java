package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.ProfileService;

@Controller
public class AdminDeleteProfileController {
	
	@Autowired 
	AccountService accountService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	LogService logService;
	
	@PostMapping
	@ResponseBody
	@RequestMapping("/admin-delete")
	public String Default(@RequestParam("id") long id, @RequestParam("password") String password){
		String username =  SecurityContextHolder.getContext().getAuthentication().getName();
		String hashpass = accountService.findByUsername(username).getPassword();
		if (BCrypt.checkpw(password, hashpass)){
			Profile p = profileService.findById(id);
			Log log = new Log(accountService.getCurrentAccount(), "Xóa tài khoản " + p.getAccount().getUsername());
			logService.add(log);
			profileService.delete(p);
			return "ok";
		}
		return "error";
	}

}
