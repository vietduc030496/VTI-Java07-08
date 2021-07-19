package vti.exercise.file.backend;

import java.io.*;

public class Exercise9 {
	public void createNewFolder(String newPathFolder) throws Exception {
		File folder = new File(newPathFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		} else {
			throw new Exception("Error! Folder Exist");
		}
	}
}
