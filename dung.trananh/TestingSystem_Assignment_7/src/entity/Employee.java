package entity;

import java.io.Serializable;

public class Employee implements Serializable{
	public static final long serialVersionUID = 1L; 
	private String firstname;
	private String lastname;
	private double salary;

	public Employee() {
	}

	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Employee(String firstname, String lastname, double salary) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
