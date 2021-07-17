package service;

import entity.Department;
import entity.Employee;

public interface IDepartment {
	public Department inputD();
	public Employee inputE();
	public void inputHE();
	public void inputSE();
	public void displayD();
	public void displayE();
	public void updateE(String ssn);
	public void deleteE(String ssn);
	public void classify();
	public void searchByDepartment(String departmentName);
	public void searchByName(String lastName);
	public void report();
}
