package backend;

import backend.utils.FileManager;

public class Exercise3 {
	FileManager fileManager;

	public Exercise3() {
		fileManager = new FileManager();
	}

	public void question1(String pathFile) {
		fileManager.isFileExists(pathFile);
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

	public void question5(String path) {
		fileManager.isFolder(path);
	}

	public void question6(String path) throws Exception {
		fileManager.getAllFileName(path);
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
