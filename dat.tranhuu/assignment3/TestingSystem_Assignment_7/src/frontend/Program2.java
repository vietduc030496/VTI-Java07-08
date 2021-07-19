package frontend;

import backend.Exercise2;

public class Program2 {
	public static void main(String[] args) {
		Exercise2 ex2 = new Exercise2();
		String path=System.getProperty("user.dir")+ "/src/entity/ex2.txt";
		ex2.createNewFile(path);
		
		String path2=System.getProperty("user.dir")+ "/src/entity/";
		ex2.createNewFile(path2,"ex2.txt");
	}
	
}
