package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.modal.User;

public class UserDaoImpl implements UserDao {

	Connection conn = null;
	ResultSet res = null;
	PreparedStatement ps = null;
	String user = "root";
	String password = "";
	String url = "jdbc:mysql://localhost:3306/ittraining";

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public User login(User user) {
		User user1 = new User();
		String query = "select * from user where username=? and password=?";
		try {
			ps = getConnection().prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			res = ps.executeQuery();
			while (res.next()) {
				user1.setUsername(res.getString("username"));
				user1.setRole(res.getString("role"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user1;
	}

}
