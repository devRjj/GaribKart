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

	public boolean addUser(User user) {
		String query = "INSERT INTO users (user_id, first_name, last_name, username, user_password, city, email, mobile) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getUserName());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getEmailId());
			pstmt.setString(8, user.getMobNumber());

			int executeUpdate = pstmt.executeUpdate();

			if (executeUpdate == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void displayUsers() {
		String query = "Select * from users";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				System.out.println("User ID" + rs.getInt("user_id"));
				System.out.println("First Name: " + rs.getString("first_Name"));
				System.out.println("Last Name: " + rs.getString("last_Name"));
				System.out.println("City: " + rs.getString("city"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Mobile: " + rs.getLong("mobile"));
				System.out.println("-------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User verifyUsers(String username, String password) {
		System.out.println("verifying the login...");
		String query = "SELECT u.user_id, u.username, r.role_name FROM users u "
				+ "JOIN roles r ON u.role_id = r.role_id " + "WHERE u.username = ? AND u.user_password = ?";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("user_id"));
					user.setUserName(rs.getString("username"));
					user.setRole(rs.getString("role_name"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// If no record is found.
		return null;
	}

	public void insertRole(String roleName) {
		String query = "INSERT INTO roles (role_name) VALUES (?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, roleName);
			pstmt.executeUpdate();

			System.out.println("Role inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void assignRoleToUser(int userId, int roleId) {
		String query = "UPDATE users SET role_id = ? WHERE user_id = ?";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setInt(1, roleId);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();

			System.out.println("Role assigned to user successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		UserConnection uc = new UserConnection(new ConfigLoader("config.properties"));
		uc.assignRoleToUser(1001, 1);
		uc.assignRoleToUser(1002, 2);
		uc.assignRoleToUser(1004, 1);
		uc.assignRoleToUser(1005, 2);
		uc.assignRoleToUser(1006, 2);

	}

}
