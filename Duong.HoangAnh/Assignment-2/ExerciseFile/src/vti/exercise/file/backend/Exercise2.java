package vti.exercise.file.backend;

import java.io.File;
import java.io.IOException;

public class Exercise2 {

	public void createNewFile(String pathFile) {
		try {
			File file = new File(pathFile);
			if (file.createNewFile()) {
				System.out.println("Tao file : " + file.getName());
			} else {
				System.out.println("File ton tai.");
			}
		} catch (IOException e) {
			System.out.println("Loi !");
		}
	}

	public void createNewFile(String path, String fileName) {
		String pathFile = path + "\\" + fileName;
		createNewFile(pathFile);
	}
}
