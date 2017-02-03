package com.app.service;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.main.AppMain;
import com.app.modal.User;

public class UserService {

	public void login(User user) {
		UserDao dao = new UserDaoImpl();
		User user1 = dao.login(user);
		if (user1.getUsername() == null) {
			System.out.println("Inavalid username and password");
			AppMain app = new AppMain();
			app.firstMenu();
		} else {
			System.out.println("Welcome: " + user1.getUsername());
			StudentService service = new StudentService();
			service.getAllStudent();

		}
	}

}
