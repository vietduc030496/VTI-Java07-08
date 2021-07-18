package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import constant.Constant;

public class Exercise4 {
	private Exercise3 ex3 = new Exercise3();
	
	public String readFile(String pathFile) throws Exception {
		String st;
		BufferedReader br = new BufferedReader(new FileReader(pathFile));
		
		if (!ex3.isFileExists(pathFile)) {
			throw new Exception(Constant.fileNotExist);
		} else {			
			while ((st = br.readLine()) != null)
				return st;
		}
		return st;
	}

	public void writeFile(String pathFile, Boolean isContinuing, String content) throws Exception {
		if (!ex3.isFileExists(pathFile)) {
			throw new Exception(Constant.fileNotExist);
		} else {			
			FileWriter fw = new FileWriter(pathFile, isContinuing);
			fw.write(content);
			System.out.println("Writed file successfully!");
			fw.close();
		}
	}
	
	public void writeObject(Object object, String path, String fileName) throws Exception {
		File folder = new File(path);
		
		if(object == null) {
			throw new Exception(Constant.objectNull);
		}
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/" + fileName));
		oos.writeObject(object);
		System.out.println("Written object successfully!");
		oos.close();
	}
	
	public Object readObject(String filePath) throws Exception {
		Object object = null;
		if(!ex3.isFileExists(filePath)) {
			throw new Exception("Error! File Not Exist");
		}
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		object = ois.readObject();
		ois.close();
		return object;
	}
}
