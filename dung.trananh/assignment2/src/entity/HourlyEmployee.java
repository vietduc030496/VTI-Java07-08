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
public class HourlyEmployee extends Employee{
    private double wage;
    private double workingHours;

    public HourlyEmployee(double wage, double workingHours, String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
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
        return "HourlyEmhployee{" + "ssn=" + this.getSsn() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", birthDate=" + this.getBirthDate() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + "wage=" + wage + ", workingHours=" + workingHours + '}' + "\n";
    }
    
}
