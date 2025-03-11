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
import com.cosmetic.app.service.OrderService;

@RestController
public class CartWebService {
	@Autowired
	private CartService cartService;

	// curl -X GET "http://localhost:8080/addToCart"
	@GetMapping("/addToCart")
	public ResponseEntity<Void> addToCart(Cosmetic cosmetic) {
		cartService.addToCart(cosmetic);
		System.out.println("OrderService.addToCart " + cosmetic);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// curl -X GET "http://localhost:8080/deleteFromCart"
	@GetMapping("/deleteFromCart")
	public ResponseEntity<Void> deleteFromCart(Cosmetic cosmetic) {
		cartService.deleteFromCart(cosmetic);
		System.out.println("OrderService.deleteFromCart " + cosmetic);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// curl -X GET "http://localhost:8080/getCart"
	@GetMapping("/getCart")
	public ResponseEntity<List<Cosmetic>> getCart() {
		List<Cosmetic> cosmetics = cartService.getCart();
		System.out.println("OrderService.getCart ");
		return ResponseEntity.status(HttpStatus.OK).body(cosmetics);
	}
}
