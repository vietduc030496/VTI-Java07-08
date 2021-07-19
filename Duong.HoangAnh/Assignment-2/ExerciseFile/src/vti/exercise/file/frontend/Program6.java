package vti.exercise.file.frontend;

import java.io.IOException;
import java.util.Scanner;

import vti.exercise.file.backend.Exercise6;

public class Program6 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Exercise6 test = new Exercise6();
		Scanner input = new Scanner(System.in);
		String pathSource = input.nextLine();
		String pathDe = input.nextLine();
		test.copyFile(pathSource, pathDe);
		input.close();
	}
}
