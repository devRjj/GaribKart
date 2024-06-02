package com.garibKart.product;

public class Bill {
	private double totalAmount = 0;

	public void addToBill(double amount) {
		totalAmount += amount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}
