package com.cosmetic.app.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.service.OrderService;

@RestController
public class OrderWebService {
//	@Autowired
//	private OrderService orderService;
//
//	// curl -X GET "http://localhost:8080/addToOrder"
//	@GetMapping("/addToOrder")
//	public ResponseEntity<List<Cosmetic>> addToOrder(Cosmetic cosmetic) {
//		List<Cosmetic> cosmetics = orderService.addToOrder(cosmetic);
//		System.out.println("OrderService.addToOrder " + cosmetic);
//		return ResponseEntity.status(HttpStatus.OK).body(cosmetics);
//	}
//
//	// curl -X GET "http://localhost:8080/deleteFromOrder"
//	@GetMapping("/deleteFromOrder")
//	public ResponseEntity<List<Cosmetic>> deleteFromOrder(Cosmetic cosmetic) {
//		List<Cosmetic> cosmetics = orderService.deleteFromOrder(cosmetic);
//		System.out.println("OrderService.deleteFromOrder " + cosmetic);
//		return ResponseEntity.status(HttpStatus.OK).body(cosmetics);
//	}
//
//	// curl -X GET "http://localhost:8080/findAllCosmetics"
//	@GetMapping("/findAllCosmetics")
//	public ResponseEntity<List<Cosmetic>> findAllCosmetics() {
//		List<Cosmetic> cosmetics = orderService.findAllCosmetics();
//		System.out.println("OrderService.findAllCosmetics ");
//		return ResponseEntity.status(HttpStatus.OK).body(cosmetics);
//	}
}
