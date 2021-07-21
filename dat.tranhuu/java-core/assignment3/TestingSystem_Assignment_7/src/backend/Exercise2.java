package backend;

import java.io.File;
import java.io.IOException;

public class Exercise2 {

	public void createNewFile(String pathFile) {
		File f = new File(pathFile);
		try {
			f.createNewFile();
			System.out.println("ok");
		} catch (IOException e) {
			System.out.println("Error!");
		}

	}

	public void createNewFile(String path, String fileName) {
		File f = new File(path, fileName);
		try {
			f.createNewFile();
			System.out.println("ok");
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}
}
