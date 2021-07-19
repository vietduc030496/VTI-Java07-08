package frontend;

import backend.Exercise4;

public class Program4 {
	public static void main(String[] args) {
		Exercise4 ex4 = new Exercise4();
		String path=System.getProperty("user.dir")+ "/src/entity/ex4.txt";
		ex4.deleteFile(path);
		
	}
}
