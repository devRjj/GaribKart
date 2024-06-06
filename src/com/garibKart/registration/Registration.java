package com.garibKart.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.garibKart.admin.Administration;
import com.garibKart.propertiesfile.ConfigLoader;

public class Registration {

	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private ConfigLoader config;

	public Registration(ConfigLoader config) {
		this.config = config;
		this.dbUrl = config.getProperty("db.url");
		this.dbUsername = config.getProperty("db.username");
		this.dbPassword = config.getProperty("db.password");
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}

	public static Scanner sc = new Scanner(System.in);

	public boolean registerUser() {

		try (Connection conn = getConnection();) {
			System.out.println("*-----------------*");
			System.out.println("*-----------------*");
			System.out.println("Enter user id :");
			int id = sc.nextInt();
			System.out.println("Enter first name :");
			String firstName = sc.next();
			System.out.println("Enter last name :");
			String lastName = sc.next();
			System.out.println("Enter username :");
			String userName = sc.next();
			System.out.println("Enter password :");
			String password = sc.next();
			System.out.println("Enter city:");
			String city = sc.next();
			System.out.println("Enter email id :");
			String emailId = sc.next();
			System.out.println("Enter mobile number :");
			String mobNumber = sc.next();
			

			User user = new User(id, firstName, lastName, userName, password, city, emailId, mobNumber);

			UserConnection uc = new UserConnection(this.config);
			boolean userAdded = uc.addUser(user);

			if (userAdded == true) {
				uc.assignRoleToUser(id, 2); 
				System.out.println("User Register Successfully.");
				return true;
			} else {
				System.out.println("Some issue while registering user");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	
	public Integer loginUser() {
	    try (Connection conn = getConnection();) {
	        System.out.println("Please login for further operation");
	        System.out.println("Enter username");
	        String username = sc.next();

	        System.out.println("Enter Password");
	        String password = sc.next();

	        UserConnection uc = new UserConnection(this.config);
	        User user = uc.verifyUsers(username, password);

	        if (user != null) {
	            System.out.println("Logged in successfully");
	            System.out.println("Role: " + user.getRole());
	            if ("admin".equalsIgnoreCase(user.getRole())) {
	                System.out.println("Welcome, Admin!");
	                Administration admin = new Administration();
	                admin.adminMethods(config);
	            } else {
	                System.out.println("Welcome, User!");
	            }

	            return user.getId();
	        } else {
	            System.out.println("The login was unsuccessful");
	            System.out.println("Please type 'y' to register 'n' to discard");

	            String wantToRegister = sc.next();

	            if (wantToRegister.equalsIgnoreCase("y") || wantToRegister.equalsIgnoreCase("yes")) {
	                Registration reg = new Registration(this.config);
	                reg.registerUser();
	            }

	            return null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}



}
