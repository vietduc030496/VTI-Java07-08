
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dung.trananh
 */
public class Department {
    private String departmentName;
    private List listOfEmployee;

    public Department(String departmentName, List listOfEmployee) {
        this.departmentName = departmentName;
        this.listOfEmployee = listOfEmployee;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(List listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public void display() {
        System.out.println("Department{" + "departmentName=" + departmentName + ", listOfEmployee=" + listOfEmployee + '}');
    }
    
}
