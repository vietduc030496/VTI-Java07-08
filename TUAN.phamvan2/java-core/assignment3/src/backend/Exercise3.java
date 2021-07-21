package backend;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import constant.Constant;

public class Exercise3 {
	public boolean isFileExists(String pathFile) {
		File f = new File(pathFile);
		if (f.exists()) {
			return true;
		}
		return false;
	}

	public void createNewFile(String pathFile) throws Exception {
		File f = new File(pathFile);
		if (f.exists()) {
			throw new Exception(Constant.fileExist);
		} else {
			f.createNewFile();
			System.out.println("Created successfully!");
		}
	}

	public void createNewFile(String path, String fileName) throws Exception {
		File f = new File(path + "/" + fileName);
		if (f.exists()) {
			throw new Exception(Constant.fileExist);
		} else {
			f.createNewFile();
			System.out.println("Created successfully!");
		}
	}

	public void deleteFile(String pathFile) throws Exception {
		File f = new File(pathFile);
		if (f.exists()) {
			f.delete();
			System.out.println("Deleted successfully!");
		} else
			throw new Exception(Constant.fileNotExist);
	}

	public boolean isFolder(String path) {
		File f = new File(path);
		if (f.isDirectory()) {
			return true;
		}
		return false;
	}

	public List<String> getAllFileName(String path) throws Exception {
		List<String> list = new ArrayList<>();
		File f = new File(path);
		if (!f.isDirectory()) {
			throw new Exception(Constant.notFolder);
		} else {
			File[] files = f.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					list.add(file.getName());
				}
			}
		}
		return list;
	}

	public void copyFile(String sourceFile, String distinationPath, String newName) throws Exception {
		File f1 = new File(sourceFile);
		File f2 = new File(distinationPath + "/" + newName);

		if (f1.exists()) {
			List<String> filesInFolder = getAllFileName(distinationPath);
			for (String fileName : filesInFolder) {
				if (fileName.equals(newName)) {
					throw new Exception(Constant.newPathExist);
				}
			}
			Files.copy(f1.toPath(), f2.toPath());
		} else {
			throw new Exception(Constant.srcNotExist);
		}
	}

	public void copyFile(String sourceFile, String newPath) throws Exception {
		File f = new File(sourceFile);
		String fileName = f.getName();
		copyFile(sourceFile, newPath, fileName);
	}

	public void moveFile(String sourceFile, String destinationPath) throws Exception {
		copyFile(sourceFile, destinationPath);
		deleteFile(sourceFile);
		System.out.println("Moved successfully!");
	}

	public void renameFile(String pathFile, String newName) throws Exception {
		if (!isFileExists(pathFile)) {
			throw new Exception(Constant.fileExist);
		} else {
			String pathFolder = (String) pathFile.subSequence(0, pathFile.lastIndexOf("/"));
			File oldfile = new File(pathFile);
			File newfile = new File(pathFolder + "/" + newName);
			oldfile.renameTo(newfile);
			
			System.out.println("Renamed successfully!");
		}
	}

	public void createNewFolder(String newPathFolder) throws Exception {
		File folder = new File(newPathFolder);
		if (folder.exists()) {
			throw new Exception(Constant.folderExist);
		}
		folder.mkdirs();
		System.out.println("Created successfully!");
	}
}
