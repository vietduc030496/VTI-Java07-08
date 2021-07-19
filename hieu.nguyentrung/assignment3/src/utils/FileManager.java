package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Formatter;
import java.util.List;

public class FileManager {
	File x;

	public boolean isFileExists(String pathFile) {
		x = new File(pathFile);
		if (x.exists()) {
//			System.out.println(x.getName() + " exists !");
			return true;
		} else {
//			System.out.println("The file doesn't exist");
			return false;
		}
	}

	public void createNewFile(String pathFile) throws Exception {
		try {
			if (isFileExists(pathFile)) {
				throw new Exception();
			} else {
				x.createNewFile();
				System.out.println("Created successfull!");
			}
		} catch (Exception e) {
			System.out.println("Error! File Exist");
		}
	}

	public void createNewFile(String path, String fileName) {

	}

	public void deleteFile(String pathFile) {
		try {
			if (isFileExists(pathFile)) {
				x.delete();
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Error! File Not Exist");
		}
	}

	public boolean isFolder(String path) {
		x = new File(path);
		if (x.isDirectory()) {
			return true;
		} else {
			if (x.isFile()) {
//				System.out.println();
			}
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

	public void copyFileUsingStream(String sourceFile, String newPath) throws Exception {
		InputStream inStream = null;
		OutputStream outStream = null;
		sourceFile = "C:\\Users\\LENOVO\\Desktop\\Test12.txt";
		newPath = "C:\\Users\\LENOVO\\Desktop\\Test4.txt";
		try {
			try {
				inStream = new FileInputStream(new File(sourceFile));
				outStream = new FileOutputStream(new File(newPath));
				int length;
				byte[] buffer = new byte[1024];

				while ((length = inStream.read(buffer)) > 0) {
					outStream.write(buffer, 0, length);
				}
				System.out.println("File is copied successful!");
			} catch (FileNotFoundException e) {
				System.out.println("\"Error! Source File Not Exist.\"");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				inStream.close();
				outStream.close();
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public void moveFile(String sourceFile, String destinationPath) throws Exception {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			try {
				File f1 = new File(sourceFile);
				File f2 = new File(destinationPath);
				inStream = new FileInputStream(f1);
				outStream = new FileOutputStream(f2);
				int length;
				byte[] buffer = new byte[1024];

				while ((length = inStream.read(buffer)) > 0) {
					outStream.write(buffer, 0, length);
				}
//				f1.delete();
				System.out.println("File is copied successful!");
			} catch (FileNotFoundException e) {
				System.out.println("\"Error! Source File Not Exist.\"");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				inStream.close();
				outStream.close();
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public void renameFile(String pathFile, String newName) throws Exception {
		File oldfile = new File(pathFile);
		File newfile = new File(newName);
		try {
			if (isFileExists(pathFile)) {
				oldfile.renameTo(newfile);
//				System.out.println("Rename successful");
				try {
					if (isFileExists(newName)) {
						throw new Exception();
					} else {
						System.out.println("Rename successful");
					}
				} catch (Exception e) {
					System.out.println("newName existed !! please pick a new name");
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Error! File doesn't exist ! ");
		}
	}

	public void createNewFolder(String newPathFolder) throws Exception {
		File file = new File(newPathFolder);
		try {
			if (!(file.exists())) {
				file.mkdir();
				System.out.println("Created Folder successful!!");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("New PathFolder exsited!! Please try again!!");
		}
	}
}
