package Bai2;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        int choice;
        Employee e1= new Employee("Hoang","Duong Duc",12000.0);
//        e1.setFname("Hoang");
//        e1.setLname("Duong Duc");
//        e1.setMsalary(12000.0);
        Employee e2= new Employee("Boy","Nghi Nhieu",-12000.0);
//        e2.setFname("Boy");
//        e2.setLname("Nghi Nhieu");
//        e2.setMsalary(-12000.0);
        Scanner sc= new Scanner(System.in);
        for(;;){
            System.out.println("Bang luong nhan vien:\n");
            System.out.println(e1.EmpInfo(e1)+ " - luong nam: " + e1.Ysalary(e1));
            System.out.println("\n");
            System.out.println(e2.EmpInfo(e2)+ " - luong nam: " + e2.Ysalary(e2));
            System.out.println("\n");
            System.out.println("1. Tang 10% luong");
            System.out.println("2. Thoat");
            do {
                System.out.println("Bấm số để chọn: ");
                choice = sc.nextInt();
            } while ((choice < 1) || (choice > 3));
            switch (choice) {
                case 1:
                    System.out.println("Bang luong nhan vien:\n");
                    System.out.println(e1.EmpInfo(e1)+ " - luong nam: " + (e1.Ysalary(e1)+ e1.Ysalary(e1)*0.1));
                    System.out.println("Bang luong nhan vien:\n");
                    System.out.println(e2.EmpInfo(e2)+ " - luong nam: " + (e2.Ysalary(e2)+ e2.Ysalary(e2)*0.1));
                case 2:
                    System.exit(0);
                    break;
            }
        }
    }
}
