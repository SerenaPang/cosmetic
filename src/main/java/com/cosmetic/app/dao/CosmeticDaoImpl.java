package com.cosmetic.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetic.app.jdbc.PostgreSQLConnection;
import com.cosmetic.app.model.Cosmetic;

@Repository
public class CosmeticDaoImpl implements CosmeticDao {
	@Autowired
	private PostgreSQLConnection dataSource;

	@Override
	public Cosmetic saveCosmetic(Cosmetic cosmetic) {
		System.out.println("jdbc save Cosmetic");
		return null;
	}

	@Override
	public Cosmetic findCosmeticById(Integer id) {
		System.out.println("jdbc find cosmetic by id " + id);
		return null;
	}

	@Override
	public List<Cosmetic> findAllCosmetics() {
		System.out.println("jdbc find all cosmetics");
		return null;
	}

	@Override
	public Cosmetic deleteCosmetic() {
		System.out.println("jdbc delete cosmetic");
		return null;
	}

}
