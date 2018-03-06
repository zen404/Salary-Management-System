package com.zensar.sps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Processor {
	Scanner in = new Scanner(System.in);
	
	DAO dao = new DAO(); 
	
	
	//displaytest
	
	
	
	
	
	
	// Login
	public void login() throws ClassNotFoundException, SQLException {

		System.out.println("Welcome to 404 Salary Processing System");
		System.out.println("Admin Login:");
		System.out.print("User ID: ");
		int ID = in.nextInt();
		System.out.print("Password: ");
		String password = in.next();
		authenticate(ID, password);

	}
	
	

	// Authentication
	private void authenticate(int iD, String password) throws ClassNotFoundException, SQLException {
		Admin ad = new Admin();
		if (iD == ad.getId() && password.equals(ad.getPassword())) {
			System.out.println("\nLogin Successful..");
			showmenu();
		}

	}

	// Show menu
	private void showmenu() throws ClassNotFoundException, SQLException {
		System.out.println("****************************************");
		System.out.println("*      1: Process Salary               *");
		System.out.println("*      2: Search data                  *");
		System.out.println("*      3: Display Salary Data          *");
		System.out.println("*      4: Exit                         *");
		System.out.println("****************************************");
		System.out.print("\nEnter your choice:");
		int choice = in.nextInt();
		control(choice);

	}

	// Control transfer to functions
	private void control(int choice) throws ClassNotFoundException, SQLException {
		//do {
		switch (choice) {
		case 1:
			// processSalary();
			break;
		case 2:
			dao.searchSalaryData();
			System.out.println("Do you want more: ");
			String ch = in.next();
			if(ch.equals("y")) {
				dao.searchSalaryData();
			}
			else {
				showmenu();
				break;
			}
			
		case 3:
			dao.displaySalaryData();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Sorry wrong choice! Try again");
			showmenu();
			break;
		}
		//}while(choice != 4);

	}
	
	
	

}
