package frontend;

import backend.Exercise1;

public class Program1 {

	public static void main(String[] args) {
		Exercise1 ex1 = new Exercise1();
		String path=System.getProperty("user.dir")+ "/src/entity/ex1.txt";
		System.out.print(ex1.isFileExist(path));
	}
}
