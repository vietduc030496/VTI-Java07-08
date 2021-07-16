package service;

import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
public class EmployeeSearch {
	public static void EmpSearch(ArrayList<Department> d) {
		int choice = 10;
		Scanner in = new Scanner(System.in);
		while (choice != 0) {
			System.out.println("Select type of search: ");
			System.out.println("-----------------------");
			System.out.println("1. Search by dept name:  ");
			System.out.println("2. Search by emp name:  ");
			System.out.println("0. Exit");
			choice = Integer.parseInt(in.nextLine());
			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 0:
				break;

			}
		}
	}

}
