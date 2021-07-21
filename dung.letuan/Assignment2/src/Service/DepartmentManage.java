package Service;

import Constant.Format;
import Entity.Department;
import Entity.HourlyEmployee;
import Entity.SalariedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManage {
    private List<Department> listOfDepartment;
    public Scanner sc = new Scanner(System.in);

    public DepartmentManage() {
        this.listOfDepartment = new ArrayList<>();
    }

    public List<Department> getListOfDepartment() {
        return listOfDepartment;
    }

    public void setListOfDepartment(List<Department> listOfDepartment) {
        this.listOfDepartment = listOfDepartment;
    }

    public boolean isExist(String name) {
        int l = this.getListOfDepartment().size();
        if (l ==0) return false;
        for (int i = 0; i < l; i++) {
            if (this.getListOfDepartment().get(i).getDepartmentName().equals(name)) return true;
        }
        return false;
    }

    public void addEmployeeToDepartment(Department d) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Employee's Information: ");
        System.out.println("First Name: ");
        String s2 = sc.nextLine();
        System.out.println("Last Name: ");
        String s3 = sc.nextLine();
        System.out.println("Date of birth: ");
        String s4 = sc.nextLine();
        while (!Format.checkDate(s4)) {
            System.out.println("Wrong format pls try again, follow format dd/mm/yyyy");
            s4 = sc.nextLine();
        }
        System.out.println("Phone Number: ");
        String s5 = sc.nextLine();
        while (!Format.checkPhone(s5)) {
            System.out.println("Wrong format pls try again, correct phone is only have 7 digits!");
            s5 = sc.nextLine();
        }
        System.out.println("Email: ");
        String s6 = sc.nextLine();
        while (!Format.checkMail(s6)) {
            System.out.println("Wrong format pls try again, follow format ...@.com..");
            s6 = sc.nextLine();
        }
        System.out.println("Type of employee, SalariedEmployee(0) or HourlyEmployee(1): ");
        int index = sc.nextInt();
        if (index == 0) {
            System.out.println("CommissionRate: ");
            double s7 = sc.nextDouble();
            System.out.println("GrossSales: ");
            double s8 = sc.nextDouble();
            System.out.println("basicSalary: ");
            double s9 = sc.nextDouble();
            SalariedEmployee e = new SalariedEmployee(s2, s3, s4, s5, s6, s7, s8, s9);
            d.getListOfEmployee().add(e);
            System.out.println("Successfully adding employee!");
        } else if (index == 1) {
            System.out.println("wage: ");
            double s7 = sc.nextDouble();
            System.out.println("workingHours: ");
            double s8 = sc.nextDouble();
            HourlyEmployee e = new HourlyEmployee(s2, s3, s4, s5, s6, s7, s8);
            d.getListOfEmployee().add(e);
            System.out.println("Successfully adding employee!");
        }
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Department: ");
        String s = sc.nextLine();
        if (!this.isExist(s)) {
            int index;
            System.out.println("Department is not exist. Want to add new? no (0) or yes (1) ... ");
            index = sc.nextInt();
            if (index == 1) {
                Department d = new Department(s);
                this.getListOfDepartment().add(d);
                addEmployeeToDepartment(d);
            } else {
                System.out.println("Reject Department!");
            }
        } else {
            int l = this.getListOfDepartment().size();
            for (int i = 0; i < l; i++) {
                if (this.getListOfDepartment().get(i).getDepartmentName().equals(s)) {
                    addEmployeeToDepartment(this.getListOfDepartment().get(i));
                    break;
                }
            }
        }
    }

    public void displayEmployee() {
        int l = this.getListOfDepartment().size();
        for (int i = 0; i < l; i++) {
            int k = this.getListOfDepartment().get(i).getListOfEmployee().size();
            System.out.println(this.getListOfDepartment().get(i).getDepartmentName() + " : ");
            for (int j = 0; j < k; j++) {
                this.getListOfDepartment().get(i).getListOfEmployee().get(j).display();
            }
        }
    }

    public void classifyEmployee() {
        int lD = this.getListOfDepartment().size();
        System.out.println("SalariedEmployee: ");
        for (int i = 0; i < lD; i++) {
            int lE = this.getListOfDepartment().get(i).getListOfEmployee().size();
            for (int j = 0; j < lE; j++) {
                if (this.getListOfDepartment().get(i).getListOfEmployee().get(j) instanceof SalariedEmployee) {
                    this.getListOfDepartment().get(i).getListOfEmployee().get(j).display();
                }
            }
        }
        System.out.println("HourlyEmployee: ");
        for (int i = 0; i < lD; i++) {
            int lE = this.getListOfDepartment().get(i).getListOfEmployee().size();
            for (int j = 0; j < lE; j++) {
                if (this.getListOfDepartment().get(i).getListOfEmployee().get(j) instanceof HourlyEmployee) {
                    this.getListOfDepartment().get(i).getListOfEmployee().get(j).display();
                }
            }
        }
    }

    public void searchEmployeeByName() {
        String name = sc.nextLine();
        int lD = this.getListOfDepartment().size();
        for (int i = 0; i < lD; i++) {
            int lE = this.getListOfDepartment().get(i).getListOfEmployee().size();
            for (int j = 0; j < lE; j++) {
                if (this.getListOfDepartment().get(i).getListOfEmployee().get(j).getFirstName().equals(name)) {
                    this.getListOfDepartment().get(i).getListOfEmployee().get(j).display();
                }
            }
        }
    }

    public void searchEmployeeByDepartment() {
        String name = sc.nextLine();
        int lD = this.getListOfDepartment().size();
        for (int i = 0; i < lD; i++) {
            if (this.getListOfDepartment().get(i).getDepartmentName().equals(name)) {
                int lE = this.getListOfDepartment().get(i).getListOfEmployee().size();
                for (int j = 0; j < lE; j++) {
                    this.getListOfDepartment().get(i).getListOfEmployee().get(j).display();
                }
            }
        }
    }

    public void report() {
        int lD = this.getListOfDepartment().size();
        System.out.println("This company has " + lD + " departments: ");
        for (int i = 0; i < lD; i++) {
            System.out.println("Department " + this.getListOfDepartment().get(i).getDepartmentName() + " has " + this.getListOfDepartment().get(i).getListOfEmployee().size() + " employees");
        }
    }

    public void deleteEmployee() {
        int ssn = sc.nextInt();
        int lD = this.getListOfDepartment().size();
        boolean result = false;
        for (int i = 0; i < lD; i++) {
            int lE = this.getListOfDepartment().get(i).getListOfEmployee().size();
            for (int j = 0; j < lE; j++) {
                if (this.getListOfDepartment().get(i).getListOfEmployee().get(j).getSsn() == ssn) {
                    this.getListOfDepartment().get(i).getListOfEmployee().remove(j);
                    System.out.println("Successfully delete!");
                    result = true;
                }
            }
        }
        if (!result) {
            System.out.println("Fail! Try again!");
        }
    }
}
