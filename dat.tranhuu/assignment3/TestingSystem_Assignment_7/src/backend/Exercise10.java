package backend;

import java.io.File;

public class Exercise10 {
	public void createNewFolder(String newPathFolder) {
		File f = new File(newPathFolder);
		if (f.mkdir()) {
			System.out.println("ok");
		} else {
			System.out.println("err");
		}
	}
}
