package com.ndanhkhoi.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ndanhkhoi.entity.Category;
import com.ndanhkhoi.entity.Import;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.CategoryService;
import com.ndanhkhoi.service.ImportService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.ProductService;

@Controller
public class AdminViewProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	ImportService importService;
	
	@Autowired 
	LogService logService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/admin-view-phone/{id}")
	public String Default(@PathVariable long id,
			ModelMap modelMap){
		Product product = productService.findById(id);
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("categoryList", categoryService.findAll());
		return "admin-view-phone";
	}

	@PostMapping
	@RequestMapping("/admin-edit-phone")
	public String updateProduct(@RequestParam("ID") long id,
			@RequestParam("CATEGORYID") int categoryId,
			@RequestParam("NAME") String name,
			@RequestParam("PRICE") long price,
			@RequestParam("OS") String os,
			@RequestParam("SCREEN") String screen,
			@RequestParam("FRONTCAMERA") String frontCam,
			@RequestParam("BACKCAMERA") String backCam,
			@RequestParam("CPU") String cpu,
			@RequestParam("RAM") float ram,
			@RequestParam("ROM") float rom,
			@RequestParam("BATTERY") String battery,
			@RequestParam("SECURITY") String security,
			@RequestParam("COLOR") String color,
			@RequestParam("DESCRIPTION") String description
			){
		
			Category category = categoryService.findById(categoryId);
			Product product = new Product(name, category, price, os, screen, frontCam, backCam, cpu, ram, rom, battery, security, color, description);
			product.setNumber(productService.findById(id).getNumber());
			product.setId(id);
			productService.addOrUpdate(product);			
			Log log =  new Log(accountService.getCurrentAccount(), "Cập nhật thông tin điện thoại ID " + id);
			logService.add(log);
		
		return "redirect: admin-view-phone/" + id;
	}
	
	@PostMapping
	@RequestMapping("/admin-update-product-img")
	public String updateProductImg(@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3,
			@RequestParam("id") long id,
			HttpServletRequest request){
		try{
			MultipartFile[] img = new MultipartFile[]{img1, img2, img3};
			for (int i = 1; i<=3; i++){
				if (!img[i-1].isEmpty()){
					String path = request.getServletContext().getRealPath("/product/") + id + "-img" + i;
					File f = new File(path);
					img[i-1].transferTo(f);
				}
			}
			Log log =  new Log(accountService.getCurrentAccount(), "Cập nhật ảnh điện thoại ID " + id);
			logService.add(log);
		}
		catch (Exception e){
			System.out.println(e);
		}		
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}
	
	@PostMapping
	@RequestMapping("/admin-import-phone")
	public String importPhone(@RequestParam("number") int number,
			@RequestParam("id") long id,
			HttpServletRequest request){
		
		Product product = productService.findById(id);
		product.setNumber(product.getNumber() + number);
		productService.addOrUpdate(product);
		Import imPort = new Import(product, number);
		importService.add(imPort);
		Log log =  new Log(accountService.getCurrentAccount(), "Nhập thêm " + number + " điện thoại " + product.getName() + ", ID: " + product.getId());
		logService.add(log);
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}

}
