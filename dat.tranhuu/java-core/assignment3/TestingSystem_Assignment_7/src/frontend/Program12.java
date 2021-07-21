package frontend;

import utils.IOManager;

public class Program12 {
	public static void main(String[] args) {
		IOManager io = new IOManager();
		String path=System.getProperty("user.dir")+ "/src/entity/ex1.txt";
		io.writeFile(path, false, "dat");
		io.writeFile(path, true, "tuan anh");
	}
}
