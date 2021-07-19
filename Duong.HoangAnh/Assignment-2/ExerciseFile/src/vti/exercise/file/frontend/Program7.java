package vti.exercise.file.frontend;

import java.util.Scanner;

import vti.exercise.file.backend.Exercise7;

public class Program7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise7 test = new Exercise7();
		Scanner input = new Scanner(System.in);
		String sourceFile = input.nextLine();
		String destinationPath = input.nextLine();
		test.moveFile(sourceFile, destinationPath);
		input.close();
	}
}
