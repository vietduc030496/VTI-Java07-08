/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author LENOVO
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ngo","Quoc An",1000.0);
        Employee e2 = new Employee("Nguyen","Van A", -1000.0);
        System.out.println("Nhân viên 1:");
        System.out.println(e1.yearlySaraly(0));
        System.out.println(e1.yearlySaraly(10));
        System.out.println("Nhân viên 2:");
        System.out.println(e2.yearlySaraly(0));
        System.out.println(e2.yearlySaraly(10));
        
    }
}
