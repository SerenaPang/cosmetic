package com.cosmetic.app.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.service.CartService;

@RestController
public class AddToCartCosmeticsWebService {
	@Autowired
	private CartService cartService;

	// curl -X GET "http://localhost:8080/addToCart"
	@GetMapping("/addToCart")
public ResponseEntity<List<Cosmetic>> addToCart(List<Cosmetic> cart, Cosmetic cosmetic) {
		List<Cosmetic> cosmetics = cartService.addToCart(cart, cosmetic);
		System.out.println("AddToCartCosmeticsWebService.addToCart " + cosmetic);
		return ResponseEntity.status(HttpStatus.OK).body(cosmetics);
	}
}
