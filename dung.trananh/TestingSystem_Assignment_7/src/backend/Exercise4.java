package backend;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;

public class Exercise4 {
	public static String readFile(String pathFile) {
		String data = "";
		try {
			data = new String(Files.readAllBytes(Paths.get(pathFile)));
		} catch (IOException e) {
			System.out.println("Error! File Not Exist");
		}
		return data;
	}

	public static void writeFile(String pathFile, boolean isContinuing, String content) {
		try {
			FileWriter fw;
			fw = new FileWriter(pathFile, isContinuing);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
	}

	public static void writeObject(Object object, String path, String fileName) {
		try {
			if (object == null) {
				System.out.println("Error! Object is Null.");
			} else {
				FileOutputStream out = new FileOutputStream(path + "\"" + fileName);
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(object);
				oos.flush();
				oos.close();
			}
		} catch (Exception e) {
			System.out.println("Error!");

		}
	}

	public static Object readObject(String filePath) {
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			Object obj = objectIn.readObject();

			System.out.println("The Object has been read from the file");
			objectIn.close();
			return obj;

		} catch (Exception ex) {
			System.out.println("Error");
			return null;
		}
	}
}
