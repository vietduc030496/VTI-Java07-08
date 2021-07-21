package backend;

import java.io.File;

public class Exercise1 {
	public boolean isFileExist(String path) {
		File f = new File(path);
		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}
}
