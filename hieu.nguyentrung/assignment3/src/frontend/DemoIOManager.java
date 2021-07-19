package frontend;

import java.util.Scanner;

import entity.Employee;
import utils.IOManager;

public class DemoIOManager {
	public static void main(String[] args) throws Exception {
		IOManager IOM = new IOManager();
		String pathFile = "src/entity/Employee.java";
		String pathFile1 = "Path/Test456.txt";
		String pathFile2 = "C:\\Users\\hieu.nguyentrung2\\Desktop\\";
		int choice;
		Employee emp = new Employee("Nguyen Trung Hieu", 18);
		String pathFile3 = "WriteFile.txt";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("*****************");
			System.out.println("1.Read File!");
			System.out.println("2.Write File !");
			System.out.println("3.Write Object !");
			System.out.println("4.Read Object !");
			System.out.println("0.Exit!");
			System.out.println("*****************");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				IOM.readFile(pathFile1);
				System.out.println();
				break;
			case 2:
				IOM.writeFile(pathFile1, false, "asdascascadasdasfasas");;
				break;
			case 3:
				IOM.writeObject(emp, pathFile2, pathFile3);
				break;
			case 4:
				emp = IOM.readObject(pathFile2+ pathFile3 );
				System.out.println("Name employee: " +emp.getName() );
				System.out.println("Name employee: " +emp.getAge() );
				break;
			case 0:
				System.exit(0);
				System.out.println("Bye!!");
			}
		}
	}
}
