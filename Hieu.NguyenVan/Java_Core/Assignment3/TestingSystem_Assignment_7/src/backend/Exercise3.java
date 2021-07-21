package backend;

import java.util.List;

import backend.utils.FileManager;

public class Exercise3 {
	FileManager fileManager;

	public Exercise3() {
		fileManager = new FileManager();
	}

	public boolean question1(String pathFile) {
		return fileManager.isFileExists(pathFile);
	}

	public void question2(String pathFile) {
		fileManager.createNewFile(pathFile);
	}

	public void question2(String path, String fileName) {
		fileManager.createNewFile(path, fileName);
	}

	public void question3() {

	}

	public void question4(String pathFile) {
		fileManager.deleteFile(pathFile);
	}

	public boolean question5(String path) {
		return fileManager.isFolder(path);
	}

	public List<String> question6(String path) throws Exception {
		return  fileManager.getAllFileName(path);
	}

	public void question7(String sourceFile, String destinationPath, String newName) throws Exception {

		fileManager.copyFile(sourceFile, destinationPath, newName);
	}

	public void question7(String sourceFile, String newPath) throws Exception {
		fileManager.copyFile(sourceFile, newPath);
	}

	public void question8(String sourceFile, String destinationPath) throws Exception {
		fileManager.moveFile(sourceFile, destinationPath);
	}

	public void question9(String pathFile, String newName) throws Exception {
		fileManager.renameFile(pathFile, newName);
	}

	public void question10(String newPathFolder) throws Exception {
		fileManager.createNewFolder(newPathFolder);
	}

}
