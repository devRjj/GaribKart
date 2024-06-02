package com.garibKart.registration;

import java.util.Scanner;

public class Registration {
	
	public static  Scanner sc = new Scanner(System.in);
	
	public static  void registerUser() {
		
		System.out.println("*-----------------*");
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
		
		
		User user  = new User(firstName, lastName, userName, password, city, emailId, mobNumber );
		
		UserConnection uc = new UserConnection();
		uc.addUser(user);
		
		System.out.println("User Register Successfully.");
		
	}
	
	public static void main(String[] args) {
		registerUser();
	}

}
