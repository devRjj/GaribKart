package com.garibKart.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.garibKart.propertiesfile.ConfigLoader;

public class ProductOperation {
	Connection con = null;
	PreparedStatement pst = null;
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private ConfigLoader config;
	
	public ProductOperation() {
		super();
	}

	public ProductOperation(ConfigLoader config) {
		this.config = config;
        this.dbUrl = config.getProperty("db.url");
        this.dbUsername = config.getProperty("db.username");
        this.dbPassword = config.getProperty("db.password");    
    }
	
	private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public boolean testConnection() {
        try (Connection conn = getConnection()) {
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public void insertData(List<Products> productList) {
		ProductOperation pro = new ProductOperation(this.config);

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established executing insert operation");
			String sqlQuery = "insert into product(pid, pname, description, price, quantity) values (?,?,?,?,?)";
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
			
			pst.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public List<Products> getAllProducts() {
		ProductOperation pro = new ProductOperation(this.config);
		List<Products> productList = new ArrayList<>();

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established showing all products from the database");
			Statement statement = con.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from product");
			while (resultSet.next()) {
				Products product = new Products();
				product.setId(resultSet.getInt("pid"));
				product.setName(resultSet.getString("pname"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				productList.add(product);
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return productList;
	}

	public void updateProduct(Products product) {
		ProductOperation pro = new ProductOperation(this.config);

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established executing insert operation");
			pst = con.prepareStatement("update product set pname=?, description=?, price=?, quantity=? where pid=?");
			
			pst.setString(1, product.getName());
			pst.setString(2, product.getDescription());
			pst.setDouble(3, product.getPrice());
			pst.setInt(4, product.getQuantity());
			pst.setInt(5, product.getId());

			int i = pst.executeUpdate();
			System.out.println("Executed Sucessfully" + i);
			
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteProduct(int productId) {
		ProductOperation pro = new ProductOperation(this.config);

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established executing insert operation");
			pst = con.prepareStatement("delete from product where pid=?");
			
			pst.setInt(1, productId);
			
			pst.executeUpdate();
			
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Products getProductById(int productId) {
		Products product = new Products();

		ProductOperation pro = new ProductOperation(this.config);

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established executing get product by id");
			pst = con.prepareStatement("select * from product where pid=?");
			
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
				product.setPrice(resultSet.getDouble(5));
				double price = product.getPrice();
				System.out.println("Product Price >> " + price);
				product.setQuantity(resultSet.getInt(4));
				int quantity = product.getQuantity();
				System.out.println("Product Quantity Available >> " + quantity);
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public void updateProductQuantity(int productId, int newQuantity) {

		ProductOperation pro = new ProductOperation(this.config);

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established updating product quantity");
			pst = con.prepareStatement("update product set quantity=quantity-? where pid=?");
			pst.setInt(1, newQuantity);
			pst.setInt(2, productId);
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getProductQuantity(int productId) {
		Products product = new Products();
		ProductOperation pro = new ProductOperation(this.config);
		
		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established showing product quantity");
			pst = con.prepareStatement("SELECT quantity FROM product WHERE pid=?");
			pst.setInt(1, productId);
			
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
//				String description = resultSet.getString("description");
//	            product.setDescription(description);
//	            System.out.println(description);
				int quantity = resultSet.getInt("quantity");
	            product.setPrice(quantity);
	            System.out.println("The number of product left is "+quantity);
			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getPriceById(int id) {
		Products product = new Products();

		ProductOperation pro = new ProductOperation(this.config);

		try(Connection con = pro.getConnection();) {
			System.out.println("Connection established getting price information of product");
			pst = con.prepareStatement("select price from product where pid=?");
			pst.setInt(1, id);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {
				double price = resultSet.getDouble("price");
	            product.setPrice(price);
	            System.out.println(price);

			}
			
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public void recordPurchase(int userId, int productId, int quantity, double totalPrice) {
	    String query = "INSERT INTO purchase_history (user_id, product_id, quantity, total_price) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {
	        
	        pstmt.setInt(1, userId);
	        pstmt.setInt(2, productId);
	        pstmt.setInt(3, quantity);
	        pstmt.setDouble(4, totalPrice);
	        
	        pstmt.executeUpdate();
	        
	        System.out.println("Purchase recorded successfully");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void getUserPurchaseHistory(int userId) {
	    String query = "SELECT ph.purchase_id, p.pname, ph.quantity, ph.total_price, ph.purchase_date " +
	                   "FROM purchase_history ph " +
	                   "JOIN product p ON ph.product_id = p.pid " +
	                   "WHERE ph.user_id = ? " +
	                   "ORDER BY ph.purchase_date DESC";

	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setInt(1, userId);
	        ResultSet rs = pstmt.executeQuery();

	        System.out.println("Purchase History for User ID: " + userId);
	        System.out.println("---------------------------------------------------------------------------");
	        System.out.println("Purchase ID | Product Name | Quantity | Total Price | Purchase Date");
	        System.out.println("---------------------------------------------------------------------------");

	        while (rs.next()) {
	            int purchaseId = rs.getInt("purchase_id");
	            String productName = rs.getString("pname");
	            int quantity = rs.getInt("quantity");
	            double totalPrice = rs.getDouble("total_price");
	            String purchaseDate = rs.getString("purchase_date");

	            System.out.println(purchaseId + " | " + productName + " | " + quantity + " | " + totalPrice + " | " + purchaseDate);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
