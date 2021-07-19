package frontend;

import backend.Exercise6;

public class Program6 {
	public static void main(String[] args) {
		Exercise6 ex6 = new Exercise6();
		String path = System.getProperty("user.dir") + "/src/entity";
		System.out.print(ex6.getAllFileName(path));
	}
}
