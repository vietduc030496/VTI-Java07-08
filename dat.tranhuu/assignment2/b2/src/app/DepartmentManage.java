package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import entity.SalariedEmployee;
import service.DepartmentSerive;
import service.EmployeeService;

public class DepartmentManage {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		List<Department> departments = new ArrayList<>();
		DepartmentManage departmentManage = new DepartmentManage();
		departmentManage.showMenu();
		Scanner input = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService(input);
		DepartmentSerive departmentSerive = new DepartmentSerive(input);
		boolean isRun = true;
		while (isRun) {

			String type = input.nextLine();
			// input.nextLine();
			switch (type) {
			case "1":
				boolean isInput = true;
				while (isInput) {
					departmentManage.showType();
					type = input.nextLine();
					switch (type) {
					case "1":
						Employee sala = employeeService.inputSala();
						employees.add(sala);
						System.out.print("departmentName: ");
						String departmentName = input.nextLine();
						boolean isExistDepartment = false;
						for (Department dpm : departments) {
							if (dpm.getDepartmentName().equals(departmentName)) {
								dpm.getListOfEmployee().add(sala);
								isExistDepartment = true;
								break;
							}
						}
						if (isExistDepartment == false) {
							Department department = new Department();
							List<Employee> epls = new ArrayList<>();
							department.setDepartmentName(departmentName);
							epls.add(sala);
							department.setListOfEmployee(epls);
							departments.add(department);
						}
						break;
					case "2":
						Employee hourty = employeeService.inputHourty();
						employees.add(hourty);
						System.out.print("departmentName: ");
						String departmentName2 = input.nextLine();
						boolean isExistDepartment2 = false;
						for (Department dpm : departments) {
							if (dpm.getDepartmentName().equals(departmentName2)) {
								dpm.getListOfEmployee().add(hourty);
								isExistDepartment2 = true;
								break;
							}
						}
						if (isExistDepartment2 == false) {
							Department department = new Department();
							List<Employee> epls = new ArrayList<>();
							department.setDepartmentName(departmentName2);
							epls.add(hourty);
							department.setListOfEmployee(epls);
							departments.add(department);
						}
						break;
					case "3":
						isInput = false;
						break;
					default:
						System.out.println("choice again!");
						break;
					}
				}
				departmentManage.showMenu();
				break;
			case "2":
				for (Employee e : employees) {
					e.display();
				}
				System.out.println("");
				System.out.println("");
				departmentManage.showMenu();
				break;
			case "3":
				for (Employee e : employees) {
					if (e instanceof SalariedEmployee) {
						System.out.print("SalariedEmployee: ");
						e.display();
					} else {
						System.out.print("HourtyEmployee: ");
						e.display();
					}
				}
				System.out.println("");
				System.out.println("");
				departmentManage.showMenu();
				break;
			case "4":
				boolean isSearch = true;
				while (isSearch) {
					departmentManage.showSearch();
					type = input.nextLine();
					switch (type) {
					case "1":
						System.out.println("input departmentName:");
						String departmentName = input.nextLine();
						departmentSerive.searchNameDepart(departmentName, departments);
						break;
					case "2":
						System.out.println("input employeeName:");
						String employName = input.nextLine();
						employeeService.searchEmployee(employName, employees);
						break;
					case "3":
						isSearch = false;
						break;
					default:
						System.out.println("choice again!");
						break;
					}
				}
				departmentManage.showMenu();
				break;
			case "5":
				boolean isExist = false;
				System.out.println("input ssn:");
				String ssn = input.nextLine();
				try {
					Long.parseLong(ssn);
					Employee update=null;
					for (Employee e : employees) {
						if (e.getSsn() == Long.parseLong(ssn)) {
							update = employeeService.update(e);
							isExist = true;
							System.out.println("update success:");
							break;
						}
					}
					if(isExist==true) {
						Iterator<Employee> iter = employees.iterator();
						while (iter.hasNext()) {
							if (Long.parseLong(ssn) == iter.next().getSsn()) {
								iter.remove();
								isExist = true;
							}
						}
						employees.add(update);
						for (Department de : departments) {
							if (de.getListOfEmployee().size() > 0) {
								iter = de.getListOfEmployee().iterator();
								while (iter.hasNext()) {
									if (Long.parseLong(ssn) == iter.next().getSsn()) {
										iter.remove();
										de.getListOfEmployee().add(update);
										isExist = true;
										break;
									}
								}
							}
						}
					}
					if (isExist == false) {
						System.out.println("not found employee:");
					}
				} catch (Exception e) {
					System.out.println("not found employee:");
				}
				departmentManage.showMenu();
				break;
			case "6":
				isExist = false;
				System.out.println("input ssn:");
				ssn = input.nextLine();
				try {
					Long.parseLong(ssn);
					Iterator<Employee> iter = employees.iterator();
					while (iter.hasNext()) {
						if (Long.parseLong(ssn) == iter.next().getSsn()) {
							iter.remove();
							isExist = true;
						}
					}
					for (Department de : departments) {
						if (de.getListOfEmployee().size() > 0) {
							iter = de.getListOfEmployee().iterator();
							while (iter.hasNext()) {
								if (Long.parseLong(ssn) == iter.next().getSsn()) {
									iter.remove();
									isExist = true;
								}
							}
						}
					}
					if (isExist == false) {
						System.out.println("not found employee:");
					}
					if (isExist == true) {
						System.out.println("delete employee success:");
					}
				} catch (Exception e) {
					System.out.println("not found employee:");
				}
				departmentManage.showMenu();
				break;
			case "7":
				
				boolean isExistDepartment = false;
				while (isExistDepartment == false) {
					boolean temp=false;
					System.out.print("departmentName: ");
					String departmentName = input.nextLine();
					for (Department dpm : departments) {
						if (dpm.getDepartmentName().equals(departmentName)) {
							System.out.println("departmentName is exist input again: ");
							temp=true;
							break;
						}
					}
					if (temp == false) {
						Department department = departmentSerive.input(departmentName);
						departments.add(department);
						isExistDepartment = true;
						System.out.println("departmentName add success: ");
					}
				}
				departmentManage.showMenu();
				break;
			case "8":
				for (Department dpm : departments) {
					dpm.display();
				}
				departmentManage.showMenu();
				break;
			case "9":
				for (Department department : departments) {
					department.display();
					System.out.println("employee of departmentName: " + department.getDepartmentName());
					for (Employee e : department.getListOfEmployee()) {
						e.display();
					}
				}
				departmentManage.showMenu();
				break;
			case "10":
				isRun = false;
				System.out.println("bye!");
				break;
			default:
				System.out.println("choice again!");
				departmentManage.showMenu();
				break;
			}

		}

		input.close();
	}

	public void showMenu() {
		System.out.println("================================================================");
		System.out.println("1.input Data");
		System.out.println("2.display employees");
		System.out.println("3.classify employees");
		System.out.println("4.employee search");
		System.out.println("5.update employee");
		System.out.println("6.delete employee");
		System.out.println("7.input department");
		System.out.println("8.show department");
		System.out.println("9.report");
		System.out.println("10.exit");
		System.out.println("Please choice: ");
	}

	public void showType() {
		System.out.println("================================================================");
		System.out.println("1.Salaried");
		System.out.println("2.Houtry");
		System.out.println("3.exit");
		System.out.println("Please choice: ");
	}

	public void showSearch() {
		System.out.println("================================================================");
		System.out.println("1.department");
		System.out.println("2.employee");
		System.out.println("3.exit");
		System.out.println("Please choice: ");
	}

	public void input() {

	}
}
