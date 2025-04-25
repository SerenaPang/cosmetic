package com.cosmetic.app.postgressql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CosmeticRepository;
import com.cosmetic.app.repository.PostgreSQLConnection;

@Repository
public class CosmeticRepositoryImpl implements CosmeticRepository {
	@Autowired
	private PostgreSQLConnection dataSource;
	@Override
	public List<Cosmetic> findBySearchString(String searchString) {
		System.out.println("CosmeticRepositoryImpl.findBySearchString() " + searchString);
		List<Cosmetic> cosmetics = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
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

	@Override
	public Cosmetic findById(long id) {
		System.out.println("CosmeticRepositoryImpl.findById() " + id);
		Map<Long, Cosmetic> cosmetics = new HashMap<Long, Cosmetic>();
		for (int i = 1; i < 10; i++) {
			Cosmetic cosmetic = new Cosmetic();
			cosmetic.setId(i);
			cosmetic.setName("Blush" + i);
			cosmetic.setBrand("FlowerKnows" + i);
			cosmetic.setDescription("Powder Blush");
			cosmetic.setPrice(new BigDecimal(24.66));
			cosmetics.put((long)i, cosmetic);
		}
		
		Cosmetic target = cosmetics.get(id);
		return target;
	}

	@Override
	public Cosmetic saveCosmetic(Cosmetic cosmetic) {
		System.out.println("jdbc save Cosmetic");
		try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO cosmetic(id, name, description, brand, price) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            try {
				preparedStatement.setLong(1, cosmetic.getId());
				preparedStatement.setString(2, cosmetic.getName());
		        preparedStatement.setString(3, cosmetic.getDescription());
		        preparedStatement.setString(4, cosmetic.getBrand());
		        preparedStatement.setBigDecimal(5, cosmetic.getPrice());
		        
		        int rowsInserted = preparedStatement.executeUpdate();
	            System.out.println(rowsInserted + " row(s) inserted.");
			} catch (SQLException e) {
				e.printStackTrace();
			}      
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cosmetic> findAllCosmetics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cosmetic deleteCosmetic() {
		// TODO Auto-generated method stub
		return null;
	}
}
