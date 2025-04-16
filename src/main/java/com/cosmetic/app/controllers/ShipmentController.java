package com.cosmetic.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cosmetic.app.model.PaymentInfo;
import com.cosmetic.app.model.ShippingInfo;
import com.cosmetic.app.service.CartService;

@Controller
public class ShipmentController implements WebMvcConfigurer{
	@Autowired
	private CartService cartService;

	@GetMapping("/shipping")
	public String processShipping(ShippingInfo shippingInfo) {
		System.out.println("ShipmentController.processShipping()" + shippingInfo);
		return "shipping.html";
	}
//
//	@PostMapping("/shippingAddress")
//	public String ShippingAddress(ShippingInfo shippingInfo, Model model) {
//		System.out.println("Shipping info: " + shippingInfo);
//		cartService.setShippingInfo(shippingInfo);
//		
//		PaymentInfo payment = cartService.getPaymentInfo();
//		if (payment == null) {
//			payment = new PaymentInfo();
//		}
//		model.addAttribute("paymentInfo", payment);
//		
//		return "redirect:/paymentInfo";
//	}
	
	@PostMapping("/shipping")
	public String ShippingAddress(@Validated ShippingInfo shippingInfo, BindingResult bindingResult) {
		System.out.println("Shipping info: " + shippingInfo);
		cartService.setShippingInfo(shippingInfo);
		
//		PaymentInfo payment = cartService.getPaymentInfo();
//		if (payment == null) {
//			payment = new PaymentInfo();
//		}
	
		if (bindingResult.hasErrors()) {
			System.out.println("ShipmentController.ShippingAddress() ERRORS");
			return "shipping.html";
		}
		return "payment.html";
	}
}