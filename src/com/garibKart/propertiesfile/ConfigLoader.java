package com.garibKart.propertiesfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	private Properties properties = new Properties();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConfigLoader config = new ConfigLoader("config.properties");

		String dbUrl = config.getProperty("db.url");
		String dbUsername = config.getProperty("db.username");
		String dbPassword = config.getProperty("db.password");

		System.out.println("Database URL: " + dbUrl);
		System.out.println("Database Username: " + dbUsername);
		System.out.println("Database Username: " + dbPassword);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public ConfigLoader(String propertiesFile) throws FileNotFoundException, IOException {

		try (FileInputStream fis = new FileInputStream(propertiesFile)) {
			properties.load(fis);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
