package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.service.ProductService;

@Controller
public class AboutPhoneController {
	
	@Autowired 
	ProductService productService;
	
	@RequestMapping("/about-phone/{id}")
	public String aboutPhone(@PathVariable long id,
			ModelMap modelMap){
		Product product = productService.findById(id);
		modelMap.addAttribute("product", product);
		return "about-phone";
	}

}
