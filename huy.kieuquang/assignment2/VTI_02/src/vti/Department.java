package vti;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Department {
	private String departmentName;
	private List<Employee> listOfEmployee;
	
	public Department() {
		
	}
	
	

	public Department(String departmentName, List<Employee> listOfEmployee) {
		this.departmentName = departmentName;
		this.listOfEmployee = listOfEmployee;
	}



	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public String display() {
		return "Department [departmentName=" + departmentName + "]";
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		// init department
		List<Department> listDp = new ArrayList<>();
		
		List<Employee> listEm1 = new ArrayList<>();
		Department d1 = new Department("d1", listEm1);
		d1.setListOfEmployee(listEm1);
		
		List<Employee> listEm2 = new ArrayList<>();
		Department d2 = new Department("d2", listEm2);
		d2.setListOfEmployee(listEm2);
		
		List<Employee> listEm3 = new ArrayList<>();
		Department d3 = new Department("d3", listEm3);
		d3.setListOfEmployee(listEm3);
		
		listDp.add(d1);
		listDp.add(d2);
		listDp.add(d3);
		
		boolean exit = false;
		
		while (exit == false) {
			System.out.println("----------Menu-----------");
			System.out.println("1.Create employee");
			System.out.println("2.Display employee");
			System.out.println("3.Classify employee");
			System.out.println("4.Search employee");
			System.out.println("5.Report ");
			System.out.println("-------------------------");
			System.out.print("Choose your action: ");
			
			int x = sc.nextInt();
			switch (x) {
			case 0:{
				exit = true;
				break;
			}
			case 1: {
				Employee em = null;
				
				System.out.println("1=salariedEm ---- 2=HourlyEm");
				System.out.print("Type employee: ");
				int type = sc.nextInt();
				
				System.out.print("Ssn: ");
				String ssn = sc.next();
				System.out.print("FirstName: ");
				String firstName = sc.next();
				System.out.print("LastName: ");
				String lastName = sc.next();
				
				System.out.print("Birthday: ");
				String birthDate = "";
				while(validateBrithday(birthDate)==false) {
					birthDate = sc.next();
				}
				
				
				System.out.print("Phone: ");
				String phone = "";
				while(validatePhone(phone)==false) {
					phone = sc.next();
					if(validatePhone(phone)==false) System.out.println("Phone is not valid");
				}
				
				
				System.out.print("Email: ");
				String email = "";
				while(validateEmail(email)==false) {
					email = sc.next();
					if(validateEmail(email)==false) System.out.println("Email is not valid");
				}
				
				
				if(type==1) {
					
					System.out.print("CommisionRate: ");
					double commissionRate = sc.nextDouble();
					System.out.print("GrossSales: ");
					double grossSales = sc.nextDouble();
					System.out.print("BasicSalary: ");
					double basicSalary = sc.nextDouble();
					 
					em = new SalariedEmployee(ssn, firstName, lastName, birthDate, phone, email, commissionRate, grossSales, basicSalary);
					
					
				}else {					
					System.out.print("Wage: ");
					double wage = sc.nextDouble();
					System.out.print("workingHours: ");
					double workingHours = sc.nextDouble();
					
					em = new HourlyEmployee(ssn, firstName, lastName, birthDate, phone, email, wage, workingHours);
					
				}
				
				System.out.print("List Department: ");	
				for (Department dp : listDp) {
					System.out.print(dp.getDepartmentName()+" ");
				}
				System.out.println();
				System.out.print("DepartmentName: ");
				String deptName = sc.next();
				
				if(deptName.equals("d1")) {
					listEm1.add(em);
				}else if(deptName.equals("d2")){
					listEm2.add(em);
				}else if(deptName.equals("d3")){
					listEm3.add(em);
				}else {
					List<Employee> listEm = new ArrayList<>();
					Department d = new Department(deptName, listEm);
					d.setListOfEmployee(listEm);
					
					listEm.add(em);
					listDp.add(d);
				}
				
				break;
			}
			case 2: {
				System.out.print("List Department: ");	
				for (Department dp : listDp) {
					System.out.print(dp.getDepartmentName()+" ");
				}
				System.out.println();
				
				System.out.print("DepartmentName: ");
				String dpName = sc.next();
				
				for (Department dp : listDp) {
					if(dpName.equals(dp.getDepartmentName())) {
						for (Employee employee : dp.getListOfEmployee()) {
							System.out.println(employee.display());
						}
					}
				}
				
				break;
			}
			case 3: {
				for (Department dp : listDp) {
					System.out.println(dp.departmentName);
					for (Employee e : dp.getListOfEmployee()) {
						System.out.println("Employee: "+e.getLastName()+" "+e.getClass().getName());
					}
				}
				
				System.out.println("-------------------------");
				break;
			}
			case 4: {
				System.out.print("List Department: ");	
				for (Department dp : listDp) {
					System.out.print(dp.getDepartmentName()+" ");
				}
				System.out.println();
				
				System.out.print("Name department: ");
				String nameDp = sc.next();
				System.out.print("Name employee: ");
				String nameEm = sc.next();
				
				for (Department dp : listDp) {
					if(nameDp.equals(dp.getDepartmentName())) {
						for (Employee employee : dp.getListOfEmployee()) {
							if(employee.getLastName().equals(nameEm)) {
								employee.display();
							}
						}
					}
				}
				
				
				System.out.println("-------------------------");			
				break;
			}
			case 5: {
				for (Department dp : listDp) {
					System.out.println(dp.getDepartmentName()+" "+dp.getListOfEmployee().size());
				}
				System.out.println("-------------------------");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
		}
		
	}
	
	
	public static boolean validateBrithday(String strDate) {
		if(strDate.trim().equals("")) {
			return false;
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			
			try {
				// valid format
				Date date = sdf.parse(strDate);
				
			}catch (ParseException e) {
				System.out.println(strDate+ " is not valid format");
				return false;
			}
			
			return true;
		}
	}
	
	public static boolean validatePhone(String phone) {
		String phoneRegex = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
		return phone.matches(phoneRegex);
	}
	
	public static boolean validateEmail(String email) {
		String emailParttern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		return email.matches(emailParttern);
	}
}
