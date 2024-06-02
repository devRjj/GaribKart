package com.garibKart.product;

import java.util.Scanner;

public class Display {
	static Insertdata data = new Insertdata();
	static Scanner sc = new Scanner(System.in);
	static int choice;
	private static int id;
	static Bill bill = new Bill();

	public static void main(String[] args) {
		System.out.println("***********************************************************************************");
		System.out.println("    GaribKart online shopping ");
		System.out.println(" ***********************************************************************************");
		System.out.println(
				"                                                                                                                                                   ");
		System.out.println("Hello, lets do shopping with us");
		System.out.println("                                                                            ");
		System.out.println("                                                                            ");
		System.out.println("---------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("=====================================================================================");
		double amount = 0;
		do {
			// System.out.println(Insertdata.showProducts());
			System.out.println("1.Mobile   >>>" + "  OnePlus");
			System.out.println("-----------------------------------------");
			System.out.println("2.Laptop   >>>" + "  HP Laptop ");
			System.out.println("-----------------------------------------");
			System.out.println("3.Television   >>>" + "LG TV with 108 cm   ");
			System.out.println("-----------------------------------------");
			System.out.println("4.Office chair   >>>" + "umbar Support with Comfortable Armrest");
			System.out.println("-----------------------------------------");
			System.out.println("5.Watches   >>>" + "iPhone watches ");
			System.out.println("-----------------------------------------");
			System.out.println("6.Guitar   >>>" + "   amaha F280 Acoustic Rosewood Guitar ");
			System.out.println("-----------------------------------------");
			System.out.println("7.trolley Bag   >>>" + "   Safari Pentagon ");
			System.out.println("-----------------------------------------");
			System.out.println("8.Treadmills   >>>" + "   Lifelong FitPro ");
			System.out.println("-----------------------------------------");
			System.out.println("9.Dining Table  >>>" + "  SONA ART & CRAFTS Solid Sheesham Wood ");
			System.out.println("-----------------------------------------");
			System.out.println("10.Electric bike >>>" + "   Okaya Faast F2B Electric Scooter ");
			System.out.println("-----------------------------------------");
			System.out.println("11.Continue Shopping ");
			System.out.println(" 0. exit");
			System.out.println("-------------------------------------------------------------");
			System.out.println(">>>>Enter  Your choice to >>>    ");
			System.out.println("-------------------------------------------------------------");
			choice = sc.nextInt();

			double price;
			switch (choice) {
			case 101:
				price = 50000;
				System.out.println(">>>>Enter quantity >>>    ");
				int quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();

				break;
			case 102:
				price = 60000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 103:
				price = 35000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 104:
				price = 9999;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 105:
				price = 84000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 106:
				price = 8000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;

			case 107:
				price = 1800;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 108:
				price = 18000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 109:
				price = 15000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);
				data.update();
				break;
			case 110:
				price = 100000;
				System.out.println(">>>>Enter quantity >>>    ");
				quantity = sc.nextInt();
				amount = process(id, price, quantity);
				bill.addToBill(amount);

				data.update();
				break;
			case 11:
				System.out.println("Continue shopping");
				if (choice == 11)
					continue;
			case 0:
				double totalAmount = bill.getTotalAmount();
				printBill(amount, totalAmount);
				System.out.println("Thanks for shopping with us! Your total bill is: " + totalAmount);
				System.out.println("Visit again!");
				break;
			}
		} while (choice != 0);

	}

	private static double process(int id, double price, int quantity) {
		price = price * quantity;
		return price;

	}

	private static void printBill(double price, double totalAmount) {
		System.out.println("------------------|----------|");
		System.out.println("Bill Summary:");
		System.out.println("------------------|----------|");
		// System.out.println("Product ID: " + id);
		// System.out.println("Quantity: " + quantity);
		System.out.println("Price per unit:      " + price);
		System.out.println("------------------|----------|");
		System.out.println("Total Amount:        " + totalAmount);
		System.out.println("------------------|----------|");
	}

}
