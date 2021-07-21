package com.vti.trainning.entity;

public class SalariedEmployee extends Employee {

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
		return "SalariedEmployee [ssn=\"" + getSss() + ", name=" + getFullName() + ", commissionRate=" + commissionRate
				+ ", grossSales=" + grossSales + ", basicSalary=" + basicSalary + "]";
	}

}
