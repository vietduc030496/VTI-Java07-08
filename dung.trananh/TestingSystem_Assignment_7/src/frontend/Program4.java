package frontend;

import java.io.IOException;
import entity.*;
import backend.Exercise4;

public class Program4 {
	public static void main(String[] args) throws IOException {
		Employee emp = new Employee("Dung","Tran");
		
		//Q1
//		Exercise4.readFile(null);
		//Q2
//		Exercise4.writeFile(null, false, null);
//		//Q3
//		Exercise4.writeObject(emp,"C:\\Users\\ADMIN\\eclipse-workspace\\TestingSystem_Assignment_7\\" , "test2.txt");
//		//Q4
		emp = (Employee) Exercise4.readObject("C:\\Users\\ADMIN\\eclipse-workspace\\TestingSystem_Assignment_7\\test2.txt");
		System.out.println(emp.getFirstname());
		System.out.println(emp.getLastname());
	}
}
