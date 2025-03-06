package com.cosmetic.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CosmeticRepository;

@Service
@ApplicationScope
public class CartService {
	@Autowired
	CosmeticRepository cosmeticRepository;
	
	public List<Cosmetic> addToCart(List<Cosmetic> cart, Cosmetic cosmetic){
		System.out.println("CosmeticService.addToCart() " + cosmetic);	
		return cosmeticRepository.addToCart(cart, cosmetic);
	}
	
}
