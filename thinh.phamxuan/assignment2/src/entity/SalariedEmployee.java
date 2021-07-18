package entity;



public class SalariedEmployee extends Employee {
	private double commissionRate;
	private double grossSales;
	private double basicSalary;
	public SalariedEmployee() {
		super();
	}
	public SalariedEmployee(String firstName, String lastName, String birthDate, String phone,
			String email, double commissionRate, double grossSales, double basicSalary) {
		super(firstName,lastName,birthDate,phone,email);
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
	public void display() {
		System.out.println("ssn:" + getSsn()+ " firstName:"+getFirstName()+ " lastName:"+getLastName()+" birthDate:" + getBirthDate() +" phone:"+getPhone()+ " email:"+getEmail()+" commissionRate:"+commissionRate+
				" grossSales:"+grossSales+" basicSalary:"+basicSalary);
	}
	
	public double getPaymentAmount() {
		return 0;
	}
}
