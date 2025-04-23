package com.cosmetic.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:postgresql://localhost:5432/cosmetic";
		String username = "postgres";
		String password = "abcd1234.";

		// Register the PostgreSQL driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connect to the database

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connecting to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Perform desired database operations

		// Close the connection
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
