package vti.exercise.file.backend;

import java.io.File;

public class Exercise4 {
	public boolean isFolder(String path) {
		File file = new File(path);
		if (file.exists()) {
			return file.isDirectory();
		}
		throw new IllegalArgumentException("Khong ton tai !");
	}
}
