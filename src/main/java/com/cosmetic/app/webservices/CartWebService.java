package com.cosmetic.app.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CosmeticRepository;
import com.cosmetic.app.service.CartService;

@RestController
public class CartWebService {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CosmeticRepository cosmeticRepository;

	//	curl --header "Content-Type: application/json" \
	//	  --request POST \
	//	  --data '{"id":"23"}' \
	//	  http://localhost:8080/addCosmeticToCart
	@PostMapping(path = "/addCosmeticToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addToCart(@RequestBody Cosmetic cosmetic) {
		System.out.println("OrderService.addToCart " + cosmetic);
			
		// TODO: Autowire the repository to findById()
		Cosmetic cosme = cosmeticRepository.findById(cosmetic.getId());
		
		if (cosme == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		// add the Cosmetic to the cart
		// If the cart is not found, return NOT_FOUND
		System.out.println("Cosmetic FOUND " + cosme);
		cartService.addToCart(cosme);
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
