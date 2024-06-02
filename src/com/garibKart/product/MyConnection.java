package com.garibKart.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/GaribKart";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "root";

	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_CLASS);

			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}

}
