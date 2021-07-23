package Entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    public List<Employee> listOfEmployee;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(List<Employee> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.listOfEmployee = new ArrayList<Employee>();
    }

    public void display() {
        int l = this.getListOfEmployee().size();
        for (int i = 0; i < l; ++i) {
            this.getListOfEmployee().get(i).display();
        }
    }
}
