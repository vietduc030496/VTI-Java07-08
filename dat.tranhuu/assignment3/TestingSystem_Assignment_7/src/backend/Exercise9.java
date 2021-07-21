package backend;

import java.io.File;

public class Exercise9 {
	public void renameFile(String pathFile, String newName) {
		File f = new File(pathFile);
		f.renameTo(new File(f.getParentFile().getPath(), newName));
	}
}
