package com.vti.trainning.entity;

public abstract class Employee implements Payable {

	private static int id = 1;

	private String ssn;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;

	public Employee() {
		super();
		ssn = String.valueOf(id);
		++id;
	}

	public Employee(String sss, String firstName, String lastName) {
		super();
		this.ssn = sss;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getSss() {
		return ssn;
	}

	public void setSss(String sss) {
		this.ssn = sss;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public abstract void display();
}