package vti.exercise.file.backend;

import java.io.File;
import java.util.*;

public class Exercise5 {
	public List<String> getAllFileName(String path) {
		List<String> listFile = new ArrayList<String>();
		File file = new File(path);
		if (file.isDirectory()) {
			for (File fileEntry : file.listFiles()) {
				if (fileEntry.isFile()) {
					listFile.add(fileEntry.getName());
				}
			}
			return listFile;
		}
		throw new IllegalArgumentException("Error! Path is not folder");
	}
}
