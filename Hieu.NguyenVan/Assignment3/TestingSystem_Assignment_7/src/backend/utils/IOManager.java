package backend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class IOManager {

	// question 1
	public String readFile(String pathFile) throws Exception {
		FileManager fileManager = new FileManager();
		String result = "";
		if (fileManager.isFileExists(pathFile)) {
			throw new Exception("\"Error! File Not Exist.\"");
		}

		try {
			Scanner scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				result += scanner.nextLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// question 2
	public void writeFile(String pathFile, boolean isContinuing, String content) throws Exception {
		FileManager fileManager = new FileManager();
		File file = new File(pathFile);
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = null;
		if (!fileManager.isFileExists(pathFile)) {

			throw new Exception("Error! File Not Exist.");

		}

		if (isContinuing) {
			fos = new FileOutputStream(file, true);

		} else {
			fos = new FileOutputStream(file);
		}
		fos.write(content.getBytes());

	}

	// question 3
	@SuppressWarnings("resource")
	public void writeObject(Object object, String path, String fileName) throws Exception {
		File file = new File(path);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (!file.exists()) {
			file.mkdir();
		}
		if (object == null) {
			throw new Exception("Error! Object is Null.");
		}
		file = new File(path + File.pathSeparator + fileName);
		try {
			file.createNewFile();
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
//				fos.write(object.toString().getBytes());
			oos.writeObject(object);
			fos.close();
			oos.close();

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// question 4
	public Object readObject(String filePath) {
		File file = new File(filePath);
		Object result = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = ois.readObject();
		} catch (FileNotFoundException e) {
			System.err.println("Error! File Not Exist.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
}
