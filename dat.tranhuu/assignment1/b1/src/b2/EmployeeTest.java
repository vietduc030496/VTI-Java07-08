package b2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee employee1= new Employee("tran", "dat", 15000);
		Employee employee2= new Employee("pham", "tuan", 10000);
		
		List<Employee> employees= new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		
		for(Employee employee:employees) {
			System.out.println(employee.getSalary());
		}
		for(Employee employee:employees) {
			System.out.println(employee.getSalaryOfYear());
		}
		
		
	}
}
