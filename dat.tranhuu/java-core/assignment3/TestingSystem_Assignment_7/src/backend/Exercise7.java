package backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Exercise7 {
	public void copyFile(String sourceFile, String distinationPath, String newName) {
		File f = new File(sourceFile);
		try {
			Files.copy(f.toPath(), (new File(distinationPath, newName)).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Error! Source File Not Exist.");
		}
	}

	public void copyFile(String sourceFile, String newPath) {
		File f = new File(sourceFile);
		try {
			Files.copy(f.toPath(), (new File(newPath, f.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Error! Source File Not Exist.");
		}
	}
}
