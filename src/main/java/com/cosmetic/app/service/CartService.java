package com.cosmetic.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.cosmetic.app.model.Cosmetic;


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
}
