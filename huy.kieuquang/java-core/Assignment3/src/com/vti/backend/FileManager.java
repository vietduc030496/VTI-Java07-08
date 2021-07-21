package com.vti.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	// question 1
	public boolean isFileExist(String pathFile) {
		Path path = Paths.get(pathFile);
		return Files.exists(path);
	}

	// question 2
	public void createNewFile(String pathFile) {
		if (isFileExist(pathFile)) {
			System.out.println("Error! File Exist");
		} else {
			try {
				File file = new File(pathFile);
				file.getParentFile().mkdirs();
				file.createNewFile();
				FileOutputStream fos = new FileOutputStream(file, false);
				fos.close();
				System.out.println("Created sucessfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// question 4
	public void deleteFile(String pathFile) {
		try {
			Files.deleteIfExists(Paths.get(pathFile));
			System.out.println("Deleted");
		} catch (FileNotFoundException e) {
			System.out.println("Error! File Exist");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// question 5
	public boolean isFolder(String path) {
		Path p = new File(path).toPath();
		if (Files.isRegularFile(p)) {
			return true;
		} else if (Files.isDirectory(p)) {
			return false;
		} else {
			System.out.println("Error");
			return false;
		}
	}

	// question 6
	public List<String> getAllFileName(String path) {
		List<String> fileNames = new ArrayList<>();
		if (isFolder(path)) {
			System.out.println("Error! Path is not folder");
		} else {
			File[] files = new File(path).listFiles();

			for (File file : files) {
				if (file.isFile()) {
					fileNames.add(file.getName());
				}
			}
		}

		return fileNames;
	}

	// question 7
	public void copyFile(String sourceFile, String newPath) {
		try {
			File source = new File(sourceFile);
			File dest = new File(newPath);

			Files.copy(source.toPath(), dest.toPath());
			System.out.println("Copy sucessful");
		} catch (NoSuchFileException e) {
			System.out.println("Error! Source File Not Exist");
		} catch (FileAlreadyExistsException e) {
			System.out.println("Error! newPath has File same name");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// question 8
	public void moveFile(String sourceFile, String destinationPath) {
		try {
			Files.move(Paths.get(sourceFile), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
		} catch (NoSuchFileException e) {
			System.out.println("Error! File Not Exist");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// question 9
	public void renameFile(String pathFile, String newName) {
		if (pathFile.equals(newName))
			System.out.println("Error! Name is Exist");
		else {
			try {
				Files.move(Paths.get(pathFile), Paths.get(newName), StandardCopyOption.ATOMIC_MOVE);
			} catch (NoSuchFileException e) {
				System.out.println("Error! File Not Exist");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// question 10
	public void createNewFolder(String newPathFolder) {
		try {
			Path p = new File(newPathFolder).toPath();
			if (Files.isDirectory(p)) {
				System.out.println("Error! Folder Exist");
			} else {
				Files.createDirectories(Paths.get(newPathFolder));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
