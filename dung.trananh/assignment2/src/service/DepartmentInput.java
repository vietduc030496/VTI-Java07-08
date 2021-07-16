/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Scanner;

import entity.Department;

public class DepartmentInput {
	public static Department Department_Input() {
		
		System.out.println("Nhap ten phong ban: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		Department d = new Department(name);
		return d;
	}
}
