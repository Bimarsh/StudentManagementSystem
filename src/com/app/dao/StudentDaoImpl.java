package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.modal.Student;

public class StudentDaoImpl implements StudentDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	String user = "root";
	String password = "";
	String url = "jdbc:mysql://localhost:3306/ittraining";

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public List<Student> getallStudents() {
		List<Student> studentsList = new ArrayList<Student>();

		String query = "select * from student";
		try {
			ps = getConnection().prepareStatement(query);
			res = ps.executeQuery();
			while (res.next()) {
				Student student = new Student();
				student.setName(res.getString("name"));
				student.setAddress(res.getString("address"));
				// student.setSurname(res.getString("surname"));
				studentsList.add(student);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentsList;
	}

}
