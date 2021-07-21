package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import backend.Exercise1;
import backend.Exercise10;

public class IOManager {
	public String readFile(String pathFile) {
		Exercise1 ex1= new Exercise1();
		if(ex1.isFileExist(pathFile)) {
			String s="";
			File f= new File(pathFile);
			try {
				Scanner read= new Scanner(f);
				while(read.hasNextLine()) {
					s+=read.nextLine()+"\n";
				}
				return s;
			} catch (FileNotFoundException e) {
				return "Error! File Not Exist";
			}
			
		}else {
			return "Error! File Not Exist";
		}
	}
	
	public void writeFile(String pathFile, boolean isContinuing, String content) {
		Exercise1 ex1= new Exercise1();
		if(ex1.isFileExist(pathFile)) {
			File f= new File(pathFile);
			try {
				FileWriter fw=null;
				if(isContinuing) {
					fw= new FileWriter(f,true);
					fw.write(content);
				}else {
					fw= new FileWriter(f);
					fw.write(content);
				}
				fw.close();
			} catch (IOException e) {
				System.out.println( "Error");
			}
		}else {
			System.out.println( "Error! File Not Exist");
		}
	}
	
	public void writeObject(Object object, String path, String fileName) {
		if(object==null) {
			System.out.println("Error! Object is Null.");
		}else {
			Exercise10 ex10= new Exercise10();
			ex10.createNewFolder(path);
			File f= new File(new File(path),fileName);
			try {
				FileOutputStream fo= new FileOutputStream(f);
				ObjectOutputStream objectOut = new ObjectOutputStream(fo);
				objectOut.writeObject(object);
	            objectOut.close();
			} catch (IOException e) {
				System.out.println("Error");
			}
			
		}
	}
	
	public Object readObject(String filePath) {
		Exercise1 ex1= new Exercise1();
		if(ex1.isFileExist(filePath)) {
			File f= new File(filePath);
			FileInputStream fileIn;
			try {
				fileIn = new FileInputStream(f);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				 
	            Object obj = objectIn.readObject();
	            objectIn.close();
	            return obj;
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("err");
				return new Object();
			}
		}else {
			return new Object();
		}
	}
}
