package backend;

import java.io.File;
import java.nio.file.Files;
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
	public void createNewFile(String path, String fileName) throws Exception {
		File file = new File(path + File.separator + fileName);
		if(file.exists()) {
			throw new Exception("Error! File Exist.");
		}
		else {
			file.createNewFile();
			System.out.println("File is created.");
		}
	}
	public void deleteFile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if(!file.exists()) {
			throw new Exception("Error! File Not Exist.");
		}
		else {
			file.delete();
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
	public void copyFile(String sourceFile, String distinationPath, String newName) throws Exception {
		File file1 = new File(sourceFile);
		File file2 = new File(distinationPath + File.separator + newName);
		if(!file1.exists()) {
			throw new Exception("Error! Source File Not Exist.");
		}
		else{
			List<String> listFileInFolder = getAllFileName(distinationPath);
			for (String fileName : listFileInFolder) {
				if(fileName.equals(newName)) {
					throw new Exception("Error! newPath has File same name.");
				}
			}
			//copy file
			Files.copy(file1.toPath(), file2.toPath());
		}
	}
	public void copyFile(String sourceFile, String newPath) throws Exception {
		File file = new File(sourceFile);
		String fileName = file.getName();
		copyFile(sourceFile, newPath, fileName);
	}
	public void moveFile(String sourceFile, String destinationPath) throws Exception {
		copyFile(sourceFile, destinationPath);
		deleteFile(sourceFile);
	}
	public void renameFile(String pathFile, String newName) throws Exception {
		if(!isFileExists(pathFile)) {
			throw new Exception("Error! File Exist.");
		}
		else {
			String pathFolder = (String) pathFile.subSequence(0, pathFile.lastIndexOf(File.separator));
			//C1:
			//File oldfile = new File(pathFile);			
			//File newfile = new File(pathFolder + File.separator + newName);
			//oldfile.renameTo(newfile);
			
			//C2:
			copyFile(pathFile, pathFolder,newName);
			deleteFile(pathFile);
		}
	}
	public void createNewFolder(String newPathFolder) throws Exception {
		File folder = new File(newPathFolder);
		if(folder.exists()) {
			throw new Exception("Error! Folder Exist");
		}
		folder.mkdirs();
	}
}
