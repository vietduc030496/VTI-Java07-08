package backend;

import java.io.File;

public class Exercise5 {
	public boolean isFolder(String path) {
		File f = new File(path);
		if (f.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}
}
