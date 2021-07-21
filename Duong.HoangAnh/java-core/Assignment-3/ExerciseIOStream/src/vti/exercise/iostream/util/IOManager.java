package vti.exercise.iostream.util;

import java.util.*;
import java.io.*;
import vti.exercise.iostream.util.*;

public class IOManager {
	public String readFile(String pathFile) {
		String result = "";
		try {
			File file = new File(pathFile);
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				result += data + "\n";
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error! File Not Exist.");
		}
		return result;
	}

	public void writeFile(String pathFile, boolean isContinuing, String content) {
		FileWriter fooWriter;
		try {
			File file = new File(pathFile);
			if (!isContinuing) {
				fooWriter = new FileWriter(file, false);
			} else {
				fooWriter = new FileWriter(file, true);
			}
			fooWriter.write(content + "\n");
			fooWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error! File Not Exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeObject(Student object, String path, String fileName) {
		try {
			File folder = new File(path);
			File file = new File(path + "\\" + fileName);
			if (folder.exists() && folder.isDirectory()) {
				if (file.exists()) {
					FileOutputStream fileOut = new FileOutputStream(file);
					ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
					objectOut.writeObject(object);
					objectOut.close();
				} else {
					file.createNewFile();
					FileOutputStream fileOut = new FileOutputStream(path + "\\" + fileName);
					ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
					objectOut.writeObject(object);
					objectOut.close();
				}
			} else {
				folder.mkdirs();
				file.createNewFile();
				FileOutputStream fileOut = new FileOutputStream(path + "\\" + fileName);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(object);
				objectOut.close();
			}
		} catch (NullPointerException e) {
			System.out.println("Error! Object is Null.");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public Object readObject(String filePath) {
		Student res = new Student();
		try {
			File file = new File(filePath);
			if (file.exists()) {
				FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
				ObjectInputStream oi = new ObjectInputStream(fi);
				res = (Student) oi.readObject();
				System.out.println(res.toString());
				oi.close();
				fi.close();
			}
		} catch (NullPointerException e) {
			System.out.println("Error! Object is Null.");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}
}
