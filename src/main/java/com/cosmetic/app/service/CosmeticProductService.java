package com.cosmetic.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cosmetic.app.dao.CosmeticDao;
import com.cosmetic.app.model.Cosmetic;

@Service
public class CosmeticProductService {
	@Autowired
	private CosmeticDao cosmeticDao;

	public Cosmetic saveCosmetic(Cosmetic cosmetic) {
		return cosmeticDao.saveCosmetic(cosmetic);
	}

	public Cosmetic findCosmeticById(Integer id) {
		return cosmeticDao.findCosmeticById(id);
	}

	public List<Cosmetic> findAllCosmetics() {
		return cosmeticDao.findAllCosmetics();
	}

	public Cosmetic deleteCosmetic() {
		return cosmeticDao.deleteCosmetic();
	}
}
