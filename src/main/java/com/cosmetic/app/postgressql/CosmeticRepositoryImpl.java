package com.cosmetic.app.postgressql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetic.app.model.Cosmetic;
import com.cosmetic.app.repository.CosmeticRepository;

@Repository
public class CosmeticRepositoryImpl implements CosmeticRepository {
	@Autowired
	private PostgreSQLConnection dataSource;
	
	@Override
	public List<Cosmetic> findBySearchString(String searchString) {
		System.out.println("CosmeticRepositoryImpl.findBySearchString() " + searchString);
		List<Cosmetic> cosmetics = new ArrayList<>();
		
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("SELECT cosmetic_id, name, description, brand, price FROM Cosmetic WHERE name = ?"); //LIKE '?%'
			ps.setString(1, searchString);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Cosmetic cosmetic = new Cosmetic();
					cosmetic.setId(rs.getInt("cosmetic_id"));
					cosmetic.setName(rs.getString("name"));
					cosmetic.setDescription(rs.getString("description"));
					cosmetic.setBrand(rs.getString("brand"));
					cosmetic.setPrice(rs.getBigDecimal("price"));
					cosmetics.add(cosmetic);
					System.out.println(cosmetic.toString());
				}
				return cosmetics;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Cosmetic findById(long id) {
		System.out.println("jdbc findById");
		try (Connection connection = dataSource.getConnection()) {
			String sql = "SELECT cosmetic_id, name, description, brand, price FROM Cosmetic WHERE cosmetic_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			Cosmetic cosmetic = new Cosmetic();

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
					cosmetic.setId(rs.getInt("cosmetic_id"));
					cosmetic.setName(rs.getString("name"));
					cosmetic.setDescription(rs.getString("description"));
					cosmetic.setBrand(rs.getString("brand"));
					cosmetic.setPrice(rs.getBigDecimal("price"));

					System.out.println(cosmetic.toString());
				}
				return cosmetic;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}