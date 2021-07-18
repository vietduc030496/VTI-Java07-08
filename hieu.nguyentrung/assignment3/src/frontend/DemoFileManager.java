package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.*;

public class DemoFileManager {

	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\LENOVO\\Desktop\\Test";
		String sourcePath = "C:\\Users\\LENOVO\\Desktop\\Test456.txt";
		String destinationPath = "C:\\Users\\LENOVO\\Desktop\\Test121356.txt";
		String newPathFolder= "C:\\Users\\LENOVO\\Desktop\\Hieunguyen2903";
		File x = new File(path);
		FileManager fM = new FileManager();
		int choice;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("*****************");
			System.out.println("1.Check file exists!");
			System.out.println("2.Create file !");
			System.out.println("3.Delete file !");
			System.out.println("4.Check path is File or Folder !");
			System.out.println("5.Get all File name of Folder !");
			System.out.println("6.Copy File !");
			System.out.println("7.Moving file !");
			System.out.println("8.Rename file !");
			System.out.println("9.Create new Folder !");
			System.out.println("0.Exit!");
			System.out.println("*****************");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				if (fM.isFileExists(path)) {
					System.out.println("this file exists!!");
				} else {
					System.out.println("This file doesn't exist");
				}
				break;
			case 2:
				if (fM.isFileExists(path) == false) {
					fM.createNewFile(path);
					System.out.println("Successfully!");
				}
				break;
			case 3:
				if (fM.isFileExists(path)) {
					fM.deleteFile(path);
					System.out.println("Delete Successfully!!");
				}
				break;
			case 4:
				if (fM.isFolder(path)) {
					System.out.println("This is folder!!");
				} else {
					System.out.println("This is file!!");
				}
				break;
			case 5:
				fM.getAllFileName(x);
				break;
			case 6:
//				try {
					fM.copyFileUsingStream();
//				} catch (FileNotFoundException e) {
//					System.out.println("\"Error! Source File Not Exist.\"");
//				}
			case 7:
				fM.moveFile(sourcePath, destinationPath);
				fM.deleteFile(sourcePath);
				break;
			case 8:
				fM.renameFile(sourcePath, destinationPath);
				break;
			case 9:
				fM.createNewFolder(newPathFolder);
				break;
			case 0:
				System.exit(0);
				System.out.println("Bye!!");
			}
		}
	}

}
