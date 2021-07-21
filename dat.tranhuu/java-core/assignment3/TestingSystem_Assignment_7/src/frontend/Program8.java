package frontend;

import backend.Exercise8;

public class Program8 {
	public static void main(String[] args) {
		Exercise8 ex8 = new Exercise8();
		String path = System.getProperty("user.dir") + "/src/entity/ex1.txt";
		String path2 = System.getProperty("user.dir") + "/src/entity/coppy";
		ex8.moveFile(path, path2);
		
	}
}
