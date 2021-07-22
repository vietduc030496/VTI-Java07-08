package backend.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	public FileManager() {
		
	}
	// q1
	public boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
		boolean result = file.exists();
		return result;
	}

	// q2
	public void createNewFile(String pathFile) {
		File file = new File(pathFile);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Error!\r\n" + "File Exist.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createNewFile(String path, String fileName) {
		File file = new File(path + "/" + fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Error!\r\n" + "File Exist.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// question 4
	public void deleteFile(String pathFile) {
		File file = new File(pathFile);
		file.deleteOnExit();
		file.delete();
	}

	// question 5
	public boolean isFolder(String path) {
		File file = new File(path);
		boolean result = file.isDirectory();
		return result;
	}

	// question 6

	public List<String> getAllFileName(String path) throws Exception {

		List<String> result = new ArrayList<String>();
		File superdir = new File(path);
		if (superdir.isDirectory()) {
			File[] listFile = superdir.listFiles();
			
			for (File file : listFile) {
				String name = file.getName();
				result.add(name);
			}

			return result;

		} else {
			
			throw new Exception("Error! Path is not folder.");
		}

	}

	// question 7
	public void copyFile(String sourceFile, String destinationPath, String newName) throws Exception {
		File source = new File(sourceFile);
		File destination =new File(destinationPath+"/" + newName);
		
		if(!source.exists()) {
			throw new Exception("Error! Source File Not Exist." );
		}
		if(destination.exists()) {
			throw new  Exception("Error! newPath has File same name.");
		}
		Files.copy(source.toPath(), destination.toPath());
	
	}

	public void copyFile(String sourceFile, String newPath) throws Exception {
		File source = new File(sourceFile);
		String newName=source.getName();
		File destination =new File(newPath +  "/" + newName);		
		if(!source.exists()) {
			throw new Exception("Error! Source File Not Exist." );
		}
//		if(destination.exists()) {
//			throw new  Exception("Error! newPath has File same name.");
//		}
		Files.copy(source.toPath(), destination.toPath());

	}

	// question 8
	public void moveFile(String sourceFile, String destinationPath) throws Exception {
		File source = new File(sourceFile);
		String newName=source.getName();
		File destination =new File(destinationPath +  "/" + newName);		
		if(!source.exists()) {
			throw new Exception("Error! Source File Not Exist." );
		}
		if(destination.exists()) {
			throw new  Exception("Error! newPath has File same name.");
		}
		Files.copy(source.toPath(), destination.toPath());
		source.delete();
		
	}

	// question 9
	public void renameFile(String pathFile, String newName) throws Exception {
		File file =new File(pathFile);
		if(!file.exists()) {
			throw new Exception("Error! File Not Exist.");
		}
		
		String destinationPath  = file.getParent()+"/" + newName;
		File newFile=new File(destinationPath);
		if(newFile.exists()) {
			throw new Exception("Error! Name is Exist.");
		}
		file.renameTo(newFile);
	}

	// question 10
	public void createNewFolder(String newPathFolder) throws Exception {
		File file =new File(newPathFolder);
		
		if(file.exists()) {
			throw new Exception("Error! Folder Exist.");
		}
		file.mkdir();
	}
}
