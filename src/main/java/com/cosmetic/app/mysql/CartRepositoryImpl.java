package com.cosmetic.app.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CartRepository;

@Repository
public class CartRepositoryImpl implements CartRepository {
	static List<Cosmetic> userCart;

	@Override
	public List<Cosmetic> addToCart(List<Cosmetic> cart, Cosmetic cosmetic) {
		userCart = cart;
		cart.add(cosmetic);
		return userCart;
	}

	@Override
	public List<Cosmetic> deleteFromCart(List<Cosmetic> cart, Cosmetic cosmetic) {
		userCart = cart;
		cart.remove(cosmetic);
		return userCart;
	}

	@Override
	public List<Cosmetic> findAllCosmetics() {
		return userCart;
	}
}
