package vti.exercise1.app;

import java.util.*;
import vti.exercise1.entity.*;

public class DepartmentManage {

	public static void initDepartment(List<Department> listDepartment) {
		Department sanam = new Department("SANNAM");
		Department ac = new Department("AC");
		Department p1 = new Department("P1");
		Department p2 = new Department("P2");
		listDepartment.add(sanam);
		listDepartment.add(ac);
		listDepartment.add(p1);
		listDepartment.add(p2);
	}

	public static void initEmployee(List<Employee> listEmployee) {
		SalariedEmployee duong = new SalariedEmployee("0", "Duong", "Hoang", 10, 10, 10);
		SalariedEmployee duong1 = new SalariedEmployee("1", "Trang", "Hoang", 200, 20, 20);
		SalariedEmployee duong2 = new SalariedEmployee("2", "Alex", "Hoang", 440, 40, 40);
		HourlyEmployee duong3 = new HourlyEmployee("3", "Brush", "Hoang", 50, 550);
		HourlyEmployee duong4 = new HourlyEmployee("4", "Flanky", "Hoang", 650, 50);
		HourlyEmployee duong5 = new HourlyEmployee("5", "Abstract", "Hoang", 150, 1550);
		listEmployee.add(duong);
		listEmployee.add(duong1);
		listEmployee.add(duong2);
		listEmployee.add(duong3);
		listEmployee.add(duong4);
		listEmployee.add(duong5);
		Collections.sort(listEmployee);
	}

	public static void joinEmployeeIntoDeparment(List<Department> listDepartment, List<Employee> listEmployee) {
		int index = 1;
		Random generator = new Random();
		for (Employee e : listEmployee) {
			if(index++%2 == 0) {
				listDepartment.get(0).getListOfEmployee().add(e);
				Collections.sort(listDepartment.get(0).getListOfEmployee());
			}else {
				int random= generator.nextInt(4);
				listDepartment.get(random).getListOfEmployee().add(e);
				Collections.sort(listDepartment.get(random).getListOfEmployee());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> listEmployee = new ArrayList<Employee>();
		List<Department> listDepartment = new ArrayList<Department>();
		initEmployee(listEmployee);
		initDepartment(listDepartment);
		joinEmployeeIntoDeparment(listDepartment, listEmployee);
		Controller controller = new Controller(listEmployee, listDepartment);
	}

}
