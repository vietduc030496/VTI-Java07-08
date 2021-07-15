/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Dung","Tran");
        Employee e2 = new Employee("Hoang","Ngo");
        
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Nhap luong nv1: ");
            double l1 = Double.parseDouble(in.nextLine());
            System.out.print("Nhap luong nv2: ");
            double l2 = Double.parseDouble(in.nextLine());
            if(l1>=0 && l2>=0){
                e1.setSalary(l1);
                e2.setSalary(l2);
                break;
            }
            if(l1<0 && l2<0){
                e1.setSalary(0.0);
                e2.setSalary(0.0);
                break;
            }
            if(l1<0 && l2>0){
                e1.setSalary(0.0);
                e2.setSalary(l2);
                break;
            }
            if(l1>0 && l2<0){
                e2.setSalary(0.0);
                e1.setSalary(l1);
                break;
            }
        }
        
        System.out.println("Luong theo nam cua 2 nhan vien do la: ");
        System.out.println("Nhan vien 1: ");
        System.out.println(e1.getSalary()*12);
        System.out.println("---------------------");
        System.out.println("Nhan vien 2: ");
        System.out.println(e2.getSalary()*12);
        System.out.println("---------------------");
        System.out.println("Luong cua nhan vien sau khi tang 10% la: ");
        System.out.println("Nhan vien 1: ");
        double s1 = (e1.getSalary() + e1.getSalary()*0.1)*12;
        System.out.println(s1);
        System.out.println("---------------------");
        System.out.println("Nhan vien 2: ");
        double s2 = (e2.getSalary() + e2.getSalary()*0.1)*12;
        System.out.println(s2);
        
        
    }
}
