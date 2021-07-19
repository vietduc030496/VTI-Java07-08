
package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;
import service.DepartmentService;
import service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Department> d = new ArrayList<>();
		List<HourlyEmployee> hE = new ArrayList<>();
		List<SalariedEmployee> sE = new ArrayList<>();
		int ssn = 0;
		DepartmentService dep = new DepartmentService();
		EmployeeService emp = new EmployeeService();
		while (true) {
			System.out.println("********************");
			System.out.println("1. Enter/Add department : ");
			System.out.println("2. Display department : ");
			System.out.println("3. Add employee");
			System.out.println("4. Display employee");
			System.out.println("5. Classify employee");
			System.out.println("6. Search : ");
			System.out.println("7. Report : ");
			System.out.println("8. Delete department: ");
			System.out.println("9. Delete employee: ");
			System.out.println("10. Update department: ");
			System.out.println("11. Update employee: ");
			System.out.println("0. Exit!");
			System.out.println("Please pick a number between 0 and 7. Thanks !!");
			System.out.println("******************");
			Scanner in = new Scanner(System.in);
			int chon;
			chon = Integer.parseInt(in.nextLine());
			switch (chon) {
			case 0:
				System.out.println("bye!!!");
				System.exit(0);
			case 1:
				Department dep1 = dep.DepartmentInput();
				d.add(dep1);
				break;
			case 2:
				dep.DisplayDepartment(d);
				break;
			case 3:
				if (d.size() > 0) {
					System.out.println("Choose department: ");
					String name = scanner.nextLine();
					for (int i = 0; i < d.size(); i++) {
						if (d.get(i).getDepartmentName().equals(name)) {
							ssn += 1;
							emp.addEmployee(d.get(i), ssn);
							System.out.println("Add employee successful !!");
						} else {
							System.out.println("Loading... !!");
						}
					}
				} else {
					System.out.println("No department exists! You must enter the department !! ");
				}
				break;
			case 4:
				emp.EmployeeDisplay(d);
				break;
			case 5:
				emp.ClassifyEmployee(d);
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				String dName = scanner.nextLine();
				dep.DeleteDepartment(d, dName);
				break;
			case 9:
				
				ssn = Integer.parseInt(scanner.nextLine());
				try {
				emp.DeleteEmployeeHE(d, String.valueOf(ssn), hE);}
				catch(IndexOutOfBoundsException e) {
					System.out.println(e);
				}
//				emp.DeleteEmployeeSE(sE, String.valueOf(ssn));
				
				break;
			case 10:
				dep.
				break;
			case 11:
				break;
			default:
				System.out.println("chi chon 0->6");
				break;
			}
		}
	}

}
