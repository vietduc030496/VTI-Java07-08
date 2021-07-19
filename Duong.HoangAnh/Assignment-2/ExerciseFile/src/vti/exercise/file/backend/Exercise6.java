package vti.exercise.file.backend;

import java.io.*;

public class Exercise6 {

	public void copyFile(String sourceFile, String distinationPath, String newName) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		File source = new File(sourceFile);
		File dest = new File(distinationPath + "\\" + newName);
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	public void copyFile(String sourceFile, String distinationPath) throws IOException {
		File fileSource = new File(sourceFile);
		copyFile(sourceFile, distinationPath, fileSource.getName() + ".copy");
	}
}
