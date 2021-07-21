package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;
import services.DepartmentService;
import services.EmployeeService;
import utils.Validate;

public class Process {
	private EmployeeService emService;
	private DepartmentService depService;
	private Validate validate;

	public void run() {
		emService = new EmployeeService();
		depService = new DepartmentService();
		validate = new Validate();

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

		emService.initEmployee(listDp, d1, d2, d3, listEm1, listEm2, listEm3);

		boolean exit = false;
		while (exit == false) {
			System.out.println("----------Menu-----------");
			System.out.println("0.Exit");
			System.out.println("1.Create employee");
			System.out.println("2.Display employee");
			System.out.println("3.Classify employee");
			System.out.println("4.Search employee");
			System.out.println("5.Report ");
			System.out.println("6.Delete employee ");
			System.out.println("-------------------------");
			System.out.print("Choose your action: ");

			int x = sc.nextInt();
			switch (x) {
			case 0: {
				exit = true;
				break;
			}
			case 1: {
				Employee e = null;
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
				while (validate.validateBrithday(birthDate) == false) {
					birthDate = sc.next();
				}

				System.out.print("Phone: ");
				String phone = "";
				while (validate.validatePhone(phone) == false) {
					phone = sc.next();
					if (validate.validatePhone(phone) == false)
						System.out.println("Phone is not valid");
				}

				System.out.print("Email: ");
				String email = "";
				while (validate.validateEmail(email) == false) {
					email = sc.next();
					if (validate.validateEmail(email) == false)
						System.out.println("Email is not valid");
				}

				// split type employee
				if (type == 1) {
					System.out.print("CommisionRate: ");
					double commissionRate = sc.nextDouble();
					System.out.print("GrossSales: ");
					double grossSales = sc.nextDouble();
					System.out.print("BasicSalary: ");
					double basicSalary = sc.nextDouble();
					e = new SalariedEmployee(ssn, firstName, lastName, birthDate, phone, email, commissionRate,
							grossSales, basicSalary);
				} else {
					System.out.print("Wage: ");
					double wage = sc.nextDouble();
					System.out.print("workingHours: ");
					double workingHours = sc.nextDouble();
					e = new HourlyEmployee(ssn, firstName, lastName, birthDate, phone, email, wage, workingHours);
				}

				System.out.print("List Department: ");
				for (Department dp : listDp) {
					System.out.print(dp.getDepartmentName() + " ");
				}
				System.out.println();
				System.out.print("DepartmentName: ");
				String deptName = sc.next();

				if (deptName.equals("d1")) {
					listEm1.add(e);
				} else if (deptName.equals("d2")) {
					listEm2.add(e);
				} else if (deptName.equals("d3")) {
					listEm3.add(e);
				} else {
					List<Employee> listEm = new ArrayList<>();
					Department d = new Department(deptName, listEm);
					d.setListOfEmployee(listEm);
					listEm.add(e);
					listDp.add(d);
					System.out.println("New department added");
				}
				break;
			}
			case 2: {
				System.out.print("List Department: ");
				for (Department dp : listDp) {
					System.out.print(dp.getDepartmentName() + " ");
				}
				System.out.println();
				System.out.print("DepartmentName: ");
				String dpName = sc.next();

				emService.displayEm(listDp, dpName);

				break;
			}
			case 3: {
				depService.classify(listDp);
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
				
				emService.search(listDp, nameDp, nameEm);
				break;
			}
			case 5: {
				depService.report(listDp);
				break;
			}
			case 6: {
				System.out.print("Enter ssn: ");
				String ssn = sc.next();
				emService.deleteBySsn(listDp, ssn);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
		}
		
		sc.close();
	}
}
