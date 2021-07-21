/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

import java.util.ArrayList;

/**
 *
 * @author van hieu
 */

public class AppEmployee {
public static void createEmployee(ArrayList listEmployee){
        
        for(int i=0;i<2;i++){
            Employee employee=new Employee("Hieu","nguyen", 100);
            listEmployee.add(employee);
        }
        
        
}
    public static void out(ArrayList listEmployee){
        for(int i=0;i<listEmployee.size();i++){
            Employee employee =(Employee) listEmployee.get(i);
            String employeeInfor=employee.toString();
            System.out.println(employeeInfor);
            System.out.println("Year  salary:"+employee.getYearSalary());
}
        
    }
    public static void main(String[] args) {
        ArrayList<Employee> listEmployee = new ArrayList();
        createEmployee(listEmployee);
        out(listEmployee);

    }
}
