package frontend;

import backend.Exercise7;

public class Program7 {
	public static void main(String[] args) {
		Exercise7 ex7 = new Exercise7();
		String path = System.getProperty("user.dir") + "/src/entity/ex2.txt";
		String path2 = System.getProperty("user.dir") + "/src/entity/coppy";
		ex7.copyFile(path, path2, "ex7.txt");
		ex7.copyFile(path, path2);
	}
}
