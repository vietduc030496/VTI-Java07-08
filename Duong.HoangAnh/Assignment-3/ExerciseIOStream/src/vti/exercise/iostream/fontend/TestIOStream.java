package vti.exercise.iostream.fontend;

import java.util.*;
import java.io.*;
import vti.exercise.iostream.util.*;

public class TestIOStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOManager iomanager = new IOManager();
		Student object = new Student("Duong", 21);
//		iomanager.writeFile("D:\\Downloads\\test.txt", false, "content");
		iomanager.writeObject(object, "D:\\Downloads", "test.txt");
		System.out.println(iomanager.readFile("D:\\Downloads\\test.txt"));
	}

}
