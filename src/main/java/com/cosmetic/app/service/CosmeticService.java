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
		System.out.println("ProductsService.searchBySearchString() " + searchString);

		return cosmeticRepository.findBySearchString(searchString);
	}
}
