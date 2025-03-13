package com.cosmetic.app.mysql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CosmeticRepository;

@Repository
public class CosmeticRepositoryImpl implements CosmeticRepository {

	@Override
	public List<Cosmetic> findBySearchString(String searchString) {
		 System.out.println("CosmeticRepositoryImpl.findBySearchString() " + searchString);
		List<Cosmetic> cosmetics = new ArrayList<>();
		for (int i = 1; i <10; i++) {
			Cosmetic cosmetic = new Cosmetic();
			cosmetic.setId(i);
			cosmetic.setName("Blush" + i);
			cosmetic.setBrand("FlowerKnows" + i);
			cosmetic.setDescription("Powder Blush");
			cosmetic.setPrice(new BigDecimal(24.66));
			cosmetics.add(cosmetic);
		}
		return cosmetics;
	}

}
