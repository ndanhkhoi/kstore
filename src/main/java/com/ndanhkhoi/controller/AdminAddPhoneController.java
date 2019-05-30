package com.ndanhkhoi.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ndanhkhoi.entity.Category;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.CategoryService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.ProductService;

@Controller
@RequestMapping("/admin-add-phone")
public class AdminAddPhoneController {
	
	@Autowired 
	AccountService accountService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	LogService logService;
	
	@PostMapping
	public String addPhone(@RequestParam("NAME") String name,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3,
			@RequestParam("CATEGORYID") int categoryId,
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
			@RequestParam("DESCRIPTION") String description,
			HttpServletRequest request
			){
		
		try{
			MultipartFile[] img = new MultipartFile[]{img1, img2, img3};
			Category category = categoryService.findById(categoryId);
			Product product = new Product(name, category, price, os, screen, frontCam, backCam, cpu, ram, rom, battery, security, color, description);
			productService.addOrUpdate(product);			
			Log log = new Log(accountService.getCurrentAccount(), "Đã thêm điện thoại " + name + " , ID: " + product.getId() );
			logService.add(log);
			for (int i = 1; i<=3; i++){
				if (!img[i-1].isEmpty()){
					String path = request.getServletContext().getRealPath("/product/") + product.getId() + "-img" + i;
					File f = new File(path);
					img[i-1].transferTo(f);
				}
			}
		}
		catch (Exception e){
			System.out.println(e);
		}		
		
		return "redirect: staff-view-phones";
	}

}
