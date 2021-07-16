package services;

import java.util.List;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;
import sun.security.pkcs11.Secmod.DbMode;

public class EmployeeService {
	public void initEmployee(List<Department> listDp, Department d1, Department d2, Department d3, List<Employee> listEm1, List<Employee> listEm2, List<Employee> listEm3) {
		// init employee 
		Employee initD1E1 = new  SalariedEmployee("1", "a", "a", "20/10/1999", "0898201199", "abc@gmail.com", 1, 2, 1000);
		Employee initD1E2 = new  SalariedEmployee("2", "a", "b", "20/10/1999", "0898201199", "abc@gmail.com", 1, 2, 1000);
		Employee initD1E3 = new HourlyEmployee("3", "a", "c", "20/10/1999", "0898201199", "abc@gmail.com", 2000, 3);
		listEm1.add(initD1E1);
		listEm1.add(initD1E2);
		listEm1.add(initD1E3);
		
		Employee initD2E1 = new  SalariedEmployee("4", "a", "a", "20/10/1999", "0898201199", "abc@gmail.com", 1, 2, 1000);
		Employee initD2E2 = new  SalariedEmployee("5", "a", "b", "20/10/1999", "0898201199", "abc@gmail.com", 1, 2, 1000);
		Employee initD2E3 = new HourlyEmployee("6", "a", "c", "20/10/1999", "0898201199", "abc@gmail.com", 2000, 3);
		listEm2.add(initD2E1);
		listEm2.add(initD2E2);
		listEm2.add(initD2E3);
		
		Employee initD3E1 = new  SalariedEmployee("7", "a", "a", "20/10/1999", "0898201199", "abc@gmail.com", 1, 2, 1000);
		Employee initD3E2 = new  SalariedEmployee("8", "a", "b", "20/10/1999", "0898201199", "abc@gmail.com", 1, 2, 1000);
		Employee initD3E3 = new HourlyEmployee("9", "a", "c", "20/10/1999", "0898201199", "abc@gmail.com", 2000, 3);
		listEm3.add(initD3E1);
		listEm3.add(initD3E2);
		listEm3.add(initD3E3);
	}
	
	public void displayEm(List<Department> listDp, String dpName) {
		for (Department dp : listDp) {
			if(dpName.equals(dp.getDepartmentName())) {
				for (Employee employee : dp.getListOfEmployee()) {
					System.out.println(employee.display());
				}
			}
		}
	}
	
	public void search(List<Department> listDp, String nameDp, String nameEm) {
		for (Department dp : listDp) {
			if(nameDp.equals(dp.getDepartmentName())) {
				for (Employee employee : dp.getListOfEmployee()) {
					if(employee.getLastName().equals(nameEm)) {
						employee.display();
					}
				}
			}
		}
	}
	
	public void deleteBySsn(List<Department> listDp, String ssn) {
		List<Employee> em = null;
		int index = 0;
		
		for (Department dp : listDp) {
			for (Employee employee : dp.getListOfEmployee()) {
				if(employee.getSsn().equals(ssn)) {
					for(int i=0; i<dp.getListOfEmployee().size(); i++) {
						if(dp.getListOfEmployee().get(i).equals(employee)) {
							index = i;
							em = dp.getListOfEmployee();
						}
					}					
				}
			}
		}
		em.remove(index);
		System.out.println("Deleted");
	}
	
}
