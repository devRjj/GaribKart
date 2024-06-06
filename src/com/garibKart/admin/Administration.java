package com.garibKart.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.garibKart.product.ProductOperation;
import com.garibKart.product.Products;
import com.garibKart.propertiesfile.ConfigLoader;
import com.garibKart.registration.Registration;
import com.garibKart.registration.UserConnection;

public class Administration {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Registration register = new Registration(new ConfigLoader("config.properties"));
		Administration admin = new Administration();
		admin.adminMethods(new ConfigLoader("config.properties"));
//		register.registerUser();
//		register.loginUser();

	}

	public void adminMethods(ConfigLoader config) {
	    ProductOperation productOperation = new ProductOperation(config);
	    Scanner sc = new Scanner(System.in);
	    UserConnection userConnection = new UserConnection(config);
	    Administration admin = new Administration();
	    admin.listOfAdminMethods();

	    int choice;
	    do {
	    	System.out.println("====================================================");
	    	System.out.println("                                                    ");
	        System.out.println("Enter the id from the list to perform the operation ");
	        choice = sc.nextInt();
	        sc.nextLine(); // Consume newline left-over
	        switch (choice) {
	            case 1:
	                List<Products> product = new ArrayList<>();
	                System.out.println("Adding product to the database...");
	                System.out.println("=================================");

	                System.out.println("Enter product ID");
	                int id = sc.nextInt();
	                sc.nextLine(); 
	                System.out.println("Enter product name");
	                String productName = sc.nextLine();
	                System.out.println("Enter product Description");
	                String description = sc.nextLine();
	                System.out.println("Enter product Price");
	                double price = sc.nextDouble();
	                System.out.println("Enter product Quantity");
	                int quantity = sc.nextInt();

	                product.add(new Products(id, productName, description, price, quantity));

	                productOperation.insertData(product);
	                break;
	            case 2:
	                System.out.println("Enter product ID to know the price of the product");
	                int idForPrice = sc.nextInt();
	                productOperation.getPriceById(idForPrice);
	                break;
	            case 3:
	                System.out.println("Enter product ID to know the quantity of the product");
	                int idForQuantity = sc.nextInt();
	                productOperation.getProductQuantity(idForQuantity);
	                break;
	            case 4:
	                System.out.println("Showing all the users details");
	                userConnection.displayUsers();
	                break;
	            case 5:
	                System.out.println("Enter the user id you want to check the id");
	                int userIdForPurchaseHistory = sc.nextInt();
	                productOperation.getUserPurchaseHistory(userIdForPurchaseHistory);
	                break;
	            case 6:
	                List<Products> allProducts = productOperation.getAllProducts();
	                for (Products products : allProducts) {
	                    System.out.println(products);
	                }
	                break;
	            case 0:
	                System.out.println("Exiting admin operations.");
	                break;
	            default:
	                System.out.println("Invalid Choice.....");
	                break;
	        }
	    } while (choice != 0);
	}


	public void listOfAdminMethods() {
		System.out.println("1. " + "  Add product to database.");
		System.out.println("-----------------------------------------");
		System.out.println("2. " + "  Check the price of the product ");
		System.out.println("-----------------------------------------");
		System.out.println("3. " + "  Check Quantity");
		System.out.println("-----------------------------------------");
		System.out.println("4. " + "  Check registered user");
		System.out.println("-----------------------------------------");
		System.out.println("5. " + "  Check user history");
		System.out.println("-----------------------------------------");
		System.out.println("6. " + "  List all product");
		System.out.println("-----------------------------------------");
		System.out.println("0. Exit");
	}
}