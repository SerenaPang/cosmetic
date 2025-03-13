package com.cosmetic.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cosmetic.app.service.CartService;

@Controller
public class CartController {
	@Autowired CartService cartService;
	
	@GetMapping("/order")
	public String viewOrder(Model model) {
		var cart = cartService.getCart();
		model.addAttribute("cart", cart);
		System.out.println("CART: [ " + cart + " ]");
		return "order.html";
	}
}

