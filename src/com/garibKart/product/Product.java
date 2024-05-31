package com.garibKart.product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.garibKart.propertiesfile.ConfigLoader;

public class Product {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Product p = new Product(new ConfigLoader("config.properties"));
        
        // Test connection
        if (p.testConnection()) {
            System.out.println("Connection established successfully.");
        } else {
            System.out.println("Failed to establish connection.");
        }
        
        // Add a product for testing
//        p.addProduct(101, "Test Product", "Test Description", 10, 99.99);
        p.addProduct(102, "Test Product 2", "Test Description", 5, 99.99);
        
        // Show products
        p.showProducts();
    }

    public Product(ConfigLoader config) {
        this.dbUrl = config.getProperty("db.url");
        this.dbUsername = config.getProperty("db.username");
        this.dbPassword = config.getProperty("db.password");
    }

    public Product() {
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

    public void addProduct(int pid, String pname, String description, int quantity, double price) {
        String query = "INSERT INTO product (pid, pname, description, quantity, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setLong(1, pid);
            pstmt.setString(2, pname);
            pstmt.setString(3, description);
            pstmt.setInt(4, quantity);
            pstmt.setDouble(5, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showProducts() {
        String query = "SELECT * FROM product";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("pid"));
                System.out.println("Name: " + rs.getString("pname"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
