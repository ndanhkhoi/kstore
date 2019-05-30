package com.ndanhkhoi.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.entity.Province;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.ProfileService;
import com.ndanhkhoi.service.ProvinceService;
import com.ndanhkhoi.service.WardService;

@Controller
public class AdminViewProfileController {
	
	@Autowired 
	ProfileService profileService;
	@Autowired
	ProvinceService provinceService;
	@Autowired
	WardService wardService;
	@Autowired 
	AccountService accountService;
	
	@Autowired 
	LogService logService;
	 
	@RequestMapping("/admin-view/{type}/{id}")
	public String Default(@PathVariable("id") long id,
			@PathVariable("type") String type,
			ModelMap modelMap){
		int typeid = 0;
		if (type.equalsIgnoreCase("staff")) typeid = 2;
			else if (type.equalsIgnoreCase("customer")) typeid = 3;
		Profile profile = profileService.findById(id);
		if (typeid != profile.getAccount().getRoles().getId()) return "redirect: ../../404";
		modelMap.addAttribute("account", profile.getAccount());
		modelMap.addAttribute("type", type);
		modelMap.addAttribute("role", accountService.getCurrentAccount().getRoles().getId());
		List<Province> provinceList = provinceService.findAll();
		modelMap.addAttribute("provinceList" ,provinceList);
		return "admin-view-detail";	
	}
	
	@PostMapping
	@RequestMapping("/admin-edit")
	public String edit(@RequestParam("fullname") String fullname,
			@RequestParam("birth") String birth,
			@RequestParam("tel") String tel,
			@RequestParam("idcard") String idcard,
			@RequestParam("gender") String gender,
			@RequestParam("ward") int ward,
			@RequestParam("id") long id,
			@RequestParam("type") String type,
			HttpServletRequest request
			){
		
		Profile profile = profileService.findById(id);
		profile.setBirthday(birth);
		profile.setGender(gender);
		if (tel.length() != 0) profile.setTel(tel);
		if (idcard.length() != 0) profile.setIdcardNumber(idcard);
		if (fullname.length() != 0) profile.setFullname(fullname);
		profile.setWard(wardService.findById(ward));
		profileService.update(profile);
		Log log = new Log(accountService.getCurrentAccount(), "Cập nhập thông tin cá nhân cho tài khoản " + profile.getAccount().getUsername());
		logService.add(log);

		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;	}
	
	@ResponseBody
	@RequestMapping("/admin-reset-password")
	public String resetPassword(@RequestParam("username") String username,
			@RequestParam("pass") String pass,
			@RequestParam("newpass") String newPass){
		if (!BCrypt.checkpw(pass, accountService.getCurrentAccount().getPassword())) return "error";
		Account account = accountService.findByUsername(username);
		account.setPassword(BCrypt.hashpw(newPass, BCrypt.gensalt()));
		accountService.update(account);
		Log log = new Log(accountService.getCurrentAccount(), "Cập nhập mật khẩu cho tài khoản " + username);
		logService.add(log);

		return "ok";
	}
	
	@PostMapping
	@RequestMapping(path = "/admin-update-avt")
	public String updateAvt(@RequestParam("AVT") MultipartFile avt,
			@RequestParam("id") long id,
			HttpServletRequest request){
		String username = profileService.findById(id).getAccount().getUsername();
		try{
			if (!avt.isEmpty()){
				String path = request.getServletContext().getRealPath("/avt/") + username;
				File f = new File(path);
				avt.transferTo(f);
				Log log = new Log(accountService.getCurrentAccount(), "Cập nhập ảnh đại diện cho tài khoản " + username);
				logService.add(log);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}
	
}
