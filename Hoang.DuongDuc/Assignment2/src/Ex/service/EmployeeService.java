package Ex.service;

import Ex.entity.Department;
import Ex.entity.Employee;

import java.util.ArrayList;

public class EmployeeService {
    public ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> employees= new ArrayList<>();
        for (Department department: Department.listDepartment){
            employees.addAll(department.getListEmployee());
        }
        return employees;
    }
}
