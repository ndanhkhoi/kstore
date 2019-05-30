package com.ndanhkhoi.controller;

import java.io.File;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ndanhkhoi.entity.Account;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.entity.Roles;
import com.ndanhkhoi.entity.Ward;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.ProfileService;
import com.ndanhkhoi.service.ProvinceService;
import com.ndanhkhoi.service.RolesService;
import com.ndanhkhoi.service.WardService;

@Controller
@RequestMapping(path = "/admin-add-staff")
public class AdminAddStaffController {
	
	@Autowired
	ProvinceService provinceService;
	
	@Autowired
	WardService wardService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RolesService rolesService;
	
	@Autowired
	LogService logService;
		
	@PostMapping
	public String registerNew(@RequestParam("HOTEN") String fullname, 
			@RequestParam("GIOITINH") String gender, 
			@RequestParam("USERNAME") String username, 
			@RequestParam("PASSWORD") String password, 
			@RequestParam("NGAYSINH") String birthday, 
			@RequestParam("SDT") String tel, 
			@RequestParam("CMND") String idcardNumber, 
			@RequestParam("ward") int wardId,
			@RequestParam("AVT") MultipartFile avt,
			ServletRequest request
			) 
	{
		try{
			String path = request.getServletContext().getRealPath("/avt/") + username;
			File f = new File(path);
			avt.transferTo(f);
			Ward ward = wardService.findById(wardId);
			Profile profile = new Profile(ward, fullname, gender, birthday, tel, idcardNumber, null, null, null);
			profileService.add(profile);
			Roles roles = rolesService.findById(2);
			Account account = new Account(username, profile, roles, BCrypt.hashpw(password, BCrypt.gensalt()));
			accountService.add(account);
			Log log = new Log(accountService.getCurrentAccount(), "Thêm tài khoản nhân viên " + username);
			logService.add(log);
		}
		catch (Exception ex){
			System.out.println(ex);
		}
		return "redirect:admin-manager/staff";
	}	
		

}
