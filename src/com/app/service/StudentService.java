package com.app.service;

import java.util.List;

import com.app.dao.StudentDao;
import com.app.dao.StudentDaoImpl;
import com.app.modal.Student;

public class StudentService {

	public void getAllStudent() {
		StudentDao studentdao = new StudentDaoImpl();
		List<Student> getstudent = studentdao.getallStudents();
		for (Student student : getstudent) {
			System.out.println("++++++++++++++++++++++++++++++++++");
			System.out.println("Name: " + student.getName());
			System.out.println("Address: " + student.getAddress());
			System.out.println("+++++++++++++++++++++++++++++++++++");
		}
	}

}
