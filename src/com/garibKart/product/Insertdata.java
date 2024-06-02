package com.garibKart.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertdata {
	Connection con = null;
	PreparedStatement ps = null;
	int id;
	double quantity;
	Scanner sc = new Scanner(System.in);

	public void insertProd(int id, String name, String description, double price, int quantity) {
		try {
			String query = "insert into products(id,name,description,price,quantity) values(?,?,?,?,?)";
			Connection con = MyConnection.getConnection();

			ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, description);
			ps.setDouble(4, price);
			ps.setInt(5, quantity);
			int i = ps.executeUpdate();
			System.out.println("record added to DB ::" + i);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showProducts() {
		String query = "SELECT * FROM products";
		// String productResult ="";
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// productResult += rs.getInt("id") + rs.getString("name") +
				// rs.getString("description") + rs.getDouble("price") +"\n" ;
				System.out.println("Product ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Description: " + rs.getString("description"));
				System.out.println("Price: " + rs.getDouble("price"));
				System.out.println("Quantity: " + rs.getInt("quantity"));
				System.out.println("----------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return productResult;

	}

	public void update() {

		System.out.println("for confirmation enter id>");
		int id = sc.nextInt();
		System.out.println("confirm quantity");
		int quantityToSub = sc.nextInt();
		String query = "UPDATE products SET quantity = quantity - ?  WHERE id = ? ";
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, quantityToSub);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			System.out.println("updated successfully " + i);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
