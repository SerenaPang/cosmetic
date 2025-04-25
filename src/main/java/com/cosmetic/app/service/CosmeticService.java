package com.cosmetic.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CosmeticRepository;

@Service
public class CosmeticService {
	@Autowired
	CosmeticRepository cosmeticRepository;

	public List<Cosmetic> searchBySearchString(String searchString) {
		System.out.println("CosmeticService.searchBySearchString() " + searchString);
		return cosmeticRepository.findBySearchString(searchString);
	}

	public Cosmetic findById(long id) {
		System.out.println("CosmeticService.findById() " + id);
		return cosmeticRepository.findById(id);
	}
	
	public Cosmetic saveCosmetic(Cosmetic cosmetic) {
		return cosmeticRepository.saveCosmetic(cosmetic);
	}

	public List<Cosmetic> findAllCosmetics() {
		return cosmeticRepository.findAllCosmetics();
	}

	public Cosmetic deleteCosmetic() {
		return cosmeticRepository.deleteCosmetic();
	}
}
