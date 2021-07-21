package com.vti.backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.vti.entity.Person;

public class IOManager {
	private FileManager fm = new FileManager();

	// Question 1
	public String readFile(String pathFile) {
		String content = "";

		if (fm.isFileExist(pathFile) == false) {
			System.out.println("Error! File Not Exist");
		} else {
			try {
				File file = new File(pathFile);
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					content = sc.nextLine();
					System.out.println(content);
				}
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	// Question 2
	public void writeFile(String pathFile, String content, boolean isContinuing) {
		if (fm.isFileExist(pathFile) == false) {
			System.out.println("Error! File Not Exist");
		} else {
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File(pathFile), isContinuing));
				pw.println(content);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Question 3
	public void writeObject(Person person, String path) {
		if (person == null) {
			System.out.println("Error! Object is Null");
		} else {
			try {
				FileOutputStream fos = new FileOutputStream(new File(path));
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(person);
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Question 4
	public Person readObject(String filePath) {
		Person person = null;
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			ObjectInputStream ois = new ObjectInputStream(fis);

			person = (Person) ois.readObject();

			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error! File Not Exist");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}
}
