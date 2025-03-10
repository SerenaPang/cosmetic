package com.cosmetic.app.repository;

import java.util.List;

import com.cosmetic.app.model.Cosmetic;

public interface CartRepository {
	public List<Cosmetic> addToCart(List<Cosmetic> cart, Cosmetic cosmetic);

	public List<Cosmetic> deleteFromCart(List<Cosmetic> cart, Cosmetic cosmetic);

	public List<Cosmetic> findAllCosmetics();
}
