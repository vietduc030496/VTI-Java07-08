package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import utils.FileManager;

public class IOManager {
	FileManager fM = new FileManager();

	public String readFile(String pathFile) throws Exception{
		if (fM.isFileExists(pathFile)) {
			FileReader fr = new FileReader(pathFile);
			BufferedReader br = new BufferedReader(fr);
			int i;
			while ((i = br.read()) != -1) {
				System.out.print((char) i);
			}
			br.close();
			fr.close();
		}
		return fM.toString();
	}
	
//	public void writeFile(String pathFile) {
//		try {
//            FileWriter fw = new FileWriter(pathFile);
//            fw.write("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//            fw.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("Success...");
//    }
	public void writeFile(String pathFile, boolean isContinuing, String content) {
        try {
            FileWriter fw;
            fw = new FileWriter(pathFile, isContinuing);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error!!!!");
        }
    }

    public void writeObject(Object object, String path, String fileName) {
        try {
            if (object == null) {
                System.out.println("Error! Object is Null.");
            } else {
                FileOutputStream out = new FileOutputStream(path + "" + "" + fileName);
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(object);
                oos.flush();
                oos.close();
            }
        } catch (Exception e) {
            System.out.println("Error!");

        }
    }

    public Object readObject(String filePath) {
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
