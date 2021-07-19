package vti.exercise1.entity;

public class SalariedEmployee extends Employee {
	private double commissionRate;
	private double grossSales;
	private double basicSalary;

	public SalariedEmployee(String ssn, String firstName, String lastName, double commissionRate, double grossSales,
			double basicSalary) {
		super(ssn, firstName, lastName);
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
