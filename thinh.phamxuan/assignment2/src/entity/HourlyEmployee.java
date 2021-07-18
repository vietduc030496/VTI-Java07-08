package entity;



public class HourlyEmployee extends Employee {
	private double wage;
	private double workingHours;
	public HourlyEmployee() {
		super();
	}
	
	public HourlyEmployee(String firstName, String lastName, String birthDate, String phone,
			String email,double wage, double workingHours) {
		super(firstName,lastName,birthDate,phone,email);
		this.wage = wage;
		this.workingHours = workingHours;
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	public void display() {
		System.out.println("ssn:" + getSsn()+ " firstName:"+getFirstName()+ " lastName:"+getLastName()+" birthDate:"+getBirthDate()+" phone:"+getPhone()+ " email:"+getEmail()+" wage:"+wage+" workingHours"+workingHours);
	}
	
	public double getPaymentAmount() {
		return 0;
	}
}
