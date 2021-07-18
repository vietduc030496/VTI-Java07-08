package app;

import java.util.ArrayList;
import java.util.Scanner;
import service.*;
import entity.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dung.trananh
 */
public class Main {

	public static void main(String[] args) {

		int choiceNumber = 10;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Department> d = new ArrayList<>();
		int ssn = 0;

		while (choiceNumber != 0) {
			System.out.println("1. Input department data from the keyboard");
			System.out.println("2. Input employee data from the keyboard");
			System.out.println("3. Display department");
			System.out.println("4. Display employees");
			System.out.println("5. Classify employees");
			System.out.println("6. Employee Search");
			System.out.println("7. Report");
			System.out.println("8. Delete Employee");
			System.out.println("0. Exit");
			System.out.println("Please choose: ");
			choiceNumber = Integer.parseInt(scanner.nextLine());

			switch (choiceNumber) {
			case 1:
				// Them department moi
				Department de = DepartmentInput.Department_Input();
				d.add(de);
				break;
			case 2:
				// Chon department muon them nhan vien
				if (d.size() > 0) {
					System.out.println("Choose department: ");
					String name = scanner.nextLine();
					for (int j = 0; j < d.size(); j++) {
						// Kiem tra ten department vs danh sach co san
						if (d.get(j).getDepartmentName().equals(name)) {
							ssn += 1;
							EmployeeInput.Employee(d.get(j), ssn);
						}
					}
				} else {
					System.out.println("Need to input department first");
				}
				break;
			case 3:
				// Hien thi cac phong ban va so luong nhan vien moi phong
				DepartmentDisplay.DeDisplay(d);
				break;
			case 4:
				// Hien thi thong tin chi tiet tung nhan vien o trong phong ban
				EmployeeDisplay.EmpDisplay(d);
				break;
			case 5:
				// Phan loai nhan vien theo 2 loai
				EmployeeClassify.EmpClassify(d);
				break;
			case 6:
				// Tim kiem
				EmployeeSearch.EmpSearch(d);
				break;
			case 7:
				// Bao cao tong ket phong ban va nhan vien
				Report.report(d);
				break;
			case 8:
				// Xoa nhan vien theo ssn
				DeleteEmployee.delEmployee(d);
				break;
			case 0:
				System.exit(0);
				break;

			}
		}
	}
}
