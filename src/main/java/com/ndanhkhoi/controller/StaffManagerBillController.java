package com.ndanhkhoi.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndanhkhoi.entity.Bill;
import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.OrderDetail;
import com.ndanhkhoi.entity.OrderInfo;
import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.BillService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.OrderInfoService;
import com.ndanhkhoi.service.ProductService;

@Controller
public class StaffManagerBillController {
	
	@Autowired
	OrderInfoService orderInfoService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	LogService logService;
	
	
	@RequestMapping("/staff-export-bill/{orderId}")
	public String exportBill(@PathVariable("orderId") int orderId,
			ModelMap modelMap){
		OrderInfo orderInfo = orderInfoService.findById(orderId);
		if (orderInfo == null) return "redirect: ../404";
		List<OrderDetail> orderDetails = orderInfo.getOrderDetails();
		modelMap.addAttribute("orderDetails", orderDetails);
		return "staff-export-bill";
	}
	
	@RequestMapping("/staff-save-bill/{orderId}")
	public String saveBill(@PathVariable("orderId") long orderId
			){
		OrderInfo oder = orderInfoService.findById(orderId);
		if (oder == null || oder.getPaid() == 1) return "redirect: ../404";
		List<OrderDetail> oderDetails = oder.getOrderDetails();
		for (OrderDetail od : oderDetails)
			if (od.getNumber() > od.getProduct().getNumber()) {
				return "redirect: ../not-enough";
			}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		String today = dtf.format(localDate);
		Bill bill = new Bill(oder, accountService.getCurrentAccount().getProfile(), today);
		billService.add(bill);
		oder.setPaid((short) 1);
		for (OrderDetail od : oderDetails) 
		{
			Product p = od.getProduct();
			p.setNumber(p.getNumber() - od.getNumber());
			productService.addOrUpdate(p);
		}
		orderInfoService.update(oder);
		Log log = new Log(accountService.getCurrentAccount(), "Thanh toán đơn đặt hàng sô " + orderId + ", In hóa đơn bán hàng số " + bill.getId());;
		logService.add(log);
		return "redirect: ../staff-manager-bill";
	}

	@RequestMapping("/staff-manager-bill")
	public String managerBill(ModelMap modelMap){
		List<Bill> bills = billService.findAll();
		modelMap.addAttribute("bills", bills);
		return "staff-manager-bill";
	}
	
	@RequestMapping("/not-enough")
	public String notEnough(){
		return "not-enough";
	}
}
