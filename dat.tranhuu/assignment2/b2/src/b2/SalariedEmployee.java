package b2;

public class SalariedEmployee extends Employee{
	
	private double commissionRate;
	private double grossSales;
	private double basicSalary;
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
	public SalariedEmployee(double commissionRate, double grossSales, double basicSalary) {
		super();
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}
	public SalariedEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone,
			String email, double commissionRate,double grossSales,double basicSalary) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void display() {
		System.out.println("ssn: "+this.getSsn()+", "+"firstName: "+this.getFirstName()+", "+"lastName: "+this.getLastName()+", "+"birthDate: "+this.getBirthDate()+", "+"phone: "+this.getPhone()+", "+"email: "+this.getEmail()+", "+
				"commissionRate: "+this.getCommissionRate()+", "+"grossSales: "+this.getGrossSales()+", "+"basicSalary: "+this.getBasicSalary());
	}
	
}
