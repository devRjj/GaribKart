package com.garibKart.product;

public class Product1 {
	int id;
	String name;
	String description;
	static double price;
	static int quntity;

	public Product1(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product1 [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static double getPrice() {
		return price;
	}

	public static void setPrice(double price) {
		Product1.price = price;
	}

	public static int getQuntity() {
		return quntity;
	}

	public static void setQuntity(int quntity) {
		Product1.quntity = quntity;
	}

}
