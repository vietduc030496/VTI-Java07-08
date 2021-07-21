package frontend;

import backend.Exercise5;

public class Program5 {
	public static void main(String[] args) {
		Exercise5 ex5 = new Exercise5();
		String path = System.getProperty("user.dir") + "/src/entity";
		System.out.print(ex5.isFolder(path));

	}
}
