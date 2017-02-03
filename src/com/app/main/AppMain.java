package com.app.main;

import java.util.Scanner;

import com.app.modal.User;
import com.app.service.UserService;

public class AppMain {

	public void firstMenu() {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("Enter your username: ");
		user.setUsername(scanner.next());
		System.out.println("Enter your password: ");
		user.setPassword(scanner.next());
		UserService service = new UserService();
		service.login(user);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppMain obj = new AppMain();
		obj.firstMenu();

	}

}
