package backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
	public static boolean isFileExists(String pathFile) throws IOException {
		File f = new File(pathFile);
		if (f.exists()) {
//			System.out.println("File Exists");
			return true;
		} else {
//			System.out.println("File doesn't exists");
			return false;
		}
	}

	public static void createNewFile(String pathFile) {
		Path path = Paths.get(pathFile);
		try {
			Files.createFile(path);
			System.out.println("File has been created");
		} catch (FileAlreadyExistsException e) {
			System.err.println("Error! File Exist");
		} catch (IOException e) {
			System.out.println("Error!");
		}
		
	}

	public static void createNewFile(String pathFile, String fileName) throws IOException {
		Path path = Paths.get(pathFile + "/" + fileName);
		try {
			Files.createFile(path);
			System.out.println("File has been created");
		} catch (

		FileAlreadyExistsException e) {
			System.err.println("Error! File Exist");
		}
	}

	public static void deleteFile(String pathFile) {
		try {
			Files.deleteIfExists(Paths.get(pathFile));
		} catch (NoSuchFileException e) {
			System.out.println("Error! File Not Exist.");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Error");
		}

		System.out.println("Deletion successful.");
	}

	public static boolean isFolder(String path) {
		Path file = new File(path).toPath();
		if (Files.isDirectory(file)) {
			System.out.println("This is folder");
			return true;
		} else if (Files.isRegularFile(file)) {
			System.out.println("This is file");
			return true;
		} else {
			return false;
		}
	}

	public static List<String> getAllFileName(String path) throws IOException {
		List<String> l = new ArrayList<>();
		File directoryPath = new File(path);
		Path file = new File(path).toPath();
		if (Files.isDirectory(file)) {
			String contents[] = directoryPath.list();
			for (int i = 0; i < contents.length; i++) {
				l.add(contents[i]);
			}
		} else {
			System.out.println("Error! Path is not folder.");
		}
		return l;
	}

	public static void copyFile(String sourceFile, String destinationPath, String newName) {
		Path source = Paths.get(sourceFile);
		Path target = Paths.get(destinationPath);

		try {
			Files.move(source, target.resolveSibling(newName));
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

	public static void copyFile(String sourceFile, String newPath) {
		Path source = Paths.get(sourceFile);
		Path target = Paths.get(newPath);

		try {
			Files.move(source, target);
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

	public static void moveFile(String sourceFile, String destinationPath) throws IOException {
		Path temp = Files.move(Paths.get(sourceFile), Paths.get(destinationPath));

		if (temp != null) {
			System.out.println("File renamed and moved successfully");
		} else {
			System.out.println("Error! File Not Exist");
		}
	}

	public static void renameFile(String pathFile, String newName) {
		Path oldFile = Paths.get(pathFile);

		try {
			Files.move(oldFile, oldFile.resolveSibling(newName));
			System.out.println("File Successfully Rename");
		} catch (IOException e) {
			System.out.println("Error! File Not Exist and Name Exist");
		}
	}

	public static void createNewFolder(String newPathFolder) {
		try {

			Path path = Paths.get(newPathFolder);

			Files.createDirectories(path);

			System.out.println("Directory is created!");

		} catch (IOException e) {
			System.err.println("Error! Folder Exist");
		}
	}

}
