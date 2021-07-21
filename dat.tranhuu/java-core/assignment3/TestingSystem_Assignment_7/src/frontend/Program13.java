package frontend;

import entity.TestObject;
import utils.IOManager;

public class Program13 {
	public static void main(String[] args) {
		IOManager io = new IOManager();
		String path=System.getProperty("user.dir")+ "/src/entity/p13";
		Object a= new TestObject("tuan anh");
		io.writeObject(a, path, "ex2.txt");
	}
}
