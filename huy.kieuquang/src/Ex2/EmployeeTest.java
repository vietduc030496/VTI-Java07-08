/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kieuq
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> arrEm = new ArrayList<>();
        
        for(int i=1; i<=2; i++){
            System.out.print("Nhap firstName: ");
            String firstName = sc.nextLine();
            System.out.print("Nhap lastName: ");
            String lastName = sc.nextLine();
            System.out.print("Nhap luong 1 thang: ");
            double salaryMonthly = Double.parseDouble(sc.nextLine());
            
            Employee e = new Employee(firstName, lastName, salaryMonthly);
            System.out.println(e.toString());
            System.out.println("-----------------------");
            
            arrEm.add(e);
        }
        
        System.out.println("Salary after raise");
        for (Employee e : arrEm) {
            System.out.println(e.display());
        }
        
    }
    
}
