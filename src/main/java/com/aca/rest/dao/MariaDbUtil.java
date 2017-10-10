package com.aca.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbUtil {
	
	private static String connectionUrl = "jdbc:mariadb://localhost:3306/northwind?user=root&password=kenYa2500";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) {
		Connection conn = MariaDbUtil.getConnection();
		
		if (null != conn) {
			System.out.println("Connected");
		} else {
			System.out.println("No connection");
		}
	}
}
