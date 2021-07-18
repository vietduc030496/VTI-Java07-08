package Ex.service;

import Ex.entity.Department;

import java.util.Scanner;

public class DepartmentService {
    public void createDepartment(Department department){
        Department.listDepartment.add(department);
    }
}
