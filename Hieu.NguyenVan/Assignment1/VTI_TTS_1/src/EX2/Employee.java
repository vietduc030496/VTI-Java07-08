/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

/**
 *
 * @author van hieu
 */
public class Employee {

    public String name;
    public String lastName;
    public double monthSalary;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        if(salary<=0) salary=0;
        this.monthSalary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return monthSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        if(salary<0) this.salary=0;
        this.monthSalary = salary;
    }
    public double getYearSalary(){
        double yearSalary=this.monthSalary*12;
        yearSalary+=yearSalary/10;
       return yearSalary;
    }
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", lastName=" + lastName + ", salary=" + salary + '}';
    }
    
    
}
