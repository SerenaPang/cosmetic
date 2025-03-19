package com.cosmetic.app.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.app.service.ShippingService;

@RestController
public class ShippingWebService {
	@Autowired
	private ShippingService shippingService;
	@PostMapping(path = "/addShippingInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addShippingInfo(@RequestParam String name,  @RequestParam String address, @RequestParam String zipcode, @RequestParam String cardNumber){
		System.out.println("ShippingService.addShippingInfo " + "name: " + name + " address:" + address + " zipcode: " + zipcode + " cardNumber: " + cardNumber);
		shippingService.addShippingInfo(name, address, null, cardNumber);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
