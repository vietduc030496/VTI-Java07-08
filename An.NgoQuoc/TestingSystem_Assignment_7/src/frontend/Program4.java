package frontend;

import backend.Exercise4;
import entity.Employee;

public class Program4 {
	public static void main(String [] arg) throws Exception {
		Exercise4 ex4 = new Exercise4();

		//Q1
		String content = ex4.readFile("JAVA\\Folder1\\file1.txt");
		System.out.println(content);

		
		/*
		//Q2
		String content = "Nội dụng mới";
		ex4.writeFile("D:\\JAVA\\Folder1\\file1.txt", true, content);
		*/
		
		/*
		//Q3
		Employee e = new Employee("Ngo Quoc An", 123456);
		ex4.writeObject(e, "D:\\JAVA\\Folder1", "file2.txt");
		*/
		
		/*
		//Q4
		Employee e = (Employee) ex4.readObject("D:\\JAVA\\Folder1\\file2.txt");
		System.out.println(e.getName() + " " + e.getSalary());
		*/
	}
}
