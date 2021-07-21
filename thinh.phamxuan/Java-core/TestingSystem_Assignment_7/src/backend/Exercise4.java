package backend;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import constant.Constant;
public class Exercise4 {
	private Exercise3 exercise3=new Exercise3();
	public static String readFile(String pathFile) throws Exception {
		if (!exercise3.isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
	
		FileInputStream fis = new FileInputStream(pathFile);
	
		fis.close();
		return ;
	}

	public void writeFile(String pathFile, boolean isContinuing, String content) throws Exception {
		if (!exercise3.isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
		FileOutputStream out = new FileOutputStream(pathFile, isContinuing);
		out.write(content.getBytes());
		out.close();

	}

	public static void writeObject(Object object, String path, String fileName) throws Exception {
		if (!exercise3.isFileExists(path)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
	
		FileOutputStream out = new FileOutputStream(path);
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		objectOut.writeObject(object);
		out.close();
		objectOut.close();
		
	}



	public static Object readObject(String filePath) throws Exception {
		if (!exercise3.isFileExists(filePath)) {
			throw new Exception(ConstantsFILE_NOT_EXISTS);
		}
		FileInputStream in = null;
		ObjectInputStream objectIn = null;
		try {
			in = new FileInputStream(filePath);
			objectIn = new ObjectInputStream(in);

			return objectIn.readObject();
		} finally {
			in.close();
			objectIn.close();
		}

	}
}
