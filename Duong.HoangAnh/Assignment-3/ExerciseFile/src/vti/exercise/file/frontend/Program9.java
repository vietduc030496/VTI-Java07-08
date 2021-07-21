package vti.exercise.file.frontend;

import java.util.Scanner;

import vti.exercise.file.backend.Exercise9;

public class Program9 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Exercise9 test = new Exercise9();
		Scanner input = new Scanner(System.in);
		String pathName = input.nextLine();
		test.createNewFolder(pathName);
		input.close();
	}
}
