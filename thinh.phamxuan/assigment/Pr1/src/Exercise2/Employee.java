package Exercise2;

public class Employee {
	private String firstName;
	private String lastName;
	private double monthlySalary;
	public Employee() {
		super();
	}
	public Employee(String firstName, String lastName, double monthlySalary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.monthlySalary = monthlySalary;
		
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
	public double getMonthlySalary() {
		if(monthlySalary<0) {
			return 0.0;
		}
		else {
			return monthlySalary;
		}
		
	}
	
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public double getYearlySalary() {
		return this.monthlySalary*12;
	}
	
	
	
}
