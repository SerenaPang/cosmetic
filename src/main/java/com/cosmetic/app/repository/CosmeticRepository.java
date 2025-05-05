package com.cosmetic.app.repository;

import com.cosmetic.app.model.Cosmetic;

public interface CosmeticRepository {
	public Cosmetic findBySearchString(String searchString);

	public Cosmetic findById(long id);
}
