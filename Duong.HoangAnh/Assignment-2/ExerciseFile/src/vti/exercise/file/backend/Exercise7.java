package vti.exercise.file.backend;

import java.io.*;

public class Exercise7 {
	public void moveFile(String sourceFile, String destinationPath) {
		File file = new File(sourceFile);
		if (file.renameTo(new File(destinationPath))) {
			file.delete();
			System.out.println("Chuyen file thanh cong");
		} else {
			System.out.println("Chuyen file that bai");
		}
	}
}
