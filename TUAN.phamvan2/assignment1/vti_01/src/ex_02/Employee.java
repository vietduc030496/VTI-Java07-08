package ex_02;

public class Employee {
	private String firstName;
	private String lastName;
	private double monthSalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String firstName, String lastName, double monthSalary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.monthSalary = monthSalary;
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
	public double getMonthSalary() {
		return monthSalary;
	}
	public void setMonthSalary(double monthSalary) {
		if(monthSalary < 0) {
			monthSalary = 0.0;
		}
		this.monthSalary = monthSalary;	
	}
	
	public double getYearlySalary() {
		return this.monthSalary * 12;
	}
}
