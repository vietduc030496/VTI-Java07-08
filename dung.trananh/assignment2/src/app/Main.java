package app;

import java.util.ArrayList;
import java.util.Scanner;
import service.DepartmentInput;
import service.EmployeeInput;
import entity.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dung.trananh
 */
public class Main {

	public static void main(String[] args) {

		int choiceNumber = 10;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Department> d = new ArrayList<>();
		int i = -1;
		int ssn = 0;

		while (choiceNumber != 0) {
			System.out.println("1. Input department data from the keyboard");
			System.out.println("2. Input employee data from the keyboard");
			System.out.println("3. Display department");
			System.out.println("4. Display employees");
			System.out.println("5. Classify employees");
			System.out.println("6. Employee Search");
			System.out.println("7. Report");
			System.err.println("0. Exit");
			System.out.println("Please choose: ");
			choiceNumber = scanner.nextInt();

			switch (choiceNumber) {
			case 1:
				Department de = DepartmentInput.Department_Input();
				d.add(de);
				break;
			case 2:
				if (d.size() > 0) {
					System.out.println("Choose department: ");
					String name = scanner.nextLine();
					for (int j = 0; j < d.size(); j++) {
						if (d.get(j).getDepartmentName().equals(name)) {
							ssn += 1;
							EmployeeInput.Employee(d.get(j), ssn);
						}else {
							System.out.println("Don't exist this department");
						}
						
					}
				} else {
					System.out.println("Need to input department first");
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 0:
				System.exit(0);
				break;

			}
		}
	}
}
