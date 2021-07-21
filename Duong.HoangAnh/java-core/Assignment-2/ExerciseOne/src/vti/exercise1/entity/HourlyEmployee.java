package vti.exercise1.entity;

public class HourlyEmployee extends Employee {
	private double wage;
	private double workingHous;

	public HourlyEmployee(String ssn, String firstName, String lastName, double wage, double workingHous) {
		super(ssn, firstName, lastName);
		this.wage = wage;
		this.workingHous = workingHous;
	}
	
	public double getWage() {
		return wage;
	}
	
	public void setWage(double wage) {
		this.wage = wage;
	}
	
	public double getWorkingHous() {
		return workingHous;
	}
	
	public void setWorkingHous(double workingHous) {
		this.workingHous = workingHous;
	}
	
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
