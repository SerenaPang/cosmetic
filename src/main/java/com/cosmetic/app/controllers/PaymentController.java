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
import com.cosmetic.app.service.CartService;

@Controller
public class PaymentController implements WebMvcConfigurer{
	@Autowired
	private CartService cartService;

	@GetMapping("/paymentInfo")//controller mapping
	public String PaymentInfos(PaymentInfo paymentInfo) {
		System.out.println("PaymentController GET: " + paymentInfo);
		
		return "payment.html";
	}
	
	@PostMapping("/paymentInfo")//controller mapping
	public String PaymentInfo(@Validated PaymentInfo paymentInfo, BindingResult bindingResult) {
		System.out.println("PaymentController POST: " + paymentInfo);
		cartService.setPaymentInfo(paymentInfo);
		
		if (bindingResult.hasErrors()) {
			System.out.println("PaymentController.PaymentInfo() ERRORS");
			return "payment.html";
		}

		return "redirect:/paymentSummary";
	}
}
