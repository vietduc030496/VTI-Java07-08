package entity;
import java.io.ObjectInputStream.GetField;

public class HourlyEmployee extends Employee{
	private double wage;
	private double workingHours;
	
	public HourlyEmployee(String firstName, String lastName, String birthDate, String phone, String email,
			double wage, double workingHours) {
		super(firstName, lastName, birthDate, phone, email);
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
	public void display() {
		System.out.println(getSsn() + " " + getFirstName() + " " + getLastName() + " " 
	+ getBirthDate() + " " + getPhone() + " " + getEmail() + " " + wage + " " + workingHours);
		}
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}


}
