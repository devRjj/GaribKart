package com.garibKart.propertiesfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Credentials {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();

		try {
			FileOutputStream fs = new FileOutputStream("config.properties");

			properties.setProperty("db.url", "jdbc:mysql://localhost:3306/garibKart");
			properties.setProperty("db.username", "root");
			properties.setProperty("db.password", "dvrj@0005");

			properties.store(fs, null);

			System.out.println("properties file added");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
