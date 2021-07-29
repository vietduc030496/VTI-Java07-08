package com.vti.trainning.app;

import java.io.IOException;
import java.util.Scanner;

import com.vti.trainning.service.DepartmentService;

public class DepartmentManage {

	private Scanner scan = new Scanner(System.in);

	private DepartmentService deptService;

	public DepartmentManage() {
		super();
		deptService = new DepartmentService();
	}

	public static void main(String[] args) throws IOException {
		new DepartmentManage().app();
	}

	private void app() throws IOException {
		int option = 0;
		while (option != 7) {
			System.out.println("---HAY CHON MOT MUC---");
			System.out.println("1: Them mot bo phan.");
			System.out.println("2: Thong tin cac bo phan.");
			System.out.println("3: Them nhan vien vao bo phan.");
			System.out.println("4: Xem thong tin nhan vien.");
			System.out.println("5: Tim kiem nhan vien theo ten.");
			System.out.println("6: Xuat thong tin nhan vien trong bo phan");
			System.out.println("7: Thoat.");

			option = scan.nextInt();
			switch (option) {
			case 1:
				deptService.addDepartment();
				continue;
			case 2:
				deptService.getListDepartment();
				continue;
			case 3:
				deptService.addEmpByDept();
				continue;
			case 4:
				deptService.showInfoEmployeeByDept();
				continue;
			case 5:
				deptService.searchEmployeeByName();
				continue;
			case 6:
				deptService.exportCsv();
				continue;
			case 7:
				System.out.println("Tam biet va hen gap lai!");
				break;
			default:
				System.out.println("Nhap sai. Chon mot thao tac");
				continue;
			}
		}
	}

}
