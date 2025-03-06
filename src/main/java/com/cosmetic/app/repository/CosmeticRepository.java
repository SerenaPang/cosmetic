package com.cosmetic.app.repository;

import java.util.List;

import com.cosmetic.app.model.Cosmetic;

public interface CosmeticRepository {
	 public List<Cosmetic> findBySearchString(String searchString);
	 public List<Cosmetic> addToCart(List<Cosmetic> cart, Cosmetic cosmetic);
}
