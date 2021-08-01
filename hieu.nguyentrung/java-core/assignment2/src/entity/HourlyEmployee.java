package entity;

public class HourlyEmployee extends Employee {
	double wage;
	double workingHours;

	public HourlyEmployee() {
		super();
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			double wage, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email);
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

	@Override
	public String toString() {
		return "HourlyEmployee [ssn=" + ssn + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", phone=" + phone + ", email="
				+ email +",wage=" + wage + ", workingHours=" + workingHours + "]";
	}


}
