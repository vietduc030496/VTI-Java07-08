package frontend;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import backend.Exercise3;
public class Program3 {
	public static void main(String[] arg) throws Exception {
		String folder1 = "D:\\JAVA\\Folder1";
		String folder2 = "D:\\JAVA\\Folder2";
		Exercise3 ex3 = new Exercise3();
		
		//Q1
		boolean fileIsExist = ex3.isFileExists(folder1 + "\\" + "file1");
		System.out.println(fileIsExist);
		
		
		/*
		//Q2
		ex3.createNewFile(folder1 + "\\" + "file2.txt");
		ex3.createNewFile(folder1, "file2.txt");
		*/
		
		/*
		//Q4
		ex3.deleteFile(folder1 + "\\" + "file2.txt");
		*/
		
		/*
		//Q5
		boolean isFolder = ex3.isFolder(folder1);
		System.out.println(isFolder);
		*/
		
		/*
		//Q6
		List<String> listFileName = ex3.getAllFileName(folder1);
		System.out.println(listFileName);
		*/
		
		/*
		//Q7
		ex3.copyFile(folder1 + "\\" + "file1.txt", folder2, "file1_copy.txt");
		ex3.copyFile(folder1 + "\\" + "file1.txt", folder2);
		*/
		
		/*
		//Q8
		ex3.moveFile(folder1 + "\\" + "file2.txt", folder2);
		*/
		
		/*
		//Q9
		ex3.createNewFolder("D:\\JAVA\\Folder3");
		*/
	}
}
