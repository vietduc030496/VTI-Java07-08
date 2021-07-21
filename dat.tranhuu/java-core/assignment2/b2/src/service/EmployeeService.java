package service;

import java.util.List;
import java.util.Scanner;

import entity.Employee;
import entity.HourtyEmployee;
import entity.SalariedEmployee;
import util.ValidUtil;

public class EmployeeService {

	private Scanner input;

	public EmployeeService(Scanner input) {
		super();
		this.input = input;
	}

	public Employee inputSala() {
		System.out.print("firstName:");
		String firstName = (input.nextLine());
		System.out.print("lastName: ");
		String lastName = (input.nextLine());
		System.out.print("birthDate: ");
		boolean validDate = false;
		String birthDate = "";
		while (validDate == false) {
			birthDate = (input.nextLine());
			validDate = ValidUtil.validDate(birthDate);
			if (validDate == false) {
				System.out.println("invalid date, input birthDate again: ");
			}

		}
		System.out.print("phone: ");
		boolean validPhone = false;
		String phone = "";
		while (validPhone == false) {
			phone = (input.nextLine());
			validPhone = ValidUtil.validPhone(phone);
			if (validPhone == false) {
				System.out.println("invalid phone, input phone again: ");
			}
		}
		System.out.print("email: ");
		boolean validEmail = false;
		String email = "";
		while (validEmail == false) {
			email = (input.nextLine());
			validEmail = ValidUtil.validEmail(email);
			if (validEmail == false) {
				System.out.println("invalid email, input email again: ");
			}
		}
		System.out.print("commissionRate: ");
		String commissionRate = "";
		boolean validCommis = false;
		while (validCommis == false) {
			commissionRate = (input.nextLine());
			validCommis = ValidUtil.validDouble(commissionRate);
			if (validCommis == false) {
				System.out.println("invalid validCommis, input validCommis again: ");
			}
		}
		System.out.print("grossSales: ");
		String grossSales = "";
		boolean validGrossSales = false;
		while (validGrossSales == false) {
			grossSales = (input.nextLine());
			validGrossSales = ValidUtil.validDouble(grossSales);
			if (validGrossSales == false) {
				System.out.println("invalid grossSales, input grossSales again: ");
			}
		}
		System.out.print("basicSalary: ");
		String basicSalary = "";
		boolean validBasicSalary = false;
		while (validBasicSalary == false) {
			basicSalary = (input.nextLine());
			validBasicSalary = ValidUtil.validDouble(basicSalary);
			if (validBasicSalary == false) {
				System.out.println("invalid validBasicSalary, input validBasicSalary again: ");
			}
		}

		Employee sala = new SalariedEmployee(firstName, lastName, birthDate, phone, email,
				Double.parseDouble(commissionRate), Double.parseDouble(grossSales), Double.parseDouble(basicSalary));
		return sala;
	}

	public Employee inputHourty() {
		System.out.print("firstName:");
		String firstName = (input.nextLine());
		System.out.print("lastName: ");
		String lastName = (input.nextLine());
		System.out.print("birthDate: ");
		boolean validDate = false;
		String birthDate = "";
		while (validDate == false) {
			birthDate = (input.nextLine());
			validDate = ValidUtil.validDate(birthDate);
			if (validDate == false) {
				System.out.println("invalid date, input birthDate again: ");
			}

		}
		System.out.print("phone: ");
		boolean validPhone = false;
		String phone = "";
		while (validPhone == false) {
			phone = (input.nextLine());
			validPhone = ValidUtil.validPhone(phone);
			if (validPhone == false) {
				System.out.println("invalid phone, input phone again: ");
			}
		}
		System.out.print("email: ");
		boolean validEmail = false;
		String email = "";
		while (validEmail == false) {
			email = (input.nextLine());
			validEmail = ValidUtil.validEmail(email);
			if (validEmail == false) {
				System.out.println("invalid email, input email again: ");
			}
		}
		System.out.print("wage: ");
		String wage = "";
		boolean validCommis = false;
		while (validCommis == false) {
			wage = (input.nextLine());
			validCommis = ValidUtil.validDouble(wage);
			if (validCommis == false) {
				System.out.println("invalid wage, input wage again: ");
			}
		}
		System.out.print("workingHours: ");
		String workingHours = "";
		boolean validGrossSales = false;
		while (validGrossSales == false) {
			workingHours = (input.nextLine());
			validGrossSales = ValidUtil.validDouble(workingHours);
			if (validGrossSales == false) {
				System.out.println("invalid workingHours, input workingHours again: ");
			}
		}

		Employee hourty = new HourtyEmployee(firstName, lastName, birthDate, phone, email, Double.parseDouble(wage),
				Double.parseDouble(workingHours));
		return hourty;
	}

