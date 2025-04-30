package com.cosmetic.app.postgressql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class PostgreSQLConnection {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		String jdbcUrl = "jdbc:postgresql://localhost:5432/cosmeticdb";
		String username = "postgres";
		String password = "abcd1234.";
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
}
