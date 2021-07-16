package service;

import java.util.ArrayList;

import entity.*;

public class EmployeeDisplay {
	public static void EmpDisplay(ArrayList<Department> d) {
		for (Department de : d) {
			de.display();
		}
	}

}