	public void searchEmployee(String name, List<Employee> list) {
		boolean isEmpty = true;
		for (Employee e : list) {
			if (e.getFirstName().contains(name) || e.getLastName().contains(name)) {
				isEmpty = false;
				e.display();
			}
		}
		if (isEmpty) {
			System.out.println("not found employeeName: " + name);
		}
	}

	public Employee update(Employee e) {
		if (e instanceof SalariedEmployee) {
			System.out.print("firstName:");
			String firstName = (input.nextLine());
			System.out.print("lastName: ");
			String lastName = (input.nextLine());
			System.out.print("birthDate: ");
			boolean validDate = false;
			String birthDate = "";
			while (validDate == false) {
				birthDate = (input.nextLine());
				validDate = ValidUtil.validDate(birthDate);
				if (validDate == false) {
					System.out.println("invalid date, input birthDate again: ");
				}

			}
			System.out.print("phone: ");
			boolean validPhone = false;
			String phone = "";
			while (validPhone == false) {
				phone = (input.nextLine());
				validPhone = ValidUtil.validPhone(phone);
				if (validPhone == false) {
					System.out.println("invalid phone, input phone again: ");
				}
			}
			System.out.print("email: ");
			boolean validEmail = false;
			String email = "";
			while (validEmail == false) {
				email = (input.nextLine());
				validEmail = ValidUtil.validEmail(email);
				if (validEmail == false) {
					System.out.println("invalid email, input email again: ");
				}
			}
			System.out.print("commissionRate: ");
			String commissionRate = "";
			boolean validCommis = false;
			while (validCommis == false) {
				commissionRate = (input.nextLine());
				validCommis = ValidUtil.validDouble(commissionRate);
				if (validCommis == false) {
					System.out.println("invalid validCommis, input validCommis again: ");
				}
			}
			System.out.print("grossSales: ");
			String grossSales = "";
			boolean validGrossSales = false;
			while (validGrossSales == false) {
				grossSales = (input.nextLine());
				validGrossSales = ValidUtil.validDouble(grossSales);
				if (validGrossSales == false) {
					System.out.println("invalid grossSales, input grossSales again: ");
				}
			}
			System.out.print("basicSalary: ");
			String basicSalary = "";
			boolean validBasicSalary = false;
			while (validBasicSalary == false) {
				basicSalary = (input.nextLine());
				validBasicSalary = ValidUtil.validDouble(basicSalary);
				if (validBasicSalary == false) {
					System.out.println("invalid validBasicSalary, input validBasicSalary again: ");
				}
			}

			Employee sala = new SalariedEmployee(Double.parseDouble(commissionRate), Double.parseDouble(grossSales),
					Double.parseDouble(basicSalary));
			sala.setSsn(e.getSsn());
			sala.setFirstName(firstName);
			sala.setLastName(lastName);
			sala.setBirthDate(birthDate);
			sala.setPhone(phone);
			sala.setEmail(email);
			return sala;
		} else {

			System.out.print("firstName:");
			String firstName = (input.nextLine());

			System.out.print("lastName: ");
			String lastName = (input.nextLine());

			System.out.print("birthDate: ");
			boolean validDate = false;
			String birthDate = "";
			while (validDate == false) {
				birthDate = (input.nextLine());
				validDate = ValidUtil.validDate(birthDate);
				if (validDate == false) {
					System.out.println("invalid date, input birthDate again: ");
				}

			}

			System.out.print("phone: ");
			boolean validPhone = false;
			String phone = "";
			while (validPhone == false) {
				phone = (input.nextLine());
				validPhone = ValidUtil.validPhone(phone);
				if (validPhone == false) {
					System.out.println("invalid phone, input phone again: ");
				}
			}

			System.out.print("email: ");
			boolean validEmail = false;
			String email = "";
			while (validEmail == false) {
				email = (input.nextLine());
				validEmail = ValidUtil.validEmail(email);
				if (validEmail == false) {
					System.out.println("invalid email, input email again: ");
				}
			}

			System.out.print("wage: ");
			String wage = "";
			boolean validCommis = false;
			while (validCommis == false) {
				wage = (input.nextLine());
				validCommis = ValidUtil.validDouble(wage);
				if (validCommis == false) {
					System.out.println("invalid wage, input wage again: ");
				}
			}
			System.out.print("workingHours: ");
			String workingHours = "";
			boolean validGrossSales = false;
			while (validGrossSales == false) {
				workingHours = (input.nextLine());
				validGrossSales = ValidUtil.validDouble(workingHours);
				if (validGrossSales == false) {
					System.out.println("invalid workingHours, input workingHours again: ");
				}
			}
			Employee hourty = new HourtyEmployee(Double.parseDouble(wage), Double.parseDouble(workingHours));
			hourty.setSsn(e.getSsn());
			hourty.setFirstName(firstName);
			hourty.setLastName(lastName);
			hourty.setBirthDate(birthDate);
			hourty.setPhone(phone);
			hourty.setEmail(email);
			return hourty;
		}
	}
}
