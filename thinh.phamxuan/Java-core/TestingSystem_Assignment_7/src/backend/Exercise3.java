package backend;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import constant.Constant;

public class Exercise3 {
	public boolean isFileExists(String pathFile) {
		File file=new File(pathFile);
		if(file.exists()) {
			return true;
		}
		else {
			return false;
		}
	
	}
	public void createNewFile(String pathFile) throws Exception{
		if(isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_EXISTS);
		}else {
			File file=new File(pathFile);
			file.createNewFile();

		}
	}
	public void createNewFile(String path,String pathFile) throws Exception {
		String pathFileName=path+"//"+pathFile;
		createNewFile(pathFileName);
		
	}
	public void deleteFile(String pathFile) throws Exception {
		if(!isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}else {
			File file=new File(pathFile);
			file.delete();

		}
	}
	public boolean isFolder(String path) {
		File file=new File(path);
		return file.isDirectory() ? true : false;
	}
	public List<String> getAllFileName(String path) throws Exception{
		if(isFolder(path)) {
			throw new Exception(Constant.PATH_IS_NOT_FOLDER);
		}
		else {
			List<String> list=new ArrayList<>();
			File file=new File(path);
			File[] files=file.listFiles();
			for(File f:files) {
				if(f.isDirectory()) {
					list.add(f.getName());
				}
			}
			return list;
		}
		
	}
	public void copyFile(String sourceFile,String destinationPath,String newName) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(Constant.SOURCE_FILE_NOT_EXISTS);
		}else {
			String destinationFile=destinationPath+"//"+newName;
			File source=new File(sourceFile);
			File dest=new File(destinationFile);
			Files.copy(source.toPath(), dest.toPath());
		}
		
	}
	public void copyFile(String sourceFile,String newPath) throws Exception  {
			File source=new File(sourceFile);
			copyFile(sourceFile, newPath,source.getName());
	}
	public void moveFile(String sourceFile,String destinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(Constant.SOURCE_FILE_NOT_EXISTS);
		}else {
			File source=new File(sourceFile);
			File dest=new File(destinationPath);
			Files.move(source.toPath(), dest.toPath());
			deleteFile(sourceFile);
		}
	}
	public void renameFile(String pathFile,String newName) throws Exception {
		if(!isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
		if (isFileExists(newName)) {
			throw new Exception(Constant.NAME_IS_EXIST);
		}
		File oldFile = new File(pathFile);
		File newFile = new File(newName);
		oldFile.renameTo(newFile);
	}
	public void createNewFolder(String newPathFolder) throws Exception {
		File f=new File(newPathFolder);
		if(f.exists()) {
			throw new Exception(Constant.FOLDER_EXISTS);
		}
		else {
			f.mkdir();
		}
	}
}
