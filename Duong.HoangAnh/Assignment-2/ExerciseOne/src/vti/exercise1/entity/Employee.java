package vti.exercise1.entity;

import vti.exercise1.service.*;

public abstract class Employee implements Comparable<Employee>, Payable {
	private String ssn;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String ssn, String firstName, String lastName) {
		super();
		ValidateData v = new ValidateData();
		firstName = v.name(firstName);
		lastName = v.name(lastName);
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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
		ValidateData v = new ValidateData();
		birthDate = v.date(birthDate);
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		ValidateData v = new ValidateData();
		phone = v.phone(phone);
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		ValidateData v = new ValidateData();
		email = v.email(email);
		this.email = email;
	}

	public void display() {
		String result = "";
		result += "SSN: " + this.ssn + " | ";
		result += "Name: " + this.firstName + " " + this.lastName + " | ";
		result += "Email: " + this.email + " | ";
		result += "Birth: " + this.birthDate + " | ";
		result += "Phone: " + this.phone + "\n";
		System.out.println(result);
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	@Override
    public int compareTo(Employee e) {
        return this.getFullName().compareTo(e.getFullName());
    }
}
