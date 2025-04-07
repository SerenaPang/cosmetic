package com.cosmetic.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.model.PaymentInfo;
import com.cosmetic.app.model.ShippingInfo;
import com.cosmetic.app.service.CartService;

@Controller
public class ComfirmationController {
	@Autowired CartService cartService;
	
	@GetMapping("/comfirmation")
	public String viewOrder(Model model) {
		List<Cosmetic> cart = cartService.getCart();
		ShippingInfo shippingInfo = cartService.getShippingInfo();
		PaymentInfo paymentInfo = cartService.getPaymentInfo();
		
		model.addAttribute("cart", cart);
		model.addAttribute("paymentInfo", paymentInfo);
		model.addAttribute("shippingInfo", shippingInfo);
		
		System.out.println("order cart: { " + cart + " }");
		System.out.println("order payment info: { " + paymentInfo + " }");
		System.out.println("order Shipping info: { " + shippingInfo + " }");
		
		return "comfirmation.html";
	}
}
