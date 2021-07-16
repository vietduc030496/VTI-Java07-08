/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.*;

import java.util.Scanner;

import constant.CheckData;

/**
 *
 * @author ADMIN
 */
public class EmployeeInput {
	static Scanner in = new Scanner(System.in);

	public static void Employee(Department d, int ssn) {
		int choice = 10;
		while (choice != 0) {
			System.out.println("Chon type of Employee: ");
			System.out.println("-----------------------");
			System.out.println("1. SalariedEmployee ");
			System.out.println("2. HourlyEmployee ");
			System.out.println("0. Exit");
			choice = Integer.parseInt(in.nextLine());
			switch (choice) {
			case 1:
				String ssn1 = String.valueOf(ssn);
				SalariedEmployee Se = salariedEmployee(ssn1);
				d.addSalariedEmployee(Se);
				ssn+=1;
				break;
			case 2:
				String ssn2 = String.valueOf(ssn);
				HourlyEmployee He = hourlyEmployee(ssn2);
				d.addHourlyEmployee(He);
				ssn+=1;
				break;
			case 0:
				break;

			}
		}

	}

	public static HourlyEmployee hourlyEmployee(String id) {
		System.out.println("Nhap first name: ");
		String fn = in.nextLine();
		System.out.println("Nhap last name: ");
		String ln = in.nextLine();
		System.out.println("Nhap birth date: ");
		String bid;
		while (true) {
			bid = in.nextLine();
			if (CheckData.checkInputDateData(bid)) {
				break;
			} else {
				System.out.print("Invalid birthdate. Please reenter: ");
			}
		}

		System.out.println("Nhap phone: ");
		String p;
		while (true) {
			p = in.nextLine();
			if (CheckData.checkInputPhoneData(p)) {
				break;
			} else {
				System.out.print("Invalid phone. Please reenter: ");
			}
		}
		System.out.println("Nhap email: ");
		String email;
		while (true) {
			email = in.nextLine();
			if (CheckData.checkInputEmailData(email)) {
				break;
			} else {
				System.out.print("Invalid email. Please reenter: ");
			}
		}
		System.out.println("Nhap wage: ");
		double wage = Double.parseDouble(in.nextLine());
		System.out.println("Nhap workingHours: ");
		double wH = Double.parseDouble(in.nextLine());
		HourlyEmployee he = new HourlyEmployee(wage, wH, id, fn, ln, bid, p, email);
		return he;
	}

	public static SalariedEmployee salariedEmployee(String id) {
		System.out.println("Nhap first name: ");
		String fn = in.nextLine();
		System.out.println("Nhap last name: ");
		String ln = in.nextLine();
		System.out.println("Nhap birth date: ");
		String bid;
		while (true) {
			bid = in.nextLine();
			if (CheckData.checkInputDateData(bid)) {
				break;
			} else {
				System.out.print("Invalid birthdate. Please reenter: ");
			}
		}

		System.out.println("Nhap phone: ");
		String p;
		while (true) {
			p = in.nextLine();
			if (CheckData.checkInputPhoneData(p)) {
				break;
			} else {
				System.out.print("Invalid phone. Please reenter: ");
			}
		}
		System.out.println("Nhap email: ");
		String email;
		while (true) {
			email = in.nextLine();
			if (CheckData.checkInputEmailData(email)) {
				break;
			} else {
				System.out.print("Invalid email. Please reenter: ");
			}
		}
		System.out.println("Nhap commissionRate: ");
		double cR = Double.parseDouble(in.nextLine());
		System.out.println("Nhap grossSales: ");
		double gS = Double.parseDouble(in.nextLine());
		System.out.println("Nhap basicSalary: ");
		double bS = Double.parseDouble(in.nextLine());
		SalariedEmployee se = new SalariedEmployee(cR, gS, bS, id, fn, ln, bid, p, email);
		return se;
	}
}
