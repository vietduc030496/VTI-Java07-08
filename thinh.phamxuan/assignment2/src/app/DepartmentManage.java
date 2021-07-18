package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;
import service.Service;
public class DepartmentManage {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String choose = null;
        boolean exit = false;
        Service sv=new Service();

    
    
        showMenu();
        while (true) {
            choose = sc.nextLine();
            switch (choose) {
            case "1":
           
            	System.out.println("Nhap ten phong ban");
            	String departmentName=sc.nextLine();
            	sv.createDepartment(departmentName);

                break;
            case "2":
            	sv.inputEmployee();
            	break;
            case "3":
            	sv.displayEmployees();
                break;
            case "4":
            	sv.classifyEmployees();
                break;
            case "5":
            	System.out.println("Chon loai tim kiem");
     	        System.out.println("1.Tim kiem nhan vien trong bo phan ");
     	        System.out.println("2.Tim kiem thong tin nhan vien");
     	        int type3=sc.nextInt();
     	        if(type3==1) {
     	        	System.out.println("Nhap ten bo phan");
     	        	String departmentName2=sc.next();
     	        	sv.searchByDepartment(departmentName2);

     	        	
     	        }
     	        else if(type3==2) {
     	        	System.out.println("Nhap ten nhan vien");
     	        	String employeeName=sc.next();
     	        	sv.searchByName(employeeName);
     	        }
                break;
            case "6":
 	        	System.out.println("Nhap ssn nhan vien can xoa");
 	        	int ssn=sc.nextInt();
 	        	sv.deleteEmployee(ssn);

                break;
            case "7":
            	sv.report();
  
                break;
            case "0":
                System.out.println("Thoat!");
                exit = true;
                break;
            default:
                System.out.println("Xin vui long chon lai:");
                break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
	}
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Nhap ten bo phan");
        System.out.println("2. Nhap thong tin nhan vien");
        System.out.println("3. Hien thi nhan vien trong tung bo phan");
        System.out.println("4. Phan loai nhan vien");
        System.out.println("5. Tim kiem nhan vien");
        System.out.println("6. Xoa nhan vien");
        System.out.println("7. Report");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
        System.out.print("Vui long chon: ");
    }

}
