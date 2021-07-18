package Ex.entity;

import Ex.entity.Employee;

public class SalariedEmployee extends Employee {
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String mail, double commissionRate, double grossSales, double basicSalary) {
        super(ssn, firstName, lastName, birthDate, phone, mail);
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
    public void display() {
        System.out.println("Thong tin cua nhan vien:");
        System.out.println("SNN:" + this.getSsn());
        System.out.println("Ho va ten:" +this.getFirstName() +this.getLastName());
        System.out.println("DOB:" +this.getBirthDate());
        System.out.println("Phone:"+ this.getBirthDate());
        System.out.println("Mail:"+ this.getMail());
        System.out.println("CommissionRate:" + this.commissionRate)  ;
        System.out.println("grossSale:"+ this.grossSales);
        System.out.println("Basic Salary:"+ this.basicSalary);
    }
}
