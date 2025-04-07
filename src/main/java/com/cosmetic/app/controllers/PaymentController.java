package com.cosmetic.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cosmetic.app.model.PaymentInfo;
import com.cosmetic.app.service.CartService;

@Controller
public class PaymentController {
	@Autowired
	private CartService cartService;

	@PostMapping("/paymentInfo")//controller mapping
	public String PaymentInfo(PaymentInfo paymentInfo, Model model) {
		System.out.println("Payment Info info: " + paymentInfo);
		cartService.setPaymentInfo(paymentInfo);
		model.addAttribute("paymentInfo", paymentInfo);
		return "orderSummary.html";
	}
	
}
