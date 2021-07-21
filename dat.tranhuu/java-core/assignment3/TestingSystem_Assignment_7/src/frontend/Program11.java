package frontend;

import utils.IOManager;

public class Program11 {
	public static void main(String[] args) {
		IOManager io = new IOManager();
		String path=System.getProperty("user.dir")+ "/src/entity/ex1.txt";
		System.out.print(io.readFile(path));
	}
}
