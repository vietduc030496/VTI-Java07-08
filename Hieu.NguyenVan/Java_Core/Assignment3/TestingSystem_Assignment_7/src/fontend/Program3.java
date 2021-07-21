package fontend;

import java.util.List;

import backend.Exercise3;
import backend.utils.constant;

public class Program3 {
	Exercise3 ex3;
	String path3="src/file1qwqw.txt";
	String path = "src/file1.txt";
	String path2="src/";
	String pathTest="test";
	public Program3() throws Exception {
		ex3 = new Exercise3();
		question1();
		question2();
		//question4();
		question5();
		question6();
		//question10();
		//question7();
		//question8();
		//question9();
		
		
	}

	public void out(String out) {
		System.out.println(out + "\n");
	}

	public void question1() {
		
		boolean ques1 = ex3.question1(path);
		out(ques1 + "");
	}

	public void question2() {
		ex3.question2(path3);
		
	}

	public void question3() {
		
	}

	public void question4() {
		ex3.question4(path);
	}

	public void question5() {
		out(ex3.question5(path)+"");
		
	}

	public void question6() {
		try {
			List<String> listFile = ex3.question6(path2);
			for(String filename:listFile) {
				out(filename);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void question7() {
		try {
			ex3.question7(path, pathTest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void question8() throws Exception {
		ex3.question8(path3, pathTest);
	}

	public void question9() throws Exception {
		ex3.question9(path, "vanhieu");
	}

	public void question10() throws Exception {
		ex3.question10(pathTest);
	}
}
