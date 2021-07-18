package backend;

import backend.utils.IOManager;

public class Exercise4 {
	IOManager ioManager;
	
	
	public Exercise4(IOManager ioManager) {
		super();
		this.ioManager = ioManager;
	}
	
	public Exercise4() {
		super();
		ioManager=new IOManager();
	}

	public void question1(String pathFile) throws Exception {
		ioManager.readFile(pathFile);
	}
	public void question2(String pathFile, boolean isContinuing, String content) throws Exception {
		ioManager.writeFile(pathFile, isContinuing, content);
	}
	public void question3(Object object, String path, String fileName) throws Exception {
		ioManager.writeObject(object, path, fileName);
	}
	public void question4(String filePath) {
		ioManager.readObject(filePath);
		
		
	}

}
