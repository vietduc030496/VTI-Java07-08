package com.vti.jdbc.app;
import java.sql.SQLException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


import com.vti.jdbc.service.StudentService;



public class app {
	private static Scanner scanner;
	public static void main(String[] args) throws SQLException, AddressException, MessagingException {
		scanner = new Scanner(System.in);
		StudentService stuService = new StudentService(); 
		while (true) {
			System.out.println("********************");
			System.out.println("1. Insert student : ");
			System.out.println("2. Display list student : ");
			System.out.println("3. Display number of student in class :");
			System.out.println("4. Display transcript :");
			System.out.println("5. Count student and information of student:");
			System.out.println("6. Min score : ");
			System.out.println("7. Top 5 score : ");
			System.out.println("8. Average score : ");
			System.out.println("9. Tuition: ");
			System.out.println("0. Exit!");
			System.out.println("Please pick a number between 0 and 9. Thanks !!");
			System.out.println("******************");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 0:
				System.out.println("bye!!!");
				System.exit(0);
			case 1:
				stuService.insertStudent();
				break;
			case 2:
				stuService.displayStudent();
				break;
			case 3:
				stuService.displayNumberStudent();
				break;
			case 4:
				stuService.displayStudentTranscript();
				break;
			case 5:
				stuService.displayCountStudentEachClass();
				stuService.displayStudentEachClass();
				break;
			case 6:
				stuService.displayMinScore();
				break;
			case 7:
				stuService.displayFiveMaxScore();
				break;
			case 8:
				stuService.displayAvgScore();
				break;
			case 9:
				stuService.calcTuision();
				break;
			default:
				System.out.println("Try again. Please pick a number between 0 and 9 !!!!!!");
				break;
			}
		}
	}

}
