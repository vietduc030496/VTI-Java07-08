package entity;

public class HourlyEmployee extends Employee {
	private double rate, workingHours;


	public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, 
			String phone, String email, double rate, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
		this.rate = rate;
		this.workingHours = workingHours;
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String toString() {
		return "Hourly Employee [SSN: " + getSsn()+ ", First Name: " 
				+ getFirstName() + ", Last Name: " + getLastName() + ", Birth Date: "
				+ getBirthDate() + ", Phone:" + getPhone() + ", Email: " + getEmail()
				+ ", Rate: " + rate + ", Working hours: " + workingHours + "]";
	}

	
	
	
}
