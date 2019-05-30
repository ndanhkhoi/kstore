package com.ndanhkhoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.service.CategoryService;
import com.ndanhkhoi.service.ProductService;

@Controller
@RequestMapping("/staff-view-phones")
public class StaffViewPhonesController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public String phones(ModelMap modelMap){
		List<Product> products = productService.findAll();
		modelMap.addAttribute("products", products);
		modelMap.addAttribute("categories", categoryService.findAll());
		return "staff-view-phones";
	}

}
