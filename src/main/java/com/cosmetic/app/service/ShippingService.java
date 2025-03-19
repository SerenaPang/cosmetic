package com.cosmetic.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetic.app.model.ShippingInfo;
import com.cosmetic.app.repository.ShippingRepository;

@Service
public class ShippingService {
	@Autowired
	ShippingRepository shippingRepository;
	
	public void addShippingInfo(String name, String address, String zipcode, String cardNumber) {
		ShippingInfo info = new ShippingInfo();
		info.setName(name);
		info.setAddress(address);
		info.setZipcode(zipcode);
		info.setCardNumber(cardNumber);
		shippingRepository.addShippingInfo(info);
	}
}
