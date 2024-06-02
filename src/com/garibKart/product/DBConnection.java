package com.garibKart.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
		private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/garibkart";
		private static final String USER_NAME = "root";
		private static final String PASSWORD = "root";

		private static Connection connection;

		public static Connection getConnection() throws Exception {

			try {
				Class.forName(DRIVER_CLASS);
				connection=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return connection;

		}
	}


