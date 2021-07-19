package frontend;

import utils.IOManager;

public class Program14 {
	public static void main(String[] args) {
		IOManager io = new IOManager();
		String path=System.getProperty("user.dir")+ "/src/entity/p13/ex2.txt";
		System.out.println(io.readObject(path));
	}
}
