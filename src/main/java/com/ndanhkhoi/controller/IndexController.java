package com.ndanhkhoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ndanhkhoi.service.CategoryService;
import com.ndanhkhoi.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String index(ModelMap modelMap){
		
		modelMap.addAttribute("mi", categoryService.findById(1).getProducts());
		modelMap.addAttribute("redmi", categoryService.findById(2).getProducts());
		modelMap.addAttribute("one", categoryService.findById(3).getProducts());
		modelMap.addAttribute("pocophone", categoryService.findById(4).getProducts());
		
		return "index";
	}
	
	@GetMapping
	@RequestMapping("/search-product")
	public String search(@RequestParam("name") String name,
			ModelMap modelMap)
	{
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("result", productService.findByName(name));
		return "search";
	}

}
