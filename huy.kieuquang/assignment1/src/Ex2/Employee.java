/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

/**
 *
 * @author kieuq
 */
public class Employee {
    public String firstName;
    public String lastName;
    public double salaryMonthly;

    public Employee(String firstName, String lastName, double salaryMonthly) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryMonthly = salaryMonthly;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        if(salaryMonthly < 0){
            String temp = String.format("%.1f", 0.0);
            salaryMonthly = Double.parseDouble(temp);
        }
        
        return salaryMonthly;
    }

    public void setSalary(double salaryMonthly) {
        this.salaryMonthly = salaryMonthly;
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", salaryYearly=" + salaryMonthly*12 + '}';
    }
    
    public String display(){
        double salaryRaise = salaryMonthly*12*(1+0.1);
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", salaryYearly=" + salaryRaise + '}';
    }
}
