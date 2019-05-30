package com.ndanhkhoi.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndanhkhoi.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			ModelMap modelMap){
		if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
			return "redirect: welcome";
		String mess = new String();
		if (error != null) mess = "Đăng nhập thất bại, sai tên đăng nhập hoặc mật khẩu";
		modelMap.addAttribute("mess", mess);
		return "login";
	}

	@RequestMapping(path = "/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";
	}	
	
	@RequestMapping(path = "/403")
	public String error403(){
		return "403";
	}
	
	@RequestMapping(path = "/404")
	public String error404(){
		return "404";
	}
	
	@RequestMapping(path = "/welcome")
	public String success(HttpServletRequest request){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username =  auth.getName();
		int roleID = accountService.findByUsername(username).getRoles().getId();
		if (roleID == 1 )
			return "redirect: admin-manager/staff";
		else if (roleID == 2 )
			return "redirect: staff-manager-order";
		else if (roleID == 3 ) 
			return "redirect: " + request.getContextPath();
		return "redirect: 403";
	}
	
}
