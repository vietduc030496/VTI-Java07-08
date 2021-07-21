package ex_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ex_01.Book;

public class EmployeeTest {
	public List<Employee> generateEmployee() {
		Scanner s = new Scanner(System.in);
		List<Employee> emps = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			Employee emp = new Employee();
			System.out.println("Enter employee information: first name, last name and monthly salary:");
			emp.setFirstName(s.nextLine());
			emp.setLastName(s.nextLine());
			emp.setMonthSalary(s.nextDouble());
			s.nextLine();
			emps.add(emp);
		}
		
		for(Employee e : emps) {
			System.out.println("Yearly salary of " + e.getLastName() + ": "  + e.getYearlySalary());
			System.out.println("After raise: " + e.getYearlySalary() * 1.1);
		}
		
		return emps;
	}
	public static void main(String[] args) {
		EmployeeTest empTest = new EmployeeTest();
		empTest.generateEmployee();
		
	}
}
