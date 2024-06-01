package com.garibKart.registration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.garibKart.propertiesfile.*;

public class UserConnection {
	
		private String dbUrl;
	    private String dbUsername;
	    private String dbPassword;
	    
	

	
	public UserConnection(ConfigLoader config) {
	       	this.dbUrl = config.getProperty("db.url");
	        this.dbUsername = config.getProperty("db.username");
	        this.dbPassword = config.getProperty("db.password");
	}
	
	public UserConnection() {}
	
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
	  
	    public void addUser(User user) {
	        String query = "INSERT INTO users (firstName, lastName, username, password, city, email, mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        try (Connection con = getConnection();
	             PreparedStatement pstmt = con.prepareStatement(query)) {
	             
	            pstmt.setString(1, user.getFirstName());
	            pstmt.setString(2, user.getLastName());
	            pstmt.setString(3, user.getUserName());
	            pstmt.setString(4, user.getPassword());
	            pstmt.setString(5, user.getCity());
	            pstmt.setString(6, user.getEmailId());
	            pstmt.setString(7, user.getMobNumber());
	      
	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void displayUsers() {
	    	String query = "Select * from users";
	    	 try (Connection conn = getConnection(); 
	                 PreparedStatement pstmt = conn.prepareStatement(query); 
	                 ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                    System.out.println("User ID" + rs.getInt("id"));
	                    System.out.println("First Name: " + rs.getString("firstName"));
	                    System.out.println("Last Name: " + rs.getString("lastName"));
	                    System.out.println("City: " + rs.getString("city"));
	                    System.out.println("Email: " + rs.getInt("email"));
	                    System.out.println("Mobile: " + rs.getDouble("mobile"));
	                    System.out.println("-------------------");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	    }
	
	public static void main(String[] args)throws FileNotFoundException,IOException {
		UserConnection uc = new UserConnection(new ConfigLoader("config.properties"));
		
		 
        // Test connection
        if (uc.testConnection()) {
            System.out.println("Connection established successfully.");
        } else {
            System.out.println("Failed to establish connection.");
        }
        
        // Add a user
          User user = new User();
          uc.addUser( user);
        
        // Display user
         uc.displayUsers();
		
	}

	
}
