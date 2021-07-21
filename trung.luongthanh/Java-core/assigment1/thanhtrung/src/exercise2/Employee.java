package exercise2;

public class Employee {
	public String firstname;
	public String lastname;
	public double monsalary;
	public Employee() {
		super();
	}
	public Employee(String firstname, String lastname, double monsalary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.monsalary = monsalary;
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
	public double getMonsalary() {
		return monsalary;
	}
	public void setMonsalary(double monsalary) {
		this.monsalary = monsalary;
	}
	
}
