package frontend;

import backend.Exercise9;

public class Program9 {
	public static void main(String[] args) {
		Exercise9 ex9 = new Exercise9();
		String path = System.getProperty("user.dir") + "/src/entity/ex2.txt";
		ex9.renameFile(path, "ex9.txt");
		
	}
}
