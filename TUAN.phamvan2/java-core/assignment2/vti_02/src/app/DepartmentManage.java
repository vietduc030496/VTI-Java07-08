package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import service.Execute;

public class DepartmentManage {
	public static void main(String[] args) {
		String choiceNumber = null;
		Scanner s = new Scanner(System.in);
		Employee emp = new Employee();
		Department dpm = new Department();
		Execute ex = new Execute();
		boolean flag = true;
		for (;;) {
			while (flag) {
				System.out.println("1. Input data from the keyboard");
				System.out.println("2. Display departments");
				System.out.println("3. Display employees");
				System.out.println("4. Update employee");
				System.out.println("5. Delete employee");
				System.out.println("6. Classify employees");
				System.out.println("7. Search employees by department name");
				System.out.println("8. Search employees by name");
				System.out.println("9. Report");
				System.out.println("10. Exit");
				System.out.println("Select a function: ");
				choiceNumber = s.nextLine();

				switch (choiceNumber) {
				case "1":
					String type = "";
					while (true) {
						System.out.print("Salaried employee (SE) or Hourly employee (HE)? ");
						type = s.nextLine().toUpperCase();
						if (type.equals("SE")) {
							ex.inputSE();
							break;
						} else if (type.equals("HE")) {
							ex.inputHE();
							break;
						} else {
							System.err.println("Enter again!");
						}
					}
				case "2":
					ex.displayD();
					break;
				case "3":
					ex.displayE();
					break;
				case "4":
					String ssn = "";
					System.out.print("Enter ssn you want to update: ");
					ssn = s.nextLine();
					ex.updateE(ssn);
					break;
				case "5":
					String ssn1 = "";
					System.out.print("Enter ssn you want to delete: ");
					ssn1 = s.nextLine();
					ex.deleteE(ssn1);
					break;
				case "6":
					ex.classify();
					break;
				case "7":
					String departmentName = "";
					System.out.print("Enter department name you want to find: ");
					departmentName = s.nextLine();
					ex.searchByDepartment(departmentName);
					break;
				case "8":
					String lastName = "";
					System.out.print("Enter employee name you want to find: ");
					lastName = s.nextLine();
					ex.searchByName(lastName);
					break;
				case "9":
					ex.report();
					break;
				case "10":
					flag = false;
					System.out.println("See ya!");
					System.exit(0);
					break;
				default:
					System.err.println("Wrong number. Enter again!");
				}
			}

		}
	}
}
