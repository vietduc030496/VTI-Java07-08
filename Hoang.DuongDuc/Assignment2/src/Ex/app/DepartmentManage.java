package Ex.app;

import Ex.entity.HourlyEmployee;
import Ex.entity.SalariedEmployee;
import Ex.service.DepartmentService;
import Ex.entity.Department;
import Ex.entity.Employee;
import Ex.service.EmployeeService;
import Ex.utils.CheckData;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentManage {
    static Scanner sc = new Scanner(System.in);
    private static void displayDepartment() {
        for (int i = 0; i < Department.listDepartment.size(); i++) {
            System.out.println((i + 1) + "." + Department.listDepartment.get(i));
        }
    }

    private static void displayDetailToDelete() {// xoa phan tu su dung iterator, dung for de bi loi!
        int k = 1;
        displayDepartment();
        System.out.println("Chon 1 phong ban de xem chi tiet:");
        int choice1 = sc.nextInt();
        ArrayList<Employee> employees = Department.listDepartment.get(choice1 - 1).getListEmployee();
        for (Employee employee : employees) {
            if (employee instanceof HourlyEmployee) {
                System.out.println(k + ".");
                ((HourlyEmployee) employee).display();
            } else {
                System.out.println(k + ".");
                ((SalariedEmployee) employee).display();
            }
            k++;
        }
        System.out.println("Chon số đứng trước của thông tin nhân viên để xóa");
        int choice2 = sc.nextInt();
        Department.listDepartment.get(choice1 - 1).getListEmployee().remove(choice2);
    }


    private static void displayAllEmployee() {
        System.out.println("Danh sach tat ca cac nhan vien:");
        EmployeeService employeeService = new EmployeeService();
        for (Employee employee : employeeService.getAllEmployee()) {
            if (employee instanceof HourlyEmployee) ((HourlyEmployee) employee).display();
            else ((SalariedEmployee) employee).display();
        }

    }

    private static void classifyEmployee() {
        EmployeeService employeeService = new EmployeeService();
        System.out.println("Danh sach cac nhan vien ban thoi gian:");
        for (Employee employee : employeeService.getAllEmployee()) {
            if (employee instanceof HourlyEmployee) {
                ((HourlyEmployee) employee).display();
            }
        }
        System.out.println("=================================");
        System.out.println("Danh sach cac nhan vien chinh thuc:");
        for (Employee employee : employeeService.getAllEmployee()) {
            if (employee instanceof SalariedEmployee) {
                ((SalariedEmployee) employee).display();
            }
        }
    }

    private static void createEmployee() {
        displayDepartment();
        System.out.println("Moi nhap so de chon phong ban:");
        int departmentNumber = sc.nextInt();
        int choice = 10;
        while (choice != 0) {
            System.out.println("-----------------------");
            System.out.println("1. SalariedEmployee ");
            System.out.println("2. HourlyEmployee ");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            if (choice == 0) return;
            String id = String.valueOf(Employee.nextUserId++);
            Department.listDepartment.get(departmentNumber - 1).getListEmployee().add(inputEmployee(id, choice));
        }
    }

    public static Employee inputEmployee(String id, int choice) {
        sc.nextLine();
        System.out.println("Nhap firstname:");
        String fname = sc.nextLine();
        System.out.println("Nhap lastname:");
        String lname = sc.nextLine();
        System.out.println("Nhap ngay thang nam sinh:");
        String bdate;
        while (true) {
            bdate = sc.nextLine();
            if (CheckData.checkInDate(bdate)) break;
        }
        System.out.println("Nhap SDT:");
        String sphone;
        while (true) {
            sphone = sc.nextLine();
            if (CheckData.checkInPhone(sphone)) break;
        }
        System.out.println("Nhap Email:");
        String mail;
        while (true) {
            mail = sc.nextLine();
            if (CheckData.checkInMail(mail)) break;
        }
        switch (choice) {
            case 1:
                System.out.println("Nhap commissionRat:");
                double cRate = Double.parseDouble(sc.nextLine());
                System.out.println("Nhap grossSale:");
                double gSale = Double.parseDouble(sc.nextLine());
                System.out.println("Nhap basicSalary:");
                double bSalary = Double.parseDouble(sc.nextLine());
                return new SalariedEmployee(id, fname, lname, bdate, sphone, mail, cRate, gSale, bSalary);
            case 2:
                System.out.println("Nhap Wage:");
                double wage = Double.parseDouble(sc.nextLine());
                System.out.println("Nhap WorkingHours:");
                double whour = Double.parseDouble(sc.nextLine());
                return new HourlyEmployee(id, fname, lname, bdate, sphone, mail, wage, whour);
        }
        return null;
    }

    public static void search() {///////
        System.out.println("Moi nhap so de chon cach nhap:");
        int choice = 10;
        while (choice != 0) {
            System.out.println("-----------------------");
            System.out.println("1. Search by name Employee ");
            System.out.println("2. Search by name Department ");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) return;
            if (choice == 1) {
                searchByEmployeeName();
            }
            if (choice == 2) {
                searchByDepartmentName();
            }
        }
    }

    public static void searchByEmployeeName() {
        System.out.println("Nhap ten nhan vien: ");
        String name = sc.nextLine();
        System.out.println("Cac nhan vien thoa man:\n");
        for (Department department : Department.listDepartment) {
            for (Employee employee : department.getListEmployee()) {
                if ((employee.getFirstName() + employee.getLastName()).contains(name))
                    employee.display();
            }
        }
    }

    public static void searchByDepartmentName() {
        System.out.println("Nhap ten phong ban: ");
        String name = sc.nextLine();
        System.out.println("Cac nhan vien thoa man:\n");
        for (Department department : Department.listDepartment) {
            if (!department.getDeparmentName().contains(name))
                continue;
            for (Employee employee : department.getListEmployee()) {
                employee.display();
            }
        }
    }

    public static void main(String[] args) {
        DepartmentService departmentService = new DepartmentService();
        initData();
        while (true) {
            int choose;
            System.out.println("                                   MENU                                 ");
            System.out.println("========================================================================");
            System.out.println("1. Them phong ban");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Hien thi thong tin cua nhan vien");
            System.out.println("4. Phan loai nhan vien");
            System.out.println("5. Tim kiem nhan vien");
            System.out.println("6. Hien thi phong ban va so luong nhan vien trong phong ban");
            System.out.println("7. Xoa nhan vien tu phong ban");
            System.out.println("0. Thoat");
            System.out.println("========================================================================");
            System.out.print("Hay chon mot so: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("Nhap ten phong ban:");
                    String nameDepartment = sc.nextLine();
                    departmentService.createDepartment(new Department(nameDepartment));
                    break;
                case 2:
                    createEmployee();
                    break;
                case 3:
                    displayAllEmployee();
                    break;
                case 4:
                    classifyEmployee();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    displayDepartment();
                    break;
                case 7:
                    displayDetailToDelete();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void initData() {
        for (int i = 0; i < 2; i++) {
            Department department = new Department("Department" + (i + 1));
            Department.listDepartment.add(department);
            for (int j = 0; j < 2; j++) {
                Employee employee;
                if (j % 2 == 0) {
                    employee = new SalariedEmployee(String.valueOf(Employee.nextUserId++), "First" + j, "Last" + j, "20/10/1000", "0123456789",
                            "aaaa@gmail.com", 12, 12, 12);
                } else {
                    employee = new HourlyEmployee(String.valueOf(Employee.nextUserId++), "First" + j, "Last" + j, "20/10/1000", "0123456789",
                            "aaaa@gmail.com", 12, 12);
                }
                department.getListEmployee().add(employee);
            }
        }
    }
}
