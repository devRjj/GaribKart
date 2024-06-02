package com.garibKart.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOperation {
	Connection con = null;
	PreparedStatement pst = null;

	public void insertData(List<Products> productList) {

		try {
			con = DBConnection.getConnection();
			String sqlQuery = "insert into product(id, name, description, price, quantity) values (?,?,?,?,?)";
			pst = con.prepareStatement(sqlQuery);
			for (Products product : productList) {
				pst.setInt(1, product.getId());
				pst.setString(2, product.getName());
				pst.setString(3, product.getDescription());
				pst.setDouble(4, product.getPrice());
				pst.setInt(5, product.getQuantity());
				int i = pst.executeUpdate();
				System.out.println("Executed Scessfully " + i);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pst.close();
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Products> getAllProducts() {
		List<Products> productList = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			Statement statement = con.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from product");
			while (resultSet.next()) {
				Products product = new Products();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				productList.add(product);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return productList;
	}

	public void updateProduct(Products product) {
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("update product set name=?, description=?, price=?, quantity=? where id=?");
			pst.setString(1, product.getName());
			pst.setString(2, product.getDescription());
			pst.setDouble(3, product.getPrice());
			pst.setInt(4, product.getQuantity());
			pst.setInt(5, product.getId());

			int i = pst.executeUpdate();
			System.out.println("Executed Sucessfully" + i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteProduct(int productId) {
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("delete from product where id=?");
			pst.setInt(1, productId);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			pst.close();
			pst.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Products getProductById(int productId) {
		Products product = new Products();

		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select * from product where id=?");
			pst.setInt(1, productId);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getInt(1));
				int id = product.getId();
				System.out.println("Product Id >> " + id);
				product.setName(resultSet.getString(2));
				String name = product.getName();
				System.out.println("Product Name >> " + name);
				product.setDescription(resultSet.getString(3));
				String description = product.getDescription();
				System.out.println("Product Description >> " + description);
				product.setPrice(resultSet.getDouble(4));
				double price = product.getPrice();
				System.out.println("Product Price >> " + price);
				product.setQuantity(resultSet.getInt(5));
				int quantity = product.getQuantity();
				System.out.println("Product Quantity Available >> " + quantity);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pst.close();
			con.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return product;
	}

	public void updateProductQuantity(int productId, int newQuantity) {

		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("update product set quantity=quantity-? where id=?");
			pst.setInt(1, newQuantity);
			pst.setInt(2, productId);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getPriceById(int id) {
		Products product = new Products();

		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select price from product where id=?");
			pst.setInt(1, id);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {
				product.setId(resultSet.getInt(1));
				double price = product.getPrice();
				System.out.println(price);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
