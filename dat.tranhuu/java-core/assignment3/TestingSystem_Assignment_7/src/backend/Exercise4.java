package backend;

import java.io.File;

public class Exercise4 {
	public void deleteFile(String pathFile) {
		File f = new File(pathFile);
		if (f.delete()) {
			System.out.print("delete success");
		} else {
			System.out.print("Error! File Not Exist.");
		}

	}
}
