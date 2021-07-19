package backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Exercise8 {
	public void moveFile(String sourceFile, String destinationPath) {
		File f = new File(sourceFile);
		try {
			Files.move(f.toPath(), new File(destinationPath, f.getName()).toPath(), StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			System.out.println("Error! File Not Exist.");
			e.printStackTrace();
		}
	}
}
