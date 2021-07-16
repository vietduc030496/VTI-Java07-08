package b2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DepartmentManage {
	public static void main(String[] args) {
		List<  Employee> employees = new ArrayList<>();
		List<Department> departments = new ArrayList<>();
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");

		DepartmentManage departmentManage = new DepartmentManage();
		departmentManage.showMenu();
		Scanner input = new Scanner(System.in);
		boolean isRun = true;
		while (isRun) {

			String type = input.nextLine();
			// input.nextLine();
			switch (type) {
			case "1":
				boolean isInput=true;
				while (isInput) {
					departmentManage.showType();
					type = input.nextLine();
					switch (type) {
					case "1":
						String departmentName="";
						System.out.print("ssn: ");
						String ssn=(input.nextLine());
						System.out.print("firstName:");
						String firstName=(input.nextLine());
						System.out.print("lastName: ");
						String lastName=(input.nextLine());
						System.out.print("birthDate: ");
						boolean validDate=true;
						String birthDate="";
						while(validDate) {
							birthDate=(input.nextLine());
							try {
								Date a=spd.parse(birthDate);
								birthDate= spd.format(a);
								validDate=false;
						     }
						     catch(ParseException e){
						    	 validDate=true;
						    	 System.out.println("invalid date, input birthDate again: ");
						     }
							
						}
						System.out.print("phone: ");
						boolean validPhone=true;
						String phone="";
						while(validPhone) {
							phone=(input.nextLine());
							if(phone.length()>6 && phone.matches("^0[0-9]*")) {
								validPhone=false;
							}else {
								System.out.println("invalid phone, input phone again: ");
							}
						}
						System.out.print("email: ");
						boolean validEmail=true;
						String email="";
						while(validEmail) {
							email=(input.nextLine());
							if(email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
								validEmail=false;
							}else {
								System.out.println("invalid email, input email again: ");
							}
							 
						}
						System.out.print("commissionRate: ");
						String commissionRate="";
						boolean validCommis=true;
						while(validCommis) {
							commissionRate=(input.nextLine());
							try {
								Double.parseDouble(commissionRate);
								validCommis=false;
						     }
						     catch(Exception e){
						    	 validCommis=true;
						    	 System.out.println("invalid validCommis, input validCommis again: ");
						     } 
						}
						System.out.print("grossSales: ");
						String grossSales="";
						boolean validGrossSales=true;
						while(validGrossSales) {
							grossSales=(input.nextLine());
							try {
								Double.parseDouble(grossSales);
								validGrossSales=false;
						     }
						     catch(Exception e){
						    	 validGrossSales=true;
						    	 System.out.println("invalid grossSales, input grossSales again: ");
						     } 
						}
						System.out.print("basicSalary: ");
						String basicSalary="";
						boolean validBasicSalary=true;
						while(validBasicSalary) {
							basicSalary=(input.nextLine());
							try {
								Double.parseDouble(basicSalary);
								validBasicSalary=false;
						     }
						     catch(Exception e){
						    	 validBasicSalary=true;
						    	 System.out.println("invalid validBasicSalary, input validBasicSalary again: ");
						     } 
						}
						
						Employee sala= new SalariedEmployee(ssn, firstName, lastName, birthDate, phone, email, Double.parseDouble(commissionRate), Double.parseDouble(grossSales), Double.parseDouble(basicSalary));
						employees.add(sala);
						System.out.print("departmentName: ");
						departmentName=input.nextLine();
						boolean isExistDepartment=false;
						for(Department dpm: departments) {
							if(dpm.getDepartmentName().equals(departmentName)) {
								dpm.getListOfEmployee().add(sala);
								isExistDepartment=true;
								break;
							}
						}
						if(isExistDepartment==false) {
							Department department= new Department();
							List<Employee> epls= new ArrayList<>();
							department.setDepartmentName(departmentName);
							epls.add(sala);
							department.setListOfEmployee(epls);
							departments.add(department);
						}
						break;
					case "2":
						String departmentName2="";
						System.out.print("ssn: ");
						String ssn2=(input.nextLine());
						System.out.print("firstName:");
						String firstName2=(input.nextLine());
						System.out.print("lastName: ");
						String lastName2=(input.nextLine());
						System.out.print("birthDate: ");
						boolean validDate2=true;
						String birthDate2="";
						while(validDate2) {
							birthDate2=(input.nextLine());
							try {
								Date a=spd.parse(birthDate2);
								birthDate2= spd.format(a);
								validDate2=false;
						     }
						     catch(ParseException e){
						    	 validDate2=true;
						    	 System.out.println("invalid date, input birthDate again: ");
						     }
							
						}
						System.out.print("phone: ");
						boolean validPhone2=true;
						String phone2="";
						while(validPhone2) {
							phone2=(input.nextLine());
							if(phone2.length()>6 && phone2.matches("^0[0-9]*")) {
								validPhone2=false;
							}else {
								System.out.println("invalid phone, input phone again: ");
							}
						}
						System.out.print("email: ");
						boolean validEmail2=true;
						String email2="";
						while(validEmail2) {
							email2=(input.nextLine());
							if(email2.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
								validEmail2=false;
							}else {
								System.out.println("invalid email, input email again: ");
							}
							 
						}
						System.out.print("wage: ");
						String wage="";
						boolean validwage=true;
						while(validwage) {
							wage=(input.nextLine());
							try {
								Double.parseDouble(wage);
								validwage=false;
						     }
						     catch(Exception e){
						    	 validwage=true;
						    	 System.out.println("invalid wage, input wage again: ");
						     } 
						}
						System.out.print("workingHours: ");
						String workingHours="";
						boolean validworkingHours=true;
						while(validworkingHours) {
							workingHours=(input.nextLine());
							try {
								Double.parseDouble(workingHours);
								validworkingHours=false;
						     }
						     catch(Exception e){
						    	 validworkingHours=true;
						    	 System.out.println("invalid workingHours, input workingHours again: ");
						     } 
						}
						Employee hourty= new HourtyEmployee(ssn2, firstName2, lastName2, birthDate2, phone2, email2, Double.parseDouble(wage), Double.parseDouble(workingHours));
						employees.add(hourty);
						System.out.print("departmentName: ");
						departmentName2=input.nextLine();
						boolean isExistDepartment2=false;
						for(Department dpm: departments) {
							if(dpm.getDepartmentName().equals(departmentName2)) {
								dpm.getListOfEmployee().add(hourty);
								isExistDepartment=true;
								break;
							}
						}
						if(isExistDepartment2==false) {
							Department department= new Department();
							List<Employee> epls= new ArrayList<>();
							department.setDepartmentName(departmentName2);
							epls.add(hourty);
							department.setListOfEmployee(epls);
							departments.add(department);
						}
						break;
					case "3":
						isInput=false;
						break;
					default:
						System.out.println("choice again!");
						//departmentManage.showType();
						break;
					}
				}
				departmentManage.showMenu();
				break;
			case "2":
				for(Employee e: employees) {
					e.display();
				}
				System.out.println("");
				System.out.println("");
				departmentManage.showMenu();
				break;
			case "3":
				for(Employee e: employees) {
					if(e instanceof SalariedEmployee) {
						System.out.print("SalariedEmployee: ");
						e.display();
					}else {
						System.out.print("HourtyEmployee: ");
						e.display();
					}
				}
				System.out.println("");
				System.out.println("");
				departmentManage.showMenu();
				break;
			case "4":
				boolean isSearch=true;
				while(isSearch) {
					departmentManage.showSearch();
					type = input.nextLine();
					switch (type) {
					case "1":
						System.out.println("input departmentName:");
						String departmentName= input.nextLine();
						boolean isEmpty=true;
						for(Department department: departments) {
							if(department.getDepartmentName().contains(departmentName)) {
								isEmpty=false;
								System.out.println("employee of departmentName: "+department.getDepartmentName());
								for(Employee e : department.getListOfEmployee()) {
									e.display();
								}
							}
						}
						if(isEmpty) {
							System.out.println("not found departmentName: "+departmentName);
						}
						//departmentManage.showSearch();
						break;
					case "2":
						System.out.println("input employeeName:");
						String employName= input.nextLine();
						isEmpty=true;
						for(Employee e: employees) {
							if(e.getFirstName().contains(employName) || e.getLastName().contains(employName)) {
								isEmpty=false;
								e.display();
							}
						}
						if(isEmpty) {
							System.out.println("not found employeeName: "+employName);
						}
						//departmentManage.showSearch();
						break;
					case "3":
						isSearch=false;
						break;
					default:
						System.out.println("choice again!");
						
						break;
					}
				}
				departmentManage.showMenu();
				break;
			case "5":
				for(Department department: departments) {
					department.display();
					System.out.println("employee of departmentName: " + department.getDepartmentName());
					for(Employee e : department.getListOfEmployee()) {
						e.display();
					}
				}
				departmentManage.showMenu();
				break;
			case "6":
				isRun=false;
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
		System.out.println("1.input Data");
		System.out.println("2.display employees");
		System.out.println("3.classify employees");
		System.out.println("4.employee search");
		System.out.println("5.report");
		System.out.println("6.exit");
		System.out.println("Please choice: ");
	}
	
	public void showType() {
		System.out.println("1.Salaried");
		System.out.println("2.Houtry");
		System.out.println("3.exit");
		System.out.println("Please choice: ");
	}

	public void showSearch() {
		System.out.println("1.department");
		System.out.println("2.employee");
		System.out.println("3.exit");
		System.out.println("Please choice: ");
	}
	public void input() {

	}
}
