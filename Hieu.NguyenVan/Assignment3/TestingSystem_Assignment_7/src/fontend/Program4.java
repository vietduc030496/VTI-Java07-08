package fontend;

import backend.Exercise3;
import backend.Exercise4;
import backend.utils.testobject;

public class Program4 {
	Exercise4 ex4;
	String path3="src/file1qwqw.txt";
	String path = "src/vanhieu";
	String path2="src/";
	String pathTest="test";
	
	public Program4() throws Exception {
		ex4 =new Exercise4();
		question1();
		question2();
		question3();
		question4();
	}
	public void out(String out) {
		System.out.println(out +"\n");
	}
	public void question1() throws Exception {
		
		out(ex4.question1(path));
	}
	public void question2() throws Exception {
		ex4.question2(path, true, "chen tiep ");
	}
	public void question3() throws Exception {
		ex4.question3(new testobject() , path2, "object.txt");
	}
	public void question4() {
		out(ex4.question4(path2+"object.txt").toString());
	}

}
