package entity;

public class SalariedEmployee extends Employee {
	private double commissionRate, grossSales, basicSalary;

	public SalariedEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone,
			String email, double commissionRate, double grossSales, double basicSalary) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return "Salaried Employee [SSN: " + getSsn() + ", First Name: " + getFirstName() + ", Last Name: "
				+ getLastName() + ", Birth Date: " + getBirthDate() + ", Phone: " + getPhone() + ", Email: "
				+ getEmail() + ", Commission rate: " + commissionRate + ", Gross sales: " + grossSales 
				+ ", Basic salary: " + basicSalary + "]";
	}

	
	
}
