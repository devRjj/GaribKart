package com.garibKart.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.garibKart.admin.Administration;
import com.garibKart.product.DisplayProduct;
import com.garibKart.propertiesfile.ConfigLoader;
import com.garibKart.registration.Registration;

public class Calling {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConfigLoader config = new ConfigLoader("config.properties");
		DisplayProduct display = new DisplayProduct(config);
		Registration register = new Registration(config);
		Scanner sc = new Scanner(System.in);
		Calling callingObj = new Calling();

		System.out.println("Enter 1 for admin operation and 2 for shopping");
		int initialInput = sc.nextInt();
		if (initialInput == 1) {
			Administration admin = new Administration();
			admin.adminMethods(new ConfigLoader("config.properties"));
		} else {

			Integer userId = callingObj.welcome(config);
			if (userId != null) {

				display.displayStaticProductData(userId);
			} else {
				display.welcomeWithProductList();

				System.out.println("Enter the product id to checkout");
				int id = sc.nextInt();

				if (id >= 1 && id <= 10) {
					Integer userId1 = (Integer) register.loginUser();
					if (userId1 != null) {
						System.out.println("Please try again to buy the product.");
						display.displayStaticProductData(userId1);
					} else {
						display.welcomeWithProductList();
					}
				}
			}
		}

	}

	public Integer welcome(ConfigLoader config) throws FileNotFoundException, IOException {
		Registration register = new Registration(config);
		Scanner sc = new Scanner(System.in);
		System.out.println("                Welcome To GaribKart                  ");
		System.out.println("      An online shopping place for garib people       ");
		System.out.println("      =========================================       ");

		System.out.println("Press 1 for login or 2 to register into GaribKart.");

		int toLoginOrRegister = sc.nextInt();

		if (toLoginOrRegister == 1) {
			Integer userId = (Integer) register.loginUser();
			if (userId != null) {
				System.out.println("Already a user. Welcome back");
				return userId;
			} else {
				return null;
			}
		} else if (toLoginOrRegister == 2) {
			if (register.registerUser() == true) {
				System.out.println("Welcome to the GaribKart family");
				System.out.println("Please login now");
				Integer userId = (Integer) register.loginUser();
				if (userId != null) {
					System.out.println("Already a user. Welcome back");
					return userId;
				} else {
					System.out.println("A guest user. You will not be able to checkout product.");
					return null;
				}
			}
		}
		System.out.println("A guest user. You will not be able to checkout product.");
		return null;
	}

}
