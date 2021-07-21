package Ex.entity;

import java.util.ArrayList;

public class Department {
    public static ArrayList<Department> listDepartment = new ArrayList<>();
    private String deparmentName;
    private ArrayList<Employee> listEmployee;

    public Department() {
    }

    public Department(String deparmentName) {
        this.deparmentName = deparmentName;
        this.listEmployee = new ArrayList<>();
    }

    public String getDeparmentName() {
        return deparmentName;
    }

    public void setDeparmentName(String deparmentName) {
        this.deparmentName = deparmentName;
    }

    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(ArrayList<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public void displayAllEmployee() {
    }

    @Override
    public String toString() {
        return deparmentName + " Co " + listEmployee.size() + " nhan vien.";
    }
}
