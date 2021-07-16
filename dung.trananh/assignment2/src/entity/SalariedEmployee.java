package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dung.trananh
 */
public class SalariedEmployee extends Employee{
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(double commissionRate, double grossSales, double basicSalary, String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
        super(ssn, firstName, lastName, birthDate, phone, email);
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
        return "SalariedEmployee{" + "ssn=" + this.getSsn() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", birthDate=" + this.getBirthDate() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + "commissionRate=" + commissionRate + ", grossSales=" + grossSales + ", basicSalary=" + basicSalary + ", email="+  '}' +"\n";
    }
    

    
}
