package service;

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

public class Service {
	public static Scanner sc = new Scanner(System.in);
	List<Department> departments=new ArrayList<Department>();
	public void createDepartment(String departmentName) {
    	Department department= new Department(departmentName,new ArrayList<Employee>());
    	departments.add(department);
	}
	public void inputEmployee() {
		System.out.println("Nhap ho nhan vien: ");
	        String firstName=sc.nextLine();
	        System.out.println("Nhap ten nhan vien: ");
	        String lastName=sc.nextLine();
	        String phone="";
	        do {
	            System.out.println("Nhap so dien thoai bao gom 7 so: ");
	            phone=sc.nextLine();
	        } while (phone.length() < 7||!phone.matches("(84|0[3|5|7|8|9])+([0-9]{5})\\b"));
	        String email="";
	        do {
	            System.out.println("Nhap email nhan vien: ");
	            email=sc.nextLine();
	        } while (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"));
	       
	        String birthDate="";
	        System.out.println("Nhap ngay sinh nhan vien: ");
	        birthDate=sc.nextLine();
	        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	        try {
				Date date=sdf.parse(birthDate);
				birthDate=sdf.format(date);
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
	        

    	System.out.println("Nhap loai sinh vien");
	        System.out.println("1.Nhan vien lam theo gio");
	        System.out.println("2.Nhan vien luong co dinh");
	        int type=sc.nextInt();
	       String choose2="";
	        if(type==1) {
	       
		        System.out.println("Nhap luong nhan vien: ");
		        double wage=sc.nextDouble();
		        System.out.println("Nhap gio lam viec nhan vien: ");
		        double workingHours=sc.nextDouble();

 	        System.out.println("Chon phong ban nhan vien");
 	        int index=1;
 	        for(Department d : departments ) {
 	        	System.out.println(index+"."+d.getDepartmentName());
 	        	index++;
 	        }
 	        System.out.println("Nhap ten phong ban nhan vien");
 	        
		       choose2=sc.next();
 	        for(Department d : departments) {
 	        	if(choose2.equals(d.getDepartmentName())) {
 	        	
 	        		HourlyEmployee he=new HourlyEmployee(firstName,lastName,birthDate,phone,email,wage,workingHours);
 	        		List<Employee> employees=d.getEmployees();
 	        		employees.add(he);
 	        	}
 	        }
 	        

	        }
	        if(type==2) {
	        
		        System.out.println("Nhap tien hoa hong nhan vien: ");
		        double commissionRate=sc.nextDouble();
		        System.out.println("Nhap ty suat loi nhuan: ");
		        double grossSales=sc.nextDouble();
 	        System.out.println("Nhap luong co ban nhan vien: ");
 	        double basicSalary=sc.nextDouble();
 	        System.out.println("Nhap ten phong ban nhan vien");
 	        int index=1;
 	        for(Department d : departments ) {
 	        	System.out.println(index+"."+d.getDepartmentName());
 	        	index++;
 	        }
 	        choose2=sc.next();
 	        for(Department d : departments) {
 	        	if(choose2.equals(d.getDepartmentName())) {
 	        		SalariedEmployee se=new SalariedEmployee(firstName,lastName,birthDate,phone,email,commissionRate,grossSales,basicSalary);
 	        		List<Employee> employee=d.getEmployees();
 	        		employee.add(se);
 	        	}
 	        }
	        }

	}
	public void displayEmployees() {
    	for(Department d: departments) {
    		System.out.println("Ten phong ban: " + d.getDepartmentName());
    		System.out.println("So luong nhan vien trong phong ban: " + d.getEmployees().size());
    		for(Employee em:d.getEmployees()) {
    			em.display();
    		}
    	}
	}
	public void classifyEmployees(){
    	System.out.println("Danh sach nhan vien lam theo gio");
    	for(Department d: departments) {
    		for(Object em:d.getEmployees()) {
    			if(em instanceof HourlyEmployee) {
    				((HourlyEmployee) em).display();
    			}
    				
    		}
    	}
    	System.out.println("Danh sach nhan vien luong co dinh");
    	for(Department d: departments) {
    		for(Object em:d.getEmployees()) {
    			if(em instanceof SalariedEmployee) {
    				((SalariedEmployee) em).display();
    			}
    				
    		}
    	}
	}
	public void report() {
      	for(Department d: departments) {
    		d.display();
    		
    	}
	}
	public void deleteEmployee(int ssn) {
    	for(Department d: departments) {
    		int index=0;
    		for(int i=0;i<d.getEmployees().size();i++) {
    			
    			if(d.getEmployees().get(i).getSsn()==ssn) {
    				d.getEmployees().remove(index);
    			}
    		}
    		index++;

    	}
	}
	public void searchByDepartment(String departmentName) {
    	for(Department d: departments) {
    		if(d.getDepartmentName().equalsIgnoreCase(departmentName)) {
    			System.out.println("Danh sach nhan vien cua "+d.getDepartmentName());
        		for(Employee em:d.getEmployees()) {
        			em.display();
        		}
    		}

    	}
	}
	public void searchByName(String employeeName) {
    	for(Department d: departments) {
    		for(Employee em:d.getEmployees()) {
        		if(em.getLastName().equalsIgnoreCase(employeeName)) {
        			System.out.println("Thong tin nhan vien cua "+em.getLastName());

            			em.display();
            		
        		}
    		}


    	}
     }
	}

