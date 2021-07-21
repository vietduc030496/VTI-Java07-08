package vti.exercise.file.backend;

import java.io.File;

public class Exercise3 {
	public void deleteFile(String pathFile) {
		File file = new File(pathFile);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("Xoa file: " + file.getName());
			} else {
				System.out.println("khong xoa duoc!");
			}
		} else {
			System.out.println("File ko ton tai!");
		}
	}
}
