package com.cosmetic.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cosmetic.app.model.ShippingInfo;
import com.cosmetic.app.service.CartService;

@Controller
public class ShipmentController {
	@Autowired
	private CartService cartService;

	@GetMapping("/shipping")
	public String addShipingInfo() {

		// System.out.println("name: " + name + );
		return "shipping.html";
	}

	@PostMapping("/shippingAddress")
	public String ShippingAddress(ShippingInfo shippingInfo) {
		System.out.println("Shipping info: " + shippingInfo);
		cartService.setShippingInfo(shippingInfo);
		return "payment.html";
	}
	
	
}