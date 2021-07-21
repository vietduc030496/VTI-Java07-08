package vti.exercise.file.frontend;

import java.util.Scanner;

import vti.exercise.file.backend.Exercise4;

public class Program4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise4 test = new Exercise4();
		Scanner input = new Scanner(System.in);
		String pathName = input.nextLine();
		System.out.println(test.isFolder(pathName));
		input.close();
	}
}
