package com.vti.trainning.entity;

public class HourlyEmployee extends Employee {

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

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		toString();

	}

	@Override
	public String toString() {
		return "HourlyEmployee [ssn=" + getSss() + ", name=" + getFullName() + ", wage=" + wage + ", workingHours="
				+ workingHours + "]";
	}

}
