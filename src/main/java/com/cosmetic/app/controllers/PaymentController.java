package com.cosmetic.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.cosmetic.app.model.PaymentInfo;
import com.cosmetic.app.service.CartService;

@Controller
public class PaymentController {
	@Autowired
	private CartService cartService;

	@PostMapping("/paymentInfo")
	public String PaymentInfo(PaymentInfo paymentInfo) {
		System.out.println("Payment Info info: " + paymentInfo);
		cartService.setPaymentInfo(paymentInfo);
		return "orderSummary.html";
	}
}
