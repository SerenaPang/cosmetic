package com.cosmetic.app.dao;

import java.util.List;

import com.cosmetic.app.model.Cosmetic;

public interface CosmeticDao {
	public Cosmetic saveCosmetic(Cosmetic cosmetic);

	public Cosmetic findCosmeticById(Integer id);

	public List<Cosmetic> findAllCosmetics();

	public Cosmetic deleteCosmetic();
}
