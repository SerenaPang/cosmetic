package com.cosmetic.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
