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

	public static void Employee() {
		int choice = 10;
		int id =0;
		while (choice != 0) {
			System.out.println("Chon type of Employee: ");
			System.out.println("-----------------------");
			System.out.println("1. SalariedEmployee ");
			System.out.println("2. HourlyEmployee ");
			System.out.println("0. Exit");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				id+=1;
				String ssn1 = String.valueOf(id); 
				SalariedEmployee Se = salariedEmployee(ssn1);
				break;
			case 2:
				id+=1;
				String ssn2 = String.valueOf(id);
				HourlyEmployee He = hourlyEmployee(ssn2);
				break;
			case 0:
				System.exit(0);
				break;

			}
		}

	}

	public HourlyEmployee hourlyEmployee(String id) {
		System.out.println("Nhap first name: ");
		String fn = in.nextLine();
		System.out.println("Nhap last name: ");
		String ln = in.nextLine();
		System.out.println("Nhap birth date: ");
		String bd = in.nextLine();
		System.out.println("Nhap phone: ");
		String p = in.nextLine();
		System.out.println("Nhap email: ");
		String email = in.nextLine();
		System.out.println("Nhap wage: ");
		double wage = Double.parseDouble(in.nextLine());
		System.out.println("Nhap workingHours: ");
		double wH = Double.parseDouble(in.nextLine());
		HourlyEmployee he = new HourlyEmployee(wage,wH,id,fn,ln,bd,p,email);
		
	}

	public SalariedEmployee salariedEmployee(int id) {
		System.out.println("Nhap first name: ");
		String fn = in.nextLine();
		System.out.println("Nhap last name: ");
		String ln = in.nextLine();
		System.out.println("Nhap birth date: ");
		String bd = in.nextLine();
		System.out.println("Nhap phone: ");
		String p = in.nextLine();
		System.out.println("Nhap email: ");
		String email = in.nextLine();
	}
}
