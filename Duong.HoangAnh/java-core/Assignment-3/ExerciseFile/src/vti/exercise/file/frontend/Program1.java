package vti.exercise.file.frontend;

import vti.exercise.file.backend.*;
import java.util.*;

public class Program1 {
	public static void main(String[] args) {
		Exercise1 test = new Exercise1();
		System.out.print("Nhap duong dan: ");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();
		if (test.isFileExists(path)) {
			System.out.print("Ton tai file");
		} else {
			System.out.print("Khong ton tai file");
		}
		input.close();
	}
}
