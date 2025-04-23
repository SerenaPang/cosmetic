package com.cosmetic.app.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

	public PostgreSQLConnection() throws ClassNotFoundException, IOException, SQLException {
		init();
	}

	private void init() throws IOException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");

		try (Connection con = getConnection()) {
			System.out.println("Connecting to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/cosmetic";
		String username = "postgres";
		String password = "abcd1234.";
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
}
