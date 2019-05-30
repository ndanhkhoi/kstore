package com.ndanhkhoi.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.ProfileService;
import com.ndanhkhoi.service.ProvinceService;
import com.ndanhkhoi.service.WardService;

@Controller
public class CustomerProfileController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ProvinceService provinceServive;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	WardService wardService;
	
	@RequestMapping("/customer-view-profile")
	public String Default(ModelMap modelMap){
		Account account = accountService.getCurrentAccount();
		modelMap.addAttribute("type", "customer");
		modelMap.addAttribute("role", accountService.getCurrentAccount().getRoles().getId());
		modelMap.addAttribute("account", account);
		modelMap.addAttribute("provinceList", provinceServive.findAll());
		return "customer-view-profile";
	}
	
	@PostMapping
	@RequestMapping("/customer-edit-profile")
	public String edit(@RequestParam("fullname") String fullname,
			@RequestParam("birth") String birth,
			@RequestParam("tel") String tel,
			@RequestParam("idcard") String idcard,
			@RequestParam("gender") String gender,
			@RequestParam("ward") int ward,
			@RequestParam("id") long id
			){
		Profile profile = profileService.findById(id);
		profile.setBirthday(birth);
		profile.setGender(gender);
		if (tel.length() != 0) profile.setTel(tel);
		if (idcard.length() != 0) profile.setIdcardNumber(idcard);
		if (fullname.length() != 0) profile.setFullname(fullname);
		profile.setWard(wardService.findById(ward));
		profileService.update(profile);
		return "redirect: customer-view-profile";
	}
	
	@ResponseBody
	@RequestMapping("/customer-reset-password")
	public String resetPassword(@RequestParam("username") String username,
			@RequestParam("pass") String pass,
			@RequestParam("newpass") String newPass){
		if (!BCrypt.checkpw(pass, accountService.getCurrentAccount().getPassword())) return "error";
		Account account = accountService.findByUsername(username);
		account.setPassword(BCrypt.hashpw(newPass, BCrypt.gensalt()));
		accountService.update(account);
		return "ok";
	}
		
	@PostMapping
	@RequestMapping(path = "/customer-update-avt")
	public String updateAvt(@RequestParam("AVT") MultipartFile avt,
			@RequestParam("id") long id,
			HttpServletRequest request){
		String username = profileService.findById(id).getAccount().getUsername();
		try{
			if (!avt.isEmpty()){
				String path = request.getServletContext().getRealPath("/avt/") + username;
				File f = new File(path);
				avt.transferTo(f);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}

}
