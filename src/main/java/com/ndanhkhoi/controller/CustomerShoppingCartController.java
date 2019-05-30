package com.ndanhkhoi.controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ndanhkhoi.entity.Log;
import com.ndanhkhoi.entity.OrderDetail;
import com.ndanhkhoi.entity.OrderInfo;
import com.ndanhkhoi.entity.Product;
import com.ndanhkhoi.entity.Profile;
import com.ndanhkhoi.service.AccountService;
import com.ndanhkhoi.service.LogService;
import com.ndanhkhoi.service.OrderDetailService;
import com.ndanhkhoi.service.OrderInfoService;
import com.ndanhkhoi.service.ProductService;

@Controller
public class CustomerShoppingCartController {
	
	@Autowired
	ProductService productService;

	@Autowired
	AccountService accountService;
	
	@Autowired 
	OrderInfoService orderInfoService;
	
	@Autowired 
	OrderDetailService orderDetaiService;
	
	@Autowired 
	LogService logService;
	
	static final Locale localeVN = new Locale("vi", "VN");
	static final NumberFormat vn = NumberFormat.getCurrencyInstance(localeVN);		
	
	public static Product existedProductInCart(Product product, HashMap<Product, Integer> cart){
		try{
			for (Product p : cart.keySet())
				if (product.getId() == p.getId() ) return p;
		}
		catch (Exception ex){};
		return null;
	}
	
	public static String getTotalPrice(HashMap<Product, Integer> cart){
		long totalPrice = 0;
	    for (Product p : cart.keySet()){
	    	totalPrice += p.getPrice() * cart.get(p);
	    }
	    return vn.format(totalPrice);
	}
		
	@SuppressWarnings("unchecked")
	@PostMapping
	@RequestMapping("/customer-add-to-cart")
	public String addToCart(@RequestParam("id") long id, 
			HttpSession session){
		HashMap<Product, Integer> cart =  (session.getAttribute("cart") == null ? 
				new HashMap<Product, Integer>() : (HashMap<Product, Integer>) session.getAttribute("cart"));
		Product product = productService.findById(id);
		Product existedProduct = existedProductInCart(product, cart);
		if (existedProduct == null){
			cart.put(product, 1);
		}
			else cart.put(existedProduct, Math.min(cart.get(existedProduct) + 1, 10) );
		session.setAttribute("cart", cart);
		session.setAttribute("totalPrice", getTotalPrice(cart));
		return "redirect: customer-shopping-cart";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping
	@ResponseBody
	@RequestMapping(path = "/customer-adjust-cart", produces = "text/plain;charset=UTF-8")
	public String adjust(@RequestParam("id") long id,
			@RequestParam("inc") boolean inc, 		// ==true: tăng, ==false: giảm	
			HttpSession session){
		try
		{
			HashMap<Product, Integer> cart =  (HashMap<Product, Integer>) session.getAttribute("cart");
			Product product = productService.findById(id);
			Product existedProduct = existedProductInCart(product, cart);
			if (existedProduct != null){
				if (inc)	//tăng
				{
					if (cart.get(existedProduct) < 10)
					cart.put(existedProduct, cart.get(existedProduct) + 1);
				}
				else if (cart.get(existedProduct) > 1)
					cart.put(existedProduct, cart.get(existedProduct) - 1);
				session.setAttribute("cart", cart);
				String totalPrice = getTotalPrice(cart);
				session.setAttribute("totalPrice", totalPrice);
				return cart.get(existedProduct).toString() + " " + totalPrice;
			}
		}
		catch(Exception ex){}
		return "error";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("customer-remove-form-cart/{id}")
	public String removeFromCart(@PathVariable("id") long id, 
			HttpSession session){
		try
		{
			HashMap<Product, Integer> cart =  (HashMap<Product, Integer>) session.getAttribute("cart");
			Product product = productService.findById(id);
			Product existedProduct = existedProductInCart(product, cart);
			if (existedProduct != null){
				cart.remove(existedProduct);
				if (cart.isEmpty()) cart = null;
				session.setAttribute("cart", cart);
				session.setAttribute("totalPrice", getTotalPrice(cart));
			}
		}
		catch (Exception ex){}
		return "redirect: ../customer-shopping-cart";
	}
	
	@GetMapping
	@RequestMapping("/customer-shopping-cart")
	public String viewCart(){
		return "customer-shopping-cart";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping
	@RequestMapping("/customer-confirm-order")
	public String confirmOrder(HttpSession session){
		try
		{
			Profile profile = accountService.getCurrentAccount().getProfile();
			long totalPrice = vn.parse( session.getAttribute("totalPrice").toString() ).longValue();
			OrderInfo orderInfo = new OrderInfo(profile, totalPrice);
			orderInfoService.add(orderInfo);
			long oderId = orderInfo.getId();
			HashMap<Product, Integer> cart =  (HashMap<Product, Integer>) session.getAttribute("cart");
			int i = 0;
			for (Product p : cart.keySet()){
				i++;
				String code = oderId + "-" + i;
				OrderDetail orderDetail = new OrderDetail(code, orderInfo, p, cart.get(p));
				orderDetaiService.add(orderDetail);
			}
			Log log = new Log(accountService.getCurrentAccount(), "Chốt đơn đặt hàng sô " + oderId);
			logService.add(log);
			session.setAttribute("cart", null);
			session.setAttribute("totalPrice", null);
		}
		catch (Exception ex){}
		return "redirect: customer-transaction-history";
	}

}
