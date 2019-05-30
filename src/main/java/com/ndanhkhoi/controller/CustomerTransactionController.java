package com.ndanhkhoi.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.OrderDetail;
import com.ndanhkhoi.entity.OrderInfo;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.OrderInfoService;

@Controller
public class CustomerTransactionController {
	
	@Autowired
	OrderInfoService orderInfoService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	LogService logService;
	
	@RequestMapping("/customer-transaction-history")
	public String transactionHistory(ModelMap modelMap){
		Profile profile = accountService.getCurrentAccount().getProfile();
		modelMap.addAttribute("listOrder", orderInfoService.findUnpaidByCustomer(profile));
		modelMap.addAttribute("listOrderPaid", orderInfoService.findPaidByCustomer(profile));
		return "customer-transaction-history";
	}
	
	@RequestMapping("/customer-cancel-order/{id}")
	@ResponseBody
	public String cancelOrder(@PathVariable("id") long id) throws ParseException{
		Profile profile = accountService.getCurrentAccount().getProfile();
		OrderInfo orderInfo = orderInfoService.findByCustomerAndOrderId(profile, id);
		if (orderInfo == null || orderInfo.getPaid() != 0) return "error";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		String today = dtf.format(localDate);
		if (!today.equalsIgnoreCase(orderInfo.getOrderDay())) return "expired";
		orderInfoService.delete(orderInfo);
		Log log = new Log(accountService.getCurrentAccount(), "Hủy đơn đặt hàng sô " + orderInfo.getId());
		logService.add(log);
		return "success";
	}
	
	@RequestMapping("customer-view-order/{id}")
	public String viewOrder(@PathVariable("id") long id,
			ModelMap modelMap){
		Profile profile = accountService.getCurrentAccount().getProfile();
		OrderInfo orderInfo = orderInfoService.findByCustomerAndOrderId(profile, id);
		if (orderInfo == null) return "redirect: ../404";
		List<OrderDetail> orderDetails = orderInfo.getOrderDetails();
		modelMap.addAttribute("orderDetails", orderDetails);
		return "customer-view-order";
	}

}
