package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.backend.FileManager;

public class Ex3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileManager run = new FileManager();

		boolean exit = false;

		// change path to apply
		String path = "";
		String newPath = "";

		while (exit == false) {
			System.out.print("Choose option: ");
			int x = sc.nextInt();
			switch (x) {
			case 0: {
				exit = true;
				break;
			}
			case 1: {
				System.out.println(run.isFileExist(path));
				break;
			}
			case 2: {
				run.createNewFile(path);
				break;
			}
			case 4: {
				run.deleteFile(path);
				break;
			}
			case 5: {
				System.out.println(run.isFolder(path));
				break;
			}
			case 6: {
				List<String> names = (List<String>) run.getAllFileName(path);
				for (String string : names) {
					System.out.println(string);
				}
				break;
			}
			case 7: {
				run.copyFile(path, newPath);
				break;
			}
			case 8: {
				run.moveFile(path, newPath);
				break;
			}
			case 9: {
				run.renameFile(path, newPath);
				break;
			}
			case 10: {
				run.createNewFolder(newPath);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
		}
		sc.close();
	}
}
