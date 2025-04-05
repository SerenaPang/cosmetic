package com.cosmetic.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.model.ShippingInfo;


@Service
//@ApplicationScope
@SessionScope
public class CartService {

	private List<Cosmetic> cart = new ArrayList<Cosmetic>();
	private ShippingInfo shippingInfo;

	public void addToCart(Cosmetic cosmetic) {
		cart.add(cosmetic);
	}

	public void deleteFromCart(Cosmetic cosmetic) {
		cart.remove(cosmetic);
	}

	public List<Cosmetic> getCart() {
		return cart;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
		System.out.println("Shipping info(cart service): " + shippingInfo);
	}
}
