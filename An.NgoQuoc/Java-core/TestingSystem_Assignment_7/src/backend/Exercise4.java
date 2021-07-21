package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Exercise4 {
	private Exercise3 ex3 = new Exercise3();
	public String readFile(String pathFile) throws Exception {
		if(!ex3.isFileExists(pathFile)) {
			throw new Exception("Error! File Not Exist");
		}
		String content="";
		FileInputStream fis = new FileInputStream(pathFile);
		Scanner sc = new Scanner(fis);
		while(sc.hasNextLine()) {
			content = content + sc.nextLine();
		}
		sc.close();
		fis.close();
		return content;
	}
	public void writeFile(String pathFile,Boolean isContinuing, String content) throws Exception {
		if(!ex3.isFileExists(pathFile)) {
			throw new Exception("Error! File Not Exist");
		}
		FileWriter fw = new FileWriter(pathFile, isContinuing);
		fw.write(content);
		fw.close();
	}
	public void writeObject(Object object,String path,String fileName) throws Exception {
		//check null
		if(object == null) {
			throw new Exception("Error! Object is Null.");
		}
		//check folder
		File folder = new File(path);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		//write file by Object
		String pathFile = path + File.separator + fileName;
		FileOutputStream fos = new FileOutputStream(pathFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(object);
		oos.close();
		fos.close();
	}
	public Object readObject(String filePath) throws Exception {
		Object object = null;
		if(!ex3.isFileExists(filePath)) {
			throw new Exception("Error! File Not Exist");
		}
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		object = ois.readObject();
		ois.close();
		fis.close();
		return object;
	}
}
