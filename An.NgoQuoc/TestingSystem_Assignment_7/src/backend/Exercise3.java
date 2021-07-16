package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
	public boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
		return file.exists();
		
	}
	public void createNewFile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if(file.exists()) {
			throw new Exception("Error! File Exist.");
		}
		else {
			file.createNewFile();
			System.out.println("File is created.");
		}
	}
	public void createNewFile(String path, String fileName) {
		
	}
	public void deleteFile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if(!file.exists()) {
			throw new Exception("Error! File Not Exist.");
		}
		else {
			file.delete();
			System.out.println("File is deleted");
		}
	}
	public boolean isFolder(String path) {
		File file = new File(path);
		if(file.isDirectory()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public List<String> getAllFileName(String path) throws Exception{
		File file = new File(path);
		List<String> listFilename = new ArrayList<String>();
		if(!file.isDirectory()) {
			throw new Exception("Error! Path is not folder.");
		}
		else {
			File[] listfile = file.listFiles();
			for (File file2 : listfile) {
				if(!file2.isDirectory()) {
					listFilename.add(file2.getName());
				}
			}
			return listFilename;
		}
		
	}
	public void copyFile(String sourceFile, String distinationPath, String newName) {
		
	}
	public void copyFile(String sourceFile, String newPath) {
		
	}
	public void moveFile(String sourceFile, String destinationPath) {
		
	}
	public void renameFile(String pathFile, String newName) {
		
	}
	public void createNewFolder(String newPathFolder) {
		
	}
}
