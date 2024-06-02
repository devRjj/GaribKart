package com.garibKart.product;

import java.util.Scanner;

public class DisplayProduct {
	public static void main(String[] args) throws Exception {

		System.out.println("Welcome To GaribKart");

		System.out.println();
		System.out.println("ProductNo   ProductName            Description  ");
		System.out.println(
				"=============================================================================================");
		System.out.println();
		System.out.println("1.          Mobile               Oneplus 12                                   ");
		System.out.println();
		System.out.println(
				"=============================================================================================");
		System.out.println();
		System.out.println("2.          Laptop               HP Laptop                              ");
		System.out.println();
		System.out.println(
				"=============================================================================================");
		System.out.println();
		System.out.println("3.            TV                 LG 108 cm 4K Ultra HD Smart LED TV            ");
		System.out.println();
		System.out.println(
				"=============================================================================================");
		System.out.println();
		System.out.println("4.          Office Chair         PRENIX High Back Revolving Home and Office Desk Chair  ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out.println("5.          Watch                Apple Watch Ultra 2                                    ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out.println("6.          Guitar                Yamaha F280 Acoustic Rosewood Guitar                   ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out
				.println("7.          Trolley Bag            Safari Pentagon                                        ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out
				.println("8.          Treadmill              Lifelong FitPro                                        ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out
				.println("9.          Dining Table           SONA ART & CRAFTS Solid Sheesham Wood Dining Table     ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out.println("10.         Electrical Bike         Okaya Faast F2B Electric Scooter               ");
		System.out.println();
		System.out.println(
				"============================================================================================");
		System.out.println();
		System.out.println("0.         Exit");
		System.out.println(
				"============================================================================================");
		Scanner sc = new Scanner(System.in);
		Products product = new Products();
		ProductOperation op = new ProductOperation();
		System.out.println();
		boolean isNext = true;
		double total = 0;
		double price = 0;
		String name = null;
		int quantity = 0;
		int totalQuantity = 0;
		int totalPrice = 0;
		String allOrders = "";

		while (isNext) {
			System.out.println("Enter Your choice >>  ");
			int choice = sc.nextInt();
			System.out.println("Enter The Quantity");
			quantity = sc.nextInt();
			int n = quantity;

			switch (choice) {

			case 1:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 2:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 3:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 4:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 5:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 6:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 7:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 8:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 9:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 10:

				product = op.getProductById(choice);
				name = product.getName();
				op.updateProductQuantity(choice, quantity);
				price = product.getPrice();
				total = price * quantity;
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Choice.....");
				break;
			}
			allOrders = allOrders + name + "        " + quantity + "        " + total + "     " + "\n";
			totalQuantity += n;
			totalPrice += total;
			System.out.println();
			System.out.println("Do you want to Buy More Products :: Y/N");
			char userInput = sc.next().charAt(0);
			if (userInput == 'N' || userInput == 'n') {
				isNext = false;

			}

		}

		System.out.println("---------------------------------------------------------------------------");
		System.out.println("ProductName     Quantity     Price     ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(allOrders);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("===========================================================================");
		System.out.println("GareebKart Order Details : ");
		System.out.println("===========================================================================");
		System.out.println("Total Quantity : " + totalQuantity);
		System.out.println("Total Price : " + totalPrice);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Thank you, Visit Again!");
	}

}
