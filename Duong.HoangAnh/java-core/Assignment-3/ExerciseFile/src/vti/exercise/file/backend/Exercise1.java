package vti.exercise.file.backend;

import java.io.File;

public class Exercise1 {
	public boolean isFileExists(String pathFile) {
		boolean result = new File(pathFile).exists();
		return result;
	}
}
