package vti.exercise.file.backend;

import java.io.*;

public class Exercise8 {
	public void renameFile(String pathFile, String newName) throws Exception {
		File file = new File(pathFile);
		if (file.exists()) {
			file.renameTo(new File(file.getParent() + "\\" + newName));
		} else {
			throw new Exception("Error! File Not Exist.");
		}
	}
}
