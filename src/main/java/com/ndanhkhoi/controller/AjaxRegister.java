package com.ndanhkhoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ndanhkhoi.entity.District;
import com.ndanhkhoi.entity.Province;
import com.ndanhkhoi.entity.Ward;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.DistrictService;
import com.ndanhkhoi.service.ProvinceService;

@Controller
public class AjaxRegister {
		
	@Autowired
	ProvinceService provinceService;
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	AccountService accountService;

	@RequestMapping(path = "/provinceList", produces = "text/plain;charset=UTF-8")
	@GetMapping
	@ResponseBody
	public String provinces(){
		List<Province> provinces = provinceService.findAll();
		String result = new String();
		result += ("<select>");
		for (Province p : provinces){
			result += ("<option value ='" + p.getId() + "'> " + p.getName() + "</option>");
		}
		result += "</select>";
		return result;
	}
	
	@RequestMapping(path = "/districtList", produces = "text/plain;charset=UTF-8")
	@GetMapping
	@ResponseBody
	public String provinceChoose(@RequestParam("province_id") int id){
		Province province = provinceService.finrById(id);
		List<District> districtList = provinceService.getDistricts(province);
		String result = new String();
		result += ("<select>");
		for (District d : districtList){
			result += ("<option value ='" + d.getId() + "'> " + d.getPrefix() + " " + d.getName() + "</option>");
		}
		result += "</select>";
		return result;
	}
	
	@RequestMapping(path = "/wardList", produces = "text/plain;charset=UTF-8")
	@GetMapping
	@ResponseBody
	public String DistrictChoose(@RequestParam("district_id") int id){
		District district = districtService.finrById(id);
		List<Ward> WardList = districtService.getWards(district);
		String result = new String();
		result += ("<select>");
		for (Ward w : WardList){
			result += ("<option value ='" + w.getId() + "'> " + w.getPrefix() + " " + w.getName() + "</option>");
		}
		result += "</select>";
		return result;
	}
	
	@RequestMapping(path = "/existedUser",  produces = "text/plain;charset=UTF-8")
	@GetMapping
	@ResponseBody
	public String existedUser(@RequestParam("user") String user){
		boolean notExisted = !accountService.existed(user);
		return notExisted + "";
	}

}
