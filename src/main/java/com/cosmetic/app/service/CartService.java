package com.cosmetic.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CartRepository;
import com.cosmetic.app.repository.CosmeticRepository;

@Service
//@ApplicationScope
@SessionScope
public class CartService {
	private List<Cosmetic> cart = new ArrayList<Cosmetic>();

	public void addToCart(Cosmetic cosmetic) {
		cart.add(cosmetic);
	}

	public void deleteFromCart(Cosmetic cosmetic) {
		cart.remove(cosmetic);
	}

	public List<Cosmetic> getCart() {
		return cart;
	}
	
	public Cosmetic findById(long id) {
		Cosmetic target = null;
		//find cosmetic
		for(int i = 1; i <cart.size(); i++) {
			if(cart.get(i).getId() == id) {
				target = cart.get(i);
			} 
		}	
		return target;
	}
}
