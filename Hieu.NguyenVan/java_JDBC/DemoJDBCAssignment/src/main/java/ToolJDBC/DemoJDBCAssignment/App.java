package ToolJDBC.DemoJDBCAssignment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ToolJDBC.entity.Department;
import ToolJDBC.entity.SinhVien;
import ToolJDBC.service.DepartmentService;
import ToolJDBC.service.SinhVienService;
import ToolJDBC.constant.appConstant;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		Scanner scanf = new Scanner(System.in);
		ControlMenu control =new  ControlMenu();
		int pick = 1;
		while (pick != appConstant.EXIT) {
			System.out.print("Enter number follow menu below:  \n");
			System.out.print("1 - Create student  \n");
			System.out.print("2 - View all student  \n");
			System.out.print("3 - Count student by gender \n");
			System.out.print("4 - View student mark by id  \n");
			System.out.print("5 - Count student by class  \n");
			System.out.print("6 - View student have  lowest mark  \n");
			System.out.print("7 - View top 5 student  \n");
			System.out.print("8 - Average by student \n");
			System.out.print("9 - Tuition fees by student   \n");
			System.out.print("Pick one :  ");
			pick = scanf.nextInt();

			switch (pick) {
			case 1: {
				control.menu1();
				break;
			}
			case 2: {
				control.menu2();
				break;
			}
			case 3: {
				control.menu3();
				break;
			}
			case 4: {
				control.menu4();
				break;
			}
			case 5: {
				control.menu5();
				break;
			}
			case 6: {
				control.menu6();
				break;
			}
			case 7: {
				control.menu7();
				break;
			}
			case 8: {
				control.menu8();
				break;
			}
			case 9: {
				control.menu9();
				break;
			}

			}
		}

//		System.out.println("Hello World!");
//		DepartmentService service = new DepartmentService();
//
//		List<Department> departments = service.getDepartments();
//		for (Department department : departments) {
//			System.out.println(department);
//		}
//
//		System.out.println("----------------------");
//
//		Department detpById = service.getDetpById(3);
//		System.out.println(detpById);
		System.err.println("This is end!!");
	}
}
