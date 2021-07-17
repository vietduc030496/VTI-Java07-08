package entity;

public class HourtyEmployee extends Employee {
	private double wage;
	private double workingHours;

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

	public HourtyEmployee(double wage, double workingHours) {
		super();
		this.wage = wage;
		this.workingHours = workingHours;
	}

	public HourtyEmployee() {
		super();
	}

	public HourtyEmployee(String firstName, String lastName, String birthDate, String phone, String email, double wage,
			double workingHours) {
		super(firstName, lastName, birthDate, phone, email);
		this.wage = wage;
		this.workingHours = workingHours;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		System.out.println("ssn: " + this.getSsn() + ", " + "firstName: " + this.getFirstName() + ", " + "lastName: "
				+ this.getLastName() + ", " + "birthDate: " + this.getBirthDate() + ", " + "phone: " + this.getPhone()
				+ ", " + "email: " + this.getEmail() + ", " + "wage: " + this.getWage() + ", " + "workingHours: "
				+ this.getWorkingHours());
	}

}
